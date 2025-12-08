package main.com.myApp.dao;

import main.com.myApp.config.DatabaseOperations;
import main.com.myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class UserDao {
    private DatabaseOperations databaseOperations;

    @Autowired
    public UserDao(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void save(User user) {
        String query = "INSERT INTO userInfo (user_name, email, password, confirmPassword) VALUES (?,?,?,?)";
        try (PreparedStatement ps = databaseOperations.getConnection().prepareStatement(query)) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getConfirmPassword());
            int rowsAffected = ps.executeUpdate();
            System.out.println("Data saved successfully! Rows affected: " + rowsAffected);
        } catch (SQLException ex){
            System.out.println("Error saving data: " + ex.getMessage());
        }
    }
}
