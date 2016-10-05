package org.krissoko.accounting.beans;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Krzysiek on 2016-02-06.
 *
 * Everything related to Paragon entity
 *
 */
@DatabaseTable(tableName = "paragon")
public class Paragon extends IdBean {

    @DatabaseField(dataType = DataType.DATE)
    private Date date;

    private String dayTime;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

}
