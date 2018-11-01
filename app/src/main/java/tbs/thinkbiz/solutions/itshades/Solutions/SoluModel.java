package tbs.thinkbiz.solutions.itshades.Solutions;

/**
 * Created by User on 29-Aug-18.
 */

public class SoluModel {

    private String id;
    private String name;
    private String desc;
    private String IndAra;
    private String focsar;
    private String uprice;
    private String psted;
    private String evntstart;
    private String evntend;
    private String comsite;
   // private String BaseUrl="https://www.itshades.com/appwebservices/";

    public SoluModel(String id, String name, String desc,String IndAra, String focsar, String uprice,
                     String psted, String evntstart, String evntend,String comsite) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.IndAra = IndAra;
        this.focsar = focsar;
        this.uprice = uprice;
        this.psted = psted;
        this.evntstart = evntstart;
        this.evntend = evntend;
        this.comsite = comsite; //BaseUrl+
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIndAra() {
        return IndAra;
    }

    public void setIndAra(String indAra) {
        IndAra = indAra;
    }

    public String getFocsar() {
        return focsar;
    }

    public void setFocsar(String focsar) {
        this.focsar = focsar;
    }

    public String getUprice() {
        return uprice;
    }

    public void setUprice(String uprice) {
        this.uprice = uprice;
    }

    public String getPsted() {
        return psted;
    }

    public void setPsted(String psted) {
        this.psted = psted;
    }

    public String getEvntstart() {
        return evntstart;
    }

    public void setEvntstart(String evntstart) {
        this.evntstart = evntstart;
    }

    public String getEvntend() {
        return evntend;
    }

    public void setEvntend(String evntend) {
        this.evntend = evntend;
    }

    public String getComsite() {
        return comsite;
    }

    public void setComsite(String comsite) {
        this.comsite = comsite;
    }
}
