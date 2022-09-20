package DataBase;

import java.sql.*;

public class sql {





        public static void main(String[] args) {
                String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;";
                Connection conn = null;
                try {
                        conn = DriverManager.getConnection(dbURL);
                        if (conn != null) {
                                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                                System.out.println("Driver name: " + dm.getDriverName());
                                System.out.println("Driver version: " + dm.getDriverVersion());
                                System.out.println("Product name: " + dm.getDatabaseProductName());
                                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                                Statement statement = conn.createStatement();

// insert the data

                                Statement stmt = conn.createStatement();
                                //select * from InvDB.dbo.People
                                // InvDB.dbo.People
                                //SELECT Lname FROM Customers
                                //WHERE Snum = 2001;
                                //"SELECT Lname FROM Customers WHERE Snum = 2001
                                ResultSet rs = stmt.executeQuery("SELECT Name FROM InvDB.dbo.People ");
                                //while (rs.next()) {
                                //  String lastName = rs.getString("Lname");
                                //  System.out.println(lastName + "\n");
                                //}
                                while (rs.next()) {
                                        String firstname = rs.getString("Name");
                                        System.out.println(firstname + "\n");
                                }

                                //Name, age, nickname
                        }
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }finally {
                        try {
                                if (conn != null && !conn.isClosed()) {
                                        conn.close();
                                }
                        } catch (SQLException ex) {
                                ex.printStackTrace();
                        }
                }

        }




}
