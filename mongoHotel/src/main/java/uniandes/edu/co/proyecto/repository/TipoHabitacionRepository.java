package uniandes.edu.co.proyecto.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.TipoHabitacion;

@Repository
public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, Long> {

    @Query("{}")
    public List<TipoHabitacion> getAll();



    public <S> S insert(TipoHabitacion tipoHabitacion);
}
