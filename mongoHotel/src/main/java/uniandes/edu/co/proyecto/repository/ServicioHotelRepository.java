package uniandes.edu.co.proyecto.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.model.ServicioHotel;

@Repository
public interface ServicioHotelRepository extends MongoRepository<ServicioHotel, String>{
    
}
