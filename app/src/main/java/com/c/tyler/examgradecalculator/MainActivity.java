package com.c.tyler.examgradecalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends ActionBarActivity {

    int numEvals = 8;

    EditText markText1, markText2, markText3, markText4, markText5, markText6, markText7, markText8;
    EditText outOfText1, outOfText2, outOfText3, outOfText4, outOfText5, outOfText6, outOfText7, outOfText8;
    EditText weightText1, weightText2, weightText3, weightText4, weightText5, weightText6, weightText7, weightText8;
    EditText finalGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate;

        // Set the EditTexts...

        markText1 = (EditText) findViewById(R.id.mark1);
        markText2 = (EditText) findViewById(R.id.mark2);
        markText3 = (EditText) findViewById(R.id.mark3);
        markText4 = (EditText) findViewById(R.id.mark4);
        markText5 = (EditText) findViewById(R.id.mark5);
        markText6 = (EditText) findViewById(R.id.mark6);
        markText7 = (EditText) findViewById(R.id.mark7);
        markText8 = (EditText) findViewById(R.id.mark8);

        markText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        markText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        markText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        markText4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        markText5.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        markText6.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        markText7.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        markText8.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        outOfText1 = (EditText) findViewById(R.id.outof1);
        outOfText2 = (EditText) findViewById(R.id.outof2);
        outOfText3 = (EditText) findViewById(R.id.outof3);
        outOfText4 = (EditText) findViewById(R.id.outof4);
        outOfText5 = (EditText) findViewById(R.id.outof5);
        outOfText6 = (EditText) findViewById(R.id.outof6);
        outOfText7 = (EditText) findViewById(R.id.outof7);
        outOfText8 = (EditText) findViewById(R.id.outof8);

        outOfText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        outOfText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        outOfText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        outOfText4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        outOfText5.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        outOfText6.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        outOfText7.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        outOfText8.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        weightText1 = (EditText) findViewById(R.id.weight1);
        weightText2 = (EditText) findViewById(R.id.weight2);
        weightText3 = (EditText) findViewById(R.id.weight3);
        weightText4 = (EditText) findViewById(R.id.weight4);
        weightText5 = (EditText) findViewById(R.id.weight5);
        weightText6 = (EditText) findViewById(R.id.weight6);
        weightText7 = (EditText) findViewById(R.id.weight7);
        weightText8 = (EditText) findViewById(R.id.weight8);

        weightText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightText4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightText5.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightText6.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightText7.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightText8.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        finalGrade = (EditText) findViewById(R.id.finalgrade);
        finalGrade.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        calculate = (Button) findViewById(R.id.calculateButton);
        calculate.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {
                                            calculateGrade();
                                         }
                                     });
    }

    public void calculateGrade() {
        double[] marks = new double[numEvals];
        double[] outOf = new double[numEvals];
        double[] weights = new double[numEvals];
        double fin;

        String[] markStrings = new String[numEvals];
        String[] outOfStrings = new String[numEvals];
        String[] weightStrings = new String[numEvals];

        double examWeight = 100; // 100 minus all weights inputted
        double c = 0;
        AlertDialog.Builder result;
        AlertDialog a;

        // Parse EditTexts as doubles

        markStrings[0] = markText1.getText().toString();
        markStrings[1] = markText2.getText().toString();
        markStrings[2] = markText3.getText().toString();
        markStrings[3] = markText4.getText().toString();
        markStrings[4] = markText5.getText().toString();
        markStrings[5] = markText6.getText().toString();
        markStrings[6] = markText7.getText().toString();
        markStrings[7] = markText8.getText().toString();

        outOfStrings[0] = outOfText1.getText().toString();
        outOfStrings[1] = outOfText2.getText().toString();
        outOfStrings[2] = outOfText3.getText().toString();
        outOfStrings[3] = outOfText4.getText().toString();
        outOfStrings[4] = outOfText5.getText().toString();
        outOfStrings[5] = outOfText6.getText().toString();
        outOfStrings[6] = outOfText7.getText().toString();
        outOfStrings[7] = outOfText8.getText().toString();

        weightStrings[0] = weightText1.getText().toString();
        weightStrings[1] = weightText2.getText().toString();
        weightStrings[2] = weightText3.getText().toString();
        weightStrings[3] = weightText4.getText().toString();
        weightStrings[4] = weightText5.getText().toString();
        weightStrings[5] = weightText6.getText().toString();
        weightStrings[6] = weightText7.getText().toString();
        weightStrings[7] = weightText8.getText().toString();

        for (int i = 0; i < numEvals; ++i) {
            // Do not parse blank strings (error!)
            if (!(markStrings[i].equals("") || outOfStrings[i].equals("") || weightStrings[i].equals(""))) {
                marks[i] = Double.parseDouble(markStrings[i]);
                outOf[i] = Double.parseDouble(outOfStrings[i]);
                weights[i] = Double.parseDouble(weightStrings[i]);
            }
            else continue;

            if (outOf[i] > 0) { // Valid division
                examWeight -= weights[i];
                c += ((marks[i] / outOf[i]) * 100) * weights[i];
            }
        }

        if (c <= 0 || finalGrade.getText().toString().equals("")) {
            result = new AlertDialog.Builder(this)
                    .setTitle("Invalid input")
                    .setMessage("Please enter a final grade and at least one evaluation.")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // ok
                        }
                    });
            a = result.create();
            a.show();
        }

        else if (examWeight <= 0) {
            result = new AlertDialog.Builder(this)
                    .setTitle("Invalid input")
                    .setMessage("Total evaluation weights must be under 100.")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // ok
                        }
                    });
            a = result.create();
            a.show();
        }

        else {
            fin = Double.parseDouble(finalGrade.getText().toString()); // Parse here in case field is blank
            double examGrade = ((fin * 100) - c) / examWeight;
            DecimalFormat df = new DecimalFormat("#.##");

            result = new AlertDialog.Builder(this)
                    .setTitle("Your exam grade")
                    .setMessage("Your final exam grade is " + df.format(examGrade) + "%!")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // ok
                        }
                    });
            a = result.create();
            a.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_help:
                openHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void openHelp() {
        AlertDialog.Builder help = new AlertDialog.Builder(this)
                .setTitle("Usage")
                .setMessage("For each of a course's evaluations, enter the weight, your mark, "
                        + "and what it was out of. Then enter the final grade you received. "
                        + "Press calculate, and view your final exam mark!")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // ok
                    }
                });
        AlertDialog a = help.create();
        a.show();
    }

}



