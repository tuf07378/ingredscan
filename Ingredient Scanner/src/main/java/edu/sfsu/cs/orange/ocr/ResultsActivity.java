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
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String ocrText = "";
        if(intent.getExtras() != null) {
             ocrText = intent.getExtras().getString("ocrText");
        }

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
        //fuckin A
        String[] allergens = {"Artificial Additives", "Artificial Sweetener", "Carcinogenic", "Cocoa", "Dairy", "Egg", "Fish",
                "Meat", "Peanut", "Sesame", "Shellfish", "Soy", "Sweetener", "Trans Fat", "Tree Nut", "Wheat"} ;
        String mainResultsInfo = myDbHelper.resultsInfo(ocrText, allergens);
        String ingredientsNotFound = myDbHelper.foodNotFoundList(ocrText);

        //Puts the main ingredient allergen results in the resultsView, and lists the ingredients not found
        resultsView.setText(mainResultsInfo);
        ingredientsNotFoundView.setText(ingredientsNotFound);





    }
}
