package uniandes.edu.co.proyecto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.model.Habitacion;

public interface HabitacionRepository extends MongoRepository<Habitacion, String>{
    
    
    
}
