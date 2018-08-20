package com.example.user.itshaeds.Jobs;

import android.widget.CheckBox;

/**
 * Created by User on 04-Jul-18.
 */

public class JobsModelName {

    private String mID;
    private String Title;
    private String Exp;
    private String Country;
    private String Loc;
    private String CmpName;
    private String Keyskils;
    private String JobDesc;
    private String ExpLevel;
    //boolean selected = false;
                                                                                                                                                       //, boolean selected

    public JobsModelName(String mID, String title, String exp, String country, String loc, String cmpName, String keyskils, String jobDesc, String expLevel) {
        this.mID = mID;
        Title = title;
        Exp = exp;
        Country = country;
        Loc = loc;
        CmpName = cmpName;
        Keyskils = keyskils;
        JobDesc = jobDesc;
        ExpLevel = expLevel;
        //this.selected = selected;
    }

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getCmpName() {
        return CmpName;
    }

    public void setCmpName(String cmpName) {
        CmpName = cmpName;
    }

    public String getKeyskils() {
        return Keyskils;
    }

    public void setKeyskils(String keyskils) {
        Keyskils = keyskils;
    }

    public String getJobDesc() {
        return JobDesc;
    }

    public void setJobDesc(String jobDesc) {
        JobDesc = jobDesc;
    }

    public String getExpLevel() {
        return ExpLevel;
    }

    public void setExpLevel(String expLevel) {
        ExpLevel = expLevel;
    }

//    public boolean isSelected() {
//        return selected;
//    }
//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }

}

    //private String name;
    //private String exp;

//    private String mID;
//    private String Title;
//    private String Exp;
//    private String Country;
//    private String Loc;
//
//
//    public JobsModelName(String mID, String title, String exp, String country, String loc) {
//        this.mID = mID;
//        Title = title;
//        Exp = exp;
//        Country=country;
//        Loc = loc;
//    }
//
//    public String getmID() {
//        return mID;
//    }
//
//    public void setmID(String mID) {
//        this.mID = mID;
//    }
//
//    public String getTitle() {
//        return Title;
//    }
//
//    public void setTitle(String title) {
//        Title = title;
//    }
//
//    public String getExp() {
//        return Exp;
//    }
//
//    public void setExp(String exp) {
//        Exp = exp;
//    }
//
//    public String getCountry() {
//        return Country;
//    }
//
//    public void setCountry(String country) {
//        Country = country;
//    }
//
//    public String getLoc() {
//        return Loc;
//    }
//
//    public void setLoc(String loc) {
//        Loc = loc;
//    }


    //    public JobsModelName(String name, String exp) {
//        this.name = name;
//        this.exp = exp;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getExp() {
//        return exp;
//    }
//
//    public void setExp(String exp) {
//        this.exp = exp;
//    }



