package com.example.firsttomcat.service.impl;

import com.example.firsttomcat.dao.imple.UserDaoImpl;
import com.example.firsttomcat.exception.DaoException;
import com.example.firsttomcat.exception.ServiceException;
import com.example.firsttomcat.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = false;
        try {
            match = userDao.authenticate(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return match;
    }
}
