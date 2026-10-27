package it.objectmethod.demo.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("number")

public class NumberController {
	private final ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));

	@GetMapping("all")
	public ArrayList<Integer> returnList() {
		return lista;
	}
	
	@GetMapping("{index}")
	public Integer returnElementList(@PathVariable("index") Integer index) {
        Integer elementoCasuale = lista.get(index);
		return elementoCasuale;
	}
	@PostMapping("/add")
	public Integer addElement(@RequestParam("numEl") Integer numEl) {
		lista.add(numEl);
		return numEl;
	}
	@PutMapping("{index}")
	public Integer changeELement(@PathVariable("index") Integer index, @RequestParam("numEl") Integer numEl) {
		if(lista.isEmpty()) return 0;
			lista.set(index, numEl);
			return numEl;	
	}
	@DeleteMapping("all")
	public void deleteList() {
		lista.removeAll(lista);
	}
	
	@DeleteMapping("{index}")
		public Number deleteElement(@PathVariable("index") Integer index) {
        Integer numElement = lista.get(index);
		lista.remove(numElement);
		return numElement;
	}
}
