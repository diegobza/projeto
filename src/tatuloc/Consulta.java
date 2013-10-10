/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tatuloc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dikson
 */
public class Consulta {

    private static Connection conn = null;

    public static ResultSet executeQuery(String SQL, Object... param) {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/obdii?"
                        + "user=root&password=dikson");

            } catch (SQLException ex) {
                System.out.println("Erro ao ser conectar ao MySQL.");
            }
        }

        PreparedStatement stmt;
        ResultSet result = null;

        try {
            stmt = conn.prepareStatement(SQL);
            System.out.println("Elementos: " + param.length);

            for (int i = 0; i < param.length; i++) {
                if (param[i] instanceof String) {
                    stmt.setString(i + 1, (String) param[i]);
                }
            }

            result = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro de consulta SQL");
        }

        return result;
    }
}
