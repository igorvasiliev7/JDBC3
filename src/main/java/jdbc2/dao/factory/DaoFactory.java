package jdbc2.dao.factory;

import jdbc2.dao.impl.ProjectDaoImpl;
import jdbc2.dao.impl.UserDaoImpl;

public class DaoFactory {

    public static UserDaoImpl getUserDaoImpl() {
        return new UserDaoImpl();
    }

    public static ProjectDaoImpl getProjectDaoImpl() {
        return new ProjectDaoImpl();
    }
}
