package uniandes.edu.co.proyecto.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;

@Document(collection = "habitacion")
public class Habitacion {
    
    @Id
    private ObjectId _id;
    private int numero_habitacion;

    public Habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public Habitacion() {;}

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero_habitacion;
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
        Habitacion other = (Habitacion) obj;
        if (numero_habitacion != other.numero_habitacion)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Habitacion [numero_habitacion=" + numero_habitacion + "]";
    }

    

}
