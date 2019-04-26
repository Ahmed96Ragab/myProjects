package com.example.android.footballscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int scoreR;
    int foulR;
    int scoreB;
    int foulB;

    /* Displays the given score for **RED** Team */

    public void addGoalR(View view){
        displayForRedTeam ( scoreR = scoreR + 1 );
    }
    private void displayForRedTeam(int score) {
        TextView scoreView = (TextView)findViewById(R.id.team_r_score);
        scoreView.setText(String.valueOf(score));
    }

    public void foulR (View view){
        displayFoulR( foulR = foulR + 1 );
    }
    private void displayFoulR(int score) {
        TextView scoreView = (TextView)findViewById(R.id.team_r_foul);
        scoreView.setText(String.valueOf(score));
    }


    /* Displays the given score for **BLUE** Team */


    public void addGoalB(View view){
        displayForBlueTeam ( scoreR = scoreR + 1 );
    }
    private void displayForBlueTeam(int score) {
        TextView scoreView = (TextView)findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void foulB (View view){
        displayFoulB ( foulB = foulB + 1 );
    }
    private void displayFoulB(int score) {
        TextView scoreView = (TextView)findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(score));
    }


    public void reset (View view){
        displayFoulR(foulR=0);
        displayForRedTeam(scoreR=0);

        displayFoulB(foulB=0);
        displayForBlueTeam(scoreB=0);

    }



}
