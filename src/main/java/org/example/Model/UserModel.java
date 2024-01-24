package org.example.Model;

import org.example.db.DbConnection;
import org.example.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean saveUser(UserDto userDto) throws SQLException {

        // Check if user already exists with the given username
        if (isUsernameExists(userDto.getU_name())) {
            throw new SQLException("Username already exists");
        }

        // Insert the new user into the database
        String sql = "INSERT INTO user (u_name, u_pword) VALUES (?, ?)";
        try (Connection connection = DbConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, userDto.getU_name());
            statement.setString(2, userDto.getU_password());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        }
    }
    private static boolean isUsernameExists(String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE u_name = ?";
        try (Connection connection = DbConnection.getInstance().getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(sql)) {

            checkStatement.setString(1, username);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
    public static ResultSet checkCredentials(String enteredUserName, String enteredPassword) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM user WHERE u_name=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,enteredUserName);
        ResultSet resultSet = pstm.executeQuery();
        return resultSet;
    }
}
