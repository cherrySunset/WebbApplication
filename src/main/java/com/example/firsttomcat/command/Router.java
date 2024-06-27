package com.example.firsttomcat.command;

public class Router {
    private String page = "index.jsp";
    private Type type = Type.FORWARD;
    enum Type {
        FORWARD, REDIRECT;
    }

    public Router(Type type) {
        this.type = type;
    }

    public Router(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setRedirect() {
        this.type = Type.REDIRECT;
    }
}
