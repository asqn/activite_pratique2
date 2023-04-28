package ma.emsi.hopital.repositories;

import ma.emsi.hopital.entities.Patient;
import ma.emsi.hopital.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<Rendezvous,String> {
}
