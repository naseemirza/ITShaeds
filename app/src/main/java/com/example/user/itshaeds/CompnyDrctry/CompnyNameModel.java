package com.example.user.itshaeds.CompnyDrctry;

/**
 * Created by User on 27-Jul-18.
 */

public class CompnyNameModel {

    private String siteID;
    private String siteName;
    private String sitelogo;
    private String Descr;
    private String siteurl;
    private String cntryCode;
    private String number;
    private String mailID;
    private String image_path="https://www.itshades.com/comapny_logo/";

    public CompnyNameModel(String siteID, String siteName, String sitelogo, String descr, String siteurl, String cntryCode, String number, String mailID) {
        this.siteID = siteID;
        this.siteName = siteName;
        this.sitelogo = image_path+sitelogo;
        Descr = descr;
        this.siteurl = siteurl;
        this.cntryCode = cntryCode;
        this.number = number;
        this.mailID = mailID;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSitelogo() {
        return sitelogo;
    }

    public void setSitelogo(String sitelogo) {
        this.sitelogo = sitelogo;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    public String getCntryCode() {
        return cntryCode;
    }

    public void setCntryCode(String cntryCode) {
        this.cntryCode = cntryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }
}
