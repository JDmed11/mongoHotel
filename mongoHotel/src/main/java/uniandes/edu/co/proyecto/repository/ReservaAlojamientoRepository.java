package uniandes.edu.co.proyecto.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.model.ReservaAlojamiento;

public interface ReservaAlojamientoRepository extends MongoRepository<ReservaAlojamiento, ObjectId>{
    
}
