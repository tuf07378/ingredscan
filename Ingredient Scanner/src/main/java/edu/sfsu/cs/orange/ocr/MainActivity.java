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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }
}
