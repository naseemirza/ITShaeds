package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission;

/**
 * Created by User on 14-Sep-18.
 */

public class JobSubModel  {

    private String id;
    private String title;
    private String keyskills;
    private String jobdesc;
    private String editable;

    private String EditUrl="https://www.itshades.com/appdata/";


    public JobSubModel(String id, String title, String keyskills, String jobdesc,String editable) {
        this.id = id;
        this.title = title;
        this.keyskills = keyskills;
        this.jobdesc = jobdesc;
        this.editable = EditUrl+editable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyskills() {
        return keyskills;
    }

    public void setKeyskills(String keyskills) {
        this.keyskills = keyskills;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }
}
