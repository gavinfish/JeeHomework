package cn.edu.nju.sj12.listeners;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CounterListener implements ServletContextListener,
		ServletContextAttributeListener {
	int counter;
	String counterFilePath;

	public CounterListener() {
		counterFilePath = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		counterFilePath = counterFilePath.replace('/', '\\'); // 将/换成\
		counterFilePath = counterFilePath.replace("file:", ""); // 去掉file:
		counterFilePath = counterFilePath.replace("classes\\", ""); // 去掉class\
		counterFilePath = counterFilePath.substring(1); // 去掉第一个\,如
														// \D:\JavaWeb...
		counterFilePath += "counter.txt";
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	synchronized void writeCounter(ServletContextAttributeEvent scae) {
		ServletContext servletContext = scae.getServletContext();
		counter = Integer.parseInt((String) servletContext
				.getAttribute("pageCounter"));
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					counterFilePath));
			writer.write(Integer.toString(counter));
			writer.close();
			System.out.println("Writing");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
