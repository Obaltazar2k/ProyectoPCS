package modelo;

import java.time.LocalDate;

public class ArchivoPOJO {
    int id;
    byte[] archivo;
    String titulo;
    LocalDate fechaEntrega;

    public ArchivoPOJO(int id, String titulo,LocalDate fechaEntrega) {
        this.id = id;
        //this.archivo = archivo;
        this.fechaEntrega = fechaEntrega;
        this.titulo = titulo;
    }

    public ArchivoPOJO() {
        
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public byte[] getArchivo() {
        return archivo;
    }
    
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
    
    
    
}
