package Utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ExampleContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Shutdown");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Startup!");

	}

}
