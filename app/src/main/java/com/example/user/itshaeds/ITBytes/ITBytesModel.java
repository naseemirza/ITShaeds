package com.example.user.itshaeds.ITBytes;

/**
 * Created by User on 03-Jul-18.
 */

public class ITBytesModel {

    private String year;
    private String month_edition;

    private String Month;
    private String Edition;

    public ITBytesModel(String year, String month_edition, String month, String edition) {
        this.year = year;
        this.month_edition = month_edition;
        Month = month;
        Edition = edition;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth_edition() {
        return month_edition;
    }

    public void setMonth_edition(String month_edition) {
        this.month_edition = month_edition;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }
}
