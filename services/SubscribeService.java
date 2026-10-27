package it.objectmethod.demo.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.objectmethod.demo.springboot.Entity.Subscribed;
import it.objectmethod.demo.springboot.Repository.SubscribeRepository;
import it.objectmethod.demo.springboot.dto.SubscribeDTO;

@Service
public class SubscribeService {
	private final SubscribeRepository subscribeRepository;

	public SubscribeService(SubscribeRepository subscribeRepository) {
		this.subscribeRepository = subscribeRepository;
	}
	
	private SubscribeDTO toDto(Subscribed s) {
		SubscribeDTO dto = new SubscribeDTO();
		dto.setName(s.getName());
		dto.setSurname(s.getSurname());
		dto.setBirthDate(s.getBirthDate());
		dto.setFiscalCode(s.getFiscalCode());
		return dto;
	}
	
	  private Subscribed toEntity(SubscribeDTO dto) {
		    Subscribed s = new Subscribed();
		    s.setName(dto.getName());
		    s.setSurname(dto.getSurname());
		    s.setFiscalCode(dto.getFiscalCode());
		    s.setBirthDate(dto.getBirthDate());
		    return s;
		  }


	public List<SubscribeDTO> getAll() {
		return subscribeRepository.findAll().stream().map(this::toDto).toList();
	}
	
	public SubscribeDTO getOne(Long index) {
		Subscribed s = subscribeRepository.findById(index).orElseThrow(() -> new RuntimeException("subscribe non trovato"));
		subscribeRepository.save(s);
		return toDto(s);
	}
	
	public SubscribeDTO addElement(SubscribeDTO subscribe) {
		Subscribed s = toEntity(subscribe);
		subscribeRepository.save(s);
		return subscribe;
	}

	public void changeElements(SubscribeDTO subscribe, Long index) {
		Subscribed s = subscribeRepository.findById(index) .orElseThrow(() -> new RuntimeException("Subscribe non trovato"));
		s.setName(subscribe.getName());
		s.setSurname(subscribe.getSurname());
		s.setFiscalCode(subscribe.getFiscalCode());
		s.setBirthDate(subscribe.getBirthDate());
		subscribeRepository.save(s);
		
	}


	public void deleteElement(Long index) {
		subscribeRepository.deleteById(index);	
	}
}
