package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.Blog;

/**
 * Created by User on 24-Sep-18.
 */

public class BlogModel {

    private String id;
    private String name;
    private String desc;
    private String status;
    private String action;

    private String BaseUrl="https://www.itshades.com/appdata/";

    public BlogModel(String id, String name, String desc,
                     String status, String action) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.action =BaseUrl+action;
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
