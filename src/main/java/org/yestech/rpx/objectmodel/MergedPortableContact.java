package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.Serializable;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "merged_poco")
public class MergedPortableContact implements Serializable {

    private Gender gender;
    private List<Url> urls = Collections.emptyList();
    private String preferredUsername;
    private String displayname;
    private DateTime birthday;
    private List<Email> emails = Collections.emptyList();
    private Name name;
    private List<String> languageSpoken = Collections.emptyList();

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

    public List<String> getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(List<String> languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MergedPortableContact that = (MergedPortableContact) o;

        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (displayname != null ? !displayname.equals(that.displayname) : that.displayname != null) return false;
        if (emails != null ? !emails.equals(that.emails) : that.emails != null) return false;
        if (gender != that.gender) return false;
        if (languageSpoken != null ? !languageSpoken.equals(that.languageSpoken) : that.languageSpoken != null)
            return false;
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
        result = 31 * result + (languageSpoken != null ? languageSpoken.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MergedPortableContact{" +
                "gender=" + gender +
                ", urls=" + urls +
                ", preferredUsername='" + preferredUsername + '\'' +
                ", displayname='" + displayname + '\'' +
                ", birthday=" + birthday +
                ", emails=" + emails +
                ", name=" + name +
                ", languageSpoken=" + languageSpoken +
                '}';
    }

    public static MergedPortableContact fromJson(JSONObject json) {
        MergedPortableContact mp = new MergedPortableContact();
        mp.gender = Gender.fromString(jsonString(json, "gender"));

        JSONArray array = jsonArray(json, "urls");
        if (array != null) {
            mp.urls = new ArrayList<Url>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                JSONObject jo = jsonObject(array, i);
                Url url = Url.fromJson(jo);
                mp.urls.add(url);
            }
        }

        mp.preferredUsername = jsonString(json, "preferredUsername");
        mp.displayname = jsonString(json, "displayName");

        JSONObject jo = jsonObject(json, "name");
        mp.name = Name.fromJson(jo);
        mp.birthday = fromRPXDateString(jsonString(json, "birthday"));

        array = jsonArray(json, "emails");
        if (array != null) {
            mp.emails = new ArrayList<Email>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                jo = jsonObject(array, i);
                Email email = Email.fromJson(jo);
                mp.emails.add(email);
            }
        }

        array = jsonArray(json, "languagesSpoken");
        if (array != null) {
            mp.languageSpoken = new ArrayList<String>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                mp.languageSpoken.add(jsonString(array, i));
            }
        }

        return mp;
    }
}
