package tbs.thinkbiz.solutions.itshades.ITBytes;

/**
 * Created by User on 03-Jul-18.
 */

public class ITBytesModel {

    private String year;
    private String yeardisplay;
    private String monthedition;

    public ITBytesModel(String year, String yeardisplay, String monthedition) {
        this.year = year;
        this.yeardisplay = yeardisplay;
        this.monthedition = monthedition;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYeardisplay() {
        return yeardisplay;
    }

    public void setYeardisplay(String yeardisplay) {
        this.yeardisplay = yeardisplay;
    }

    public String getMonthedition() {
        return monthedition;
    }

    public void setMonthedition(String monthedition) {
        this.monthedition = monthedition;
    }
}
