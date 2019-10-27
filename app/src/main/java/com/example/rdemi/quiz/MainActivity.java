package com.example.rdemi.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalQuestionsCount = 5;
    int correctAnswersCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Check the answer of question 1 and if correct,increase the count of correct answers */
    void checkQ1Answers() {
        final CheckBox option1 = (CheckBox) findViewById(R.id.q1_financialCrisis);
        final CheckBox option2 = (CheckBox) findViewById(R.id.q1_lavishSpending);
        final CheckBox option3 = (CheckBox) findViewById(R.id.q1_systemInequality);
        if (option1.isChecked() && option2.isChecked() && option3.isChecked())
            correctAnswersCount += 1;
    }

    /* Check the answer of question 2 and if correct,increase the count of correct answers */
    void checkQ2Answers() {
        final RadioGroup q2AnswerGroup = (RadioGroup) findViewById(R.id.q2_options);
        if (q2AnswerGroup.getCheckedRadioButtonId() == R.id.q2_stormingBastille)
            correctAnswersCount += 1;
    }

    /* Check the answer of question 3 and if correct,increase the count of correct answers */
    void checkQ3Answers() {
        final RadioGroup q3AnswerGroup = (RadioGroup) findViewById(R.id.q3_options);
        if (q3AnswerGroup.getCheckedRadioButtonId() == R.id.q3_assemblyTogether)
            correctAnswersCount += 1;
    }

    /* Check the answer of question 4 and if correct,increase the count of correct answers */
    void checkQ4Answers() {
        final EditText q4AnswerField = (EditText) findViewById(R.id.q4_leaderReignOfTerror);
        String q4Answer = q4AnswerField.getText().toString();
        if (q4Answer != null) {
            if (q4Answer.equals("Robespierre")) {
                correctAnswersCount += 1;
            } else if (q4Answer.equals("Maximillian Robespierre")) correctAnswersCount += 1;
        }
    }

    /* Check the answer of question 5 and if correct,increase the count of correct answers */
    void checkQ5Answers() {
        final RadioGroup q5AnswerGroup = (RadioGroup) findViewById(R.id.q5_options);
        if (q5AnswerGroup.getCheckedRadioButtonId() == R.id.q5_committeePublicSafety)
            correctAnswersCount += 1;
    }

    /* Resets the user score and the selected answers */
    public void resetQuiz(View v) {
        correctAnswersCount = 0;
        Button checkAnswersButton = (Button) findViewById(R.id.checkAnswersButton);
        LinearLayout displayScoreLayout = (LinearLayout) findViewById(R.id.scoreLayout);
        final RadioGroup q2AnswerGroup = (RadioGroup) findViewById(R.id.q2_options);
        final RadioGroup q3AnswerGroup = (RadioGroup) findViewById(R.id.q3_options);
        final RadioGroup q5AnswerGroup = (RadioGroup) findViewById(R.id.q5_options);
        final EditText q4AnswerField = (EditText) findViewById(R.id.q4_leaderReignOfTerror);
        final CheckBox option1 = (CheckBox) findViewById(R.id.q1_financialCrisis);
        final CheckBox option2 = (CheckBox) findViewById(R.id.q1_lavishSpending);
        final CheckBox option3 = (CheckBox) findViewById(R.id.q1_systemInequality);
        option1.setChecked(false);
        option2.setChecked(false);
        option3.setChecked(false);
        q2AnswerGroup.clearCheck();
        q3AnswerGroup.clearCheck();
        q5AnswerGroup.clearCheck();
        q4AnswerField.setText("");
        displayScoreLayout.setVisibility(View.GONE);
        checkAnswersButton.setVisibility(View.VISIBLE);

    }

    /* Checks the answers for the quiz,calculates and displays the user score */
    public void checkQuizAnswers(View v) {
        checkQ1Answers();
        checkQ2Answers();
        checkQ3Answers();
        checkQ4Answers();
        checkQ5Answers();
        Button checkAnswersButton = (Button) findViewById(R.id.checkAnswersButton);
        LinearLayout displayScoreLayout = (LinearLayout) findViewById(R.id.scoreLayout);
        String quizScore = String.valueOf(correctAnswersCount) + "/" + String.valueOf(totalQuestionsCount) + " correct answers";
        Toast.makeText(MainActivity.this, quizScore, Toast.LENGTH_SHORT).show();
        checkAnswersButton.setVisibility(View.GONE);
        displayScoreLayout.setVisibility(View.VISIBLE);
    }

}
