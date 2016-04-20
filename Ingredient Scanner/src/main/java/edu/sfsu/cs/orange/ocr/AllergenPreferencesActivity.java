package edu.sfsu.cs.orange.ocr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class AllergenPreferencesActivity extends AppCompatActivity {

    CheckBox allergen_button_1;
    CheckBox allergen_button_2;
    CheckBox allergen_button_3;
    CheckBox allergen_button_4;
    CheckBox allergen_button_5;
    CheckBox allergen_button_6;
    CheckBox allergen_button_7;
    CheckBox allergen_button_8;
    CheckBox allergen_button_9;
    CheckBox allergen_button_10;
    CheckBox allergen_button_11;
    CheckBox allergen_button_12;
    CheckBox allergen_button_13;
    CheckBox allergen_button_14;
    Button save_settings_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allergen_list_layout);
        addListenerOnButton();

    }

    public void addListenerOnButton(){
        allergen_button_1 = (CheckBox)findViewById(R.id.artificial_sweetener_enabled);
        allergen_button_2 = (CheckBox)findViewById(R.id.carcinogenic_enabled);
        allergen_button_3 = (CheckBox)findViewById(R.id.dairy_enabled);
        allergen_button_4 = (CheckBox)findViewById(R.id.egg_enabled);
        allergen_button_5 = (CheckBox)findViewById(R.id.fish_enabled);
        allergen_button_6 = (CheckBox)findViewById(R.id.meat_enabled);
        allergen_button_7 = (CheckBox)findViewById(R.id.peanut_enabled);
        allergen_button_8 = (CheckBox)findViewById(R.id.sesame_enabled);
        allergen_button_9 = (CheckBox)findViewById(R.id.shellfish_enabled);
        allergen_button_10 = (CheckBox)findViewById(R.id.soy_enabled);
        allergen_button_11 = (CheckBox)findViewById(R.id.sweetener_enabled);
        allergen_button_12 = (CheckBox)findViewById(R.id.trans_fat_enabled);
        allergen_button_13 = (CheckBox)findViewById(R.id.tree_nut_enabled);
        allergen_button_14 = (CheckBox)findViewById(R.id.wheat_enabled);
        save_settings_button = (Button)findViewById(R.id.save_allergy_preferences);
        save_settings_button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(AllergenPreferencesActivity.this, "Saved preferences", Toast.LENGTH_LONG).show();
                        savePreferences();
                    }
                }

        );

    }

    public void savePreferences()
    {
        AllergenPreferences ap =(AllergenPreferences)getApplication();
        if(allergen_button_1.isChecked())
            ap.setArtificial_sweetener_enabled(true);
        else
            ap.setArtificial_sweetener_enabled(false);
        if(allergen_button_2.isChecked())
            ap.setCarcinogenic_enabled(true);
        else
            ap.setCarcinogenic_enabled(false);
        if(allergen_button_3.isChecked())
            ap.setDairy_enabled(true);
        else
            ap.setDairy_enabled(false);
        if(allergen_button_4.isChecked())
            ap.setEgg_enabled(true);
        else
            ap.setEgg_enabled(false);
        if(allergen_button_5.isChecked())
            ap.setFish_enabled(true);
        else
            ap.setFish_enabled(false);
        if(allergen_button_6.isChecked())
            ap.setMeat_enabled(true);
        else
            ap.setMeat_enabled(false);
        if(allergen_button_7.isChecked())
            ap.setPeanut_enabled(true);
        else
            ap.setPeanut_enabled(false);
        if(allergen_button_8.isChecked())
            ap.setSesame_enabled(true);
        else
            ap.setSesame_enabled(false);
        if(allergen_button_9.isChecked())
            ap.setShellfish_enabled(true);
        else
            ap.setShellfish_enabled(false);
        if(allergen_button_10.isChecked())
            ap.setSoy_enabled(true);
        else
            ap.setSoy_enabled(false);
        if(allergen_button_11.isChecked())
            ap.setSweetener_enabled(true);
        else
            ap.setSweetener_enabled(false);
        if(allergen_button_12.isChecked())
            ap.setTrans_fat_enabled(true);
        else
            ap.setTrans_fat_enabled(false);
        if(allergen_button_13.isChecked())
            ap.setTree_nut_enabled(true);
        else
            ap.setTree_nut_enabled(false);
        if(allergen_button_14.isChecked())
            ap.setWheat_enabled(true);
        else
            ap.setWheat_enabled(false);


    }
}
