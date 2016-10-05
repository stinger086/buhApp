package org.krissoko.accounting.beans;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Krzysiek on 2016-02-06.
 *
 * Default IdBean class for my entities
 *
 */
public class IdBean {

    @DatabaseField(generatedId = true)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
