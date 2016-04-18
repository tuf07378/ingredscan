package edu.sfsu.cs.orange.ocr;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import edu.sfsu.cs.orange.ocr.database.DataBaseHelper;


public class ResultsActivity extends AppCompatActivity {

    private TextView text2;
    private TextView resultsView;
    private TextView ingredientsNotFoundView;
    private TextView ocrTextView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        text2 = (TextView) findViewById(R.id.text2);

        text2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Text2 was clicked",
                        Toast.LENGTH_LONG).show();
                text2.setText("Visit us: http://examples.javacodegeeks.com");

                if (text2.getLinksClickable() == true) {
                    text2.setLinkTextColor(Color.BLUE);
                }
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String ocrText = intent.getExtras().getString("ocrText");

        //Initializes our 3 textViews.
        resultsView = (TextView) findViewById(R.id.results_view);
        ingredientsNotFoundView = (TextView) findViewById(R.id.ingredients_not_found);
        ocrTextView= (TextView) findViewById(R.id.ocr_text);

        //Sets up our first textView, the OCR text.
        ocrTextView.setText("OCR Scan Result:\n" + ocrText);


        //Database procedure
        DataBaseHelper myDbHelper = new DataBaseHelper(this);
        myDbHelper = new DataBaseHelper(this);
        try {
        myDbHelper.createDataBase();
        } catch (IOException ioe) {
          throw new Error("Unable to create database");
        }
        try {
          myDbHelper.openDataBase();
        } catch (SQLException sqle) {
          throw sqle;
        }

        //Allergens (hardcoded for now)
        String[] allergens = {"Dairy", "Artificial Sweetener", "Carcinogenic"};
        String mainResultsInfo = myDbHelper.resultsInfo(ocrText, allergens);
        String ingredientsNotFound = myDbHelper.foodNotFoundList(ocrText);

        //Puts the main ingredient allergen results in the resultsView, and lists the ingredients not found
        resultsView.setText(mainResultsInfo);
        ingredientsNotFoundView.setText(ingredientsNotFound);




    }
}
