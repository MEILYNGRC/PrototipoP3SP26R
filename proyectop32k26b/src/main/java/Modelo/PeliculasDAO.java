package Modelo;
//dao 7 campos

import Controlador.Peliculas;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.*;
import Modelo.Conexion;

public class PeliculasDAO {

    Connection conn;

    public PeliculasDAO() {//constructor
        try {
            conn = Conexion.getConnection();
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
//insertae
    public void insertar(Peliculas p, clsBitacora b) {
        try {
            String sql = "INSERT INTO peliculas (id, nombre, clasificacion, genero, subtitulado, idioma, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getIdPeliculas());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getClasificacion());
            ps.setString(4, p.getGenero());
            ps.setString(5, p.getSubtitulado());
            ps.setString(6, p.getIdioma());
            ps.setDouble(7, p.getPrecio());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//actualizar
    public void actualizar(Peliculas p, clsBitacora b) {
        try {
            String sql = "UPDATE peliculas SET nombre=?, clasificacion=?, genero=?, subtitulado=?, idioma=?, precio=? WHERE id=?";
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
//eliminar
    public void eliminar(int id, clsBitacora b) {
        try {
            String sql = "DELETE FROM peliculas WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//datos 
    public List<Peliculas> obtenerTodos(clsBitacora b) {
        List<Peliculas> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM peliculas";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Peliculas p = new Peliculas();
                p.setIdPeliculas(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setClasificacion(rs.getString("clasificacion"));
                p.setGenero(rs.getString("genero"));
                p.setSubtitulado(rs.getString("subtitulado"));
                p.setIdioma(rs.getString("idioma"));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
