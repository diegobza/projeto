/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tatuloc.Consulta;
import tatuloc.TelaPrincipalController;

/**
 * FXML Controller class
 *
 * @author Dikson
 */
public class PaneMarcaController implements Initializable {
    @FXML
    private Label l_msg;
    @FXML
    private Button b_incluir;
    @FXML
    private Button b_cancelar;
    @FXML
    private TextField tf_marca;
    
    private TelaPrincipalController tp;
    
    @FXML
    private void cancelmarca(){        
        tp.mudarPane("Cad. Veículo");
    }    
    public void setMain(TelaPrincipalController tp) {
        this.tp = tp;
    }
    @FXML
    private void cadmarca(){
    String SQL ="SELECT * from marca where nome=?";
    ResultSet rs = Consulta.executeQuery(SQL, tf_marca.getText());
    String marca = null;
        try {
            if (rs.next()){
            marca = rs.getString("nome");
            }
            if (tf_marca.getText().equals(marca)){
              l_msg.setText("Marca Já Cadastrada!");
            }else{
              String SQL1 = "INSERT INTO marca(nome) VALUES(?)";
              Consulta.executeUpdate(SQL1, tf_marca.getText());
              tp.mudarPane("Cad. Veículo");
              l_msg.setText("");         
            }
        } catch (Exception e) {
        }
    
    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
