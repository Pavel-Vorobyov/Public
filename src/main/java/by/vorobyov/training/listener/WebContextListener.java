package by.vorobyov.training.listener;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;

/**
 * Initializes the {@link by.vorobyov.training.database.connectionpool.ConnectionPool ConnectionPool}
 * when the application starts and closes all connections when the application exits.
 *
 * @see javax.servlet.ServletContextListener
 */
public class WebContextListener implements javax.servlet.ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(WebContextListener.class.getName());

    private static final String CONNECTION_POOL_EXCEPTION_MESSAGE = "Connection pool has not been initialized!";
    private final static String NOT_CLOSED_CONNECTIONS_MESSAGE = "Connections were not closed";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool.getInstance().init();
        } catch (DAOException e) {
            LOGGER.warn(CONNECTION_POOL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool.getInstance().closeConnections();
        } catch (DAOException e) {
            LOGGER.info(NOT_CLOSED_CONNECTIONS_MESSAGE);
        }
    }
}
