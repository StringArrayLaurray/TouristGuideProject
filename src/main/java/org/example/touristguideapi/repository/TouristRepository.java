package org.example.touristguideapi.repository;

import org.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    //ArrayList til at opbevare TouristAttraction-objekter
    private List<TouristAttraction> touristAttractions = new ArrayList<>();

    //Konstruktør til at initialisere og tilføje
    public TouristRepository() {
        TouristAttraction attraction1 = new TouristAttraction("Tivoli", "Forlystelsespark midt i København centrum");
        TouristAttraction attraction2 = new TouristAttraction("Den Lille Havfrue", "Statue ved Langelinie");
        TouristAttraction attraction3 = new TouristAttraction("Amalienborg", "Hovedresidens for det danske Kongehus");

        touristAttractions.add(attraction1);
        touristAttractions.add(attraction2);
        touristAttractions.add(attraction3);
    }

    //GET - Metode til at hente alle turistattraktioner
    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }


    //GET - Metode til at finde turistattraktion ved navn
    /*Denne metode søger gennem en liste over turistattraktioner (touristAttractions) for at finde en attraktion, hvis navn matcher den angivne name-parameter (uanset store/små bogstaver).
     Hvis den finder en matchende attraktion, returnerer den denne. Hvis ingen match findes, returnerer den null.*/
    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    //POST - Metode til at tilføje en ny turistattraktion
    public void addAttraction(TouristAttraction attraction) {
        touristAttractions.add(attraction);
    }

    //POST - metode til at opdatere turistattraktionen
    /*Metoden updateTouristAttraction søger efter en turistattraktion i en liste, der har et navn, der matcher det navn, der er givet som parameter.
    Hvis en matchende attraktion findes, erstatter metoden denne attraktion med det opdaterede TouristAttraction-objekt.
    Hvis der ikke findes en match, sker der ingenting, og metoden afsluttes.*/
    public void updateTouristAttraction(String name, TouristAttraction updatedAttraction){
        for(int i = 0; i < touristAttractions.size(); i++){
            if (touristAttractions.get(i).getName().equalsIgnoreCase(name)) {
                touristAttractions.set(i, updatedAttraction);
                return;
            }
        }
    }

    //POST - Slette
    public void deleteTouristAttraction(String name){
        touristAttractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }
}

