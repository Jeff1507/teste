package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;

public class JDBCPlaylistDAO implements PlaylistDAO{

    private FabricaConexoes fabrica;

    private JDBCPlaylistDAO(FabricaConexoes fabrica){
        this.fabrica=fabrica;
    }

    @Override
    public Resultado criar(Playlist playlist) {
        try(Connection con=fabrica.getConnection()){
            
            PreparedStatement pstm = con.prepareStatement("INSERT INTO playlist(nome) VALUES (?)");
            pstm.setString(1, playlist.getNome());
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
    
}
