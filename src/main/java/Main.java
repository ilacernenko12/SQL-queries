import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2010127mN";

    public static void main(String[] args) {
        System.out.println("Choose action");
        System.out.println("1. Sing up");
        System.out.println("2. Sing in");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        User user = new User();
        user.setLogin();
        user.setPassword();

        Connection connection;
        Statement statement;

        try {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
            if (action == 1) {
                String query = "INSERT INTO users (login, password) values" + "('" + user.getLogin() + "', '" + user.getPassword() + "')";
                statement.execute(query);
            } else if (action == 2) {
                ResultSet resultSet = statement.executeQuery("SELECT * from users" +
                        " where login = '"+ user.getLogin()+"' and password = '"+user.getPassword()+"'");
            if (resultSet.next()){
                System.out.println("Done!");
                } else {
                System.out.println("Incorrect login or password.");
            }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
