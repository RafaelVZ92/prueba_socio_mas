
package com.example.nycschool.schools.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchoolsData implements Parcelable {

    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("school_name")
    @Expose
    private String schoolName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("school_email")
    @Expose
    private String schoolEmail;

    protected SchoolsData(Parcel in) {
        dbn = in.readString();
        schoolName = in.readString();
        location = in.readString();
        website = in.readString();
        schoolEmail = in.readString();
    }

    public static final Creator<SchoolsData> CREATOR = new Creator<SchoolsData>() {
        @Override
        public SchoolsData createFromParcel(Parcel in) {
            return new SchoolsData(in);
        }

        @Override
        public SchoolsData[] newArray(int size) {
            return new SchoolsData[size];
        }
    };

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dbn);
        dest.writeString(schoolName);
        dest.writeString(location);
        dest.writeString(website);
        dest.writeString(schoolEmail);
    }
}
