package uniandes.edu.co.proyecto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.TipoHabitacion;

@Repository
public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, String> {

}
