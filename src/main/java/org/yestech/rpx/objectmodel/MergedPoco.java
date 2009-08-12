package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXDateTimeUtil.fromRPXDateString;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "merged_poco")
public class MergedPoco {

    private Gender gender;
    private List<Url> urls = Collections.emptyList();
    private String preferredUsername;
    private String displayname;
    private DateTime birthday;
    private List<Email> emails = Collections.emptyList();
    private Name name;

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

    public DateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MergedPoco that = (MergedPoco) o;

        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (displayname != null ? !displayname.equals(that.displayname) : that.displayname != null) return false;
        if (emails != null ? !emails.equals(that.emails) : that.emails != null) return false;
        if (gender != that.gender) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
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
        result = 31 * result + (name != null ? name.hashCode() : 0);
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
                ", name='" + name + '\'' +
                '}';
    }

    public static MergedPoco fromJson(JSONObject json) throws JSONException {
        MergedPoco mp = new MergedPoco();
        mp.gender = Gender.fromString(json.getString("gender"));

        JSONArray array = json.getJSONArray("urls");
        if (array != null) {
            mp.urls = new ArrayList<Url>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                JSONObject jo = array.getJSONObject(i);
                Url url = Url.fromJson(jo);
                mp.urls.add(url);
            }
        }

        mp.preferredUsername = json.getString("preferredUsername");
        mp.displayname = json.getString("displayName");

        JSONObject jo = json.getJSONObject("name");
        mp.name = Name.fromJson(jo);
        mp.birthday = fromRPXDateString(json.getString("birthday"));

        array = json.getJSONArray("emails");
        if (array != null) {
            mp.emails = new ArrayList<Email>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                jo = array.getJSONObject(i);
                Email email = Email.fromJson(jo);
                mp.emails.add(email);
            }
        }

        return mp;
    }
}
