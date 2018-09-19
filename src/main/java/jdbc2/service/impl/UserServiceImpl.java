package jdbc2.service.impl;

import jdbc2.dao.impl.UserDaoImpl;
import jdbc2.model.User;
import jdbc2.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUserAndSay(User user) {
        new UserDaoImpl().save(user);

        System.out.println("Hello User");
    }
}
