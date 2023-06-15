package com.example.springboot.Exercise2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// BUONGIORNISSIMO CAFFÈ
@RestController
public class portataController {
	private List<Portata> listaCibo = Arrays.asList(
			new Portata("Pollo", "Pollo....", 20),
			new Portata("Carote", "Carote... ma allo spiedo", 5),
			new Portata("Zebra in brodo", "Zebra con brodino", 4),
			new Portata("Funghi", "Porcini ottimi", 10),
			new Portata("Mele e pere", "Macedonia", 15),
			new Portata("Porchetta", "Oink oink", 88),
			new Portata("Riso sushi", "Salmone con anisakis", 23)
	);

	private List<Portata> soupOfTheDay = Arrays.asList(
			new Portata("Ossa di piccione in brodino", "Pollo....", 20),
			new Portata("Pollo in brodo", "Pollo ancora... ma allo spiedo", 4),
			new Portata("Pollo in brodo", "Brodo.. con pollo", 4),
			new Portata("Coscia in brodo", "Coscia... di pollo", 10),
			new Portata("Pollo arrosto in brodo", "Finalmente un buon pollo", 15),
			new Portata("Pollo con brodo fungo", "Porcini con pollo", 88),
			new Portata("Pollo in brodo", "Apelle figlio di A-Pollo...", 4)
	);

	@GetMapping("/get/day-dependent-portata/")
	public ResponseEntity<?> getChefsSpecial(
			@RequestParam("dayOfTheWeekIndex") int dayOfTheWeekIndex,
			@RequestParam("isSoupOfTheDay") boolean isSoupOfTheDay) {
		if (dayOfTheWeekIndex < 0 || dayOfTheWeekIndex > 6 ){
			return ResponseEntity.badRequest().body("Brutta richiesta");
		}
		if (isSoupOfTheDay) {return ResponseEntity.ok(soupOfTheDay.get (dayOfTheWeekIndex));}
		else {return ResponseEntity.ok(listaCibo.get(dayOfTheWeekIndex));}
	}

	@GetMapping("/list/{listIndex}")
	public ResponseEntity<Portata> portatasList(
			@PathVariable("listIndex") int listIndex) {
		return ResponseEntity.ok(listaCibo.get(listIndex));
	}

	@GetMapping("/portata/{name}")
	public ResponseEntity<?> portataName(
			@PathVariable("name") String name) {
		for (Portata portata : listaCibo) {
			if (portata.getName().equals(name)) {
				return ResponseEntity.ok(portata);
			}
		}
		return ResponseEntity.badRequest().body("Non c'è!");
	}

	@GetMapping("/portata/description-match/{phrase}")
	public Portata portataDesc(@PathVariable("phrase") String descrizione) {
		for (Portata portata : listaCibo){
			if (portata.getDescription().equalsIgnoreCase(descrizione)){return portata;}
		}
		return null;
	}

	@GetMapping("/portata/price")
	public ResponseEntity<List<Portata>> portataPriceRange(
			@RequestParam("min") double min,
			@RequestParam("max") double max){
		List<Portata> portatasGiusti = new ArrayList<>();
		for(Portata portata: listaCibo){
			if(portata.getPrice()>=min && portata.getPrice()<=max){
				portatasGiusti.add(portata);}
		}
		if(!portatasGiusti.isEmpty()){return ResponseEntity.ok(portatasGiusti);}
		else{return ResponseEntity.notFound().build();}
	}
}
