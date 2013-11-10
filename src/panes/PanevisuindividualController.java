/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import java.net.URL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tatuloc.Consulta;

/**
 * FXML Controller class
 *
 * @author Dikson
 */
public class PanevisuindividualController implements Initializable {
    @FXML
    private TextField tf_id;
    @FXML
    private Button b_atualiza;
    @FXML
    private Button b_velocidade;
    @FXML
    private Button b_rpm;
    @FXML
    private Button b_km;
    //- - - - - - - - - - - - - - - - - - - - -
    @FXML
    private Label l_velocidade;
    @FXML
    private Label l_rpm;
    @FXML
    private Label l_lat;
    @FXML
    private Label l_long;
    @FXML
    private Label l_data;
    @FXML
    private Label l_hora;
    @FXML
    private Label l_km;
    @FXML
    private Label l_marcha;
    @FXML
    private Label l_cinto;
    @FXML
    private Label l_combustivel;
    // - - - - - - - - - - - - - 
    @FXML
    public void mostrarinf(){
    String SQL = "SELECT * FROM dadosobdii WHERE veiculo_id=?"; 
    ResultSet rs = Consulta.executeQuery(SQL, tf_id.getText());
    int velo,comb,marcha,lat,longi;
    DateFormat data;
        try {
            if (rs.next()){
            velo = rs.getInt("velocidade");
            l_velocidade.setText(Integer.toString(velo));
            comb = rs.getInt("combustivel");
            l_combustivel.setText(Integer.toString(comb));
            marcha = rs.getInt("marcha");
            l_marcha.setText(Integer.toString(marcha));
            lat = rs.getInt("latitude");
            l_lat.setText(Integer.toString(lat));
            longi = rs.getInt("longitude");
            l_long.setText(Integer.toString(longi));
        }
    //data = DateFormat.getInstance("hora");
    //l_velocidade.setText(Integer.toString(data));
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
