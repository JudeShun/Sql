/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author cabalhaoma_sd2082
 */
public class withsql {

    public static void main(String[] args) {
        // TODO code application logic here
        DateTimeFormatter ann = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println(ann.format(time1));
        for (int i = 1; i < 201; i++) {
            try {
//                stmt = null;

                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sqlcabalhao", "root", "");
                java.sql.Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery(null);
                String sql = "insert into `sql`(`id`, `column1`, `column2`, `column3`, `column4`, `column5`) VALUES (" + i + "," + (i) + "," + (i + 1) + "," + (i + 2) + "," + (i + 3) + "," + (i + 4) + ")";
                stmt.executeUpdate(sql);
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);

            }
            DateTimeFormatter date2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime time2 = LocalDateTime.now();
            System.out.println(date2.format(time2));

            System.out.println("Time:" + (time2.getSecond() - time1.getSecond()));

        }
    }

}
