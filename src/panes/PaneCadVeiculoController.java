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
    private TextField tf_placalet;
    @FXML
    private TextField tf_placanum;
    @FXML
    private TextField tf_codigo;
    @FXML
    private Button b_concluir;

    @FXML
    public void cadastrarveic(ActionEvent event) {
        String SQL = "SELECT * FROM veiculo WHERE placa=?";
        // String SQL1 = "SELECT MAX(id) as uid FROM veiculo";
        String placa = ((tf_placalet.getText()) + (tf_placanum.getText()));
        ResultSet rs = Consulta.executeQuery(SQL, placa);
        //ResultSet rs1 = Consulta.executeQuery(SQL1);
        String pla = null, id = null;
        int uid = 0;
        try {
            if (rs.next()) {
                pla = rs.getString("placa");
                id = rs.getString("id");
                System.out.println(pla);

            }
            if (placa.equals(pla)) {
                l_msg.setText("Veículo Já Cadastrado!");
                tf_codigo.setText(id);
            } else {
                String SQL2 = "insert into veiculo(placa,situacao)values(?,'I')";
                Consulta.executeUpdate(SQL2, placa);
                l_msg.setText("Veículo Cadastrado com Sucesso!");
                String SQL5 = "SELECT id FROM veiculo WHERE placa=?";
                ResultSet rs5 = Consulta.executeQuery(SQL5, placa);
                if (rs5.next()) {
                    uid = rs5.getInt("id");
                    System.out.println(Integer.toString(uid));
                    tf_codigo.setText(Integer.toString(uid));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro 12345");
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
