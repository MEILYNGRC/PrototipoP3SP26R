package Modelo;

import Controlador.Peliculas;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.*;
import Modelo.Conexion;

public class PeliculasDAO {

    Connection conn;

    public PeliculasDAO() {
        try {
            conn = Conexion.getConnection();
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    // INSERTAR
    public void insertar(Peliculas p, clsBitacora b) {
        try {
            String sql = "INSERT INTO peliculas (Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getClasificacion());
            ps.setString(3, p.getGenero());
            ps.setString(4, p.getSubtitulado());
            ps.setString(5, p.getIdioma());
            ps.setDouble(6, p.getPrecio());

            int resultado = ps.executeUpdate();
            System.out.println("Filas insertadas: " + resultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ACTUALIZAR
    public void actualizar(Peliculas p, clsBitacora b) {
        try {
            String sql = "UPDATE peliculas SET Nombre=?, Clasificacion=?, Genero=?, Subtitulado=?, Idioma=?, precio=? WHERE idPeliculas=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getClasificacion());
            ps.setString(3, p.getGenero());
            ps.setString(4, p.getSubtitulado());
            ps.setString(5, p.getIdioma());
            ps.setDouble(6, p.getPrecio());
            ps.setInt(7, p.getIdPeliculas());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(int id, clsBitacora b) {
        try {
            String sql = "DELETE FROM peliculas WHERE idPeliculas=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // OBTENER TODOS
    public List<Peliculas> obtenerTodos(clsBitacora b) {
        List<Peliculas> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM peliculas";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Peliculas p = new Peliculas();

                p.setIdPeliculas(rs.getInt("idPeliculas"));
                p.setNombre(rs.getString("Nombre"));
                p.setClasificacion(rs.getString("Clasificacion"));
                p.setGenero(rs.getString("Genero"));
                p.setSubtitulado(rs.getString("Subtitulado"));
                p.setIdioma(rs.getString("Idioma"));
                p.setPrecio(rs.getDouble("precio"));

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
