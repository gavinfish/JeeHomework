package cn.edu.nju.sj12.listeners;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		System.out.println("ServletContextattribute replaced");
		writeCounter(scae);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Application shut down");
	}

	@Override
	public void contextInitialized(ServletContextEvent cse) {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new FileReader(counterFilePath));
			counter = Integer.parseInt( reader.readLine() );
			reader.close();
			System.out.println("Reading" + counter);}
			catch (Exception e) {
			System.out.println(e.toString());
			}
			ServletContext servletContext= cse.getServletContext();
			servletContext.setAttribute("pageCounter", Integer.toString(counter));
			System.out.println("Application initialized");

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
