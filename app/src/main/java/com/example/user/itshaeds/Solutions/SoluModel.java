package com.example.user.itshaeds.Solutions;

/**
 * Created by User on 03-Aug-18.
 */

public class SoluModel {

    private String name;
    private String desc;
    private String Indrelby;
    private String Indrel;
    private String focarby;
    private String focsar;
    private String pstdby;
    private String psted;
    private String pstdate;
    private String date1;

    public SoluModel(String name, String desc, String indrelby, String indrel, String focarby, String focsar, String pstdby, String psted, String pstdate, String date1) {
        this.name = name;
        this.desc = desc;
        Indrelby = indrelby;
        Indrel = indrel;
        this.focarby = focarby;
        this.focsar = focsar;
        this.pstdby = pstdby;
        this.psted = psted;
        this.pstdate=pstdate;
        this.date1=date1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIndrelby() {
        return Indrelby;
    }

    public void setIndrelby(String indrelby) {
        Indrelby = indrelby;
    }

    public String getIndrel() {
        return Indrel;
    }

    public void setIndrel(String indrel) {
        Indrel = indrel;
    }

    public String getFocarby() {
        return focarby;
    }

    public void setFocarby(String focarby) {
        this.focarby = focarby;
    }

    public String getFocsar() {
        return focsar;
    }

    public void setFocsar(String focsar) {
        this.focsar = focsar;
    }

    public String getPstdby() {
        return pstdby;
    }

    public void setPstdby(String pstdby) {
        this.pstdby = pstdby;
    }

    public String getPsted() {
        return psted;
    }

    public void setPsted(String psted) {
        this.psted = psted;
    }

    public String getPstdate() {
        return pstdate;
    }

    public void setPstdate(String pstdate) {
        this.pstdate = pstdate;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
}
