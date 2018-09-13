package tbs.thinkbiz.solutions.itshades.LearningAndDevelopment;

/**
 * Created by User on 03-Aug-18.
 */

public class LnDModel {

    private String id;
    private String name;
    private String desc;
    private String Indrel;
    private String focsar;
    private String psted;


    public LnDModel(String id, String name, String desc, String indrel, String focsar, String psted) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        Indrel = indrel;
        this.focsar = focsar;
        this.psted = psted;

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

    public String getIndrel() {
        return Indrel;
    }

    public void setIndrel(String indrel) {
        Indrel = indrel;
    }

    public String getFocsar() {
        return focsar;
    }

    public void setFocsar(String focsar) {
        this.focsar = focsar;
    }

    public String getPsted() {
        return psted;
    }

    public void setPsted(String psted) {
        this.psted = psted;
    }
}
