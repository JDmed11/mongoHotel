package uniandes.edu.co.proyecto.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.TipoHabitacion;
import uniandes.edu.co.proyecto.repository.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    /**
     * Devuelve la lista de tipos de habitacion
     * @param model modelo utilizado por la vista
     * @return lista de tipos de habitacion
     */
    @GetMapping("/tiposHabitacion")
    public String getAll(Model model) {
        model.addAttribute("tipos_habitacion", tipoHabitacionRepository.findAll());
        return "TiposHabitacion/lista";
    }

    /**
     * crea un nuevo tipo de habitacion
     * @param model modelo utilizado por la vista
     * @return formulario para crear un nuevo tipo de habitacion
     */
    @GetMapping("/tiposHabitacion/nuevo")
    public String create(Model model) {
        model.addAttribute("tipo_habitacion", new TipoHabitacion());
        return "TiposHabitacion/nuevo";
    }

    /**
     * Guarda un nuevo tipo de habitacion
     * @param tipoHabitacion tipo de habitacion a guardar
     * @return redireccion a la lista de tipos de habitacion
     */
    @PostMapping("/tiposHabitacion/nuevo/guardar")
    public String save(TipoHabitacion tipoHabitacion) {
        List<Habitacion> listaHabitacion = new ArrayList<Habitacion>();
        tipoHabitacion.setHabitaciones_asociadas(listaHabitacion);
        tipoHabitacionRepository.save(tipoHabitacion);
        return "redirect:/tiposHabitacion";
    }

    /**
     * Elimina un tipo de habitacion
     * @param id id del tipo de habitacion a eliminar
     * @return redireccion a la lista de tipos de habitacion
     */
    @GetMapping("/tiposHabitacion/eliminar/{id}")
    public String delete(@PathVariable("id") String id) {
        tipoHabitacionRepository.deleteById(id);
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/habitaciones/{id}")
    public String getHabitaciones(@PathVariable("id") String id, Model model) {
        model.addAttribute("tipo_habitacion", tipoHabitacionRepository.findById(id).get());
        model.addAttribute("habitaciones", tipoHabitacionRepository.findById(id).get().getHabitaciones_asociadas());
        model.getAttribute("habitaciones");
        return "TiposHabitacion/habitaciones";
    }

    @GetMapping("/tiposHabitacion/habitaciones/{id}/{numero_habitacion}/eliminar")
    public String deleteHabitacion(@PathVariable("id") String id, @PathVariable("numero_habitacion") int numero_habitacion) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findById(id).get();
        List<Habitacion> habitaciones = tipoHabitacion.getHabitaciones_asociadas();
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getNumero_habitacion() == numero_habitacion) {
                habitaciones.remove(i);
                break;
            }
        }
        tipoHabitacion.setHabitaciones_asociadas(habitaciones);
        tipoHabitacionRepository.save(tipoHabitacion);
        return "redirect:/tiposHabitacion/habitaciones/" + id;
    }

    @GetMapping("/tiposHabitacion/habitaciones/{id}/nuevo")
    public String createHabitacion(@PathVariable("id") String id, Model model) {
        model.addAttribute("tipo_habitacion", tipoHabitacionRepository.findById(id).get());
        model.addAttribute("habitacion", new Habitacion());
        return "TiposHabitacion/nuevaHabitacion";
    }

    @PostMapping("/tiposHabitacion/habitaciones/{id}/nuevo/guardar")
    public String saveHabitacion(@PathVariable("id") String id, Habitacion habitacion) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findById(id).get();
        List<Habitacion> habitaciones = tipoHabitacion.getHabitaciones_asociadas();
        habitaciones.add(habitacion);
        tipoHabitacion.setHabitaciones_asociadas(habitaciones);
        tipoHabitacionRepository.save(tipoHabitacion);
        return "redirect:/tiposHabitacion/habitaciones/" + id;
    }
}
