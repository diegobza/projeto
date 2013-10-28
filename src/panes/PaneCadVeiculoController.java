/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import tatuloc.Consulta;

/**
 * FXML Controller class
 *
 * @author Dikson
 */
public class PaneCadVeiculoController implements Initializable {
    @FXML
    private Label l_msg;
    @FXML
    private TextField tf_placa;
    @FXML
    private TextField tf_codigo;
    @FXML
    private Button b_concluir;

    @FXML
    public void cadastrarveic(ActionEvent event){
        String SQL = "SELECT * FROM veiculo WHERE placa=?";
        String SQL1 = "SELECT MAX(id) as uid FROM veiculo";
        ResultSet rs = Consulta.executeQuery(SQL, tf_placa.getText());
        ResultSet rs1 = Consulta.executeQuery(SQL1);
        String placa = null,id = null;
        int uid=0;
        try {
            if (rs1.next()){
            uid = rs1.getInt("uid");
            }
            
            if (rs.next()) {
                placa = rs.getString("placa");
                id = rs.getString("id");
                System.out.println(placa);
                                              
           }
             if (tf_placa.getText().equals(placa)) {
                       l_msg.setText("Veículo Já Cadastrado!");
                       tf_codigo.setText(id);
                } else {
                  String SQL2 = "insert into veiculo(placa)values(?)";
                  Consulta.executeUpdate(SQL2, tf_placa.getText());      
                  l_msg.setText("Veículo Cadastrado com Sucesso!");
                                    
                  tf_codigo.setText(Integer.toString(uid+1));
             } 
        } catch(SQLException ex) {            
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
