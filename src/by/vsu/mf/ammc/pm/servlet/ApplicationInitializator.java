package by.vsu.mf.ammc.pm.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import by.vsu.mf.ammc.pm.datasource.Connector;

@WebListener
public class ApplicationInitializator implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext context = event.getServletContext();
			String jdbcDriver = context.getInitParameter("jdbc-driver");
			String jdbcUrl = context.getInitParameter("jdbc-url");
			String jdbcUser = context.getInitParameter("jdbc-user");
			String jdbcPassword = context.getInitParameter("jdbc-password");
			Connector.init(jdbcDriver, jdbcUrl, jdbcUser, jdbcPassword);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {}
}
