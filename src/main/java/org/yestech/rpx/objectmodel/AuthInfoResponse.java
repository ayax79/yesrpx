package org.yestech.rpx.objectmodel;

import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement
public class AuthInfoResponse {


    @XmlElement(name = "sreg")
    private SharedRegistration sreg;

    @XmlElement(name = "stat")
    private RPXStat stat;

    @XmlElement(name = "profile")
    private Profile profile;

    @XmlElement(name = "merged_poco")
    private MergedPoco mergedPoco;

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

    public MergedPoco getMergedPoco() {
        return mergedPoco;
    }

    public void setMergedPoco(MergedPoco mergedPoco) {
        this.mergedPoco = mergedPoco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthInfoResponse that = (AuthInfoResponse) o;

        if (mergedPoco != null ? !mergedPoco.equals(that.mergedPoco) : that.mergedPoco != null) return false;
        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (sreg != null ? !sreg.equals(that.sreg) : that.sreg != null) return false;
        //noinspection RedundantIfStatement
        if (stat != that.stat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sreg != null ? sreg.hashCode() : 0;
        result = 31 * result + (stat != null ? stat.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (mergedPoco != null ? mergedPoco.hashCode() : 0);
        return result;
    }

    public static AuthInfoResponse fromJson(JSONObject json) {
        AuthInfoResponse response = new AuthInfoResponse();
        JSONObject json2 = jsonObject(json, "sreg");
        response.sreg = SharedRegistration.fromJson(json2);
        json2 = jsonObject(json, "profile");
        response.profile = Profile.fromJson(json2);
        json2 = jsonObject(json, "merged_poco");
        response.mergedPoco = MergedPoco.fromJson(json2);
        response.stat = RPXStat.fromString(jsonString(json, "stat"));
        return response;
    }
}
