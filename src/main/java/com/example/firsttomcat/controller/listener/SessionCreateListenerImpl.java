package com.example.firsttomcat.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@WebListener
public class SessionCreateListenerImpl implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    static Logger logger = Logger.getLogger(SessionCreateListenerImpl.class.getName());
    @Override
    public void sessionCreated(HttpSessionEvent se){
        logger.log(Level.INFO, "-------------> sessionCreated:" + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        logger.log(Level.INFO, "-------------> sessionDestroyed:" + se.getSession().getId());
    }
}
