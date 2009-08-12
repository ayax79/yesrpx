package org.yestech.rpx.objectmodel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;
import java.util.Collections;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "merged_poco")
public class MergedPoco {

    private Gender gender;
    private List<Url> urls = Collections.emptyList();
    private String preferredUsername;
    private String displayname;
    private Date birthday;
    private List<Email> emails = Collections.emptyList();

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MergedPoco that = (MergedPoco) o;

        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (displayname != null ? !displayname.equals(that.displayname) : that.displayname != null) return false;
        if (emails != null ? !emails.equals(that.emails) : that.emails != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (preferredUsername != null ? !preferredUsername.equals(that.preferredUsername) : that.preferredUsername != null)
            return false;
        //noinspection RedundantIfStatement
        if (urls != null ? !urls.equals(that.urls) : that.urls != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gender != null ? gender.hashCode() : 0;
        result = 31 * result + (urls != null ? urls.hashCode() : 0);
        result = 31 * result + (preferredUsername != null ? preferredUsername.hashCode() : 0);
        result = 31 * result + (displayname != null ? displayname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (emails != null ? emails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MergedPoco{" +
                "gender=" + gender +
                ", urls=" + urls +
                ", preferredUsername='" + preferredUsername + '\'' +
                ", displayname='" + displayname + '\'' +
                ", birthday=" + birthday +
                ", emails=" + emails +
                '}';
    }
}
