package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;
import static org.yestech.rpx.objectmodel.RPXUtil.fromRPXDateString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author A.J. Wright
 */
@XmlRootElement
public class Organization implements Serializable {

    private String title;
    private DateTime startDate;
    private DateTime endDate;
    private String name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        //noinspection RedundantIfStatement
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                '}';
    }

    public static Organization fromJson(JSONObject json) {
        Organization o = new Organization();
        o.title = jsonString(json, "title");
        o.startDate = fromRPXDateString(jsonString(json, "startDate"));
        o.endDate = fromRPXDateString(jsonString(json, "endDate"));
        o.name = jsonString(json, "name");
        return o;
    }
}
