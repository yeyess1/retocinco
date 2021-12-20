package com.example.retodos.Repository;
import java.util.List;
import java.util.Optional;

import com.example.retodos.Crud.CosmeticCrudRepository;
import com.example.retodos.Model.Cosmetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YeiverS
 */
@Repository
public class CosmeticRepository {
    @Autowired
    private CosmeticCrudRepository cosmeticCrudRepository;

    public List<Cosmetic> getAll(){
        return cosmeticCrudRepository.findAll();
    }

    public Optional<Cosmetic> getClothe(String reference){
        return cosmeticCrudRepository.findById(reference);
    }

    public Cosmetic save(Cosmetic clothe){
        return cosmeticCrudRepository.save(clothe);
    }

    public void update(Cosmetic clothe){
        cosmeticCrudRepository.save(clothe);
    }

    public void delete(Cosmetic clothe){
        cosmeticCrudRepository.delete(clothe);
    }
    public List<Cosmetic> getByPrice(double price){
        return cosmeticCrudRepository.findByPrice(price);
    }

    public List<Cosmetic> getByDescriptionContains(String description){
        return cosmeticCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}

