package org.krissoko.accounting.dao;

import org.krissoko.accounting.beans.IdBean;

import java.util.List;

/**
 * Created by Krzysiek on 2016-02-06.
 *
 * All operations listed for entities
 */
public interface Operations<T extends IdBean> {

    void save(T entity);

    List<T> findAll();
}
