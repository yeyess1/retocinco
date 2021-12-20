package com.example.retodos.Crud;
import com.example.retodos.Model.Cosmetic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *
 * @author YeiverS
 */

public interface CosmeticCrudRepository  extends MongoRepository<Cosmetic, String> {
    public List<Cosmetic> findByPrice(double price);
    public List<Cosmetic> findByDescriptionContainingIgnoreCase(String description);
}

