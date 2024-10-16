package servico;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import dominio.Pelicula;

public class ServicosPeliculasArquivo implements IServicoPeliculas {

    private final String NOME_ARQUIVO = "peliculas.txt";

    public ServicosPeliculasArquivo () {

        var arquivo = new File(NOME_ARQUIVO);

        try {

            if (arquivo.exists()) System.out.println("Arquivo ja existe!");

            else {

                var saida = new PrintWriter(new FileWriter(arquivo));

                saida.close();
                System.out.println("Arquivo criado com sucesso.");
            }
            
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao abrir o arquivo: " + e.getMessage());

        }
    }

    @Override
    public void listarPeliculas() {
       
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
       
    }

}
