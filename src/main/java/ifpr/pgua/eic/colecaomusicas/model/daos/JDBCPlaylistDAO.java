package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;

public class JDBCPlaylistDAO implements PlaylistDAO{
    private static final String insertSQLPlay="INSERT INTO playlist(nome) VALUES (?)";
    private static final String insertSQLPlayMusica="INSET INTO playlist_musica(playlist_id, musica_id) VALUES (?, ?)";
    private static final String SELECTSQL="SELECT * FROM playlist_musica";

    private FabricaConexoes fabrica;

    public JDBCPlaylistDAO(FabricaConexoes fabrica){
        this.fabrica=fabrica;
    }

    @Override
    public Resultado criar(Playlist playlist) {
        try(Connection con=fabrica.getConnection()){
            
            PreparedStatement pstm = con.prepareStatement(insertSQLPlay, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, playlist.getNome());

            PreparedStatement pstm2=con.prepareStatement(insertSQLPlayMusica, Statement.RETURN_GENERATED_KEYS);


            int ret=pstm.executeUpdate();
            if(ret==1){
                return Resultado.sucesso("Playlist criada!", playlist);
            }
            return Resultado.erro("Erro desconhecido!");

        }
        catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
        
    }

    @Override
    public Resultado listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Resultado getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Resultado atualizar(int id, Playlist nova) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Resultado deletar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}
