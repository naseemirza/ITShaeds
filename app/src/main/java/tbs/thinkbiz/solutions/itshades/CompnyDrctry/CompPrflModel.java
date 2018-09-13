package tbs.thinkbiz.solutions.itshades.CompnyDrctry;

/**
 * Created by User on 30-Jul-18.
 */

public class CompPrflModel {
    private String name;
    private int image;

    public CompPrflModel(String name, int image) {
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
