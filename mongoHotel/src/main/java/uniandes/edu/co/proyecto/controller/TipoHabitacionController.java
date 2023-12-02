package uniandes.edu.co.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
}
