package ifpr.pgua.eic.colecaomusicas.model.entities;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String nome;
    private ArrayList<Musica> musicas;

    
    
    public Playlist(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Playlist(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Playlist [nome=" + nome + "]";
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

}
