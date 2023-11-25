package com.recette.app.controller;

import com.recette.app.entity.Recette;
import com.recette.app.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @PostMapping
    public ResponseEntity<Recette> addRecette(@RequestBody Recette recette) {
        Recette newRecette = recetteService.addRecette(recette);
        return new ResponseEntity<>(newRecette, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Recette>> getAllRecettes() {
        List<Recette> recettes = recetteService.getAllRecettes();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recette> getRecetteById(@PathVariable Long id) {
        Recette recette = recetteService.getRecetteById(id);
        return new ResponseEntity<>(recette, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recette> updateRecette(@PathVariable Long id, @RequestBody Recette recette) {
        recette.setId(id);
        Recette updatedRecette = recetteService.updateRecette(recette);
        return new ResponseEntity<>(updatedRecette, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable Long id) {
        recetteService.deleteRecette(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
