package org.example.touristguideapi.controller;

import org.example.touristguideapi.model.TouristAttraction;
import org.example.touristguideapi.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // GET - Hent alle turistattraktioner
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> attractions = touristService.getTouristAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    // GET - Hent en turistattraktion ved navn
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST - Tilføj en ny turistattraktion
    @PostMapping("/add")
    public ResponseEntity<Void> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // POST - Opdater en eksisterende turistattraktion
    @PostMapping("/update")
    public ResponseEntity<Void> updateAttraction(@RequestParam String name, @RequestBody TouristAttraction updatedAttraction) {
        touristService.updateTouristAttraction(name, updatedAttraction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE - Slet en turistattraktion ved navn
    @PostMapping("/delete/{name}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable String name) {
        touristService.deleteTouristAttraction(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
