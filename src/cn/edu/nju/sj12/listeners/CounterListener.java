package cn.edu.nju.sj12.listeners;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CounterListener implements ServletContextListener,
		ServletContextAttributeListener,HttpSessionListener {
	int totalCounter;
	int onlineCounter;
	int visitorCounter;
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
		System.out.println(counterFilePath);
		totalCounter = 0;
		onlineCounter = 0;
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
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(
//					counterFilePath));
//			writer.write("0 0 0");
//			writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void contextInitialized(ServletContextEvent cse) {
		// TODO Auto-generated method stub
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(
//					counterFilePath));
//			String line = reader.readLine();
//			String[] counters = line.split(" ");
//			totalCounter = Integer.parseInt(counters[0]);
//			onlineCounter = Integer.parseInt(counters[1]);
//			visitorCounter = Integer.parseInt(counters[2]);
//			reader.close();
//			System.out.println(counterFilePath);
//			System.out.println("Reading" + "totalCounter:"+totalCounter+" onlineCounter:"+onlineCounter+" visitorCounter:"+visitorCounter);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		ServletContext servletContext = cse.getServletContext();
		servletContext.setAttribute("totalCounter", totalCounter);
		servletContext.setAttribute("onlineCounter", onlineCounter);
		servletContext.setAttribute("counter", 1);
		System.out.println("Application initialized");

	}

	synchronized void writeCounter(ServletContextAttributeEvent scae) {
		ServletContext servletContext = scae.getServletContext();
		totalCounter = (int)servletContext.getAttribute("totalCounter");
		onlineCounter = (int)servletContext.getAttribute("onlineCounter");
		visitorCounter = totalCounter-onlineCounter;
		String counters = totalCounter+" "+onlineCounter+" "+visitorCounter;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					counterFilePath));
			writer.write(counters);
			writer.close();
			System.out.println("Writing"+"totalCounter:"+totalCounter+" onlineCounter:"+onlineCounter+" visitorCounter:"+visitorCounter);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		ServletContext servletContext = session.getServletContext();
		totalCounter = (int)servletContext.getAttribute("totalCounter");
		totalCounter++;
		visitorCounter = totalCounter-onlineCounter;
		servletContext.setAttribute("totalCounter", totalCounter);
		System.out.println("session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		String isLog = (String)session.getAttribute("isLog");
		ServletContext servletContext = session.getServletContext();
		totalCounter = (int)servletContext.getAttribute("totalCounter");
		onlineCounter = (int)servletContext.getAttribute("onlineCounter");
		visitorCounter = totalCounter-onlineCounter; 
		if ((isLog != null) && ((isLog.equals("true")) || (isLog == "true"))) {
			onlineCounter--;
			servletContext.setAttribute("onlineCounter", onlineCounter);
		} else {
			
		}
		totalCounter--;
		servletContext.setAttribute("totalCounter", totalCounter);
		System.out.println("destroy session: "+totalCounter+" "+onlineCounter);
	}

}
