package com.example.user.itshaeds.ITBytes;

/**
 * Created by User on 03-Jul-18.
 */

public class ITBytesModel {

    private String Name;
    private String Desc;

    public ITBytesModel(String name, String desc) {
        Name = name;
        Desc = desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
