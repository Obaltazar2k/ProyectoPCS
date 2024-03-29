package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase que encargada de realizar todas las operaciones de los objetos
 * ESTUDIANTE manejados dentro del sistema con los registrados en la BD.
 *
 * @version 1.0
 */
public class EstudianteDAO implements EstudianteDAO_Interfaz{

    /**
     * Recupera un objeto ESTUDIANTE por medio de una matricula especifica.
     * 
     * @param matricula Matricula del ESTUDIANTE a recuperar.
     * @return EstudiantePOJO Objeto ESTUDIANTE.
     */
    @Override
    public EstudiantePOJO recuperar(String matricula) throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        EstudiantePOJO estudiante = null;
        String sql = "SELECT * FROM estudiante WHERE matricula = '" + 
                matricula + "';";
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                estudiante = new EstudiantePOJO(rs.getString(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getString(6), rs.getFloat(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "recuperar: " + ex.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        
        return estudiante;
    }

    /**
     * Recupera el nombre de un ESTUDIANTE especificado.
     * 
     * @param matricula Matricula del ESTUDIANTE a recuperar.
     * @return nombreEstudiante Nombre del ESTUDIAIANTE especificado.
     */
    @Override
    public String recuperarNombreEstudiante(String matricula) throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String nombreEstudiante = null;
        String sql = "SELECT estudiante.nombre FROM estudiante WHERE matricula"
                + " = '" + matricula + "';";
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                nombreEstudiante = rs.getString(1);
            }
        } catch (SQLException ex) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "recuperarNombreEstudiante: " + ex.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        
        return nombreEstudiante;
    }

    /**
     * Recupera el nombre de la ORGANIZACION perteneciente al PROYECTO asignado
     * a un ESTUDIANTE especificado.
     * 
     * @param matricula Matricula del ESTUDIANTE a recuperar.
     * @return nombreOrganizacion Nombre de la ORGANIZACION especificado.
     */
    @Override
    public String recuperarNombreOrganizacion(String matricula) 
            throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String nombreOrganizacion = null;
        String sql = "SELECT proyecto.nombreorganizacion FROM inscripcion JOIN "
                + "proyecto ON inscripcion.claveProyecto = "
                + "proyecto.claveProyecto WHERE matricula = '" + matricula + 
                "';";
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                nombreOrganizacion = rs.getString(1);
            }
        } catch (SQLException ex) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "recuperarNombreOrganizacion: " + ex.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        
        return nombreOrganizacion;
    }

    /**
     * Recupera el nombre del PROYECTO asignado a un ESTUDIANTE especificado.
     * 
     * @param matricula Matricula del ESTUDIANTE a recuperar.
     * @return nombreProyecto Nombre del PROYECTO especificado.
     */
    @Override
    public String recuperarNombreProyecto(String matricula) throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String nombreProyecto = null;
        String sql = "SELECT proyecto.nombre FROM inscripcion JOIN proyecto ON "
                + "inscripcion.claveProyecto = proyecto.claveProyecto WHERE "
                + "matricula = '" + matricula + "';";
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                nombreProyecto = rs.getString(1);
            }
        } catch (SQLException ex) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "recuperarNombreProyecto: " + ex.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        
        return nombreProyecto;
    }

    /**
     * Recupera la clave del PROYECTO asignado a un ESTUDIANTE especificado.
     * 
     * @param matricula Matricula del ESTUDIANTE a recuperar.
     * @return claveProyecto Clave del PROYECTO especificado.
     */
    @Override
    public int recuperarClaveProyecto(String matricula) throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        int claveProyecto = 0;
        String sql = "SELECT inscripcion.claveProyecto FROM inscripcion "
                + "WHERE matricula = '" + matricula + "';";
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                claveProyecto = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "recuperarClaveProyecto: " + ex.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        return claveProyecto;
    }

    /**
     * Recupera la clave del EXPEDIENTE perteneciente a un ESTUDIANTE 
     * especificado.
     * 
     * @param matricula Matricula del ESTUDIANTE a recuperar.
     * @return claveExpediente Clave del EXPEDIENTE especificado.
     */
    @Override
    public int recuperaClaveExpediente(String matricula) throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        int claveExpediente = 0;
        String sql = "SELECT expediente.clave FROM expediente WHERE matricula "
                + "= '" + matricula + "';";
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                claveExpediente = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "recuperarClaveExpediente: " + ex.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        return claveExpediente;
    }

    /**
     * Recupera de la base de datos la lista de ESTUDIANTES registrados en la 
     * BD.
     * 
     * @return obs Lista contenedora de los ESTUDIANTES.
     */
    @Override
    public ObservableList<EstudiantePOJO> getEstudiantes() throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select estudiante.nombre, estudiante.apellidopaterno, "
                + "estudiante.apellidomaterno, estudiante.matricula from "
                + "estudiante where not exists (select estudiante.matricula "
                + "from expediente where expediente.matricula = "
                + "estudiante.matricula);";
        ObservableList<EstudiantePOJO> obs = FXCollections.
                observableArrayList();
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                String apellidoPaterno = rs.getString("APELLIDOPATERNO");
                String apellidoMaterno = rs.getString("APELLIDOMATERNO");
                String matricula = rs.getString("MATRICULA");
                EstudiantePOJO c = new EstudiantePOJO(nombre, apellidoPaterno, 
                        apellidoMaterno, matricula);
                obs.add(c);
            }
        } catch (SQLException e) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "getEstudiantes: " + e.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        return obs;
    }

    /**
     * Recupera de la base de datos la lista de SELECCIONPROYECTO de un
     * ESTUDIANTE especificado registrado en la BD.
     * 
     * @param matricula Matricula del ESTUDIANTE del cual se recuperaran las 
     * SELECCIONPROYECTO.
     * @return obs Lista contenedora de las SELECCIONPROYECTO.
     */
    @Override
    public ArrayList<SeleccionProyectoPOJO> getSelecciones(String matricula) 
            throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select claveproyecto, fecha, periodo from "
                + "seleccionproyecto where matricula = '" + matricula + "';";
        ArrayList<SeleccionProyectoPOJO> obs 
                = new ArrayList<SeleccionProyectoPOJO>();
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int claveproyecto = rs.getInt("claveproyecto");
                LocalDate fecha = LocalDate.parse(rs.getString("fecha"), 
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String periodo = rs.getString("periodo");
                SeleccionProyectoPOJO c = new SeleccionProyectoPOJO(
                        claveproyecto, fecha, periodo);
                obs.add(c);
            }
        } catch (SQLException e) {            
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "getSelecciones: " + e.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
        return obs;
    }

    /**
     * Realiza la asignación de un ESTUDIANTE y un PROYECTO registrados en la BD
     * registrando la INSCRIPCION y abriendo el EXPEDIENTE con las respectivas
     * claves de ambos parametros.
     * 
     * @param matriculaEstudianteElegido Matricula del ESTUDIANTE a asignar.
     * @param claveProyectoElegido Clave del PROYECTO a asignar.
     */
    @Override
    public void asginarProyecto(String matriculaEstudianteElegido, 
            int claveProyectoElegido) throws Exception{
        Connection con = null;
        Statement stm = null;
        LocalDate fechaInicioPP = LocalDate.now();
        LocalDate fechaFinPP = fechaInicioPP.plusMonths(6);
        String sql = "INSERT INTO inscripcion VALUES ('" 
                + matriculaEstudianteElegido + "', " + claveProyectoElegido 
                + ", 234, 1, 35, 'Inscrito', '" + fechaInicioPP 
                + "', 123, 'FEB2020-AGO2020', 1, 'Primera inscripcion');";
        String sql2 = "INSERT INTO expediente VALUES (null, '" + fechaFinPP 
                + "', '" + fechaInicioPP + "', 0, 0, '" 
                + matriculaEstudianteElegido + "', " + claveProyectoElegido 
                + ");";
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            stm.executeUpdate(sql2);
;
        } catch (SQLException e) {
            throw new Exception("Error en Clase EstudianteDAO, método "
                    + "getSelecciones: " + e.getMessage());
        }finally{
            try { if (stm != null) stm.close(); } catch (Exception e) {};
            try { if (con!= null) con.close(); } catch (Exception e) {};
        }
    }
}
