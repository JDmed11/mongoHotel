package uniandes.edu.co.proyecto.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "servicios_hotel")
public class ServicioHotel {
    
    @Id
    private ObjectId _id;
    private String nombre_servicio;

    public ServicioHotel(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public ServicioHotel() {;}

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
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
        return true;
    }

    @Override
    public String toString() {
        return "ServicioHotel [nombre_servicio=" + nombre_servicio + "]";
    }

    
}
