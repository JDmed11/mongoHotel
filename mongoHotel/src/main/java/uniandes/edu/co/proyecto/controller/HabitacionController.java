package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.repository.HabitacionRepository;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;
    
}
