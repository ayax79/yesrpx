package org.yestech.rpx.objectmodel;

import org.json.JSONObject;
import org.json.JSONArray;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonArray;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * @author A.J. Wright
 */
@XmlRootElement
public class AuthInfoResponse implements Serializable {


    @XmlElement(name = "sreg")
    private SharedRegistration sreg;

    @XmlElement(name = "stat")
    private RPXStat stat;

    @XmlElement(name = "profile")
    private Profile profile;

    @XmlElement(name = "merged_poco")
    private MergedPortableContact mergedPoco;

    private List<String> friends;

    private AccessCredentials accessCredentials;

    public SharedRegistration getSreg() {
        return sreg;
    }

    public void setSreg(SharedRegistration sreg) {
        this.sreg = sreg;
    }

    public RPXStat getStat() {
        return stat;
    }

    public void setStat(RPXStat stat) {
        this.stat = stat;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public MergedPortableContact getMergedPoco() {
        return mergedPoco;
    }

    public void setMergedPoco(MergedPortableContact mergedPoco) {
        this.mergedPoco = mergedPoco;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public AccessCredentials getAccessCredentials() {
        return accessCredentials;
    }

    public void setAccessCredentials(AccessCredentials accessCredentials) {
        this.accessCredentials = accessCredentials;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthInfoResponse response = (AuthInfoResponse) o;

        if (accessCredentials != null ? !accessCredentials.equals(response.accessCredentials) : response.accessCredentials != null)
            return false;
        if (friends != null ? !friends.equals(response.friends) : response.friends != null) return false;
        if (mergedPoco != null ? !mergedPoco.equals(response.mergedPoco) : response.mergedPoco != null) return false;
        if (profile != null ? !profile.equals(response.profile) : response.profile != null) return false;
        if (sreg != null ? !sreg.equals(response.sreg) : response.sreg != null) return false;
        //noinspection RedundantIfStatement
        if (stat != response.stat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sreg != null ? sreg.hashCode() : 0;
        result = 31 * result + (stat != null ? stat.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (mergedPoco != null ? mergedPoco.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (accessCredentials != null ? accessCredentials.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthInfoResponse{" +
                "sreg=" + sreg +
                ", stat=" + stat +
                ", profile=" + profile +
                ", mergedPoco=" + mergedPoco +
                ", friends=" + friends +
                ", accessCredentials=" + accessCredentials +
                '}';
    }

    public static AuthInfoResponse fromJson(JSONObject json) {
        AuthInfoResponse response = new AuthInfoResponse();
        JSONObject json2 = jsonObject(json, "sreg");
        response.sreg = SharedRegistration.fromJson(json2);
        json2 = jsonObject(json, "profile");
        response.profile = Profile.fromJson(json2);
        json2 = jsonObject(json, "merged_poco");
        response.mergedPoco = MergedPortableContact.fromJson(json2);
        response.stat = RPXStat.fromString(jsonString(json, "stat"));

        JSONArray array = jsonArray(json, "friends");
        if (array != null) {
            response.friends = new ArrayList<String>(array.length());

            for (int i = 0, size = array.length(); i < size; i++) {
                response.friends.add(jsonString(array, i));
            }
        }

        response.accessCredentials = AccessCredentials.fromJson(jsonObject(json, "accessCredentials"));

        return response;
    }
}
