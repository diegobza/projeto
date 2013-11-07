/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package custom;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author sistemas
 */
public class Veiculo {

    private final SimpleStringProperty id;
    private final SimpleStringProperty placa;
    private final SimpleStringProperty situacao;

    public Veiculo(String vid, String vplaca, String vsituacao) {
        this.id = new SimpleStringProperty(vid);
        this.placa = new SimpleStringProperty(vplaca);
        this.situacao = new SimpleStringProperty(vsituacao);
    }

    public Veiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id.get();
    }

    public void setId(String vid) {
        id.set(vid);
    }

    public String getPlaca() {
        return placa.get();
    }

    public void setPlaca(String vplaca) {
        placa.set(vplaca);
    }

    public String getSituacao() {
        return situacao.get();
    }

    public void setSituacao(String vsituacao) {
        situacao.set(vsituacao);
    }
}