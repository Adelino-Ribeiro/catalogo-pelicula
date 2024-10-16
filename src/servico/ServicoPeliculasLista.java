package servico;

import java.util.ArrayList;
import java.util.List;

import dominio.Pelicula;

public class ServicoPeliculasLista implements IServicoPeliculas{

    private final List<Pelicula> peliculas;

    public ServicoPeliculasLista () {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {

        System.out.println("Lista de Peliculas...");
        peliculas.forEach(System.out::println);
       
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

        peliculas.add(pelicula);

        System.out.println("Sucesso");
       
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

        var indice = peliculas.indexOf(pelicula);

        if ( indice == -1)
            System.out.println("Pelicula nao encontrada");
        else 
            System.out.println("Pelicula encontrada no indice: " + indice);

       
    }

    public static void main (String[] ags) {
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");
    
        IServicoPeliculas servicoPeliculas = new ServicoPeliculasLista();
        servicoPeliculas.agregarPelicula(pelicula1);
        servicoPeliculas.agregarPelicula(pelicula2);

        servicoPeliculas.listarPeliculas();

        // Buscar
        servicoPeliculas.buscarPelicula(pelicula1);
       }

}
