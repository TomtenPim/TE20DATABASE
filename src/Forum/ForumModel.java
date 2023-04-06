package Forum;

import javax.swing.*;
import java.sql.*;

public class ForumModel {

    private String forumPost[];
    private Connection conn = null;
    private String user = "te20";
    private String password;

    public ForumModel() {
        JPasswordField pf = new JPasswordField();
        JOptionPane.showConfirmDialog(null, pf, "password?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        this.password = new String(pf.getPassword());

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.getForumPost(1);
    }

    public String getForumPost(Integer i){
        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM sa04loginForum";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int j = 1 ; j <= numCols ; j++) {
                System.out.println(metadata.getColumnClassName(j));
            }

            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getString("createdAt") + ", " +
                        result.getInt("authorId");
                this.forumPost[i] = output;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return forumPost[i];
    };





    public static void main(String[] args) {
        Connection conn = null;
        String user = "te20";
        JPasswordField pf = new JPasswordField();
        JOptionPane.showConfirmDialog(null, pf, "password?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String password = new String(pf.getPassword());

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM sa04loginUsers";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("author") + ", " +
                        result.getString("password");
                System.out.println(output);
            }

            String name = JOptionPane.showInputDialog(null,"Namn");
            String lösen = JOptionPane.showInputDialog(null,"Lösen");

            SQLQuery = "INSERT INTO sa04loginUsers(author, password) VALUES ('"+ name +"','"+ lösen +"')";
            stmt.executeUpdate(SQLQuery);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
