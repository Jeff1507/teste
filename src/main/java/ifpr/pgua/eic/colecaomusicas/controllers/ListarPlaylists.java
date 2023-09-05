package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioMusicas;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ListarPlaylists implements Initializable{

    @FXML
    private ListView<Playlist> lstPlaylists;

    @FXML
    private ListView<Musica> lstMusicas;

    private RepositorioPlaylist repositorio;
    private RepositorioMusicas repositorioMusicas;

    public ListarPlaylists(RepositorioPlaylist repositorio, RepositorioMusicas repositorioMusicas){
        this.repositorio=repositorio;
        this.repositorioMusicas=repositorioMusicas;
    }

    /*@FXML
    void mostrarDetalhes(MouseEvent event){
        
        Playlist playlist=lstPlaylists.getSelectionModel().getSelectedItem();
        if(playlist!=null){
            int PlaylistId=playlist.getId();

            Resultado resultado=repositorio.listarPlaylists();
        }
    }*/

    @FXML
    void voltar(ActionEvent event){
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstPlaylists.getItems().clear();

        Resultado resultado=repositorio.listarPlaylists();

        if(resultado.foiErro()){
            Alert alert=new Alert(AlertType.ERROR, resultado.getMsg());
            alert.showAndWait();
            return;
        }

        List<Playlist> lista = (List)resultado.comoSucesso().getObj();
        lstPlaylists.getItems().addAll(lista);
        

    }
}
