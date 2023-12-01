package uniandes.edu.co.proyecto.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "consumos_servicio")
public class ConsumoServicio {
    
    @Id
    private ObjectId _id;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String nombre_servicio;
    private double costo;

    public ConsumoServicio(Date fecha_inicio, Date fecha_fin, String nombre_servicio, double costo) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.nombre_servicio = nombre_servicio;
        this.costo = costo;
    }

    public ConsumoServicio() {;}

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha_inicio == null) ? 0 : fecha_inicio.hashCode());
        result = prime * result + ((fecha_fin == null) ? 0 : fecha_fin.hashCode());
        result = prime * result + ((nombre_servicio == null) ? 0 : nombre_servicio.hashCode());
        long temp;
        temp = Double.doubleToLongBits(costo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        ConsumoServicio other = (ConsumoServicio) obj;
        if (fecha_inicio == null) {
            if (other.fecha_inicio != null)
                return false;
        } else if (!fecha_inicio.equals(other.fecha_inicio))
            return false;
        if (fecha_fin == null) {
            if (other.fecha_fin != null)
                return false;
        } else if (!fecha_fin.equals(other.fecha_fin))
            return false;
        if (nombre_servicio == null) {
            if (other.nombre_servicio != null)
                return false;
        } else if (!nombre_servicio.equals(other.nombre_servicio))
            return false;
        if (Double.doubleToLongBits(costo) != Double.doubleToLongBits(other.costo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ConsumoServicio [fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", nombre_servicio="
                + nombre_servicio + ", costo=" + costo + "]";
    }

    
}
