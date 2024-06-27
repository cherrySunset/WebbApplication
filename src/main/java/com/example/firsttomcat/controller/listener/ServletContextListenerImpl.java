package com.example.firsttomcat.controller.listener;

import com.example.firsttomcat.pool.ConnectionPool;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    static Logger logger = Logger.getLogger(ServletContextListenerImpl.class.getName());
    @Override
    public void contextInitialized(ServletContextEvent sce){
        logger.log(Level.INFO, "++++++++++++++++ contextInitialized:" + sce.getServletContext().getServerInfo());
        ConnectionPool.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        logger.log(Level.INFO, "---------------- contextDestroyed:" + sce.getServletContext().getContextPath());
        ConnectionPool.getInstance().destroyPool();
    }

}
