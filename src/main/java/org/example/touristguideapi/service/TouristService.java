package org.example.touristguideapi.service;

import org.example.touristguideapi.model.TouristAttraction;
import org.example.touristguideapi.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    @Autowired //hvad er det helt præcis? - måske fjernes
    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }

    //CRUD-metoder
    //GET alle turistattraktioner
    public List<TouristAttraction> getTouristAttractions() {
        return touristRepository.getTouristAttractions();
    }

    //GET en turtistattraktion ved navn
         public TouristAttraction getTouristAttractionByName(String name) {
             return touristRepository.getTouristAttractionByName(name);
         }


    //POST - tilføj en ny turistattraktion
    public void addAttraction(TouristAttraction attraction) {
        touristRepository.addAttraction(attraction);
    }

    //POST - opdater en eksisterende turistattraktion
    public void updateTouristAttraction(String name, TouristAttraction updatedAttraction) {
        touristRepository.updateTouristAttraction(name, updatedAttraction);
    }

    //POST - slette
    public void deleteTouristAttraction(String name){
        touristRepository.deleteTouristAttraction(name);
    }

}
