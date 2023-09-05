package ifpr.pgua.eic.colecaomusicas.model.repositories;

import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.daos.MusicaDAO;
import ifpr.pgua.eic.colecaomusicas.model.daos.PlaylistDAO;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;

public class RepositorioPlaylist {

    private ArrayList<Playlist> playlists;
    
    private PlaylistDAO dao;
    private MusicaDAO musicaDao;

    public RepositorioPlaylist(PlaylistDAO dao){
        playlists = new ArrayList<>();
        this.dao = dao;
    }

    public Resultado cadastrarPlaylist(String nome, List<Musica> musicas){
        if(nome.isBlank() || nome.isEmpty()){
            return Resultado.erro("Nome invalido");
        }
        Playlist playlist = new Playlist(nome);
        playlist.setMusicas(musicas);
        Resultado resultado = dao.criar(playlist);
        return resultado;
    }

    public Resultado listarPlaylists(){

        return dao.listar();
    }

}
