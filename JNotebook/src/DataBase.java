import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

    public static Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:notebook.db");
            System.out.println("База жива!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }


    public static void main(String[] args) throws SQLException {
        Connection con = connect();

        con.prepareStatement("DROP TABLE IF EXISTS people").execute();
        con.prepareStatement("DROP TABLE IF EXISTS contacts").execute();

        con.prepareStatement("CREATE TABLE people ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT NOT NULL, surname TEXT," +
                " corp TEXT" +
                ");").execute();

        con.prepareStatement("CREATE TABLE contacts" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tel TEXT NOT NULL, " +
                "tg TEXT, " +
                "mail TEXT, " +
                "FOREIGN KEY (id) REFERENCES people(id) " +
                ");").execute();



        con.prepareStatement("INSERT INTO people (name, surname, corp) VALUES ('Artyom', 'Sysoev', 'Monsters, Incorporated')").executeUpdate();
        con.prepareStatement("INSERT INTO contacts (tg, tel, mail) VALUES ('@sobaka', '88005553535', 'sobaka@gmail.com')").executeUpdate();
        con.close();
    }
}
