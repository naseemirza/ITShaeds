package tbs.thinkbiz.solutions.itshades.Jobs;

/**
 * Created by User on 08-Jun-18.
 */

public class ModelJobs  {


    private String name;
    private int image;

    public ModelJobs(String name, int image) {
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
