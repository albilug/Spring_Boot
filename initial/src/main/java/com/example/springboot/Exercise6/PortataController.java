package com.example.springboot.Exercise6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PortataController {
    private PortataService portataService;
    @Autowired
    public PortataController(PortataService portataService) {
        this.portataService = portataService;
    }

    private List<Portata> listaPortate = new ArrayList<>(Arrays.asList(
            new Portata("Bistecca", "Bella bisteccona", 14.50, 700, false),
            new Portata("Pasta", "Pasta al pomodoro", 9.50, 1200, false),
            new Portata("Carciofi al vapore", "Carciofi... ma cotti al vaporre",  4.00, 300, true)

    ));

    @GetMapping("/meals")
    public ResponseEntity<List<Portata>> menu() {
        return ResponseEntity.ok(listaPortate);
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<?> mealByName(@PathVariable("name") String name) {
        for (Portata m : listaPortate) {
            if (m.getName().equals(name)) {
                return ResponseEntity.ok(m);
            }
        }
        return ResponseEntity.badRequest().body("No such meal at present");
    }

    @GetMapping("meal/description-match/{description}")
    public ResponseEntity<?> mealByDescription(@PathVariable("description") String description) {
        List<Portata> returnList = new ArrayList<>();
        for (Portata m : listaPortate) {
            if (m.getDescription().contains(description)) {
                returnList.add(m);
            }
        }
        if (returnList.isEmpty()) {
            return ResponseEntity.badRequest().body("No portata matches the description");
        }
        else return ResponseEntity.ok(returnList);
    }

    @GetMapping("meal/price")
    public ResponseEntity<?> mealByPriceRange(
            @RequestParam("minimum") double min,
            @RequestParam("maximum") double max) {
        List<Portata> returnList = new ArrayList<>();
        for (Portata m : listaPortate) {
            if (m.getPrice() >= min && m.getPrice() <= max) {
                returnList.add(m);
            }
        }
        if (returnList.isEmpty()) {
            return ResponseEntity.badRequest().body("No portata in the price range");
        }
        else return ResponseEntity.ok(returnList);
    }


    @PostMapping(value = "post/meal")
    public ResponseEntity<?> postMeal(@RequestBody Portata portata) {
        listaPortate.add(portata);
        return ResponseEntity.ok("Meal inserted!");
    }

    @PutMapping("put/meal/{name}")
    public ResponseEntity<?> putMeal(@PathVariable("name") String name, @RequestBody Portata portata) {
        listaPortate.removeIf(m -> m.getName().equals(name));
        listaPortate.add(portata);
        return ResponseEntity.ok("Meal updated!");
    }

    @DeleteMapping("delete/meal/{name}")
    public ResponseEntity<?> deleteMeal(@PathVariable("name") String name) {
        listaPortate.removeIf(m -> m.getName().equals(name));
        return ResponseEntity.ok("Meal deleted!");
    }

    @DeleteMapping("delete/meal/price/{price}")
    public ResponseEntity<?> deleteAbovePrice(@PathVariable("price") double price) {
        listaPortate.removeIf(m -> m.getPrice()>price);
        return ResponseEntity.ok("Meals above "+price+"€ have been deleted");
    }

    @PutMapping("put/meal/{name}/price")
    public ResponseEntity<?> updateMealPrice(@PathVariable("name") String name, @RequestParam("price") double price) {
        for (Portata m : listaPortate) {
            if (m.getName().equals(name)) {
                m.setPrice(price);
            }
        }
        return ResponseEntity.ok("Prezzo of "+name+" aggiornato! Ora costa €"+price+"!");
    }

    @GetMapping (value = "/api/portata/portata1")
    public ResponseEntity<List<Portata>> test1() {
        return ResponseEntity.ok(portataService.portata1());
    }
    @GetMapping (value = "/api/portata/portata2")
    public ResponseEntity<List<Portata>> test2() {
        return ResponseEntity.ok(portataService.portata2());
    }
    @GetMapping (value = "/api/portata/portata3")
    public ResponseEntity<List<Portata>> test3() {
        return ResponseEntity.ok(portataService.portata3());
    }
    @GetMapping (value = "/api/portata/portata4")
    public ResponseEntity<List<Portata>> test4() {
        return ResponseEntity.ok(portataService.portata4());
    }
    @GetMapping (value = "/api/portata/portata5")
    public ResponseEntity<List<Portata>> test5() {
        return ResponseEntity.ok(portataService.portata5());
    }
    @GetMapping (value = "/api/portata/portata6")
    public ResponseEntity<List<Portata>> test6() {
        return ResponseEntity.ok(portataService.portata6());
    }

    // solo per test miei
    @GetMapping (value = "/api/portate")
    public ResponseEntity<List<Portata>> getTutti() {
        return ResponseEntity.ok(portataService.getPortate());
    }

    @GetMapping (value = "/api/winter-portate")
    public List<Portata> getWinterPortate() {
        return portataService.getWinterPortate();
    }
}
