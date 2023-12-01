package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.TipoHabitacion;

@Repository
public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, ObjectId> {

    @Query("{}")
    public List<TipoHabitacion> getAll();

}
