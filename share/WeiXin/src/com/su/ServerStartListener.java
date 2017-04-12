package com.su;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartListener
 *
 */
@WebListener
public class ServerStartListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public ServerStartListener() {
        //启动定时任务定时获取 access_token (90分钟获取一次)
    	ScheduledExecutorService newScheduledThreadPool = Executors
                .newScheduledThreadPool(2);
    	newScheduledThreadPool.scheduleAtFixedRate(new AccessTokenControl(), 0, 90, TimeUnit.MINUTES);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    }

}
