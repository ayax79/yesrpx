package org.yestech.rpx.objectmodel;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonInt;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonArray;

import java.io.Serializable;
import java.util.Collection;
import java.util.ArrayList;
import static java.util.Collections.emptyList;

/**
 * @author A.J. Wright
 */
public class GetContactsResponse implements Serializable {

    private int startIndex;
    private int itemsPerPage;
    private int totalResults;
    private RPXStat stat;
    private Collection<Contact> entry = emptyList();

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public RPXStat getStat() {
        return stat;
    }

    public void setStat(RPXStat stat) {
        this.stat = stat;
    }

    public Collection<Contact> getEntry() {
        return entry;
    }

    public void setEntry(Collection<Contact> entry) {
        this.entry = entry;
    }


    public static GetContactsResponse fromJson(JSONObject json) throws JSONException {
        GetContactsResponse r = new GetContactsResponse();

        r.stat = RPXStat.fromString(json.getString("stat"));
        json = jsonObject(json, "response");

        r.startIndex = jsonInt(json, "startIndex");
        r.itemsPerPage = jsonInt(json, "itemsPerPage");
        r.totalResults = jsonInt(json, "totalResults");

        JSONArray jsonArray = jsonArray(json, "entry");

        if (jsonArray != null && jsonArray.length() > 0) {
            r.entry = new ArrayList<Contact>(jsonArray.length());

            for (int i = 0, size = jsonArray.length(); i < size; i++) {
                JSONObject jo = jsonObject(jsonArray, i);
                r.entry.add(Contact.fromJson(jo));
            }
        }

        return r;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetContactsResponse that = (GetContactsResponse) o;

        if (itemsPerPage != that.itemsPerPage) return false;
        if (startIndex != that.startIndex) return false;
        if (totalResults != that.totalResults) return false;
        if (entry != null ? !entry.equals(that.entry) : that.entry != null) return false;
        //noinspection RedundantIfStatement
        if (stat != that.stat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startIndex;
        result = 31 * result + itemsPerPage;
        result = 31 * result + totalResults;
        result = 31 * result + (stat != null ? stat.hashCode() : 0);
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        return result;
    }
}
