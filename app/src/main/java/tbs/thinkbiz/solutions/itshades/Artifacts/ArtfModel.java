package tbs.thinkbiz.solutions.itshades.Artifacts;

/**
 * Created by User on 29-Aug-18.
 */

public class ArtfModel {

    private String id;
    private String name;
    private String desc;
    private String IndAra;
    private String focsar;
    private String pstedby;
    private String pstdate;
    private String comsite;

    public ArtfModel(String id, String name, String desc, String indAra, String focsar, String pstedby, String pstdate,String comsite) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        IndAra = indAra;
        this.focsar = focsar;
        this.pstedby = pstedby;
        this.pstdate = pstdate;
        this.comsite = comsite;
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

    public String getPstedby() {
        return pstedby;
    }

    public void setPstedby(String pstedby) {
        this.pstedby = pstedby;
    }

    public String getPstdate() {
        return pstdate;
    }

    public void setPstdate(String pstdate) {
        this.pstdate = pstdate;
    }

    public String getComsite() {
        return comsite;
    }

    public void setComsite(String comsite) {
        this.comsite = comsite;
    }
}
