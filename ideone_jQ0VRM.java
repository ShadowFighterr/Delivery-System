import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliverySystem {
    private static DeliverySystem instance;
    private Connection connection;

    private DeliverySystem() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery_system", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DeliverySystem getInstance() {
        if (instance == null) {
            instance = new DeliverySystem();
        }
        return instance;
    }

    public void makeOrder(Order order) {
        String sql = "INSERT INTO orders (item, quantity) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, order.getItem());
            preparedStatement.setInt(2, order.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void investMoney(double amount) {
        String sql = "INSERT INTO investments (amount) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reportIssue(String issue) {
        String sql = "INSERT INTO issue_reports (issue_description) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, issue);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
