package edu.sfsu.cs.orange.ocr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
        ocrText = "Sybean oil, Crayfish, Macademia Nut, Molasses, Choccolate, Peanut Buttar, Yoghurt";
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

            String ingredientsNotFound = "";
            ingredientsNotFound = myDbHelper.foodNotFoundList(ocrText); // Old method of getting the list.


            resultsView.setText("OCR Text: " + ocrText + "\n\nResult: " + mainResultsInfo + "\n" + ingredientsNotFound);
            myDbHelper.close(); //where I fixed the sql error :)<3333
        }
        else{
            resultsView.setText("No text scanned. Go to the camera and scan some text.");
        }
    }

    public String[] allergenArray() {
        final SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(this);

        String allergenList = "";
        if (prefs.getBoolean("allergen_checkbox_1", true))
            allergenList += "Artificial Sweetener,";
        if (prefs.getBoolean("allergen_checkbox_2", true))
            allergenList += "Carcinogenic,";
        if (prefs.getBoolean("allergen_checkbox_3", true))
            allergenList += "Dairy,";
        if (prefs.getBoolean("allergen_checkbox_4", true))
            allergenList += "Egg,";
        if (prefs.getBoolean("allergen_checkbox_5", true))
            allergenList += "Fish,";
        if (prefs.getBoolean("allergen_checkbox_6", true))
            allergenList += "Meat,";
        if (prefs.getBoolean("allergen_checkbox_7", true))
            allergenList += "Peanut,";
        if (prefs.getBoolean("allergen_checkbox_8", true))
            allergenList += "Sesame,";
        if (prefs.getBoolean("allergen_checkbox_9", true))
            allergenList += "Shellfish,";
        if (prefs.getBoolean("allergen_checkbox_10", true))
            allergenList += "Soy,";
        if (prefs.getBoolean("allergen_checkbox_11", true))
            allergenList += "Sweetener,";
        if (prefs.getBoolean("allergen_checkbox_12", true))
            allergenList += "Trans Fat,";
        if (prefs.getBoolean("allergen_checkbox_13", true))
            allergenList += "Tree Nut,";
        if (prefs.getBoolean("allergen_checkbox_14", true))
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
