package edu.sfsu.cs.orange.ocr;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;


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



        allergen_checkbox_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_1", isChecked).commit();
            }
        });

        allergen_checkbox_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_2", isChecked).commit();
            }
        });
        allergen_checkbox_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_3", isChecked).commit();
            }
        });
        allergen_checkbox_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_3", isChecked).commit();
            }
        });
        allergen_checkbox_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_4", isChecked).commit();
            }
        });
        allergen_checkbox_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_5", isChecked).commit();
            }
        });
        allergen_checkbox_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_6", isChecked).commit();
            }
        });
        allergen_checkbox_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_7", isChecked).commit();
            }
        });
        allergen_checkbox_8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_8", isChecked).commit();
            }
        });
        allergen_checkbox_9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_9", isChecked).commit();
            }
        });
        allergen_checkbox_10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_10", isChecked).commit();
            }
        });
        allergen_checkbox_11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_11", isChecked).commit();
            }
        });
        allergen_checkbox_12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_12", isChecked).commit();
            }
        });
        allergen_checkbox_13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_13", isChecked).commit();
            }
        });
        allergen_checkbox_14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                prefs.edit().putBoolean("allergen_checkbox_14", isChecked).commit();
            }
        });

    }

}
