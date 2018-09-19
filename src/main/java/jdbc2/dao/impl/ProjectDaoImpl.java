package jdbc2.dao.impl;

import jdbc2.dao.ProjectDao;
import jdbc2.datasource.DatabaseSource;
import jdbc2.model.Project;
import jdbc2.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProjectDaoImpl implements ProjectDao {

    private static final String INSERT_PROJ = "INSERT INTO projects (name) VALUES (?)";
    private static final String INSERT_USER = "INSERT INTO project_users ( project_id, user_id) VALUES (?,?)";
    private static final String SELECT_PROJECTS =
            "select p.id, p.name from project_users pu, projects p WHERE pu.user_id=? AND pu.project_id=p.id;";
    private static final String SELECT_FELLOWS =
            "select u.id, u.name_user from project_users pu, users u WHERE pu.user_id=? AND pu.project_id=u.id;";
    private static final String SELECT_ALL =
            "select * from projects;";


    /**
     * * {@inheritDoc}.
     */
    @Override
    public void save(Project project) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJ)) {
            preparedStatement.setString(1, project.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Project> findAll() {
        List<Project> projects = new LinkedList<>();
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setName(resultSet.getString("name"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void addUserOnProject(User user, Project project) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Project> findProjectsByUsersId(User user) {
        List<Project> projects = new LinkedList<>();
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJECTS)) {
            preparedStatement.setLong(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setName(resultSet.getString("name"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<User> findFellowsByProjectId(Project project) {
        List<User> users = new LinkedList<>();
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FELLOWS)) {
            preparedStatement.setLong(1, project.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name_user"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Map<Project, List<User>> findAllUserFellows(User user) {
        Map<Project, List<User>> map = new HashMap<>();
        List<Project> projects = findProjectsByUsersId(user);
        for (Project project : projects) {
            List<User> users = findFellowsByProjectId(project);
            map.put(project, users);
        }
        return map;
    }
}
