package com.example.firsttomcat.command.impl;

import com.example.firsttomcat.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/index.jsp";
    }
}
