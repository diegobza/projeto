/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tatuloc;

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 *
 * @author Dikson
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private Label l_tipo;
    @FXML
    private TextField t_placa;
    @FXML
    private TextField t_codigo;
    @FXML
    private Button b_concluir;
    @FXML
    private ListView l_view;
    @FXML
    private TreeView<String> t_view;
    @FXML
    private TreeView<String> t_view1;
    @FXML
    private TreeView<String> t_view2;
    @FXML
    private TreeView<String> t_view3;

    // Connection c = ConnectionFactory.getConnection();  
    @FXML
    private void cadastrarse(ActionEvent event) {
        String SQL = "insert into veiculo(placa)values(?)";


        Consulta.executeUpdate(SQL, t_placa.getText());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        TreeItem<String> root4 = new TreeItem<String>("root");
        TreeItem<String> rootItem7 = new TreeItem<String>("Cad. Veículo");
        TreeItem<String> rootItem8 = new TreeItem<String>("Cad. Motorista");
        TreeItem<String> root = new TreeItem<String>("root");
        TreeItem<String> rootItem1 = new TreeItem<String>("Veículos Ativos");
        TreeItem<String> rootItem2 = new TreeItem<String>("Veículos Inativos");
        TreeItem<String> root2 = new TreeItem<String>("root");
        TreeItem<String> rootItem3 = new TreeItem<String>("Motoristas Operando");
        TreeItem<String> rootItem4 = new TreeItem<String>("Motoristas Disponiveis");
        TreeItem<String> root3 = new TreeItem<String>("root");
        TreeItem<String> rootItem5 = new TreeItem<String>("Rel. Mot. Cadastrados");
        TreeItem<String> rootItem6 = new TreeItem<String>("Quant. Veiculos");

        root.getChildren().add(rootItem1);
        root.getChildren().add(rootItem2);

        root2.getChildren().add(rootItem3);
        root2.getChildren().add(rootItem4);

        root3.getChildren().add(rootItem5);
        root3.getChildren().add(rootItem6);

        root4.getChildren().add(rootItem7);
        root4.getChildren().add(rootItem8);

        t_view.setRoot(root);
        t_view.setShowRoot(false);
        t_view1.setRoot(root2);
        t_view1.setShowRoot(false);
        t_view2.setRoot(root3);
        t_view2.setShowRoot(false);
        t_view3.setRoot(root4);
        t_view3.setShowRoot(false);


        t_view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println(tl);
                if (tl.getValue() == "Veículos Ativos") {
                    l_tipo.setText("Veículos Ativos");
                } else {
                    l_tipo.setText("Veículos Inativos");
                }
            }
        });
        t_view1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println(tl.getValue());
            }
        });
        t_view2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println(tl.getValue());
            }
        });
        t_view3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println(tl.getValue());
            }
        });
    }
}
