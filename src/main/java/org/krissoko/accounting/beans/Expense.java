package org.krissoko.accounting.beans;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Krzysiek on 2016-02-06.
 *
 * Everything related to Expense entity
 *
 */
@DatabaseTable(tableName = "expense")
public class Expense extends IdBean {

    @DatabaseField(dataType = DataType.DATE, columnName = "create_date")
    private Date createDate;

    private Paragon paragon;

    @DatabaseField(columnName = "name")
    private String expenseName;

    private BigDecimal amount;

    // ar to reikia, ar kitaip vadinsis?
    private String comment;


    public Expense() {
    }

    public Expense(Date createDate, String expenseName) {
        this.createDate = createDate;
        this.expenseName = expenseName;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Paragon getParagon() {
        return paragon;
    }

    public void setParagon(Paragon paragon) {
        this.paragon = paragon;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
