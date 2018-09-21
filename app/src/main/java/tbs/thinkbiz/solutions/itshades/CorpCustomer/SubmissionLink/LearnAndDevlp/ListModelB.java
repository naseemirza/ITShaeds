package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp;

/**
 * Created by User on 19-Sep-18.
 */

public class ListModelB {

    private String id;
    private String name;
    private String indsRelv;
    private String focsAra;
    private String userPrice;
    private String addeddate;
    private String status;
    private String action;

    private String BaseUrl="https://www.itshades.com/appdata/";

    public ListModelB(String id, String name, String indsRelv, String focsAra,
                      String userPrice, String addeddate, String status, String action) {
        this.id = id;
        this.name = name;
        this.indsRelv = indsRelv;
        this.focsAra = focsAra;
        this.userPrice = userPrice;
        this.addeddate = addeddate;
        this.status = status;
        this.action = BaseUrl+action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndsRelv() {
        return indsRelv;
    }

    public void setIndsRelv(String indsRelv) {
        this.indsRelv = indsRelv;
    }

    public String getFocsAra() {
        return focsAra;
    }

    public void setFocsAra(String focsAra) {
        this.focsAra = focsAra;
    }

    public String getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(String userPrice) {
        this.userPrice = userPrice;
    }

    public String getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(String addeddate) {
        this.addeddate = addeddate;
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
