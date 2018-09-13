package tbs.thinkbiz.solutions.itshades.Jobs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 04-Jul-18.
 */

public class JobsModelName  implements Parcelable {

    private String mID;
    private String Title;
    private String Exp;
    private String Country;
    private String Loc;
    private String CmpName;
    private String Keyskils;
    private String JobDesc;
    private String ExpLevel;


    public JobsModelName(String mID, String title, String exp, String country, String loc, String cmpName, String keyskils, String jobDesc, String expLevel) {
        this.mID = mID;
        Title = title;
        Exp = exp;
        Country = country;
        Loc = loc;
        CmpName = cmpName;
        Keyskils = keyskils;
        JobDesc = jobDesc;
        ExpLevel = expLevel;
    }

    protected JobsModelName(Parcel in) {
        mID = in.readString();
        Title = in.readString();
        Exp = in.readString();
        Country = in.readString();
        Loc = in.readString();
        CmpName = in.readString();
        Keyskils = in.readString();
        JobDesc = in.readString();
        ExpLevel = in.readString();
    }

    public static final Parcelable.Creator<JobsModelName> CREATOR = new Parcelable.Creator<JobsModelName>() {
        @Override
        public JobsModelName createFromParcel(Parcel in) {
            return new JobsModelName(in);
        }

        @Override
        public JobsModelName[] newArray(int size) {
            return new JobsModelName[size];
        }
    };

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getCmpName() {
        return CmpName;
    }

    public void setCmpName(String cmpName) {
        CmpName = cmpName;
    }

    public String getKeyskils() {
        return Keyskils;
    }

    public void setKeyskils(String keyskils) {
        Keyskils = keyskils;
    }

    public String getJobDesc() {
        return JobDesc;
    }

    public void setJobDesc(String jobDesc) {
        JobDesc = jobDesc;
    }

    public String getExpLevel() {
        return ExpLevel;
    }

    public void setExpLevel(String expLevel) {
        ExpLevel = expLevel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mID);
        parcel.writeString(Title);
        parcel.writeString(Exp);
        parcel.writeString(Country);
        parcel.writeString(Loc);
        parcel.writeString(CmpName);
        parcel.writeString(Keyskils);
        parcel.writeString(JobDesc);
        parcel.writeString(ExpLevel);
    }


}





