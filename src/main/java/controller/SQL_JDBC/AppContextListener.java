package controller.SQL_JDBC;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import java.lang.reflect.Method;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Do nothing on startup
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            // Get the shutdown method
            Method shutdownMethod = AbandonedConnectionCleanupThread.class.getDeclaredMethod("shutdown");

            // Make it accessible
            shutdownMethod.setAccessible(true);

            // Invoke it
            shutdownMethod.invoke(null);
        } catch (Exception e) {
            sce.getServletContext().log("SEVERE: failed to cleanup MySQL connection cleanup thread", e);
        }
    }
}
