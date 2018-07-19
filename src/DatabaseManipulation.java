import java.sql.*;

public class DatabaseManipulation {

    //Class.forName("com.mysql.jdbc.Driver")

    public void printDB(){

        Connection con;

        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?verifyServerCertificate=false&useSSL=true", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM workers");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {

        DatabaseManipulation db = new DatabaseManipulation();
        db.printDB();
    }
}
