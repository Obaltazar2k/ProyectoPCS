package vista;

import javafx.stage.Stage;

public abstract class Alerta {

    protected Stage ventanaPropietaria;

    public Alerta(Stage ventanaPropietaria) {
        this.ventanaPropietaria = ventanaPropietaria;
    }

    public abstract void alertaInformacion(String titulo, String encabezado,
            String contenido);

    public abstract void alertaError(String titulo, String encabezado,
            String contenido);

    public abstract boolean alertaConfirmacion(String titulo, String encabezado,
            String contenido);

}
