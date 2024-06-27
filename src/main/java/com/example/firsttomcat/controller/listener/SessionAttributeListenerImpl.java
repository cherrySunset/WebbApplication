package com.example.firsttomcat.controller.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class SessionAttributeListenerImpl  implements HttpSessionAttributeListener {
    static Logger logger = Logger.getLogger(SessionAttributeListenerImpl.class.getName());
    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe){
        logger.log(Level.INFO, "+++<<<<-------------> attributeAdded:" + sbe.getSession().getAttribute("user_name"));
        logger.log(Level.INFO, "+++<<<<-------------> attributeAdded:" + sbe.getSession().getAttribute("current_page"));

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe){

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe){
        logger.log(Level.INFO, "###<<<<-------------> attributeReplaced:" + sbe.getSession().getAttribute("user_name"));
        logger.log(Level.INFO, "###<<<<-------------> attributeReplaced:" + sbe.getSession().getAttribute("current_page"));

    }
}
