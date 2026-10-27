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
@RequestMapping("string")

public class StringController {
	private final ArrayList<String> lista = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","y","z"));

	@GetMapping("all")
	public ArrayList<String> returnList() {
		return lista;
	}
	
	@GetMapping("{index}")
	public String returnElementList(@PathVariable("index") Integer index) {
        String indexEl = lista.get(index);
		return indexEl;
	}
	@PostMapping("/add")
	public String addElement(@RequestParam("strEl") String strEl) {
		lista.add(strEl);
		return strEl;
	}
	@PutMapping("{index}")
	public String changeRandomELement(@PathVariable("index") Integer index, @RequestParam("strEl") String strEl) {
		if(lista.isEmpty()) return "";
			lista.set(index, strEl);
			return strEl;	
	}
	@DeleteMapping("all")
	public void deleteList() {
		lista.removeAll(lista);
	}
	
	@DeleteMapping("{index}")
		public String deleteElement(@PathVariable("index") Integer index) {
        String strEl = lista.get(index);
		lista.remove(strEl );
		return strEl;
	}
}
