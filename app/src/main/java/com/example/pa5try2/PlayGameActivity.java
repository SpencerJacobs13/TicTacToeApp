package com.example.pa5try2;
/**
 *  This is the controller. It connects the view to the model (TicTacToeBoard) and updates the
 *  view as necessary. It is the middle man that speaks to both the model and the view (XML).
 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGameActivity extends AppCompatActivity {
    /**
     * Creates a new object of TicTacToeBoard, which creates a 3x3 grid of blank spaces.
     */
    protected TicTacToeBoard board = new TicTacToeBoard();
    /**
     * newGameButton is the button that appears at the bottom of the screen when a game is over and
     * allows the user to start a new game with a reset board.
     */
    protected Button newGameButton;
    /**
     *  name1 is the name of player 1 that is "accepted" from the MainActivity
     */
    protected String name1;
    /**
     * name2 is the name of player 2 that is "accepted" from the MainActivity
     */
    protected String name2;
    /**
     * statusLabel is the information tab that is updated after every turn and notifies the players
     * what the current state of the game is (who won, game ended in draw, whose turn it is, etc)e
     */
    protected TextView statusLabel;
    /**
     * previewInfo is the ImageView that shows which player is up.
     */
    protected ImageView previewInfo;


    /**
     * The method that is called when the app is started (created)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        previewInfo = (ImageView) findViewById(R.id.previewInfo);
        statusLabel = (TextView) findViewById(R.id.statusText);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        /**
         * Creating a new intent to launch the second activity.
         */
        Intent intent = getIntent();
        if(intent != null){
            name1 = intent.getStringExtra("player1Name");
            name2 = intent.getStringExtra("player2Name");

            statusLabel.setText(name1 + getString(R.string.yourTurn));
            previewInfo.setImageResource(R.drawable.angel);
        }

        //making a back to main button send user back to home screen
        Button backToMain = (Button) findViewById(R.id.backToMainButton);
        /**
         * Anonymous class that listens for when the user clicks the "Back to Main" button and
         * responds appropriately.
         */
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                PlayGameActivity.this.finish();
            }
        });

        Button newGameButton = (Button) findViewById(R.id.newGameButton);

        /**
         * Anonymous class that listens for when the user clicks the "New Game" button.
         * When this button is clicked, a new object of TicTacToeBoard is instantiated and the board
         * is reset for the users to play again.
         */
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if this button is clicked, clear the board and start over.
                //making a new board
                board = new TicTacToeBoard();

                //clear the images & reset information
                resetBoardImages();
                statusLabel.setText(name1 + getString(R.string.yourTurn));
                previewInfo.setImageResource(R.drawable.angel);
            }
        });
    }

    /**
     * Resetting the images on the board back to a blank white square.
     */
    private void resetBoardImages(){
        ImageView zerozero = (ImageView) findViewById(R.id.zerozero);
        zerozero.setImageResource(R.drawable.white);
        zerozero.setClickable(true);
        ImageView zeroone = (ImageView) findViewById(R.id.zeroone);
        zeroone.setImageResource(R.drawable.white);
        zeroone.setClickable(true);
        ImageView zerotwo = (ImageView) findViewById(R.id.zerotwo);
        zerotwo.setImageResource(R.drawable.white);
        zerotwo.setClickable(true);
        ImageView onezero = (ImageView) findViewById(R.id.onezero);
        onezero.setImageResource(R.drawable.white);
        onezero.setClickable(true);
        ImageView oneone = (ImageView) findViewById(R.id.oneone);
        oneone.setImageResource(R.drawable.white);
        oneone.setClickable(true);
        ImageView onetwo = (ImageView) findViewById(R.id.onetwo);
        onetwo.setImageResource(R.drawable.white);
        onetwo.setClickable(true);
        ImageView twozero = (ImageView) findViewById(R.id.twozero);
        twozero.setImageResource(R.drawable.white);
        twozero.setClickable(true);
        ImageView twoone = (ImageView) findViewById(R.id.twoone);
        twoone.setImageResource(R.drawable.white);
        twoone.setClickable(true);
        ImageView twotwo = (ImageView) findViewById(R.id.twotwo);
        twotwo.setImageResource(R.drawable.white);
        twotwo.setClickable(true);
    }

    /**
     * This is the heart of the program.
     * When the user clicks a button, we want to figure out what button they clicked and parse
     * out the integers that represent the location on the board. Once we have those, we can create a new
     * Coordinates object and pass those ints into the constructor. From there we use that Coordinate object
     * to pass into the model of the system where the game logic is run.
     *
     * We call the functions in the TicTacToeBoard (model) class to play the game and to
     * figure out if anybody has won, if the board is full, whose turn it is, etc
     *
     * @param view
     */
    public void onButtonClick(View view){
        //telling the user who is up
        previewInfo = (ImageView) findViewById(R.id.previewInfo);
        ImageView button = (ImageView) view;
        String text = button.getTag().toString();
        int x = Character.getNumericValue(text.charAt(0));
        int y = Character.getNumericValue(text.charAt(1));
        button.setImageResource(R.drawable.angel);

        //create coordinates and pass them into the isValidMove
        Coordinates coord = new Coordinates(x, y);

        //if the move can legally be made, change the info and update the board
        if(board.makeMove(coord)){
            //game logic
            if(!board.whoTurn) {
                button.setImageResource(R.drawable.angel);
                statusLabel.setText(name2 + getString(R.string.yourTurn));
                previewInfo.setImageResource(R.drawable.demon);
                board.whoTurn = !board.whoTurn;
                button.setClickable(false);
            }
            else {
                button.setImageResource(R.drawable.demon);
                statusLabel.setText(name1 + getString(R.string.yourTurn));
                previewInfo.setImageResource(R.drawable.angel);
                board.whoTurn = !board.whoTurn;
                button.setClickable(false);
            }
        }
        else //if the move is not valid
            Toast.makeText(this, getString(R.string.invalidName), Toast.LENGTH_LONG).show();

        //someone has won, and that someone is player1.
        if(board.isWinner() && board.whoTurn){
            statusLabel.setText(name1 + " " + getString(R.string.winnerMessage));
            previewInfo.setImageResource(R.drawable.angel);
            newGameButton.setVisibility(View.VISIBLE);
            setUnclickable(view);
            return;
        }

        //someone has won, and that someone is player2.
        if(board.isWinner() && !board.whoTurn) {
            statusLabel.setText(name2 + " " + getString(R.string.winnerMessage));
            previewInfo.setImageResource(R.drawable.demon);
            newGameButton.setVisibility(View.VISIBLE);
            setUnclickable(view);
            return;
        }

        //check if the board is full LAST because it is possible to win on the last move
        if(board.checkBoardFull()) {
            statusLabel.setText(getString(R.string.gameDraw));
            newGameButton.setVisibility(View.VISIBLE);
            setUnclickable(view);
            return;
        }

    }

    /**
     * When someone wins, we want the board to be unplayable. Set all of the buttons to be unclickable
     * before the user chooses what to do next.
     *
     * @param view
     */
    private void setUnclickable(View view){
            ImageView zerozero = (ImageView) findViewById(R.id.zerozero);
            zerozero.setClickable(false);
            ImageView zeroone = (ImageView) findViewById(R.id.zeroone);
            zeroone.setClickable(false);
            ImageView zerotwo = (ImageView) findViewById(R.id.zerotwo);
            zerotwo.setClickable(false);
            ImageView onezero = (ImageView) findViewById(R.id.onezero);
            onezero.setClickable(false);
            ImageView oneone = (ImageView) findViewById(R.id.oneone);
            oneone.setClickable(false);
            ImageView onetwo = (ImageView) findViewById(R.id.onetwo);
            onetwo.setClickable(false);
            ImageView twozero = (ImageView) findViewById(R.id.twozero);
            twozero.setClickable(false);
            ImageView twoone = (ImageView) findViewById(R.id.twoone);
            twoone.setClickable(false);
            ImageView twotwo = (ImageView) findViewById(R.id.twotwo);
            twotwo.setClickable(false);
    }
}//end class
