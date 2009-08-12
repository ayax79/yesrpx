package org.yestech.rpx.objectmodel;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "name")
public class Name {

    private String formatted;

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        //noinspection RedundantIfStatement
        if (formatted != null ? !formatted.equals(name.formatted) : name.formatted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return formatted != null ? formatted.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Name{" +
                "formatted='" + formatted + '\'' +
                '}';
    }
}
