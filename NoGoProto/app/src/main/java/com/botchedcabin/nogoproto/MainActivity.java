package com.botchedcabin.nogoproto;

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
    Vector<ImageView> pieces = new Vector<>(); /**< Vector of pieces we have played */

    /**
     * Do stuff when the view is created
     * @param savedInstanceState
     */
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

        // Doing this here because otherwise the first conditional below fails
        newButton.setText("New Game");

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // If the new game button is clicked, show they board dim picker
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
                        // Start the game, remove some UI elements
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
                // Game has ended, reset everything
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

    /**
     * When the user touches the screen, validate the touch and place a piece
     * @param event Screen touch event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :

                final Button endButton = (Button) findViewById(R.id.endButton);

                // Only allow placement when the game is started and the state is not finished
                if (endButton.getVisibility() == View.INVISIBLE || game.getGameState() == 2)
                    return true;

                //adding imageview for black piece
                RelativeLayout rel = (RelativeLayout) findViewById(R.id.mainactivity);
                final ImageView newPieceView = new ImageView(this);

                // Query the game to see if we are placing a black or white piece
                if (game.getGameState() == 0) {
                    newPieceView.setImageResource(R.drawable.black_piece);
                } else {
                    newPieceView.setImageResource(R.drawable.white_piece);
                }

                // Hacks on hacks
                newPieceView.setLayoutParams(new LayoutParams(30, 30));
                newPieceView.setX(event.getX() - 55); // It's a weird offset for me, and I don't know why
                newPieceView.setY(event.getY() - 300);
                pieces.addElement(newPieceView);

                // Adding piece view to layout
                rel.addView(newPieceView);
                game.placePiece(0,0);

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
