package com.example.user.itshaeds.ITBytes;

/**
 * Created by User on 09-Aug-18.
 */

public class ITbytdetalsmodel {

    private String id ;
    private String titlename;
    private String descr;

    public ITbytdetalsmodel(String id, String titlename, String descr) {
        this.id = id;
        this.titlename = titlename;
        this.descr = descr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
