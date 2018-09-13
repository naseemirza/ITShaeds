package tbs.thinkbiz.solutions.itshades.LearningAndDevelopment;

/**
 * Created by User on 11-Sep-18.
 */

public class LnDRltdModel {

    private String id;
    private String name;
    private String desc;
    private String IndAra;
    private String focsar;
    private String teleconbrdg;
    private String pstedby;

    public LnDRltdModel(String id, String name, String desc, String indAra, String focsar, String teleconbrdg, String pstedby) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        IndAra = indAra;
        this.focsar = focsar;
        this.teleconbrdg = teleconbrdg;
        this.pstedby = pstedby;
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

    public String getTeleconbrdg() {
        return teleconbrdg;
    }

    public void setTeleconbrdg(String teleconbrdg) {
        this.teleconbrdg = teleconbrdg;
    }

    public String getPstedby() {
        return pstedby;
    }

    public void setPstedby(String pstedby) {
        this.pstedby = pstedby;
    }
}
