package com.example.android.hurricanequiz;

import android.content.Context;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int totalScore = 0;

    /**

     This method is called when the submit answers button is clicked.
     A toast message also appears to show the correct amount of answers;
     */
    public void submitAnswers(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_view);
        String userEntry = nameField.getText().toString();
        if(userEntry.equals("Alberto"))
            totalScore = + 1;

        RadioButton questionAnswer = findViewById(R.id.true_Cat);
        boolean questionOne = questionAnswer.isChecked();
        if (questionOne) {
            totalScore = + 1;
        }
        RadioButton questionAnswer2 = findViewById(R.id.false_Nhc);
        boolean questionTwo = questionAnswer2.isChecked();
        if (questionTwo) {
            totalScore += 1;
        }
        RadioButton questionAnswer3 = findViewById(R.id.true_Winds);
        boolean questionThree = questionAnswer3.isChecked();
        if (questionThree) {
            totalScore += 1;
        }
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.storm_checkbox);
        boolean questionFour = checkBox1.isChecked();
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.winds_true_checkbox);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.tornados_checkbox);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.rain_checkbox);
        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() & !checkBox4.isChecked()){
            totalScore += 1;
        }
        String answers = quizSummary(userEntry, questionOne, questionTwo, questionThree, questionFour);

        Context context = getApplicationContext();
        CharSequence text = "You got " + totalScore + " Right ";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        if(totalScore >= 3){
            Toast.makeText(getApplicationContext(),   " You passed the Quiz with a score of " + totalScore,  Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),  " You failed with a score of  " + totalScore,  Toast.LENGTH_SHORT).show();
        }

        displayMessage(answers);

    }
    /**

     This method is to display the correct answers under Quiz Results;
     */
    private String quizSummary( String name, boolean one, boolean two, boolean three, boolean four) {

        String answers = "Correct answers are below";
        answers += "\nQuestion  1: Alberto" ;
        answers += "\nQuestion  2: True" ;
        answers += "\nQuestion  3: True" ;
        answers += "\nQuestion  4: True" ;
        answers += "\nQuestion  5: Storm Surge, Winds, Tornadoes" ;
        return answers;
    }

    /**

     This method is to reset the Quiz Results;
     */
    public void resetQuiz(View view) {
        RadioButton questionAnswer1 = findViewById(R.id.true_Cat);
        questionAnswer1.setChecked(false);

        RadioButton questionAnswer1a = findViewById(R.id.false_Cat);
        questionAnswer1.setChecked(false);

        RadioButton questionAnswer2 = findViewById(R.id.true_Nhc);
        questionAnswer2.setChecked(false);

        RadioButton questionAnswer2a = findViewById(R.id.false_Nhc);
        questionAnswer2a.setChecked(false);

        RadioButton questionAnswer3 = findViewById(R.id.true_Winds);
        questionAnswer3.setChecked(false);

        RadioButton questionAnswer3a = findViewById(R.id.false_Winds);
        questionAnswer3a.setChecked(false);


        CheckBox checkBox = (CheckBox) findViewById(R.id.storm_checkbox);
        checkBox.setChecked(false);

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.winds_true_checkbox);
        checkBox2.setChecked(false);

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.tornados_checkbox);
        checkBox3.setChecked(false);

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.rain_checkbox);
        checkBox4.setChecked(false);

        EditText nameField = (EditText) findViewById(R.id.name_view);
        nameField.setText("");

        totalScore = 0;
    }
    /**

     This method is to display the correct answers under Quiz Results;
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.answer_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}