package uniandes.edu.co.proyecto.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.model.ConsumoServicio;

public interface ConsumoServicioRepository extends MongoRepository<ConsumoServicio, ObjectId>{
    
}
