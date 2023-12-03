package uniandes.edu.co.proyecto.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.model.ServicioHotel;
import uniandes.edu.co.proyecto.repository.ServicioHotelRepository;


@Controller
public class ServicioHotelController {
 
    @Autowired
    private ServicioHotelRepository servicioHotelRepository;

    /**
     * Devuelve la lista de servicios de hotel
     * @param model modelo utilizado por la vista
     * @return lista de servicios de hotel
     */
    @GetMapping("/serviciosHotel")
    public String getAll(Model model) {
        model.addAttribute("servicios_hotel", servicioHotelRepository.findAll());
        return "ServicioHotel/lista";
    }

    /**
     * crea un nuevo servicio de hotel
     * @param model modelo utilizado por la vista
     * @return formulario para crear un nuevo servicio de hotel
     */
    @GetMapping("/serviciosHotel/nuevo")
    public String create(Model model) {
        model.addAttribute("servicio_hotel", new ServicioHotel());
        return "ServicioHotel/nuevo";
    }

    /**
     * Guarda un nuevo servicio de hotel
     * @param servicioHotel servicio de hotel a guardar
     * @return redireccion a la lista de servicios de hotel
     */
    @PostMapping("/serviciosHotel/nuevo/guardar")
    public String save(ServicioHotel servicioHotel) {
        servicioHotelRepository.save(servicioHotel);
        return "redirect:/serviciosHotel";
    }

    /**
     * Elimina un servicio de hotel
     * @param id id del servicio de hotel a eliminar
     * @return redireccion a la lista de servicios de hotel
     */
  @GetMapping("/serviciosHotel/eliminar/{id}")
    public String delete(@PathVariable("id") String id) {
        servicioHotelRepository.deleteById(id);
        return "redirect:/serviciosHotel";
    }
    
    /**
     * Edita un servicio de hotel
     * @param id id del servicio de hotel a editar
     * @param model modelo utilizado por la vista
     * @return formulario para editar un servicio de hotel
     */
    @GetMapping("/serviciosHotel/editar/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("servicio_hotel", servicioHotelRepository.findById(id));
        return "ServicioHotel/editar";
    }
    
}
