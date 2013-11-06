/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import custom.Veiculo;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tatuloc.Consulta;

/**
 * FXML Controller class
 *
 * @author Dikson
 */
public class PaneVisuVeiculosController implements Initializable {

    @FXML
    private Button b_atualizar;
    @FXML
    private TableView tb_visu;
    @FXML
    private TableColumn tc_id;
    @FXML
    private TableColumn tc_placa;
    @FXML
    private TableColumn tc_situacao;
   // private ObservableList data;

    @FXML
    public void c_veiculos(ActionEvent event) {
       
        /*
        String SQL0 ="SELECT MAX(id) as total FROM veiculo";
        ResultSet rs0 = Consulta.executeQuery(SQL0);
        String qtd="";
        try {
           if(rs0.next())
            qtd = rs0.getString("total");
            System.out.println(qtd);
        } catch (SQLException ex) {            
        }
        System.out.println(qtd);
        for (int cont=1;cont <= Integer.parseInt(qtd);cont++){
        */
        String SQL = "SELECT * FROM veiculo"; // where id="+cont;
        ResultSet rs = Consulta.executeQuery(SQL);
        String bdid = null, bdplaca = null, bdsituacao = null;
        final ObservableList<Veiculo> data = FXCollections.observableArrayList();
        try {
            
            while (rs.next()) {
                bdid = rs.getString("id");
                System.out.println(bdid);
                bdplaca = rs.getString("placa");
                System.out.println(bdplaca);
                bdsituacao = rs.getString("situacao");
                System.out.println(bdsituacao);
                Veiculo Entrada = new Veiculo(bdid, bdplaca, bdsituacao);
                data.add(Entrada);

            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta dos veículos.");
        }
       tc_id.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("ID"));       
       tc_placa.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("Placa"));
       tc_situacao.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("Situação"));
        
        //tb_visu.getColumns().addAll(data);            
      tb_visu.setItems(data); 
        
        
        }
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        // TODO
    }
}
