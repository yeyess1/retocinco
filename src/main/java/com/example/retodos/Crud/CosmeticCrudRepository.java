package com.example.retodos.Crud;
import com.example.retodos.Model.Cosmetic;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author YeiverS
 */

public interface CosmeticCrudRepository  extends MongoRepository<Cosmetic, String> {

}

