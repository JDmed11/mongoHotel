package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.ConsumoServicio;
import uniandes.edu.co.proyecto.model.ReservaAlojamiento;
import uniandes.edu.co.proyecto.model.enumeraciones.EstadoReserva;
import uniandes.edu.co.proyecto.repository.ReservaAlojamientoRepository;

@Controller
public class ReservaAlojamientoController {

    @Autowired
    private ReservaAlojamientoRepository reservaAlojamientoRepository;
    
    /**
     * Metodo que retorna la lista de reservas de alojamiento
     * @param model Modelo utilizado por Thymeleaf
     * @return La vista de la lista de reservas de alojamiento
     */
    @GetMapping("/reservasAlojamiento")
    public String getAll(Model model){
        model.addAttribute("reservasAlojamiento", reservaAlojamientoRepository.findAll());
        return "ReservasAlojamiento/lista";
    }

    /**
     * Metodo que retorna la vista de crear una reserva de alojamiento
     * @param model Modelo utilizado por Thymeleaf
     * @return La vista de crear una reserva de alojamiento
     */
    @GetMapping("/reservasAlojamiento/nuevo")
    public String create(Model model){
        model.addAttribute("reservaAlojamiento", new ReservaAlojamiento());
        return "ReservasAlojamiento/nuevo";
    }

    /**
     * Metodo que guarda una reserva de alojamiento
     * @param reservaAlojamiento La reserva de alojamiento a guardar
     * @return La vista de la lista de reservas de alojamiento
     */
    @PostMapping("/reservasAlojamiento/nuevo/guardar")
    public String save(ReservaAlojamiento reservaAlojamiento){
        reservaAlojamiento.setEstado_reserva(EstadoReserva.RESERVADA);
        reservaAlojamiento.setSaldo_actual(0);
        reservaAlojamiento.setConsumos_servicio(new ArrayList<ConsumoServicio>());
        reservaAlojamientoRepository.save(reservaAlojamiento);
        return "redirect:/reservasAlojamiento";
    }

    /**
     * Metodo que retorna la vista de editar una reserva de alojamiento
     * @param id El id de la reserva de alojamiento a editar
     * @param model Modelo utilizado por Thymeleaf
     * @return La vista de editar una reserva de alojamiento
     */
    @GetMapping("/reservasAlojamiento/editar/{id}")
    public String edit(@PathVariable("id") String id, Model model){
        model.addAttribute("reserva", reservaAlojamientoRepository.findById(id).get());
        return "ReservasAlojamiento/editar";
    }

    /**
     * Metodo que guarda una reserva de alojamiento editada
     * @param id El id de la reserva de alojamiento a editar
     * @param reservaAlojamiento La reserva de alojamiento a guardar
     * @return La vista de la lista de reservas de alojamiento
     */
    @PostMapping("/reservasAlojamiento/editar/{id}/guardar")
    public String saveEdit(@PathVariable("id") String id, ReservaAlojamiento reservaAlojamiento){
        reservaAlojamientoRepository.save(reservaAlojamiento);
        return "redirect:/reservasAlojamiento";
    }

    /**
     * Metodo que retorna la vista de eliminar una reserva de alojamiento
     * @param id El id de la reserva de alojamiento a eliminar
     * @param model Modelo utilizado por Thymeleaf
     * @return La vista de eliminar una reserva de alojamiento
     */
    @GetMapping("/reservasAlojamiento/eliminar/{id}")
    public String delete(@PathVariable("id") String id){
        reservaAlojamientoRepository.deleteById(id);
        return "redirect:/reservasAlojamiento";
    }
}
