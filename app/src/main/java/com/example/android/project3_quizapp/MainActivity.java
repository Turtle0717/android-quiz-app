package com.example.android.project3_quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * This method called when user presses submit button on the activity.main.xml
     */
    public void submitAnswers(View view) {

        int points = 0;// variable that keeps count of users total score

        //Question 1
        RadioButton longanRadioButton = (RadioButton) findViewById(R.id.question1_longan);
        boolean checkLongan = longanRadioButton.isChecked();

        RadioButton lycheeRadioButton = (RadioButton) findViewById(R.id.question1_lychee);
        boolean checkLychee = lycheeRadioButton.isChecked();

        if (checkLongan == true && checkLychee == false) {
            points++;
        }

        //Question 2
        EditText tomatoEditText = (EditText) findViewById(R.id.question2_choice);
        String tomatoAnswer = tomatoEditText.getText().toString();

        if (tomatoAnswer.equals("Fruit")) {
            points++;
        }

        //Question 3
        CheckBox papayaCheckBox = (CheckBox) findViewById(R.id.question3_papaya);
        boolean checkPapaya = papayaCheckBox.isChecked();

        CheckBox honeydewCheckBox = (CheckBox) findViewById(R.id.question3_honeydew);
        boolean checkHoneydew = honeydewCheckBox.isChecked();

        CheckBox cantaloupeCheckBox = (CheckBox) findViewById(R.id.question3_cantaloupe);
        boolean checkCantaloupe = cantaloupeCheckBox.isChecked();

        if (checkPapaya == false && checkHoneydew == true && checkCantaloupe == true) {
            points++;
        }

        //Question 4
        CheckBox greenBananaCheckBox = (CheckBox) findViewById(R.id.question4_banana_green);
        boolean checkGreenBanana = greenBananaCheckBox.isChecked();

        CheckBox yellowBananaCheckBox = (CheckBox) findViewById(R.id.question4_banana_yellow);
        boolean checkYellowBanana = yellowBananaCheckBox.isChecked();

        CheckBox brownBananaCheckBox = (CheckBox) findViewById(R.id.question4_banana_brown);
        boolean checkBrownBanana = brownBananaCheckBox.isChecked();

        if (checkGreenBanana == false && checkYellowBanana == true && checkBrownBanana == true) {
            points++;
        }

        //Question 5
        RadioButton strawberryTrueRadioButton = (RadioButton) findViewById(R.id.question5_strawberry_true);
        boolean checkStrawberryTrue = strawberryTrueRadioButton.isChecked();

        RadioButton strawberryFalseRadioButton = (RadioButton) findViewById(R.id.question5_strawberry_false);
        boolean checkStrawberryFalse = strawberryFalseRadioButton.isChecked();

        if (checkStrawberryTrue == true && checkStrawberryFalse == false) {
            points++;
        }

        String pointsObtained = pointsMessage(points);
        displayPoints(pointsObtained);

    }

    /*
     * This method displays the points message by using setText and taking a String message as a param
     * @param message String of message to display
     * @return displays the points summary total
     */
    private void displayPoints(String message) {
        TextView pointsMessage = (TextView) findViewById(R.id.score);
        pointsMessage.setText(message);

    }

    /*
     * This method uses the points from the global variable and returns a message
     * @param points the amount of obtained from answering questions
     * @return Message and points obtained.
     */
    private String pointsMessage(int points) {
        String pointSummary;
        if(points == 5){
            Toast correct = Toast.makeText(this,"Congratulations!\n You got them all correct!", Toast.LENGTH_SHORT);
            correct.show();
            pointSummary = "You got " + points + " correct!";
        } else if(points < 5 && points > 2) {
            Toast correct = Toast.makeText(this,"You almost got them all!", Toast.LENGTH_SHORT);
            correct.show();
            pointSummary = "You got " + points + " correct!";
        } else {
            Toast correct = Toast.makeText(this,"Not quite there yet!", Toast.LENGTH_SHORT);
            pointSummary = "You got " + points + " correct!";
            correct.show();
        }
        return pointSummary;
    }


}
