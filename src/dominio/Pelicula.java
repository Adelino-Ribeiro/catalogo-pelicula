package dominio;

public class Pelicula {

    private String nome;

    public Pelicula () {}

    public Pelicula(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pelicula other = (Pelicula) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

   public static void main (String[] ags) {
    var pelicula1 = new Pelicula("Batman");
    var pelicula2 = new Pelicula("Superman");

    System.out.println(pelicula1);
    System.out.println(pelicula2);
   }
}