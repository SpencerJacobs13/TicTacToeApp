package com.example.pa5try2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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

    protected String name1;
    protected String name2;
    protected TextView statusLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Intent intent = getIntent();
        if(intent != null){
            name1 = intent.getStringExtra("player1Name");
            name2 = intent.getStringExtra("player2Name");
            //test to make sure we are accepting the names
            Toast.makeText(this, "Name1: " + name1 + " Name2" + name2, Toast.LENGTH_LONG).show();
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
            }
        });

        //____________________________________________________________

    }

    private void resetBoardImages(){

    }

    //figuring out which button they clicked.
    public void onButtonClick(View view){
        ImageView button = (ImageView) view;
        String text = button.getTag().toString();
        int x = Character.getNumericValue(text.charAt(0));
        int y = Character.getNumericValue(text.charAt(1));

        button.setImageResource(R.drawable.angel);

        //create coordinates and pass them into
        Coordinates p1 = new Coordinates(x, y);
        //if(TicTacToeBoard.isValidMove(p1))
        //get the tag of whatever image view is clicked
        //then we have to parse out that string to determine which ImageView was clicked.
        Toast.makeText(this, "Button: " + text + " x-coor: " + x + " y-coor: " + y, Toast.LENGTH_LONG).show();

        statusLabel = (TextView) findViewById(R.id.statusText);
        statusLabel.setText(name2 + ", you're up!");


    }
}
