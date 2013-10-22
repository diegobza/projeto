/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import tatuloc.Consulta;

/**
 * FXML Controller class
 *
 * @author Dikson
 */
public class PaneVizuVeiculosController implements Initializable {
    @FXML
    private ListView lv_inativo;
    @FXML 
    public void veiculosina(ActionEvent event){
        String SQL = "SELECT * FROM veiculo";

       /* 
        ResultSet rs = Consulta.executeQuery(SQL);
                  String id = rs.getString("id");
                  lv_inativo.setText(); */
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
