package org.yestech.rpx.objectmodel;

import org.json.JSONObject;
import org.json.JSONArray;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonArray;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonObject;

import java.io.Serializable;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author A.J. Wright
 */
public class Contact implements Serializable {

    private String displayName;
    private Collection<TypeValue> emails = Collections.emptyList();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Collection<TypeValue> getEmails() {
        return emails;
    }

    public void setEmails(Collection<TypeValue> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (displayName != null ? !displayName.equals(contact.displayName) : contact.displayName != null) return false;
        //noinspection RedundantIfStatement
        if (emails != null ? !emails.equals(contact.emails) : contact.emails != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = displayName != null ? displayName.hashCode() : 0;
        result = 31 * result + (emails != null ? emails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "displayName='" + displayName + '\'' +
                ", emails=" + emails +
                '}';
    }

    public static Contact fromJson(JSONObject json) {
        Contact c = new Contact();
        c.displayName = jsonString(json, "displayName");
        JSONArray jsonArray = jsonArray(json, "emails");
        if (jsonArray != null && jsonArray.length() > 0) {
            c.emails = new ArrayList<TypeValue>(jsonArray.length());

            for (int i = 0, size = jsonArray.length(); i < size; i++) {
                JSONObject jo = jsonObject(jsonArray, i);
                c.emails.add(TypeValue.fromJson(jo));
            }
        }

        return c;
    }
}
