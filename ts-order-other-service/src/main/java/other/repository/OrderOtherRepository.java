package other.repository;

import other.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Repository
public interface OrderOtherRepository extends MongoRepository<Order, String> {

    @Query("{ 'id': ?0 }")
    Order findById(UUID id);

    ArrayList<Order> findAll();

    @Query("{ 'accountId' : ?0 }")
    ArrayList<Order> findByAccountId(UUID accountId);

    @Query("{ 'trainNumber' : ?0}")
    ArrayList<Order> findByTrainNumber(String trainNumber);

    @Query("{ 'travelDate' : ?0 , trainNumber : ?1 }")
    ArrayList<Order> findByTravelDateAndTrainNumber(Date travelDate, String trainNumber);

    void deleteById(UUID id);
}
