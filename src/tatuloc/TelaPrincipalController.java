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
import javafx.event.ActionEvent;
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
    private Node pane_incial;
    private Node pane_cadveiculo;
    private Node pane_vizuveiculos;
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
private void initMenuVizu() {
        final String VIZ_VEIC = "Viz. Veículos Ativos";
        final String TOD_VEIC = "Tod. os Veiculos";
        TreeItem<String> ti_root = new TreeItem<>("root");
        TreeItem<String> ti_vizVeicA = new TreeItem<>(VIZ_VEIC);
        TreeItem<String> ti_vizTodVeic = new TreeItem<>(TOD_VEIC);

        ti_root.getChildren().add(ti_vizVeicA);
        ti_root.getChildren().add(ti_vizTodVeic);

        tv_veiculos.setRoot(ti_root);
        tv_veiculos.setShowRoot(false);

        tv_veiculos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> ov, TreeItem<String> t, TreeItem<String> tl) {
                System.out.println("Menu: " + tl.getValue());
                switch (tl.getValue()) {
                    case VIZ_VEIC:
                        int indice = stackpane.getChildren().indexOf(pane_vizuveiculos);
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {           
            pane_incial = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneInicial.fxml"));
            pane_cadveiculo = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneCadVeiculo.fxml"));         
            pane_vizuveiculos = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneVizuVeiculos.fxml"));                      
            pane_todosveiculos = (Node) FXMLLoader.load(getClass().getResource("/panes/PaneTodVeiculos.fxml"));
            stackpane.getChildren().add(pane_todosveiculos); 
            stackpane.getChildren().add(pane_vizuveiculos);
            stackpane.getChildren().add(pane_cadveiculo);
            stackpane.getChildren().add(pane_incial);
            
            
        } catch (IOException ex) {
            System.out.println("Erro ao carregar os Panes");
        }
        initMenuCadastro();
        initMenuVizu();

       
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
