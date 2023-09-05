package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;

public interface MusicaDAO {
    Resultado criar(Musica musica);
    Resultado listar();
    Resultado getById(int id);
    Resultado atualizar(int id, Musica nova);
    Resultado deletar(int id);
    Resultado buscarMusicasPlaylist(int playlistid);
}
