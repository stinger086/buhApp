package org.krissoko.accounting.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import org.krissoko.accounting.beans.IdBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.lang.management.OperatingSystemMXBean;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Krzysiek on 2016-02-06.
 *
 * Persistence layer abstraction
 *
 */
public abstract class AbstractDAO<T extends IdBean> implements Operations<T>, InitializingBean {

    @Autowired
    private ConnectionProvider connectionProvider;

    private final Class<T> abstractType;

    protected Dao<T, String> dao;


    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.abstractType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractDAO.class);
    }

    @Override
    public void afterPropertiesSet() throws SQLException {
        this.dao = DaoManager.createDao(connectionProvider.getConnectionSource(), abstractType);
    }

    @Override
    public List<T> findAll() {

        try {
            return dao.queryForAll();

        } catch (SQLException e) {
            System.out.println("Error querying " + abstractType.getName());
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public void save(T entity) {

        try {
            dao.create(entity);

        } catch (SQLException e) {
            System.out.println("Error saving " + abstractType.getName());
            e.printStackTrace();
        }
    }

}
