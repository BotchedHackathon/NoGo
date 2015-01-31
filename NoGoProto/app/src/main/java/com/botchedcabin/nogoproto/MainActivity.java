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
import android.view.MotionEvent;
import android.support.v4.view.MotionEventCompat;

import java.util.Vector;


public class MainActivity extends ActionBarActivity {

    public Game game = new Game();
    Vector<ImageView> pieces = new Vector<ImageView>();

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

        newButton.setText("New Game");

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (newButton.getText() == "New Game") {
                    boardSizePicker.setVisibility(View.VISIBLE);
                    boardSizePicker.setMinValue(4);
                    boardSizePicker.setMaxValue(64);
                    boardDimLabel.setVisibility(View.VISIBLE);
                    newButton.setText("Go!");
                } else if (newButton.getText() == "Go!") {
                    if (boardSizePicker.getValue() < 4 || boardSizePicker.getValue() > 64) {
                        boardDimLabel.setText("Must be >4 and <64");
                    } else {
                        game.newGame(boardSizePicker.getValue());
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

                for (Object obj : pieces) {
                    if (obj instanceof ImageView) {
                        ((ImageView) obj).setVisibility(View.INVISIBLE);
                        obj = null;
                    }
                }
                pieces.clear();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :

                final Button endButton = (Button) findViewById(R.id.endButton);
                if (endButton.getVisibility() == View.INVISIBLE)
                    return true;
                //adding imageview for black piece
                RelativeLayout rel = (RelativeLayout) findViewById(R.id.mainactivity);
                final ImageView blackPieceView = new ImageView(this);
                blackPieceView.setImageResource(R.drawable.black_piece);
                blackPieceView.setLayoutParams (new LayoutParams(30, 30));
                blackPieceView.setX(event.getX() - 55); // It's a weird offset for me, and I don't know why
                blackPieceView.setY(event.getY() - 300);
                pieces.addElement(blackPieceView);

                //adding piece view to layout
                rel.addView(blackPieceView);
                return true;
            case (MotionEvent.ACTION_MOVE) :

                return true;
            case (MotionEvent.ACTION_UP) :

                return true;
            case (MotionEvent.ACTION_CANCEL) :

                return true;
            case (MotionEvent.ACTION_OUTSIDE) :

                return true;
            default :
                return super.onTouchEvent(event);
        }
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
