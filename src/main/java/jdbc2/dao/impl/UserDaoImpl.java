package jdbc2.dao.impl;

import jdbc2.dao.UserDao;
import jdbc2.datasource.DatabaseSource;
import jdbc2.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final String INSERT = "INSERT INTO users (name) VALUES (?)";

    /**
    * {@inheritDoc}.
    */
    @Override
    public void save(User user) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
