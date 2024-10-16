package servico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

        var arquivo = new File(NOME_ARQUIVO);

        try {

            System.out.println("Lista de peliculas..");

            var entrada = new BufferedReader(new FileReader(arquivo));

            String linha;

            linha = entrada.readLine();

            while (linha != null) {

                var pelicula = new Pelicula(linha);

                System.out.println(pelicula);

                linha = entrada.readLine();

            }

            entrada.close();

        } catch (Exception e) {
         
            System.out.println("Ocorreu um erro ao ler o arquivo");

        }
       
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        
        var anexar = false;
       
        var arquivo = new File(NOME_ARQUIVO);

        try {

            anexar = arquivo.exists();

            var saida = new PrintWriter(new FileWriter(arquivo, anexar));

            saida.println(pelicula);

            saida.close();

            System.out.println("Agregado com sucesso");

        } catch (Exception e) {
         
            System.out.println("Ocorreu um erro ao agregar o arquivo");

        }
       
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

        var arquivo = new File(NOME_ARQUIVO);

        try {

            var entrada = new BufferedReader(new FileReader(arquivo));

            String linhaTexto;

            linhaTexto = entrada.readLine();
            
            var indice = 1;

            var encontrado = false;

            var peliculaBuscar = pelicula.getNome();

            while (linhaTexto != null) {

                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(linhaTexto)) {

                    encontrado = true;

                    break;

                }

                linhaTexto = entrada.readLine();

                indice++;
                
            }

            if (encontrado) {

                System.out.println("Pelicula " + linhaTexto + " econtrado na linha " + indice);
                
            } else System.out.println("Pelicula nao encontrada");

            System.out.println("Agregado com sucesso");

        } catch (Exception e) {
         
            System.out.println("Ocorreu um erro ao buscar o arquivo");

        }
    }

}
