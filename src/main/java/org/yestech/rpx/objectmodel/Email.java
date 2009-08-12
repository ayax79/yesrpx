package org.yestech.rpx.objectmodel;

import org.json.JSONObject;
import org.json.JSONException;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "email")
public class Email {

    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (value != null ? !value.equals(email.value) : email.value != null) return false;
        //noinspection RedundantIfStatement
        if (type != null ? !type.equals(email.type) : email.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static Email fromJson(JSONObject json) throws JSONException {
        Email email = new Email();
        email.type = json.getString("type");
        email.value = json.getString("value");
        return email;
    }
}
