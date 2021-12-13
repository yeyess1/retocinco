package com.example.retodos.Services;


import java.util.List;
import java.util.Optional;

import com.example.retodos.Model.Cosmetic;
import com.example.retodos.Repository.CosmeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CosmeticService {
    @Autowired
    private CosmeticRepository cosmeticCrudRepository;

    public List<Cosmetic> getAll(){
        return cosmeticCrudRepository.getAll();
    }

    public Optional<Cosmetic> getClothe(String reference){
        return cosmeticCrudRepository.getClothe(reference);
    }

    public Cosmetic save(Cosmetic accesory) {
        if (accesory.getReference() == null){
            return accesory;
        }else{
            return cosmeticCrudRepository.save(accesory);
        }
    }

    public Cosmetic update (Cosmetic accesory){
        if (accesory.getReference() != null){
            Optional<Cosmetic> accesoryDb = cosmeticCrudRepository.getClothe(accesory.getReference());

            if (!accesoryDb.isEmpty()){

                if (accesory.getBrand() != null){
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null){
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getName() != null){
                    accesoryDb.get().setName(accesory.getName());
                }

                if (accesory.getDescription() != null){
                    accesoryDb.get().setDescription(accesory.getDescription());
                }

                if (accesory.getPrice() != 0.0){
                    accesoryDb.get().setPrice(accesory.getPrice());
                }

                if (accesory.getQuantity() != 0){
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }

                if (accesory.getPhotography() != null){
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                cosmeticCrudRepository.update(accesoryDb.get());
                return accesoryDb.get();
            }else{
                return accesory;
            }
        }else{
            return accesory;
        }
    }

    public boolean delete(String reference){
        Boolean aBoolean = getClothe(reference).map(accesory ->{
            cosmeticCrudRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

