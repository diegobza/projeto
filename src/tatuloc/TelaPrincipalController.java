/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tatuloc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import panes.PaneCadVeiculoController;
import panes.PaneMarcaController;
import panes.PaneVisuVeiculosController;

/**
 *
 * @author Dikson
 */
public class TelaPrincipalController implements Initializable {

    final String CAD_VEIC = "Cad. Veículo";
    final String VIS_VEIC = "Vis. Veículos Ativos";

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

    private FXMLLoader loader_inicial;
    private FXMLLoader loader_cadveiculo;
    private FXMLLoader loader_visuveiculos;
    private FXMLLoader loader_todosveiculos;
    private FXMLLoader loader_detalhe;
    private FXMLLoader loader_marca;
    private Node pane_incial;
    private Node pane_cadveiculo;
    private Node pane_visuveiculos;
    private Node pane_todosveiculos;
    private Node pane_detalhe;
    private Node pane_marca;

    public void mudarPane(String pane) {
        int indice;
        switch (pane) {
            case CAD_VEIC:
                indice = stackpane.getChildren().indexOf(pane_cadveiculo);
                System.out.println("Indice1: " + indice);
                stackpane.getChildren().get(indice).toFront();
                System.out.println("Indice2: " + indice);
                break;
            
            case "MARCA":
                indice = stackpane.getChildren().indexOf(pane_marca);
                stackpane.getChildren().get(indice).toFront();
                System.out.println("indice: " + indice);
                break;

            case VIS_VEIC:
                indice = stackpane.getChildren().indexOf(pane_visuveiculos);
                stackpane.getChildren().get(indice).toFront();
                System.out.println("indice: " + indice);
                break;

            case "DETALHE":
                indice = stackpane.getChildren().indexOf(pane_detalhe);
                stackpane.getChildren().get(indice).toFront();
                System.out.println("indice: " + indice);
        }
    }

    private void initMenuCadastro() {

        TreeItem<String> ti_root = new TreeItem<>("root");
        TreeItem<String> ti_cadVeic = new TreeItem<>(CAD_VEIC);
        TreeItem<String> ti_cadMot = new TreeItem<>("Cad. Motorista");

        ti_root.getChildren().add(ti_cadVeic);
        ti_root.getChildren().add(ti_cadMot);

        tv_cadastro.setRoot(ti_root);
        tv_cadastro.setShowRoot(false);

        tv_cadastro.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if (t1) {
                    String item = tv_cadastro.getSelectionModel().getSelectedItem().getValue();
                    mudarPane(item);
                }
            }
        });

        tv_veiculos.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if (t1) {
                    String item = tv_veiculos.getSelectionModel().getSelectedItem().getValue();
                    mudarPane(item);
                }
            }
        });

        tv_cadastro.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println("Menu: " + tl.getValue());
                switch (tl.getValue()) {
                    case CAD_VEIC:
                        int indice = stackpane.getChildren().indexOf(pane_cadveiculo);
                        System.out.println("Indice1: " + indice);
                        stackpane.getChildren().get(indice).toFront();
                        System.out.println("Indice2: " + indice);
                }
            }
        });
    }

    private void initMenuVisu() {
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

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("/maps/Map.fxml"));
            Scene scene = new Scene(root);
            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.show();
        } catch (IOException ex) {
            System.out.println("Erro ao abrir o mapa.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iview.setImage(new Image(getClass().getResourceAsStream("/imagens/map.jpg"), 147, 147, true, true));

        try {
            loader_inicial = new FXMLLoader(getClass().getResource("/panes/PaneInicial.fxml"));
            loader_cadveiculo = new FXMLLoader(getClass().getResource("/panes/PaneCadVeiculo.fxml"));
            loader_visuveiculos = new FXMLLoader(getClass().getResource("/panes/PaneVisuVeiculos.fxml"));
            loader_todosveiculos = new FXMLLoader(getClass().getResource("/panes/PaneTodVeiculos.fxml"));
            loader_detalhe = new FXMLLoader(getClass().getResource("/panes/Panevisuindividual.fxml"));
            loader_marca = new FXMLLoader (getClass().getResource("/panes/PaneMarca.fxml"));
            pane_incial = (Node) loader_inicial.load();
            pane_cadveiculo = (Node) loader_cadveiculo.load();
            pane_visuveiculos = (Node) loader_visuveiculos.load();
            pane_todosveiculos = (Node) loader_todosveiculos.load();
            pane_detalhe = (Node) loader_detalhe.load();
            pane_marca = (Node) loader_marca.load();
            
            stackpane.getChildren().add(pane_marca);
            stackpane.getChildren().add(pane_detalhe);
            stackpane.getChildren().add(pane_todosveiculos);
            stackpane.getChildren().add(pane_visuveiculos);
            stackpane.getChildren().add(pane_cadveiculo);
            stackpane.getChildren().add(pane_incial);

            ((PaneVisuVeiculosController) loader_visuveiculos.getController()).setMain(this);
            ((PaneCadVeiculoController) loader_cadveiculo.getController()).setMain(this);
            ((PaneMarcaController) loader_marca.getController()).setMain(this);
        } catch (IOException ex) {
            System.out.println("Erro ao carregar os Panes");
        }

        mudarPane("INICIAL");
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
