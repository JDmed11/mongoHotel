package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.ReservaAlojamiento;
import uniandes.edu.co.proyecto.model.enumeraciones.EstadoReserva;
import uniandes.edu.co.proyecto.repository.ReservaAlojamientoRepository;

@Controller
public class ReservaAlojamientoController {

    @Autowired
    private ReservaAlojamientoRepository reservaAlojamientoRepository;
    
    @GetMapping("/reservasAlojamiento")
    public String getAll(Model model){
        model.addAttribute("reservasAlojamiento", reservaAlojamientoRepository.findAll());
        return "ReservasAlojamiento/lista";
    }

    @GetMapping("/reservasAlojamiento/nuevo")
    public String create(Model model){
        model.addAttribute("reservaAlojamiento", new ReservaAlojamiento());
        return "ReservasAlojamiento/nuevo";
    }

    @PostMapping("/reservasAlojamiento/nuevo/guardar")
    public String save(ReservaAlojamiento reservaAlojamiento){
        reservaAlojamiento.setEstado_reserva(EstadoReserva.RESERVADA);
        reservaAlojamiento.setSaldo_actual(0);
        reservaAlojamientoRepository.save(reservaAlojamiento);
        return "redirect:/reservasAlojamiento";
    }

    @GetMapping("/reservasAlojamiento/eliminar/{id}")
    public String delete(@PathVariable("id") String id){
        reservaAlojamientoRepository.deleteById(id);
        return "redirect:/reservasAlojamiento";
       
    }
}
