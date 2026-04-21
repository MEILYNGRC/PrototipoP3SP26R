package Controlador;

public class Peliculas {
    private int idPeliculas;
    private String nombre;
    private String clasificacion;
    private String genero;
    private String subtitulado;
    private String idioma;
    private double precio;

    public int getIdPeliculas() { return idPeliculas; }
    public void setIdPeliculas(int idPeliculas) { this.idPeliculas = idPeliculas; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getSubtitulado() { return subtitulado; }
    public void setSubtitulado(String subtitulado) { this.subtitulado = subtitulado; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
