package it.objectmethod.demo.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.objectmethod.demo.springboot.Entity.Subscribed;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribed, Long>{

}
