package com.example.user.itshaeds.ITBytes;

/**
 * Created by User on 09-Aug-18.
 */

public class ITbytdetalsmodel {

    private String name;
    private String exp;

    public ITbytdetalsmodel(String name, String exp) {
        this.name = name;
        this.exp = exp;
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
}
