package com.example.pa5try2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PlayGameActivity extends AppCompatActivity {
    protected TicTacToeBoard board = new TicTacToeBoard();
    protected Button newGameButton;
    protected String name1;
    protected String name2;
    protected TextView statusLabel;
    protected ImageView previewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        previewInfo = (ImageView) findViewById(R.id.previewInfo);
        statusLabel = (TextView) findViewById(R.id.statusText);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        Intent intent = getIntent();
        if(intent != null){
            name1 = intent.getStringExtra("player1Name");
            name2 = intent.getStringExtra("player2Name");

            statusLabel.setText(name1 + ", you're up!");
            previewInfo.setImageResource(R.drawable.angel);
        }

        //making a back to main button send user back to home screen
        Button backToMain = (Button) findViewById(R.id.backToMainButton);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                PlayGameActivity.this.finish();
            }
        });


        //starting a new game at any point
        Button newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if this button is clicked, clear the board and start over.
                //making a new board
                 board = new TicTacToeBoard();

                //clear the images
                resetBoardImages();

                statusLabel.setText(name1 + ", you're up!");
                previewInfo.setImageResource(R.drawable.angel);

            }
        });

    }

    private void resetBoardImages(){
        ImageView zerozero = (ImageView) findViewById(R.id.zero_zero);
        zerozero.setImageResource(R.drawable.white);
        zerozero.setClickable(true);
        ImageView zeroone = (ImageView) findViewById(R.id.zero_one);
        zeroone.setImageResource(R.drawable.white);
        zeroone.setClickable(true);
        ImageView zerotwo = (ImageView) findViewById(R.id.zero_two);
        zerotwo.setImageResource(R.drawable.white);
        zerotwo.setClickable(true);
        ImageView onezero = (ImageView) findViewById(R.id.one_zero);
        onezero.setImageResource(R.drawable.white);
        onezero.setClickable(true);
        ImageView oneone = (ImageView) findViewById(R.id.one_one);
        oneone.setImageResource(R.drawable.white);
        oneone.setClickable(true);
        ImageView onetwo = (ImageView) findViewById(R.id.one_two);
        onetwo.setImageResource(R.drawable.white);
        onetwo.setClickable(true);
        ImageView twozero = (ImageView) findViewById(R.id.two_zero);
        twozero.setImageResource(R.drawable.white);
        twozero.setClickable(true);
        ImageView twoone = (ImageView) findViewById(R.id.two_one);
        twoone.setImageResource(R.drawable.white);
        twoone.setClickable(true);
        ImageView twotwo = (ImageView) findViewById(R.id.two_two);
        twotwo.setImageResource(R.drawable.white);
        twotwo.setClickable(true);
    }

    //figuring out which button they clicked.
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

        Toast.makeText(this, "x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();

        if(board.makeMove(coord)){
            //game logic
            if(!board.whoTurn) {
                button.setImageResource(R.drawable.angel);
                statusLabel.setText(name2 + ", you're up!");
                previewInfo.setImageResource(R.drawable.demon);
                board.whoTurn = !board.whoTurn;
                button.setClickable(false);
            }
            else {
                button.setImageResource(R.drawable.demon);
                statusLabel.setText(name1 + ", you're up!");
                previewInfo.setImageResource(R.drawable.angel);
                board.whoTurn = !board.whoTurn;
                button.setClickable(false);
            }
        }
        else //if the move is not valid
            Toast.makeText(this, "Invalid Move. Try Again", Toast.LENGTH_LONG).show();

        if(board.isWinner() && board.whoTurn){
            statusLabel.setText(name1 + " wins, good work!");
            previewInfo.setImageResource(R.drawable.angel);
            newGameButton.setVisibility(View.VISIBLE);
            setUnclickable(view);
            return;
        }

        if(board.isWinner() && !board.whoTurn) {
            statusLabel.setText(name2 + " wins, excellent game!");
            previewInfo.setImageResource(R.drawable.demon);
            newGameButton.setVisibility(View.VISIBLE);
            setUnclickable(view);
            return;
        }

        if(board.checkBoardFull()) {
            statusLabel.setText("Uh oh! The game has ended in a draw!");
            newGameButton.setVisibility(View.VISIBLE);
            setUnclickable(view);
            return;
        }

    }

    public void setUnclickable(View view){
            ImageView zerozero = (ImageView) findViewById(R.id.zero_zero);
            zerozero.setClickable(false);
            ImageView zeroone = (ImageView) findViewById(R.id.zero_one);
            zeroone.setClickable(false);
            ImageView zerotwo = (ImageView) findViewById(R.id.zero_two);
            zerotwo.setClickable(false);
            ImageView onezero = (ImageView) findViewById(R.id.one_zero);
            onezero.setClickable(false);
            ImageView oneone = (ImageView) findViewById(R.id.one_one);
            oneone.setClickable(false);
            ImageView onetwo = (ImageView) findViewById(R.id.one_two);
            onetwo.setClickable(false);
            ImageView twozero = (ImageView) findViewById(R.id.two_zero);
            twozero.setClickable(false);
            ImageView twoone = (ImageView) findViewById(R.id.two_one);
            twoone.setClickable(false);
            ImageView twotwo = (ImageView) findViewById(R.id.two_two);
            twotwo.setClickable(false);
    }
}//end class
