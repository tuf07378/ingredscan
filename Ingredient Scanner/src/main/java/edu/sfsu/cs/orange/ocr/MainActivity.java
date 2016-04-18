package edu.sfsu.cs.orange.ocr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cameraActivityButton;
    Button settingsActivityButton;
    Button resultsActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String sendTest = "test from main activity";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraActivityButton = (Button)findViewById(R.id.capture_activity_button);
        cameraActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivity(i); //will send us there
            }
        });

        settingsActivityButton = (Button)findViewById(R.id.settings_button);
        settingsActivityButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PreferencesActivity.class);
                startActivity(i); //sends us to options!
            }
        });

        resultsActivityButton = (Button)findViewById(R.id.results_button_test);
        resultsActivityButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResultsActivity.class);
                i.putExtra("mainActivityTest", sendTest);
                startActivity(i); //sends us to results test!
            }
        });
    }
}
