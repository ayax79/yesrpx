package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.fromRPXDateString;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "sreg")
public class SharedRegistration {

    private DateTime dob;
    private String nickname;
    private String fullname;
    private Gender gender;
    private String email;

    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

        SharedRegistration sreg = (SharedRegistration) o;

        if (dob != null ? !dob.equals(sreg.dob) : sreg.dob != null) return false;
        if (email != null ? !email.equals(sreg.email) : sreg.email != null) return false;
        if (fullname != null ? !fullname.equals(sreg.fullname) : sreg.fullname != null) return false;
        if (gender != sreg.gender) return false;
        //noinspection RedundantIfStatement
        if (nickname != null ? !nickname.equals(sreg.nickname) : sreg.nickname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dob != null ? dob.hashCode() : 0;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SharedRegistration{" +
                "dob=" + dob +
                ", nickname='" + nickname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    public static SharedRegistration fromJson(JSONObject json) {
        SharedRegistration sreg = new SharedRegistration();
        sreg.dob = fromRPXDateString(jsonString(json, "dob"));
        sreg.nickname = jsonString(json, "nickname");
        sreg.fullname = jsonString(json, "fullname");
        sreg.gender = Gender.fromString(jsonString(json, "gender"));
        sreg.email = jsonString(json, "email");
        return sreg;
    }
}
