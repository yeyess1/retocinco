package com.example.retodos.Controller;

import com.example.retodos.Model.Cosmetic;
import com.example.retodos.Services.CosmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class CosmeticController {
    @Autowired
    private CosmeticService cosmeticServices;

    @GetMapping("/all")
    public List<Cosmetic> getAll(){
        return cosmeticServices.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cosmetic> getClothe(@PathVariable("reference") String reference){
        return cosmeticServices.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetic save (@RequestBody Cosmetic gadget){
        return cosmeticServices.save(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetic update(@RequestBody Cosmetic gadget){
        return cosmeticServices.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return cosmeticServices.delete(reference);
    }
}

