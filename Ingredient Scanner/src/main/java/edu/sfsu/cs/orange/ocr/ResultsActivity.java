package edu.sfsu.cs.orange.ocr;

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
        Bundle bundle = getIntent().getExtras();
        String ocrText = bundle.getString("ocrText");
        String str1= "spaghetti";
        String str2 = "meatballs";
        String str3 = str1 + " and " + str2;
        resultsView = (TextView) findViewById(R.id.results_view);

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

    String[] allergens = {"Dairy", "Artificial Sweetener", "Carcinogenic"};
    String mainResultsInfo = myDbHelper.resultsInfo(ocrText, allergens);
    String ingredientsNotFound = myDbHelper.foodNotFoundList(ocrText);

    String finalResults = "OCR text:\n" + ocrText  + "\n" + "Main Results: " +   mainResultsInfo + "\n" + ingredientsNotFound;

        resultsView.setText(mainResultsInfo);

    }
}
