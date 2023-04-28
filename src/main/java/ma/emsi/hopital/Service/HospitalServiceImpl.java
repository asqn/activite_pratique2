package ma.emsi.hopital.Service;

import jakarta.transaction.Transactional;
import ma.emsi.hopital.entities.Consultation;
import ma.emsi.hopital.entities.Medecin;
import ma.emsi.hopital.entities.Patient;
import ma.emsi.hopital.entities.Rendezvous;
import ma.emsi.hopital.repositories.ConsultationRepository;
import ma.emsi.hopital.repositories.MedecinRepository;
import ma.emsi.hopital.repositories.PatientRepository;
import ma.emsi.hopital.repositories.RendezvousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional

public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezvousRepository rendezvousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,ConsultationRepository consultationRepository,
                               MedecinRepository medecinRepository,RendezvousRepository rendezvousRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository=consultationRepository;
        this.rendezvousRepository=rendezvousRepository;
        this.medecinRepository=medecinRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Rendezvous saveRDV(Rendezvous rendezvous) {
        rendezvous.setId(UUID.randomUUID().toString());
        return rendezvousRepository.save(rendezvous);
    }

    @Override
    public Consultation saveconsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
