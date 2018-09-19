package jdbc2.dao;

import jdbc2.model.Project;
import jdbc2.model.User;

import java.util.List;
import java.util.Map;

public interface ProjectDao {

    /**
    * Save project
    *
    */
    void save(Project project);

    /**
     * Find all projects
     *
     */
    List<Project> findAll();

    /**
    * Add user on project
    */
    void addUserOnProject(User user, Project project);

    /**
    * Find user`s projects
    */
    List<Project> findProjectsByUsersId(User user);

    /**
    * Find participants of a project by id
    */
    List<User> findFellowsByProjectId(Project project);

    /**
    * Find all participants of a user`s projects
    */
    Map<Project, List<User>> findAllUserFellows(User user);

}
