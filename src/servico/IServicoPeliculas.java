package servico;

import dominio.Pelicula;

public interface IServicoPeliculas {
    
    public void listarPeliculas ();

    public void agregarPelicula (Pelicula pelicula);

    public void buscarPelicula (Pelicula pelicula);
    
}
