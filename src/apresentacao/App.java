package apresentacao;

import java.util.Scanner;

import dominio.Pelicula;
import servico.IServicoPeliculas;
import servico.ServicoPeliculasLista;
import servico.ServicosPeliculasArquivo;

public class App {
    public static void main(String[] args) throws Exception {
        
        var sair =  false;

        var console = new Scanner(System.in);

        // IServicoPeliculas servicoPeliculas = new ServicoPeliculasLista();
        IServicoPeliculas servicoPeliculas = new ServicosPeliculasArquivo();

        while (!sair) {

            try {
                mostrarMenu();

                sair = executarOpcoes (console, servicoPeliculas);

            } catch (Exception e) {

                System.out.println("Ocorreu um erro: " + e.getMessage());

            }

            System.out.println();
        }

    }
    
    private static void mostrarMenu () {

        System.out.print("""
                *** Catalogo de Peliculas ***    
                1. Agregar pelicula
                2. Listar Peliculas
                3. Buscar pelicula
                4. Sair
                Escolha uma opcao: 
                """);
        
    }

    public static boolean executarOpcoes (Scanner console, IServicoPeliculas servicoPeliculas) {

        var opcao = Integer.parseInt(console.nextLine());

        var sair = false;

        switch (opcao) {
            case 1 -> {
                System.out.println("Insira o nome da pelicula: ");
                var nome = console.nextLine();
                servicoPeliculas.agregarPelicula(new Pelicula(nome));
            }

            case 2 -> servicoPeliculas.listarPeliculas();
        
            case 3 -> {
                System.out.println("Insira a pelicula a buscar: ");
                var buscar = console.nextLine();
                servicoPeliculas.buscarPelicula(new Pelicula(buscar));
            }

            case 4 -> {
                System.out.println("Saindo...");
                sair = true;
            }

            default -> System.out.println("Opcao incorrecta: " + opcao);

        }

        return sair;
        
    }
}
