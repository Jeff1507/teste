package ifpr.pgua.eic.colecaomusicas.controllers;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroPlaylist {
    @FXML
    private TextField tfNome;

    private RepositorioPlaylist repositorio;

    public CadastroPlaylist(RepositorioPlaylist repositorio){
        this.repositorio=repositorio;
    }
    @FXML
    void cadastrar(ActionEvent event){
        String nome=tfNome.getText();
        String msg=repositorio.cadastrarPlaylist(nome);
        Alert alert=new Alert(AlertType.INFORMATION, msg);
        alert.showAndWait();
    }
    @FXML
    void cancelar(ActionEvent event){
        App.popScreen();
    }
}
