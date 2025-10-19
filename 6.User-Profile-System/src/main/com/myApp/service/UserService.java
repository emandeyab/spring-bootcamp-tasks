package main.com.myApp.service;

import main.com.myApp.dao.UserDao;
import main.com.myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user){
        userDao.save(user);
    }
}
