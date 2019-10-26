package com.example.pa5try2;
/**
 * The main activity that is shown onCreate of the Application.
 */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /**
     * The EditText that will correspond to what the user enters as the name for player 1
     */
    protected EditText p1Name;
    /**
     * The EditText that will correspond to what the user enters as the name for player 2
     */
    protected EditText p2Name;

    /**
     * The code that is run when the user opens the app and enters two names. These names are linked
     * as key->value pairs to their corresponding strings so that they can be extracted in the
     * PlayGameActivity.
     *
     * We add this information to the intent that we create before we start that intent, which will take us
     * to the next screen (activity) where the game logic is played out using the names entered here.
     *
     * @param savedInstanceState
     */
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
                //create a new intent and specify where you are and where you want the intent to take you
                Intent intent = new Intent(MainActivity.this, PlayGameActivity.class);

                String name1 = p1Name.getText().toString();
                String name2 = p2Name.getText().toString();

                intent.putExtra("player1Name", name1);
                intent.putExtra("player2Name", name2);

                startActivity(intent);
            }
        });
    }
}
