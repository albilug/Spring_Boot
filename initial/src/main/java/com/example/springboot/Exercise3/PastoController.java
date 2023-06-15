package com.example.springboot.Exercise3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PastoController {
    private List<Pasto> pasti = new ArrayList<>(Arrays.asList(
            new Pasto("Carotone", "Carote con burro", 10.00),
            new Pasto("Pandispagna", "Solo pane... ma dalla spagna", 5.00),
            new Pasto("Grilli fritti", "CRI CRI CRI", 3.00))
    );

    @GetMapping(value = "/get/pasto")
    public ResponseEntity<List<Pasto>> getPasto() {
        return ResponseEntity.ok(pasti);
    }

    @PostMapping(value = "/pasto")
    public ResponseEntity<String> postPasto(
            @RequestBody Pasto pasto
    ) {
        this.pasti.add(pasto);
        return ResponseEntity.ok("Pasto Added!");
    }

    @PutMapping(value = "/pasto/{name}")
    public ResponseEntity<String> putPasto(
            @PathVariable("name") String name,
            @RequestBody Pasto pasto
    ) {
        this.pasti.removeIf(m -> m.getName().equals(m.getName()));
        this.pasti.add(pasto);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping(value = "/pasto/{name}")
    public ResponseEntity<String> deletePasto(
            @PathVariable("name") String name
    ) {
        this.pasti.removeIf(m -> m.getName().equals(name));
        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping(value = "/pasto/price/{price}")
    public ResponseEntity<String> deletePasto2(
            @PathVariable("price") double price
    ) {
        this.pasti.removeIf(m -> m.getPrice() > price);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping(value = "/pasto/{name}/price")
    public ResponseEntity<String> putPasto2(
            @PathVariable("name") String name,
            @RequestBody Double updatedPrice
    ) {
        Pasto pasto = this.pasti.stream().filter(m -> m.getName().equals(name)).toList().get(0);
        this.pasti.removeIf(m -> m.getName().equals(name));
        pasto.setPrice(updatedPrice);
        this.pasti.add(pasto);
        return ResponseEntity.ok("Prezzo Aggiornato");
    }
}
