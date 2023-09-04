package ifpr.pgua.eic.colecaomusicas.model.repositories;

import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.daos.PlaylistDAO;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;

public class RepositorioPlaylist {
        private ArrayList<Playlist> playlists;
    
    private PlaylistDAO dao;

    public RepositorioPlaylist(PlaylistDAO dao){
        playlists = new ArrayList<>();
        this.dao = dao;
    }

    public String cadastrarPlaylist(String nome){
        Playlist playlist = new Playlist(nome);
        Resultado resultado = dao.criar(playlist);
        return resultado.getMsg();
    }

    public Resultado listarPlaylists(){
        return dao.listar();
    }

}
