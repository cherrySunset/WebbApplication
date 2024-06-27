package com.example.firsttomcat.controller;

import com.example.firsttomcat.command.Command;
import com.example.firsttomcat.command.CommandType;
import com.example.firsttomcat.exception.CommandException;
import com.example.firsttomcat.pool.ConnectionPool;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = {"/controller", "*.do"})
public class Controller extends HttpServlet {

    public void init() {
        //ConnectionPool.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // String strNum = request.getParameter("num");
        // int resNum = 2 * Integer.parseInt(strNum);
        //request.setAttribute("result" , resNum);
        String commandStr = request.getParameter("command");
        Command command = CommandType.define(commandStr);
        String page = null;
        try {
            page = command.execute(request);
            //request.getRequestDispatcher(page).forward(request, response);
            response.sendRedirect(page);
        } catch (CommandException e) {
           // response.sendError(500);
            throw new ServletException(e);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {

      //  ConnectionPool.getInstance().destroyPool();
    }

}