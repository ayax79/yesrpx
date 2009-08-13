package org.yestech.rpx.objectmodel;

import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement
public class AccessCredentials {

    private String expires;
    private String uid;
    private String type;
    private String sessionKey;

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessCredentials that = (AccessCredentials) o;

        if (expires != null ? !expires.equals(that.expires) : that.expires != null) return false;
        if (sessionKey != null ? !sessionKey.equals(that.sessionKey) : that.sessionKey != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        //noinspection RedundantIfStatement
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expires != null ? expires.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sessionKey != null ? sessionKey.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccessCredentials{" +
                "expires='" + expires + '\'' +
                ", uid='" + uid + '\'' +
                ", type='" + type + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }

    public static AccessCredentials fromJson(JSONObject json) {
        AccessCredentials ac = new AccessCredentials();
        ac.expires = jsonString(json, "expires");
        ac.uid = jsonString(json, "uid");
        ac.type = jsonString(json, "type");
        ac.sessionKey = jsonString(json, "sessionKey");
        return ac;
    }
}
