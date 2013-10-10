/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tatuloc;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Dikson
 */
public class SampleController implements Initializable {
    
 @FXML
    private TextField tf_login;
    @FXML
    private Button bt_entrar;
    @FXML
    private PasswordField pf_password;
    @FXML
    private Label l_msg;

    @FXML
    private void checarnome(ActionEvent event) {
        String SQL = "SELECT * FROM usuario WHERE login=?";

        ResultSet rs = Consulta.executeQuery(SQL, tf_login.getText());

        String usuario = null, senha = null;
        
        try {
            if (rs.next()) {
                usuario = rs.getString("login");
                System.out.println(usuario);
                senha = rs.getString("senha");
                System.out.println(senha);                              
           }
             if (tf_login.getText().equals(usuario) && pf_password.getText().equals(senha)) {
                       l_msg.setText("Usuário Cadastrado!");
                } else {
                       l_msg.setText("Senha ou Usuário Incorreto!");
                } 
        } catch(SQLException ex) {            
        }

       
  
    }
    @FXML
    private Button bt_sair;
    @FXML
    private void fechar() {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
