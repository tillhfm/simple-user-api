package de.trxsson.userapi.service;

import java.sql.*;

/**
 * Represents a service for interacting with a database.
 */
public class DatabaseService {

    /**
     * Holds the instance's connection to a database.
     */
    private Connection connection;

    public DatabaseService() {
        connect();
    }

    /**
     * FIXME: Connection with complicated passwords not working, passwords possibly being messed up
     * <p>
     * Establishes a connection to the database using the provided credentials.
     * <p>
     * The connection URL is constructed using the environment variables for the database host, name, username, and password.
     * Sets the connection field of the class.
     *
     * @throws RuntimeException if a SQLException occurs during the connection attempt
     *
     */
    private void connect() {
        try {
            String DATABASE_URL_FORMAT = "jdbc:mariadb://%s/%s?user=%s&password=%s&autoReconnect=true";

            String formattedURL = String.format(DATABASE_URL_FORMAT,
                    System.getenv("USER_DATABASE_HOST"),
                    System.getenv("USER_DATABASE_NAME"),
                    System.getenv("USER_DATABASE_USERNAME"),
                    System.getenv("USER_DATABASE_PASSWORD"));

            connection = DriverManager.getConnection(formattedURL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Closes the connection to the database.
     * <p>
     * If the connection is not null and not already closed, it will be closed.
     * Any SQLException thrown during the closure will be wrapped in a RuntimeException and re-thrown.
     *
     * @throws RuntimeException if a SQLException occurs during the closure
     *
     */
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Validates the database connection.
     * <p>
     * If the connection is null or closed, the method will close the connection using the {@link #close()} method.
     * The method will then attempt to establish a new connection using the {@link #connect()} method.
     *
     * @throws RuntimeException if a SQLException occurs during the validation process
     */
    private void validateConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect();
        }
    }

    /**
     * Executes a SQL query with optional parameters and returns the result set.
     *
     * @param sql    the SQL query to execute
     * @param values optional parameter values
     * @return the result set produced by the query
     * @throws RuntimeException if a SQLException occurs during the query execution or parameter setting
     */
    public ResultSet query(String sql, Object... values) {
        validateConnection();
        try (var preparedStatement = prepare(sql)) {
            for (int i = 1; i <= values.length; i++) {
                preparedStatement.setObject(i, values[i - 1]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes an update SQL statement with optional parameters.
     *
     * @param sql    the update SQL statement to execute
     * @param values optional parameter values for the SQL statement
     * @throws RuntimeException if a SQLException occurs during the execution of the statement or parameter setting
     */
    public void update(String sql, Object... values) {
        validateConnection();
        try (var preparedStatement = prepare(sql)) {
            for (int i = 1; i <= values.length; i++) {
                preparedStatement.setObject(i, values[i - 1]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prepares a SQL statement for execution.
     *
     * @param sql the SQL statement to prepare
     * @return a PreparedStatement object that represents the compiled SQL statement
     * @throws RuntimeException if a SQLException occurs while preparing the statement
     */
    private PreparedStatement prepare(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
