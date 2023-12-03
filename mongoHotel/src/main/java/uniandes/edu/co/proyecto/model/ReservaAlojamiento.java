package uniandes.edu.co.proyecto.model;

import java.util.Date;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Id;
import uniandes.edu.co.proyecto.model.enumeraciones.EstadoReserva;

@Document(collection = "reservas_alojamiento")
public class ReservaAlojamiento {
 
    @Id
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_entrada;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_salida;
    private String cedula_cliente;
    private int numero_acompaniantes;
    private Habitacion habitacion_asociada;
    private EstadoReserva estado_reserva;
    private double saldo_actual;
    private List<ConsumoServicio> consumos_servicio;

    public ReservaAlojamiento(Date fecha_entrada, Date fecha_salida, String cedula_cliente, int numero_acompaniantes,
            Habitacion habitacion_asociada, EstadoReserva estado_reserva, double saldo_actual) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.cedula_cliente = cedula_cliente;
        this.numero_acompaniantes = numero_acompaniantes;
        this.habitacion_asociada = habitacion_asociada;
        this.estado_reserva = estado_reserva;
        this.saldo_actual = saldo_actual;
    }

    public ReservaAlojamiento() {;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public int getNumero_acompaniantes() {
        return numero_acompaniantes;
    }

    public void setNumero_acompaniantes(int numero_acompaniantes) {
        this.numero_acompaniantes = numero_acompaniantes;
    }

    public Habitacion getHabitacion_asociada() {
        return habitacion_asociada;
    }

    public void setHabitacion_asociada(Habitacion habitacion_asociada) {
        this.habitacion_asociada = habitacion_asociada;
    }

    public EstadoReserva getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(EstadoReserva estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public List<ConsumoServicio> getConsumos_servicio() {
        return consumos_servicio;
    }

    public void setConsumos_servicio(List<ConsumoServicio> consumos_servicio) {
        this.consumos_servicio = consumos_servicio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha_entrada == null) ? 0 : fecha_entrada.hashCode());
        result = prime * result + ((fecha_salida == null) ? 0 : fecha_salida.hashCode());
        result = prime * result + ((cedula_cliente == null) ? 0 : cedula_cliente.hashCode());
        result = prime * result + numero_acompaniantes;
        result = prime * result + ((habitacion_asociada == null) ? 0 : habitacion_asociada.hashCode());
        result = prime * result + ((estado_reserva == null) ? 0 : estado_reserva.hashCode());
        long temp;
        temp = Double.doubleToLongBits(saldo_actual);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((consumos_servicio == null) ? 0 : consumos_servicio.hashCode());
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
        ReservaAlojamiento other = (ReservaAlojamiento) obj;
        if (fecha_entrada == null) {
            if (other.fecha_entrada != null)
                return false;
        } else if (!fecha_entrada.equals(other.fecha_entrada))
            return false;
        if (fecha_salida == null) {
            if (other.fecha_salida != null)
                return false;
        } else if (!fecha_salida.equals(other.fecha_salida))
            return false;
        if (cedula_cliente == null) {
            if (other.cedula_cliente != null)
                return false;
        } else if (!cedula_cliente.equals(other.cedula_cliente))
            return false;
        if (numero_acompaniantes != other.numero_acompaniantes)
            return false;
        if (habitacion_asociada == null) {
            if (other.habitacion_asociada != null)
                return false;
        } else if (!habitacion_asociada.equals(other.habitacion_asociada))
            return false;
        if (estado_reserva != other.estado_reserva)
            return false;
        if (Double.doubleToLongBits(saldo_actual) != Double.doubleToLongBits(other.saldo_actual))
            return false;
        if (consumos_servicio == null) {
            if (other.consumos_servicio != null)
                return false;
        } else if (!consumos_servicio.equals(other.consumos_servicio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ReservaAlojamiento [fecha_entrada=" + fecha_entrada + ", fecha_salida=" + fecha_salida
                + ", cedula_cliente=" + cedula_cliente + ", numero_acompaniantes=" + numero_acompaniantes
                + ", habitacion_asociada=" + habitacion_asociada + ", estado_reserva=" + estado_reserva
                + ", saldo_actual=" + saldo_actual + ", consumos_servicio=" + consumos_servicio + "]";
    }

    
    
}
