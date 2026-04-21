package Modelo;

import Controlador.Peliculas;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.*;
import Modelo.Conexion;

public class PeliculasDAO {

    Connection conn;

    public PeliculasDAO(){
        conn = Conexion.getConnection(); // 👈 tu conexión
    }

    public void insertar(Peliculas p, clsBitacora b){
        try{
            String sql = "INSERT INTO peliculas VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getIdPeliculas());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void actualizar(Peliculas p, clsBitacora b){
        try{
            String sql = "UPDATE peliculas SET nombre=?, precio=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getIdPeliculas());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void eliminar(int id, clsBitacora b){
        try{
            String sql = "DELETE FROM peliculas WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Peliculas> obtenerTodos(clsBitacora b){
        List<Peliculas> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM peliculas";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Peliculas p = new Peliculas();
                p.setIdPeliculas(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                lista.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

}
