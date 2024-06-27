package com.example.firsttomcat.command.impl;

import com.example.firsttomcat.command.Command;
import com.example.firsttomcat.exception.CommandException;
import com.example.firsttomcat.exception.ServiceException;
import com.example.firsttomcat.service.UserService;
import com.example.firsttomcat.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        UserService userService = UserServiceImpl.getInstance();
        String page;
        HttpSession session = request.getSession();
        try {
            if (userService.authenticate(login, password)) {
                request.setAttribute("user", login);
                session.setAttribute("user_name", login);
                page = "pages/main.jsp";
            } else {
                request.setAttribute("login_msg", "incorrect login or pass");
                page = "index.jsp";
            }
            session.setAttribute("current_page", page);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }
}
