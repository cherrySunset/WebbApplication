package com.example.firsttomcat.command.impl;

import com.example.firsttomcat.command.Command;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "index.jsp";
    }
}
