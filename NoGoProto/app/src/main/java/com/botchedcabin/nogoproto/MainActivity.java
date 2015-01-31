package com.botchedcabin.nogoproto;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;;
import android.widget.NumberPicker;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button newButton = (Button) findViewById(R.id.newbutton);
        final Button endButton = (Button) findViewById(R.id.endButton);
        final NumberPicker boardSizePicker = (NumberPicker) findViewById(R.id.boardSizePicker);
        final TextView boardDimLabel = (TextView) findViewById(R.id.BoardDimLabel);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));

        //adding imageview for black piece
        RelativeLayout rel = (RelativeLayout) findViewById(R.id.mainactivity);
        final ImageView blackPieceView = new ImageView(this);
        blackPieceView.setImageResource(R.drawable.black_piece);
        blackPieceView.setLayoutParams (new LayoutParams(30, 30));
        blackPieceView.setX(100);
        blackPieceView.setY(100);

        //adding piece view to layout
        rel.addView(blackPieceView);
        newButton.setText("New Game");

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (newButton.getText() == "New Game") {
                    blackPieceView.setVisibility(View.INVISIBLE);
                    boardSizePicker.setVisibility(View.VISIBLE);
                    boardSizePicker.setMinValue(4);
                    boardSizePicker.setMaxValue(64);
                    boardDimLabel.setVisibility(View.VISIBLE);
                    newButton.setText("Go!");
                } else if (newButton.getText() == "Go!") {
                    if (boardSizePicker.getValue() < 4 || boardSizePicker.getValue() > 64) {
                        boardDimLabel.setText("Must be >4 and <64");
                    } else {
                        boardDimLabel.setVisibility(View.INVISIBLE);
                        boardSizePicker.setVisibility(View.INVISIBLE);
                        newButton.setVisibility(View.INVISIBLE);
                        endButton.setVisibility(View.VISIBLE);
                    }
                } else {
                    newButton.setText("New Game");
                }
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newButton.setVisibility(View.VISIBLE);
                endButton.setVisibility(View.INVISIBLE);
                newButton.setText("New Game");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
