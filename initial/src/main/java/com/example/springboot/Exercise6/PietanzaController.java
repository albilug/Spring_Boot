package com.example.springboot.Exercise6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PietanzaController {
    private PietanzaService pietanzaService;
    @Autowired
    public PietanzaController(PietanzaService pietanzaService) {
        this.pietanzaService = pietanzaService;
    }

    private List<Pietanza> listaPietanze = new ArrayList<>(Arrays.asList(
            new Pietanza("Bistecca", "Bella bisteccona", 14.50, 700, false),
            new Pietanza("Pasta", "Pasta al pomodoro", 9.50, 1200, false),
            new Pietanza("Carciofi al vapore", "Carciofi... ma cotti al vaporre",  4.00, 300, true)

    ));

    @GetMapping("/meals")
    public ResponseEntity<List<Pietanza>> menu() {
        return ResponseEntity.ok(listaPietanze);
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<?> mealByName(@PathVariable("name") String name) {
        for (Pietanza m : listaPietanze) {
            if (m.getName().equals(name)) {
                return ResponseEntity.ok(m);
            }
        }
        return ResponseEntity.badRequest().body("No such meal at present");
    }

    @GetMapping("meal/description-match/{description}")
    public ResponseEntity<?> mealByDescription(@PathVariable("description") String description) {
        List<Pietanza> returnList = new ArrayList<>();
        for (Pietanza m : listaPietanze) {
            if (m.getDescription().contains(description)) {
                returnList.add(m);
            }
        }
        if (returnList.isEmpty()) {
            return ResponseEntity.badRequest().body("No pietanza matches the description");
        }
        else return ResponseEntity.ok(returnList);
    }

    @GetMapping("meal/price")
    public ResponseEntity<?> mealByPriceRange(
            @RequestParam("minimum") double min,
            @RequestParam("maximum") double max) {
        List<Pietanza> returnList = new ArrayList<>();
        for (Pietanza m : listaPietanze) {
            if (m.getPrice() >= min && m.getPrice() <= max) {
                returnList.add(m);
            }
        }
        if (returnList.isEmpty()) {
            return ResponseEntity.badRequest().body("No pietanza in the price range");
        }
        else return ResponseEntity.ok(returnList);
    }


    @PostMapping(value = "post/meal")
    public ResponseEntity<?> postMeal(@RequestBody Pietanza pietanza) {
        listaPietanze.add(pietanza);
        return ResponseEntity.ok("Meal inserted!");
    }

    @PutMapping("put/meal/{name}")
    public ResponseEntity<?> putMeal(@PathVariable("name") String name, @RequestBody Pietanza pietanza) {
        listaPietanze.removeIf(m -> m.getName().equals(name));
        listaPietanze.add(pietanza);
        return ResponseEntity.ok("Meal updated!");
    }

    @DeleteMapping("delete/meal/{name}")
    public ResponseEntity<?> deleteMeal(@PathVariable("name") String name) {
        listaPietanze.removeIf(m -> m.getName().equals(name));
        return ResponseEntity.ok("Meal deleted!");
    }

    @DeleteMapping("delete/meal/price/{price}")
    public ResponseEntity<?> deleteAbovePrice(@PathVariable("price") double price) {
        listaPietanze.removeIf(m -> m.getPrice()>price);
        return ResponseEntity.ok("Meals above "+price+"€ have been deleted");
    }

    @PutMapping("put/meal/{name}/price")
    public ResponseEntity<?> updateMealPrice(@PathVariable("name") String name, @RequestParam("price") double price) {
        for (Pietanza m : listaPietanze) {
            if (m.getName().equals(name)) {
                m.setPrice(price);
            }
        }
        return ResponseEntity.ok("Prezzo of "+name+" aggiornato! Ora costa €"+price+"!");
    }

    @GetMapping (value = "/api/pietanza/pietanza1")
    public ResponseEntity<List<Pietanza>> pietanza1() {
        return ResponseEntity.ok(pietanzaService.pietanza1());
    }
    @GetMapping (value = "/api/pietanza/pietanza2")
    public ResponseEntity<List<Pietanza>> pietanza2() {
        return ResponseEntity.ok(pietanzaService.pietanza2());
    }
    @GetMapping (value = "/api/pietanza/pietanza3")
    public ResponseEntity<List<Pietanza>> pietanza3() {
        return ResponseEntity.ok(pietanzaService.pietanza3());
    }
    @GetMapping (value = "/api/pietanza/pietanza4")
    public ResponseEntity<List<Pietanza>> pietanza4() {
        return ResponseEntity.ok(pietanzaService.pietanza4());
    }
    @GetMapping (value = "/api/pietanza/pietanza5")
    public ResponseEntity<List<Pietanza>> pietanza5() {
        return ResponseEntity.ok(pietanzaService.pietanza5());
    }
    @GetMapping (value = "/api/pietanza/pietanza6")
    public ResponseEntity<List<Pietanza>> pietanza6() {
        return ResponseEntity.ok(pietanzaService.pietanza6());
    }

    @GetMapping (value = "/api/pietanze")
    public ResponseEntity<List<Pietanza>> getTutti() {
        return ResponseEntity.ok(pietanzaService.getPietanze());
    }

    @GetMapping (value = "/api/winter-pietanze")
    public List<Pietanza> getWinterPietanze() {
        return pietanzaService.getWinterPietanze();
    }
}
