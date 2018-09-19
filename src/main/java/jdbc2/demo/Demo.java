package jdbc2.demo;

import jdbc2.dao.UserDao;
import jdbc2.dao.factory.DaoFactory;
import jdbc2.dao.impl.ProjectDaoImpl;
import jdbc2.dao.impl.UserDaoImpl;
import jdbc2.model.Project;
import jdbc2.model.User;

public class Demo {

    public static void main(String[] args) {

        final UserDaoImpl userDaoImpl = jdbc2.dao.factory.DaoFactory.getUserDaoImpl();
        final ProjectDaoImpl projectDaoImpl = jdbc2.dao.factory.DaoFactory.getProjectDaoImpl();



//        User user1 = new User( 1L);
//        User user2 = new User( 2L);
//        User user3 = new User( 3L);
//        User user4 = new User( 4L);
//        User user5 = new User( 5L);
//        User user6 = new User( 6L);
//        User user7 = new User( 7L);
//        User user8 = new User( 8L);
//        Project project1 = new Project( 1L);
//        Project project2 = new Project( 2L);
//        Project project3 = new Project( 3L);

//        userDaoImpl.save(user1);
//        userDaoImpl.save(user2);
//        userDaoImpl.save(user3);
//        userDaoImpl.save(user4);
//        userDaoImpl.save(user5);
//        userDaoImpl.save(user6);
//        userDaoImpl.save(user7);
//        userDaoImpl.save(user8);

//        projectDaoImpl.save(project1);
//        projectDaoImpl.save(project2);
//        projectDaoImpl.save(project3);

//        projectDaoImpl.addUserOnProject(user1,project1 );
//        projectDaoImpl.addUserOnProject(user2,project2 );
//        projectDaoImpl.addUserOnProject(user3,project3 );
//        projectDaoImpl.addUserOnProject(user4,project1 );
//        projectDaoImpl.addUserOnProject(user5,project2 );
//        projectDaoImpl.addUserOnProject(user6,project1 );
//        projectDaoImpl.addUserOnProject(user7,project3 );
//        projectDaoImpl.addUserOnProject(user8,project3 );
    }
}
