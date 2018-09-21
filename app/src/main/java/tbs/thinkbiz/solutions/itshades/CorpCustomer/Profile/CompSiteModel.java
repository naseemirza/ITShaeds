package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

/**
 * Created by User on 20-Sep-18.
 */

public class CompSiteModel {

    private String name;
    private int image;

    public CompSiteModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
