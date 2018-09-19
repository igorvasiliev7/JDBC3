package jdbc2.service.factory;

import jdbc2.service.ProjectService;
import jdbc2.service.UserService;
import jdbc2.service.impl.ProjectServiceImpl;
import jdbc2.service.impl.UserServiceImpl;

public class ServiceFactory {

    public static UserService getUserService(){
        return new UserServiceImpl();
    }

    public static ProjectService getProjectService(){
        return new ProjectServiceImpl();
    }
}
