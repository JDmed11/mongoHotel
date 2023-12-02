package uniandes.edu.co.proyecto.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "tipos_habitacion")
public class TipoHabitacion {
    
    @Id
    private String id;
    private String nombre_tipo;
    private int capacidad;
    private boolean tiene_jacuzzi;
    private boolean tiene_cocina;
    private boolean tiene_comedor;
    private double precio_noche;
    private List<Habitacion> habitaciones_asociadas;

    public TipoHabitacion(String nombre_tipo, int capacidad, boolean jacuzzi, boolean cocina, boolean comedor, double precio_noche) {
        this.nombre_tipo = nombre_tipo;
        this.capacidad = capacidad;
        this.tiene_jacuzzi = jacuzzi;
        this.tiene_cocina = cocina;
        this.tiene_comedor = comedor;
        this.precio_noche = precio_noche;
    }

    public TipoHabitacion() {;}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isTiene_jacuzzi() {
        return tiene_jacuzzi;
    }

    public void setTiene_jacuzzi(boolean jacuzzi) {
        this.tiene_jacuzzi = jacuzzi;
    }

    public boolean isTiene_cocina() {
        return tiene_cocina;
    }

    public void setTiene_cocina(boolean cocina) {
        this.tiene_cocina = cocina;
    }

    public boolean isTiene_comedor() {
        return tiene_comedor;
    }

    public void setTiene_comedor(boolean comedor) {
        this.tiene_comedor = comedor;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public List<Habitacion> getHabitaciones_asociadas() {
        return habitaciones_asociadas;
    }

    public void setHabitaciones_asociadas(List<Habitacion> habitaciones_asociadas) {
        this.habitaciones_asociadas = habitaciones_asociadas;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre_tipo == null) ? 0 : nombre_tipo.hashCode());
        result = prime * result + capacidad;
        result = prime * result + (tiene_jacuzzi ? 1231 : 1237);
        result = prime * result + (tiene_cocina ? 1231 : 1237);
        result = prime * result + (tiene_comedor ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(precio_noche);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((habitaciones_asociadas == null) ? 0 : habitaciones_asociadas.hashCode());
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
        TipoHabitacion other = (TipoHabitacion) obj;
        if (nombre_tipo == null) {
            if (other.nombre_tipo != null)
                return false;
        } else if (!nombre_tipo.equals(other.nombre_tipo))
            return false;
        if (capacidad != other.capacidad)
            return false;
        if (tiene_jacuzzi != other.tiene_jacuzzi)
            return false;
        if (tiene_cocina != other.tiene_cocina)
            return false;
        if (tiene_comedor != other.tiene_comedor)
            return false;
        if (Double.doubleToLongBits(precio_noche) != Double.doubleToLongBits(other.precio_noche))
            return false;
        if (habitaciones_asociadas == null) {
            if (other.habitaciones_asociadas != null)
                return false;
        } else if (!habitaciones_asociadas.equals(other.habitaciones_asociadas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoHabitacion [nombre_tipo=" + nombre_tipo + ", capacidad=" + capacidad + ", jacuzzi=" + tiene_jacuzzi
                + ", cocina=" + tiene_cocina + ", comedor=" + tiene_comedor + ", precio_noche=" + precio_noche
                + ", habitaciones_asociadas=" + habitaciones_asociadas.toString() + "]";
    }

    
    
}


