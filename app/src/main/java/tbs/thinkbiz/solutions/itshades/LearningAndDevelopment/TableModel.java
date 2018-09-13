package tbs.thinkbiz.solutions.itshades.LearningAndDevelopment;

import android.widget.TextView;

/**
 * Created by User on 12-Sep-18.
 */

public class TableModel {

    private String id;
    private String srnumbr;
    private String address;
    private String country;
    private String TelconBrdg;
    private String City;
    private String Userprice;
    private String Reglink;
    private String postedby;
    private String strtdate;
    private String endate;
    private String resource;

    public TableModel(String id, String srnumbr, String address, String country, String telconBrdg, String city,
                      String userprice, String reglink, String postedby, String strtdate, String endate, String resource) {
        this.id = id;
        this.srnumbr = srnumbr;
        this.address = address;
        this.country = country;
        TelconBrdg = telconBrdg;
        City = city;
        Userprice = userprice;
        Reglink = reglink;
        this.postedby = postedby;
        this.strtdate = strtdate;
        this.endate = endate;
        this.resource = resource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrnumbr() {
        return srnumbr;
    }

    public void setSrnumbr(String srnumbr) {
        this.srnumbr = srnumbr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelconBrdg() {
        return TelconBrdg;
    }

    public void setTelconBrdg(String telconBrdg) {
        TelconBrdg = telconBrdg;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getUserprice() {
        return Userprice;
    }

    public void setUserprice(String userprice) {
        Userprice = userprice;
    }

    public String getReglink() {
        return Reglink;
    }

    public void setReglink(String reglink) {
        Reglink = reglink;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public String getStrtdate() {
        return strtdate;
    }

    public void setStrtdate(String strtdate) {
        this.strtdate = strtdate;
    }

    public String getEndate() {
        return endate;
    }

    public void setEndate(String endate) {
        this.endate = endate;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
