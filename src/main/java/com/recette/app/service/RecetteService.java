package com.recette.app.service;

import com.recette.app.entity.Recette;
import com.recette.app.exception.errors.CustomException;
import com.recette.app.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteService {

    @Autowired
    RecetteRepository recetteRepo;

    public Recette addRecette(Recette recette) {
        return recetteRepo.save(recette);
    }

    public List<Recette> getAllRecettes() {
        return recetteRepo.findAll();
    }

    public Recette getRecetteById(Long id) {
        return recetteRepo.findById(id)
                .orElseThrow(() -> new CustomException("Recette non trouvée avec l' pour etre mise a jour : " + id));
    }

    public Recette updateRecette(Recette recette) {
        if (recetteRepo.existsById(recette.getId())) {
            return recetteRepo.save(recette);
        } else {
            throw new CustomException("Recette non trouvée avec l'ID : " + recette.getId());
        }
    }

    public void deleteRecette(Long id) {
        recetteRepo.deleteById(id);
    }
}