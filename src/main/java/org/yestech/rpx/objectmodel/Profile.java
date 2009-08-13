package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "profile")
public class Profile {

    private Name name;
    private String displayname;
    private String preferredUsername;
    private String url;
    private Gender gender;
    private DateTime birthday;
    private String providerName;
    private String identifier;
    private String email;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (birthday != null ? !birthday.equals(profile.birthday) : profile.birthday != null) return false;
        if (displayname != null ? !displayname.equals(profile.displayname) : profile.displayname != null) return false;
        if (email != null ? !email.equals(profile.email) : profile.email != null) return false;
        if (gender != profile.gender) return false;
        if (identifier != null ? !identifier.equals(profile.identifier) : profile.identifier != null) return false;
        if (name != null ? !name.equals(profile.name) : profile.name != null) return false;
        if (preferredUsername != null ? !preferredUsername.equals(profile.preferredUsername) : profile.preferredUsername != null)
            return false;
        if (providerName != null ? !providerName.equals(profile.providerName) : profile.providerName != null)
            return false;
        //noinspection RedundantIfStatement
        if (url != null ? !url.equals(profile.url) : profile.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (displayname != null ? displayname.hashCode() : 0);
        result = 31 * result + (preferredUsername != null ? preferredUsername.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (providerName != null ? providerName.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name=" + name +
                ", displayname='" + displayname + '\'' +
                ", preferredUsername='" + preferredUsername + '\'' +
                ", url='" + url + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", providerName='" + providerName + '\'' +
                ", identifier='" + identifier + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Profile fromJson(JSONObject json) {
        Profile p = new Profile();

        JSONObject jo = jsonObject(json, "name");
        Name name = new Name();
        name.setFormatted(jsonString(jo, "formatted"));
        p.setName(name);
        p.setDisplayname(jsonString(json, "displayName"));
        p.setPreferredUsername(jsonString(json, "preferredUsername"));
        p.setBirthday(RPXUtil.fromRPXDateString(jsonString(json, "birthday")));
        p.setProviderName(jsonString(json, "providerName"));
        p.setIdentifier(jsonString(json, "identifier"));
        p.setEmail(jsonString(json, "email"));
        p.setUrl(jsonString(json, "url"));
        p.setGender(Gender.fromString(jsonString(json, "gender")));
        return p;
    }
}