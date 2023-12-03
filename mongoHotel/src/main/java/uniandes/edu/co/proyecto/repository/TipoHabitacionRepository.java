package uniandes.edu.co.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.internal.operation.AggregateOperation;

import uniandes.edu.co.proyecto.model.TipoHabitacion;

import org.springframework.data.mongodb.core.MongoTemplate;



@Repository
public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, String> {

}
