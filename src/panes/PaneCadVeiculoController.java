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
        String SQL1 = "SELECT * FROM veiculo WHERE placa=?";

        ResultSet rs = Consulta.executeQuery(SQL1, tf_placa.getText());

        String placa = null,id = null;
        
        try {
            if (rs.next()) {
                placa = rs.getString("placa");
                id = rs.getString("id");
                System.out.println(placa);
                                              
           }
             if (tf_placa.getText().equals(placa)) {
                       l_msg.setText("Placa Já Cadastrada!");
                       tf_codigo.setText(id);
                } else {
                  String SQL = "insert into veiculo(placa)values(?)";
                  Consulta.executeUpdate(SQL, tf_placa.getText());      
                  l_msg.setText("Veículo Cadastrado com Sucesso!");
                  ResultSet rs2 = Consulta.executeQuery(SQL1, tf_placa.getText());
                  String id2 = rs2.getString("id");
                  tf_codigo.setText(id2);
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
