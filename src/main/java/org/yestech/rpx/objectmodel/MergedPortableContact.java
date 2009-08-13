package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Collections.emptyList;
import java.util.List;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "merged_poco")
public class MergedPortableContact implements Serializable {

    private Gender gender;
    private List<TypeValue> urls = emptyList();
    private String preferredUsername;
    private String displayname;
    private DateTime birthday;
    private List<TypeValue> emails = emptyList();
    private Name name;
    private List<String> languageSpoken = emptyList();
    private List<String> movies = emptyList();
    private Address currentLocation;
    private List<String> tvShows = emptyList();
    private List<String> music = emptyList();
    private List<Organization> organizations = emptyList();
    private String relationshipStatus;
    private List<String> interests = emptyList();
    private String utcOffset;
    private List<TypeValue> photos;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<TypeValue> getUrls() {
        return urls;
    }

    public void setUrls(List<TypeValue> urls) {
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

    public List<TypeValue> getEmails() {
        return emails;
    }

    public void setEmails(List<TypeValue> emails) {
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

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    public Address getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Address currentLocation) {
        this.currentLocation = currentLocation;
    }

    public List<String> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<String> tvShows) {
        this.tvShows = tvShows;
    }

    public List<String> getMusic() {
        return music;
    }

    public void setMusic(List<String> music) {
        this.music = music;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public List<TypeValue> getPhotos() {
        return photos;
    }

    public void setPhotos(List<TypeValue> photos) {
        this.photos = photos;
    }

    public static MergedPortableContact fromJson(JSONObject json) {
        MergedPortableContact mp = new MergedPortableContact();
        mp.gender = Gender.fromString(jsonString(json, "gender"));

        JSONArray array = jsonArray(json, "urls");
        if (array != null) {
            mp.urls = new ArrayList<TypeValue>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                JSONObject jo = jsonObject(array, i);
                TypeValue url = TypeValue.fromJson(jo);
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
            mp.emails = new ArrayList<TypeValue>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                jo = jsonObject(array, i);
                TypeValue email = TypeValue.fromJson(jo);
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

        array = jsonArray(json, "music");
        if (array != null) {
            mp.music = new ArrayList<String>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                mp.music.add(jsonString(array, i));
            }
        }

        array = jsonArray(json, "movies");
        if (array != null) {
            mp.movies = new ArrayList<String>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                mp.movies.add(jsonString(array, i));
            }
        }

        array = jsonArray(json, "tvShows");
        if (array != null) {
            mp.tvShows = new ArrayList<String>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                mp.tvShows.add(jsonString(array, i));
            }
        }

        array = jsonArray(json, "interests");
        if (array != null) {
            mp.interests = new ArrayList<String>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                mp.interests.add(jsonString(array, i));
            }
        }

        jo = jsonObject(json, "currentLocation");
        mp.currentLocation = Address.fromJson(jo);

        array = jsonArray(json, "organizations");
        if (array != null) {
            mp.organizations = new ArrayList<Organization>(array.length());
            for (int i = 0, size = array.length(); i < size; i++) {
                jo = jsonObject(array, i);
                mp.organizations.add(Organization.fromJson(jo));
            }
        }

        mp.relationshipStatus = jsonString(json, "relationshipStatus");
        mp.utcOffset = jsonString(json, "utcOffset");

        array = jsonArray(json, "photos");
        if (array != null) {
            mp.photos = new ArrayList<TypeValue>(array.length());

            for (int i = 0, size = array.length(); i < size; i++) {
                jo = jsonObject(array, i);
                mp.photos.add(TypeValue.fromJson(jo));
            }
        }


        return mp;
    }
}
