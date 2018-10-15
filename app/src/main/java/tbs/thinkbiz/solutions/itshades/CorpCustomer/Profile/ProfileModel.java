package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

/**
 * Created by User on 08-Aug-18.
 */

public class ProfileModel {
    String name;

    public ProfileModel(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
