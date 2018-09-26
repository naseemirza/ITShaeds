package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.MyEmployer;

/**
 * Created by User on 25-Sep-18.
 */

public class MyEmpModel {
    private String id;
    private String fname;
    private String lname;
    private String email;
    private String addedate;
    private String status;
    private String action;

    private String BaseUrl="https://www.itshades.com/appdata/";

    public MyEmpModel(String id, String fname, String lname, String email, String addedate, String status, String action) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.addedate = addedate;
        this.status = status;
        this.action = BaseUrl+action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddedate() {
        return addedate;
    }

    public void setAddedate(String addedate) {
        this.addedate = addedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
