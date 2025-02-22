package com.example.firsttomcat.command;

import com.example.firsttomcat.exception.CommandException;
import com.example.firsttomcat.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
    default void refresh(){}
}
