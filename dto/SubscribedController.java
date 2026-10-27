package it.objectmethod.demo.springboot.dto;

import it.objectmethod.demo.springboot.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("subscribe")

public class SubscribedController {
		@Autowired
		SubscribeService subscribeService;
		
		@GetMapping("all")
		public List<SubscribeDTO> returnAllSubscribe() {
			return subscribeService.getAll();
		}
		
		@GetMapping("{index}")
		public SubscribeDTO returnOneSubscribe(@PathVariable("index") Long index) {
			return subscribeService.getOne(index);
		}

		@PostMapping("create")
		public SubscribeDTO addSubscribe(@RequestBody SubscribeDTO subscribe) {
			return subscribeService.addElement(subscribe);
		}

		@PutMapping("change")
		public void changeELement(@RequestBody SubscribeDTO subscribe) {
			subscribeService.changeElements(subscribe, subscribe.getId());
		}

		@DeleteMapping("{index}")
		public void deleteElement(@PathVariable("index") Long index) {
			subscribeService.deleteElement(index);
		}
}
