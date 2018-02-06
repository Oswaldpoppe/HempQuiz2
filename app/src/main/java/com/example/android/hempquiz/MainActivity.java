package com.example.android.hempquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Hemp Quiz by Oswald Poppe @Udacity (project 3)
 */

public class MainActivity extends AppCompatActivity {
    CheckBox yesCheckBox, noCheckBox;
    //Saves the score.
    int score = 0;
    private RadioGroup firstRadioGroup, secondRadioGroup, thirdRadioGroup, fourthRadioGroup, fifthRadioGroup, sixthRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method gets the name of the player.
     * <p>
     * Checks which radio buttons are clicked.
     * <p>
     * Checks if all questions are answered.
     * <p>
     * Handles the 'if you want to know more' question.
     *
     * @param view I have idea what description to give here
     */

    public void submitButton(View view) {

        //Gets the name of the player
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //Checks if the right radio button is checked for question 1
        RadioButton answerOneC = findViewById(R.id.a1_C);
        Boolean a1C = answerOneC.isChecked();

        //Checks if the right radio button is checked for question 2
        RadioButton answerTwoC = findViewById(R.id.a2_C);
        Boolean a2C = answerTwoC.isChecked();

        // Checks if the right radio button is checked for question 3
        RadioButton answerThreeC = findViewById(R.id.a3_C);
        Boolean a3C = answerThreeC.isChecked();

        // Checks if the right radio button is checked for question 4
        RadioButton answerFourA = findViewById(R.id.a4_A);
        Boolean a4A = answerFourA.isChecked();

        // Checks if the right radio buttons are checked for question 5
        RadioButton answerFiveB = findViewById(R.id.a5_B);
        Boolean a5B = answerFiveB.isChecked();
        RadioButton answerFiveC = findViewById(R.id.a5_C);
        Boolean a5C = answerFiveC.isChecked();

        // Checks if the right radio buttons are checked for question 6
        RadioButton answerSixB = findViewById(R.id.a6_B);
        Boolean a6B = answerSixB.isChecked();
        RadioButton answerSixC = findViewById(R.id.a6_C);
        Boolean a6C = answerSixC.isChecked();

        int finalScore = calculateScore(a1C, a2C, a3C, a4A, a5B, a5C, a6B, a6C);

        //Checks if all questions are answered.
        firstRadioGroup = findViewById(R.id.q1);
        if (firstRadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Question 1 is not answered!", Toast.LENGTH_SHORT).show();
        }
        secondRadioGroup = findViewById(R.id.q2);
        if (secondRadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Question 2 is not answered!", Toast.LENGTH_SHORT).show();
        }
        thirdRadioGroup = findViewById(R.id.q3);
        if (thirdRadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Question 3 is not answered!", Toast.LENGTH_SHORT).show();
        }
        fourthRadioGroup = findViewById(R.id.q4);
        if (fourthRadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Question 4 is not answered!", Toast.LENGTH_SHORT).show();
        }
        fifthRadioGroup = findViewById(R.id.q5);
        if (fifthRadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Question 5 is not answered!", Toast.LENGTH_SHORT).show();
        }
        sixthRadioGroup = findViewById(R.id.q6);
        if (sixthRadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Question 6 is not answered!", Toast.LENGTH_SHORT).show();
        }

        // Handles 'Want to know more' question.
        yesCheckBox = findViewById(R.id.yes);
        Boolean isYesChecked = yesCheckBox.isChecked();
        if (isYesChecked) {
            TextView onlyScore = findViewById(R.id.only_score);
            onlyScore.setText(name + " ,Your score is\n " + finalScore + " out of 6!");
            TextView moreInfo = findViewById(R.id.more_info);
            moreInfo.setText(getString(R.string.extra_info));
        }
        noCheckBox = findViewById(R.id.no);
        Boolean isNoChecked = noCheckBox.isChecked();
        if (isNoChecked) {
            TextView onlyScore = findViewById(R.id.only_score);
            onlyScore.setText(name + " ,Your score is\n " + finalScore + " out of 6!");
        }

        //Makes a Toast with the score
        Toast.makeText(this, "Your score is " + finalScore + " out of 6!", Toast.LENGTH_SHORT).show();

        //Makes the reset button visible
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setVisibility(View.VISIBLE);

    }

    /**
     * This method is called when the reset button is clicked
     *
     * @param view I have no idea what description to give here
     */

    public void resetButton(View view) {
        //Resets the RadioGroups and CheckBoxes
        firstRadioGroup.clearCheck();
        secondRadioGroup.clearCheck();
        thirdRadioGroup.clearCheck();
        fourthRadioGroup.clearCheck();
        fifthRadioGroup.clearCheck();
        sixthRadioGroup.clearCheck();
        yesCheckBox.setChecked(false);
        noCheckBox.setChecked(false);

        //Resets the text created by clicking submit button.
        TextView moreInfo = findViewById(R.id.more_info);
        moreInfo.setText("");
        TextView onlyScore = findViewById(R.id.only_score);
        onlyScore.setText("");
        EditText nameInput = findViewById(R.id.name_field);
        nameInput.setText("");

        //Makes the reset button invisible again
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setVisibility(View.INVISIBLE);

        //Goes backs to the top of the ScrollView
        ScrollView mainScrollView = findViewById(R.id.scrollView);
        mainScrollView.fullScroll(ScrollView.FOCUS_UP);
    }

    /**
     * Method to calculate the final score.
     *
     * @param a1C adds 1 points for question 1
     * @param a2C adds 1 points for question 2
     * @param a3C adds 1 points for question 3
     * @param a4A adds 1 points for question 4
     * @param a5B adds 1 points for question 5
     * @param a5C adds 1 points for question 5
     * @param a6B adds 1 points for question 6
     * @param a6C adds 1 points for question 6
     * @return score
     */
    public int calculateScore( boolean a1C, boolean a2C, boolean a3C, boolean a4A, boolean a5B, boolean a5C, boolean a6B, boolean a6C) {
        score = 0;
        //Question 1
        if (a1C) {
            score = score + 1;
        }
        //Question 2
        if (a2C) {
            score = score + 1;
        }
        //Question 3
        if (a3C) {
            score = score + 1;
        }
        //Question 4
        if (a4A) {
            score = score + 1;
        }
        //Question 5
        if (a5B) {
            score = score + 1;
        } else if (a5C) {
            score = score + 1;
        }
        //Question 6
        if (a6B) {
            score = score + 1;
        } else if (a6C){
            score = score + 1;
        }
        //Returns the final score
        return score;
    }
}
