package uniandes.edu.co.proyecto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.model.ReservaAlojamiento;

public interface ReservaAlojamientoRepository extends MongoRepository<ReservaAlojamiento, String>{
    
}
