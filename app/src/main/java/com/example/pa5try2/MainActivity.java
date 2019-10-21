package com.example.pa5try2;

/*
    This program is a simple app that allows users to enter names, enter a new
    activity which is a 3x3 TicTacToe board game using two different icons
    CPSC312-01, Fall 2019
    Programming Assignment #5
    No sources to cite

    @author Spencer Jacobs
    @version v1.0 10/21/19
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    protected EditText p1Name;
    protected EditText p2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1Name = (EditText) findViewById(R.id.player1NameEdit);
        p2Name = (EditText) findViewById(R.id.player2NameEdit);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a new intent
                Intent intent = new Intent(MainActivity.this, PlayGameActivity.class);

                String name1 = p1Name.getText().toString();
                String name2 = p2Name.getText().toString();

                intent.putExtra("player1Name", name1);
                intent.putExtra("player2Name", name2);

                //create a new game when the next button is clicked.
                TicTacToeBoard gamePlay = new TicTacToeBoard(3);

                startActivity(intent);
            }
        });
    }
}
