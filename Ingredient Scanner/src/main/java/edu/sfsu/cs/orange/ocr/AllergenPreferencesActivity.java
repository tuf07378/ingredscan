package edu.sfsu.cs.orange.ocr;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


public class AllergenPreferencesActivity extends AppCompatActivity {

    private CheckBox allergen_checkbox_1;
    private CheckBox allergen_checkbox_2;
    private CheckBox allergen_checkbox_3;
    private CheckBox allergen_checkbox_4;
    private CheckBox allergen_checkbox_5;
    private CheckBox allergen_checkbox_6;
    private CheckBox allergen_checkbox_7;
    private CheckBox allergen_checkbox_8;
    private CheckBox allergen_checkbox_9;
    private CheckBox allergen_checkbox_10;
    private CheckBox allergen_checkbox_11;
    private CheckBox allergen_checkbox_12;
    private CheckBox allergen_checkbox_13;
    private CheckBox allergen_checkbox_14;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allergen_list_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addListenerOnButtons();
    }

    public void addListenerOnButtons(){
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        allergen_checkbox_1 = (CheckBox)findViewById(R.id.artificial_sweetener_enabled);
        allergen_checkbox_2 = (CheckBox)findViewById(R.id.carcinogenic_enabled);
        allergen_checkbox_3 = (CheckBox)findViewById(R.id.dairy_enabled);
        allergen_checkbox_4 = (CheckBox)findViewById(R.id.egg_enabled);
        allergen_checkbox_5 = (CheckBox)findViewById(R.id.fish_enabled);
        allergen_checkbox_6 = (CheckBox)findViewById(R.id.meat_enabled);
        allergen_checkbox_7 = (CheckBox)findViewById(R.id.peanut_enabled);
        allergen_checkbox_8 = (CheckBox)findViewById(R.id.sesame_enabled);
        allergen_checkbox_9 = (CheckBox)findViewById(R.id.shellfish_enabled);
        allergen_checkbox_10 = (CheckBox)findViewById(R.id.soy_enabled);
        allergen_checkbox_11 = (CheckBox)findViewById(R.id.sweetener_enabled);
        allergen_checkbox_12 = (CheckBox)findViewById(R.id.trans_fat_enabled);
        allergen_checkbox_13 = (CheckBox)findViewById(R.id.tree_nut_enabled);
        allergen_checkbox_14 = (CheckBox)findViewById(R.id.wheat_enabled);
        allergen_checkbox_1.setChecked(prefs.getBoolean("allergen_checkbox_1", true));  //the second parameter is the default string to use if the variable isn't found!)
        allergen_checkbox_2.setChecked(prefs.getBoolean("allergen_checkbox_2", true));
        allergen_checkbox_3.setChecked(prefs.getBoolean("allergen_checkbox_3", true));
        allergen_checkbox_4.setChecked(prefs.getBoolean("allergen_checkbox_4", true));
        allergen_checkbox_5.setChecked(prefs.getBoolean("allergen_checkbox_5", true));
        allergen_checkbox_6.setChecked(prefs.getBoolean("allergen_checkbox_6", true));
        allergen_checkbox_7.setChecked(prefs.getBoolean("allergen_checkbox_7", true));
        allergen_checkbox_8.setChecked(prefs.getBoolean("allergen_checkbox_8", true));
        allergen_checkbox_9.setChecked(prefs.getBoolean("allergen_checkbox_9", true));
        allergen_checkbox_10.setChecked(prefs.getBoolean("allergen_checkbox_10", true));
        allergen_checkbox_11.setChecked(prefs.getBoolean("allergen_checkbox_11", true));
        allergen_checkbox_12.setChecked(prefs.getBoolean("allergen_checkbox_12", true));
        allergen_checkbox_13.setChecked(prefs.getBoolean("allergen_checkbox_13", true));
        allergen_checkbox_14.setChecked(prefs.getBoolean("allergen_checkbox_14", true));

        allergen_checkbox_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_1", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_1", false).apply();
                }
            }
        });

        allergen_checkbox_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_2", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_2", false).apply();
                }
            }
        });
        allergen_checkbox_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_3", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_3", false).apply();
                }
            }
        });
        allergen_checkbox_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_4", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_4", false).apply();
                }
            }
        });
        allergen_checkbox_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_5", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_5", false).apply();
                }
            }
        });
        allergen_checkbox_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_6", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_6", false).apply();
                }
            }
        });
        allergen_checkbox_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_7", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_7", false).apply();
                }
            }
        });
        allergen_checkbox_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_8", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_8", false).apply();
                }
            }
        });
        allergen_checkbox_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_9", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_9", false).apply();
                }
            }
        });
        allergen_checkbox_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_10", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_10", false).apply();
                }
            }
        });
        allergen_checkbox_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_11", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_11", false).apply();
                }
            }
        });
        allergen_checkbox_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_12", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_12", false).apply();
                }
            }
        });
        allergen_checkbox_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_13", true).apply();
                }else{
                    prefs.edit().putBoolean("allergen_checkbox_13", false).apply();
                }
            }
        });
        allergen_checkbox_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergen_checkbox_1.isChecked()){
                    prefs.edit().putBoolean("allergen_checkbox_14", true).apply();
                }else{
                    System.out.println("wheat checked");
                    prefs.edit().putBoolean("allergen_checkbox_14", false).apply();
                }
            }
        });
    }

}
