package uniandes.edu.co.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "servicios_hotel")
public class ServicioHotel {
    
    @Id
    private String id;
    private String nombre_servicio;
    private boolean disponible;

    public ServicioHotel(String nombre_servicio, boolean disponible) {
        this.nombre_servicio = nombre_servicio;
        this.disponible = disponible;
    }

    public ServicioHotel() {;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre_servicio == null) ? 0 : nombre_servicio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ServicioHotel other = (ServicioHotel) obj;
        if (nombre_servicio == null) {
            if (other.nombre_servicio != null)
                return false;
        } else if (!nombre_servicio.equals(other.nombre_servicio))
            return false;
        if (disponible != other.disponible)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ServicioHotel [nombre_servicio=" + nombre_servicio + ", disponible=" + disponible + "]";
    }

    
}
