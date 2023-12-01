package uniandes.edu.co.proyecto.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.model.ServicioHotel;

public interface ServicioHotelRepository extends MongoRepository<ServicioHotel, ObjectId>{
    
}
