package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioMusicas;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylist;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroPlaylist implements Initializable{
    @FXML
    private TextField tfNome;

    @FXML
    private ListView<Musica> lstMusicas;

    private RepositorioPlaylist repositorio;
    private RepositorioMusicas repositorioMusicas;

    private List<Musica> musicasSelecionadas;

    public CadastroPlaylist(RepositorioPlaylist repositorio, RepositorioMusicas repositorioMusicas){
        this.repositorio=repositorio;
        this.repositorioMusicas=repositorioMusicas;
        this.musicasSelecionadas=new ArrayList<>();
    }
    @FXML
    void cadastrar(ActionEvent event){
        String nome=tfNome.getText();
        List<Musica> musicasPlaylist=new ArrayList<>(musicasSelecionadas);

        Resultado rs=repositorio.cadastrarPlaylist(nome, musicasPlaylist);
        Alert alert;
        String msg=rs.getMsg();
        if(rs.foiErro()){
            alert=new Alert(AlertType.ERROR, msg);
        }
        else{
            alert=new Alert(AlertType.INFORMATION, msg);
        }
        alert.showAndWait();

    }
    @FXML
    void cancelar(ActionEvent event){
        App.popScreen();
    }
    @FXML
    void adicionarMusicas(){
        List<Musica> musicasSelecionadasTemp=lstMusicas.getSelectionModel().getSelectedItems();
        musicasSelecionadas.addAll(musicasSelecionadasTemp);
        if(musicasSelecionadas.isEmpty()){
            Alert alert=new Alert(AlertType.ERROR, "Selecione ao menos uma musica");
            alert.showAndWait();
        }
        else{
            String str="";
            for(Musica m:musicasSelecionadas){
                str+=m.getNome()+";";
            }
            Alert alert = new Alert(AlertType.INFORMATION, "Música(s) adicionadas");
            alert.showAndWait();
        }

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstMusicas.getItems().clear();

        lstMusicas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Resultado res=repositorioMusicas.listar();

        if(res.foiSucesso()){
            List<Musica> lista=(List<Musica>) res.comoSucesso().getObj();
            lstMusicas.getItems().addAll(lista);
        }
        else{
            Alert alert = new Alert(AlertType.ERROR, res.getMsg());
            alert.showAndWait();
        }


    }
}
