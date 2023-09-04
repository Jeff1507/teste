package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListarPlaylists implements Initializable{

    @FXML
    private ListView<Playlist> lstPlaylists;

    @FXML
    private ListView<Musica> lstMusicas;

    private RepositorioPlaylist repositorio;

    public ListarPlaylists(RepositorioPlaylist repositorio){
        this.repositorio=repositorio;
    }

    @FXML
    void voltar(ActionEvent event){
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstPlaylists.getItems().clear();
    }
}
