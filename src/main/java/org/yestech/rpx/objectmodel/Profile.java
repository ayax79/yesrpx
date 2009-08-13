package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "profile")
public class Profile implements Serializable {

    private Name name;
    private String displayname;
    private String preferredUsername;
    private String url;
    private Gender gender;
    private DateTime birthday;
    private String providerName;
    private String identifier;
    private String email;
    private String verifiedEmail;
    private String photo;
    private String utcOffset;
    private Address address;

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

    public String getVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(String verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        p.verifiedEmail = jsonString(json, "verifiedEmail");
        p.photo = jsonString(json, "photo");
        p.utcOffset = jsonString(json, "utcOffset");
        jo = jsonObject(json, "address");
        p.address = Address.fromJson(jo);

        return p;
    }
}