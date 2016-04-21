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

    private TextView resultsView;
    private String ocrText = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Code to get the OCR text from the previous activity.
        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            ocrText = intent.getExtras().getString("ocrText");
        }

        //Initializes our TextView
        resultsView = (TextView) findViewById(R.id.results_view);

        resultCompute();  //

        //Allergens (hardcoded, useful for testing)
        /*String[] allergensHardcoded = {"Artificial Sweetener", "Carcinogenic", "Dairy", "Egg", "Fish",
                "Meat", "Peanut", "Sesame", "Shellfish", "Soy", "Sweetener", "Trans Fat", "Tree Nut", "Wheat"};
                */
    }


    //Main Method that gives us our results and puts them in the TextView.
    public void resultCompute()
    {
        if(ocrText.length() > 0) {
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
            String[] allergens = allergenArray();
            String mainResultsInfo = myDbHelper.resultsInfo(ocrText, allergens);
            String ingredientsNotFound = myDbHelper.foodNotFoundList(ocrText);
            resultsView.setText("OCR Text: " + ocrText + "\nResult: " + mainResultsInfo + "\n" + ingredientsNotFound);
            myDbHelper.close(); //where I fixed the sql error :)<3333
        }
        else{
            resultsView.setText("No text scanned. Go to the camera and scan some text.");
        }
    }

    public String[] allergenArray() {
        AllergenPreferences ap = (AllergenPreferences) getApplication();
        String allergenList = "";
        if (ap.isArtificial_sweetener_enabled())
            allergenList += "Artificial Sweetener,";
        if (ap.isCarcinogenic_enabled())
            allergenList += "Carcinogenic,";
        if (ap.isDairy_enabled())
            allergenList += "Dairy,";
        if (ap.isEgg_enabled())
            allergenList += "Egg,";
        if (ap.isFish_enabled())
            allergenList += "Fish,";
        if (ap.isMeat_enabled())
            allergenList += "Meat,";
        if (ap.isPeanut_enabled())
            allergenList += "Peanut,";
        if (ap.isSesame_enabled())
            allergenList += "Sesame,";
        if (ap.isShellfish_enabled())
            allergenList += "Shellfish,";
        if (ap.isSoy_enabled())
            allergenList += "Soy,";
        if (ap.isSweetener_enabled())
            allergenList += "Sweetener,";
        if (ap.isTrans_fat_enabled())
            allergenList += "Trans Fat,";
        if (ap.isTree_nut_enabled())
            allergenList += "Tree Nut,";
        if (ap.isWheat_enabled())
            allergenList += "Wheat,";

        return stringtoArray(allergenList);
    }

    public String[] stringtoArray(String replacedStr) {
        String[] returnString = replacedStr.split(",");
        for (int i = 0; i < returnString.length; i++) {
            returnString[i] = returnString[i].replaceFirst(",", "");
        }
        return returnString;
    }
}
