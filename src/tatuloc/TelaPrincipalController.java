/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tatuloc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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
    private TreeView<String> tv_cadastro;
    @FXML
    private TreeView<String> tv_veiculos;
    @FXML
    private TreeView<String> tv_motoristas;
    @FXML
    private TreeView<String> tv_relatorios;
    @FXML
    private StackPane stackpane;
    @FXML
    private Button bt_mapa;
    @FXML
    private ImageView iview;
    private Node pane_incial;
    private Node pane_cadveiculo;
    private Node pane_visuveiculos;
    private Node pane_todosveiculos;

    private void mudar() {
    }
    // Connection c = ConnectionFactory.getConnection();  

    private void initMenuCadastro() {
        final String CAD_VEIC = "Cad. Veículo";

        TreeItem<String> ti_root = new TreeItem<>("root");
        TreeItem<String> ti_cadVeic = new TreeItem<>(CAD_VEIC);
        TreeItem<String> ti_cadMot = new TreeItem<>("Cad. Motorista");

        ti_root.getChildren().add(ti_cadVeic);
        ti_root.getChildren().add(ti_cadMot);

        tv_cadastro.setRoot(ti_root);
        tv_cadastro.setShowRoot(false);

        tv_cadastro.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println("Menu: " + tl.getValue());
                switch (tl.getValue()) {
                    case CAD_VEIC:
                        int indice = stackpane.getChildren().indexOf(pane_cadveiculo);
                        stackpane.getChildren().get(indice).toFront();
                        System.out.println("indice: " + indice);
                }
            }
        });
    }

    private void initMenuVisu() {
        final String VIS_VEIC = "Vis. Veículos Ativos";
        final String TOD_VEIC = "Tod. os Veiculos";
        TreeItem<String> ti_root = new TreeItem<>("root");
        TreeItem<String> ti_visVeicA = new TreeItem<>(VIS_VEIC);
        TreeItem<String> ti_visTodVeic = new TreeItem<>(TOD_VEIC);

        ti_root.getChildren().add(ti_visVeicA);
        ti_root.getChildren().add(ti_visTodVeic);

        tv_veiculos.setRoot(ti_root);
        tv_veiculos.setShowRoot(false);

        tv_veiculos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println("Menu: " + tl.getValue());
                switch (tl.getValue()) {
                    case VIS_VEIC:
                        int indice = stackpane.getChildren().indexOf(pane_visuveiculos);
                        stackpane.getChildren().get(indice).toFront();
                        System.out.println("indice: " + indice);
                    /* case TOD_VEIC:
                     indice = stackpane.getChildren().indexOf(pane_todosveiculos);
                     stackpane.getChildren().get(indice).toFront();
                     System.out.println("indice: " + indice);*/
                }
            }
        });
    }

    @FXML
    private void abrirMapa() {
        System.out.println("abriu");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iview.setImage(new Image(getClass().getResourceAsStream("/imagens/map.jpg"), 147, 147,true, true));

        try {
            pane_incial = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneInicial.fxml"));
            pane_cadveiculo = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneCadVeiculo.fxml"));
            pane_visuveiculos = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneVisuVeiculos.fxml"));
            pane_todosveiculos = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneTodVeiculos.fxml"));
            stackpane.getChildren().add(pane_todosveiculos);
            stackpane.getChildren().add(pane_visuveiculos);
            stackpane.getChildren().add(pane_cadveiculo);
            stackpane.getChildren().add(pane_incial);


        } catch (IOException ex) {
            System.out.println("Erro ao carregar os Panes");
        }
        initMenuCadastro();
        initMenuVisu();


        TreeItem<String> root2 = new TreeItem<>("root");
        TreeItem<String> rootItem3 = new TreeItem<>("Motoristas Operando");
        TreeItem<String> rootItem4 = new TreeItem<>("Motoristas Disponiveis");
        TreeItem<String> root3 = new TreeItem<>("root");
        TreeItem<String> rootItem5 = new TreeItem<>("Rel. Mot. Cadastrados");
        TreeItem<String> rootItem6 = new TreeItem<>("Quant. Veiculos");

        root2.getChildren().add(rootItem3);
        root2.getChildren().add(rootItem4);

        root3.getChildren().add(rootItem5);
        root3.getChildren().add(rootItem6);



    }
}
