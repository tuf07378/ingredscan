package edu.sfsu.cs.orange.ocr;

import android.app.Application;

/**
 * Created by Vlad on 4/19/2016.
 */


//This class is no longer used, due to the switch to SharedPreferences from this Global class.
public class AllergenPreferences extends Application {

    private boolean artificial_sweetener_enabled, carcinogenic_enabled, dairy_enabled, egg_enabled,
            fish_enabled, meat_enabled, peanut_enabled, sesame_enabled, shellfish_enabled, soy_enabled, sweetener_enabled, trans_fat_enabled, tree_nut_enabled, wheat_enabled;

    public AllergenPreferences() {
        artificial_sweetener_enabled = carcinogenic_enabled = dairy_enabled = egg_enabled = fish_enabled = meat_enabled = peanut_enabled = sesame_enabled = shellfish_enabled = soy_enabled = sweetener_enabled = trans_fat_enabled = tree_nut_enabled = wheat_enabled = true;
    }

    public boolean isArtificial_sweetener_enabled() {
        return artificial_sweetener_enabled;
    }

    public void setArtificial_sweetener_enabled(boolean artificial_sweetener_enabled) {
        this.artificial_sweetener_enabled = artificial_sweetener_enabled;
    }

    public boolean isCarcinogenic_enabled() {
        return carcinogenic_enabled;
    }

    public void setCarcinogenic_enabled(boolean carcinogenic_enabled) {
        this.carcinogenic_enabled = carcinogenic_enabled;
    }

    public boolean isDairy_enabled() {
        return dairy_enabled;
    }

    public void setDairy_enabled(boolean dairy_enabled) {
        this.dairy_enabled = dairy_enabled;
    }

    public boolean isEgg_enabled() {
        return egg_enabled;
    }

    public void setEgg_enabled(boolean egg_enabled) {
        this.egg_enabled = egg_enabled;
    }

    public boolean isFish_enabled() {
        return fish_enabled;
    }

    public void setFish_enabled(boolean fish_enabled) {
        this.fish_enabled = fish_enabled;
    }

    public boolean isMeat_enabled() {
        return meat_enabled;
    }

    public void setMeat_enabled(boolean meat_enabled) {
        this.meat_enabled = meat_enabled;
    }

    public boolean isPeanut_enabled() {
        return peanut_enabled;
    }

    public void setPeanut_enabled(boolean peanut_enabled) {
        this.peanut_enabled = peanut_enabled;
    }

    public boolean isSesame_enabled() {
        return sesame_enabled;
    }

    public void setSesame_enabled(boolean sesame_enabled) {
        this.sesame_enabled = sesame_enabled;
    }

    public boolean isShellfish_enabled() {
        return shellfish_enabled;
    }

    public void setShellfish_enabled(boolean shellfish_enabled) {
        this.shellfish_enabled = shellfish_enabled;
    }

    public boolean isSoy_enabled() {
        return soy_enabled;
    }

    public void setSoy_enabled(boolean soy_enabled) {
        this.soy_enabled = soy_enabled;
    }

    public boolean isSweetener_enabled() {
        return sweetener_enabled;
    }

    public void setSweetener_enabled(boolean sweetener_enabled) {
        this.sweetener_enabled = sweetener_enabled;
    }

    public boolean isTrans_fat_enabled() {
        return trans_fat_enabled;
    }

    public void setTrans_fat_enabled(boolean trans_fat_enabled) {
        this.trans_fat_enabled = trans_fat_enabled;
    }

    public boolean isTree_nut_enabled() {
        return tree_nut_enabled;
    }

    public void setTree_nut_enabled(boolean tree_nut_enabled) {
        this.tree_nut_enabled = tree_nut_enabled;
    }

    public boolean isWheat_enabled() {
        return wheat_enabled;
    }

    public void setWheat_enabled(boolean wheat_enabled) {
        this.wheat_enabled = wheat_enabled;
    }
}
