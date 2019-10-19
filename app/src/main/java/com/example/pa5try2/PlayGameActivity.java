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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        statusLabel = (TextView) findViewById(R.id.statusText);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        Intent intent = getIntent();
        if(intent != null){
            name1 = intent.getStringExtra("player1Name");
            name2 = intent.getStringExtra("player2Name");
            //test to make sure we are accepting the names
            //Toast.makeText(this, "Name1: " + name1 + " Name2" + name2, Toast.LENGTH_LONG).show();
            statusLabel.setText(name1 + ", you're up!");
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
                new TicTacToeBoard();

                //clear the images
                resetBoardImages();

            }
        });

    }

    private void resetBoardImages(){
        ImageView zerozero = (ImageView) findViewById(R.id.zero_zero);
        zerozero.setColorFilter(Color.WHITE);
        ImageView zeroone = (ImageView) findViewById(R.id.zero_one);
        zeroone.setColorFilter(Color.WHITE);
        ImageView zerotwo = (ImageView) findViewById(R.id.zero_two);
        zerotwo.setColorFilter(Color.WHITE);
        ImageView onezero = (ImageView) findViewById(R.id.one_zero);
        onezero.setColorFilter(Color.WHITE);
        ImageView oneone = (ImageView) findViewById(R.id.one_one);
        oneone.setColorFilter(Color.WHITE);
        ImageView onetwo = (ImageView) findViewById(R.id.one_two);
        onetwo.setColorFilter(Color.WHITE);
        ImageView twozero = (ImageView) findViewById(R.id.two_zero);
        twozero.setColorFilter(Color.WHITE);
        ImageView twoone = (ImageView) findViewById(R.id.two_one);
        twoone.setColorFilter(Color.WHITE);
        ImageView twotwo = (ImageView) findViewById(R.id.two_two);
        twotwo.setColorFilter(Color.WHITE);
    }

    //figuring out which button they clicked.
    public void onButtonClick(View view){
        //telling the user who is up
        ImageView previewInfo = (ImageView) findViewById(R.id.previewInfo);
        ImageView button = (ImageView) view;
        String text = button.getTag().toString();
        int x = Character.getNumericValue(text.charAt(0));
        int y = Character.getNumericValue(text.charAt(1));
        button.setImageResource(R.drawable.angel);

        //create coordinates and pass them into the isValidMove
        Coordinates coord = new Coordinates(x, y);

        //Toast.makeText(this, "Button: " + text + " x-coor: " + x + " y-coor: " + y, Toast.LENGTH_LONG).show();
        if(board.makeMove(coord)){
            //game logic
            if(!board.whoTurn) {
                button.setImageResource(R.drawable.angel);
                statusLabel.setText(name2 + ", you're up!");
                previewInfo.setImageResource(R.drawable.demon);
                board.whoTurn = !board.whoTurn;
            }
            else {
                button.setImageResource(R.drawable.demon);
                statusLabel.setText(name1 + ", you're up!");
                previewInfo.setImageResource(R.drawable.angel);
                board.whoTurn = !board.whoTurn;
            }

            if(board.isWinner() && board.whoTurn){
                statusLabel.setText(name1 + " wins, good work!");
                newGameButton.setVisibility(View.VISIBLE);
                setUnclickable(view);
                return;
            }
            else if(board.isWinner() && !board.whoTurn) {
                statusLabel.setText(name2 + " wins, excellent game!");
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
        else
            Toast.makeText(this, "Invalid Move. Try Again", Toast.LENGTH_LONG).show();

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
