import java.sql.*;

public class DBConnect {

    private Connection connection = null;
    private final String jdbcURL = "jdbc:sqlite:C:\\Users\\lukas.sirhal\\IdeaProjects\\lukas-test.db";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL);
    }

    public void insertAuthor(String[] authorValues) {
        String sqlInsert = String.format("INSERT INTO author (`name`, `sur_name`) VALUES('%s', '%s');", authorValues[0], authorValues[1]);
//        String sqlInsert = "select * from author";
        try {
            Statement stmt  = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sqlInsert);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("sur_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void connect() {
        Connection conn = null;
        try {
            String sqlSelect = "select * from table_test_name";
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sqlSelect);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("sur_name"));
            }

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
