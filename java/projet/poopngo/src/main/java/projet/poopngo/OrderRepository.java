package projet.poopngo;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<Ordersss, Long> {
    @Query(value = "SELECT * FROM ORDERSSS WHERE HOST = :id",nativeQuery = true) 
    List<Ordersss> findByidH(@Param("id") String id);
    @Query(value = "SELECT * FROM ORDERSSS WHERE CLIENT = :id",nativeQuery = true) 
    List<Ordersss> findByidC(@Param("id") String id);
   
}