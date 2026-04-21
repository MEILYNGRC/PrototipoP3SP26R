package Vista;


import Controlador.Peliculas;
import Controlador.clsBitacora;
import Modelo.PeliculasDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class frmPeliculas extends javax.swing.JFrame {

    public frmPeliculas() {
        initComponents();
        llenadoDeTablas();
    }

    private void initComponents() {
        setTitle("Mantenimiento Peliculas");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        txtCodigo = new JTextField(); txtCodigo.setBounds(20,20,100,25); add(txtCodigo);
        txtNombre = new JTextField(); txtNombre.setBounds(20,60,150,25); add(txtNombre);
        txtPrecio = new JTextField(); txtPrecio.setBounds(20,100,100,25); add(txtPrecio);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(20,140,100,30);
        add(btnRegistrar);

        tabla = new JTable();
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(200,20,550,400);
        add(sp);
    }

    public void llenadoDeTablas(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");

        PeliculasDAO dao = new PeliculasDAO();
        List<Peliculas> lista = dao.obtenerTodos(new clsBitacora());

        for(Peliculas p: lista){
            modelo.addRow(new Object[]{p.getIdPeliculas(), p.getNombre(), p.getPrecio()});
        }

        tabla.setModel(modelo);
    }

    private JTextField txtCodigo, txtNombre, txtPrecio;
    private JButton btnRegistrar;
    private JTable tabla;

    public static void main(String[] args){
        new frmPeliculas().setVisible(true);
    }
}
