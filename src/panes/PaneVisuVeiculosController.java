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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
    private TableColumn tc_id;
    @FXML
    private TableColumn tc_placa;
    @FXML
    private TableColumn tc_situacao;

    @FXML
    public void c_veiculos(ActionEvent event) {
        String SQL = "SELECT * FROM veiculo";
        ResultSet rs = Consulta.executeQuery(SQL);
        String bdid = null, bdplaca = null, bdsituacao = null;
        try {
            if (rs.next()) {
                bdid = rs.getString("id");
                System.out.println(bdid);
                bdplaca = rs.getString("placa");
                System.out.println(bdplaca);
                bdsituacao = rs.getString("situacao");
                System.out.println(bdsituacao);

                final ObservableList<Veiculo> data = FXCollections.observableArrayList(
                        new Veiculo(bdid, bdplaca, bdsituacao));


            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta dos veículos.");
        }

        tc_id.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("ID"));
        tc_placa.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("Placa"));
        tc_situacao.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("Situacao"));


    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
