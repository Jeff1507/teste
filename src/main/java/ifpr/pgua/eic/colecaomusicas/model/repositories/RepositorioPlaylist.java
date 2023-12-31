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

    private ArrayList<Musica> musicas;
    
    private PlaylistDAO dao;
    private MusicaDAO musicaDao;

    public RepositorioPlaylist(PlaylistDAO dao, MusicaDAO musicaDAO){
        playlists=new ArrayList<>();
        this.dao = dao;
        this.musicaDao=musicaDao;
    }

    public Resultado cadastrarPlaylist(String nome, List<Musica> musicas){
        if(nome.isBlank() || nome.isEmpty()){
            return Resultado.erro("Nome invalido");
        }
        else if(musicas.isEmpty()){
            return Resultado.erro("Nenhuma musica selecionada!");
        }
        Playlist playlist = new Playlist(nome);
        playlist.setMusicas(musicas);
        Resultado resultado = dao.criar(playlist);
        return resultado;
    }

    public Resultado listarPlaylists(){

        Resultado resultado=dao.listar();

        if(resultado.foiSucesso()){
            List<Playlist> lista=(List<Playlist>) resultado.comoSucesso().getObj();

            for(Playlist p:lista){
                Resultado r=musicaDao.buscarMusicasPlaylist(p.getId());

                if(r.foiErro()){
                    return r;
                }
                List<Musica> musicas=(List<Musica>) r.comoSucesso().getObj();
                p.setMusicas(musicas);
            }

        }
        return resultado;
        

    }


}
