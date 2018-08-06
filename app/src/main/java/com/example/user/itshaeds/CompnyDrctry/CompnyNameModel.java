package com.example.user.itshaeds.CompnyDrctry;

/**
 * Created by User on 27-Jul-18.
 */

public class CompnyNameModel {
    private String name;
    private int compnydesc;
    private int image;

    public CompnyNameModel(String name, int compnydesc, int image) {
        this.name = name;
        this.compnydesc = compnydesc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompnydesc() {
        return compnydesc;
    }

    public void setCompnydesc(int compnydesc) {
        this.compnydesc = compnydesc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
