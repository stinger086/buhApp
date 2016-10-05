package org.krissoko.accounting.dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.krissoko.accounting.service.Services;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created by Krzysiek on 2016-02-06.
 *
 * Connection class to my Postgres database
 *
 */
@Service(Services.CONNECTION_PROVIDER)
public class ConnectionProvider implements InitializingBean {

    @Override
    public String toString() {
        return "connection-provider";
    }

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/krissoko_accounting_v1";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "123654";

    private ConnectionSource connectionSource;


    public void afterPropertiesSet() throws Exception {

        connectionSource = new JdbcConnectionSource(DATABASE_URL, USERNAME, PASSWORD);
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }
}
