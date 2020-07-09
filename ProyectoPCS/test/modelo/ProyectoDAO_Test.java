package modelo;

import javafx.collections.ObservableList;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ProyectoDAO_Test{
    ProyectoDAO proyectoDAO;
    ProyectoPOJO proyecto;
    
    @Before
    public void before(){
        proyectoDAO = new ProyectoDAO();
    }
    
    @Test
    public void testRecuperarNombre(){
        String nombre = proyectoDAO.recuperarNombre(712);
        assertTrue(nombre.equalsIgnoreCase("SecureServ"));
    }
    
    @Test
    public void testRecuperarNombreOrganizacion(){
        String nombreOrganizacion = proyectoDAO.recuperarNombreOrganizacion(712);
        assertTrue(nombreOrganizacion.equalsIgnoreCase("Softeck"));
    }
    
    @Test 
    public void recuperarProyectosTest(){
        ObservableList<ProyectoPOJO> proyectos = proyectoDAO.getProyectos();
        proyecto = proyectos.get(0);
        assertTrue(proyecto.getNombre().equalsIgnoreCase("ProdutivityService"));
    }
}
