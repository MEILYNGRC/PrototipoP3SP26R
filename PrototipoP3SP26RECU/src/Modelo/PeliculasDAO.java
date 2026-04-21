package Modelo;

import Controlador.Peliculas;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.*;

public class PeliculasDAO {

    Conexion cn = new Conexion();

    public void insertar(Peliculas p, clsBitacora bitacora) {
        String sql = "INSERT INTO Peliculas (Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = cn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getClasificacion());
            ps.setString(3, p.getGenero());
            ps.setString(4, p.getSubtitulado());
            ps.setString(5, p.getIdioma());
            ps.setDouble(6, p.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    
    }

    public void actualizar(Peliculas p, clsBitacora bitacora) {
        String sql = "UPDATE Peliculas SET Nombre=?, Clasificacion=?, Genero=?, Subtitulado=?, Idioma=?, precio=? WHERE idPeliculas=?";
        try (Connection conn = cn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getClasificacion());
            ps.setString(3, p.getGenero());
            ps.setString(4, p.getSubtitulado());
            ps.setString(5, p.getIdioma());
            ps.setDouble(6, p.getPrecio());
            ps.setInt(7, p.getIdPeliculas());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void eliminar(Peliculas p, clsBitacora bitacora) {
        String sql = "DELETE FROM Peliculas WHERE idPeliculas=?";
        try (Connection conn = cn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPeliculas());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Peliculas obtenerPorId(int id, clsBitacora bitacora) {
        Peliculas p = null;
        String sql = "SELECT * FROM Peliculas WHERE idPeliculas=?";
        try (Connection conn = cn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Peliculas();
                p.setIdPeliculas(rs.getInt("idPeliculas"));
                p.setNombre(rs.getString("Nombre"));
                p.setClasificacion(rs.getString("Clasificacion"));
                p.setGenero(rs.getString("Genero"));
                p.setSubtitulado(rs.getString("Subtitulado"));
                p.setIdioma(rs.getString("Idioma"));
                p.setPrecio(rs.getDouble("precio"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return p;
    }

    public List<Peliculas> obtenerTodos(clsBitacora bitacora) {
        List<Peliculas> lista = new ArrayList<>();
        String sql = "SELECT * FROM Peliculas";
        try (Connection conn = cn.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
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
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
}
