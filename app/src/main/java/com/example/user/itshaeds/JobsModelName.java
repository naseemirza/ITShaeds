package com.example.user.itshaeds;

import android.widget.CheckBox;

/**
 * Created by User on 04-Jul-18.
 */

public class JobsModelName  {

    private String name;
    private String exp;
    //private boolean selected;
                                              //, boolean selected
    public JobsModelName(String name, String exp) {
        this.name = name;
        this.exp = exp;
        //this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

//    public boolean getSelected() {
//        return selected;
//    }
//
//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }
}

