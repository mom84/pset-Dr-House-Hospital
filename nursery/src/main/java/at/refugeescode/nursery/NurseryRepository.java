package at.refugeescode.nursery;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseryRepository extends MongoRepository<Patient,String> {
}
