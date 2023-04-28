package ma.emsi.hopital.Service;

import ma.emsi.hopital.entities.Consultation;
import ma.emsi.hopital.entities.Medecin;
import ma.emsi.hopital.entities.Patient;
import ma.emsi.hopital.entities.Rendezvous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Rendezvous saveRDV(Rendezvous rendezvous);
    Consultation saveconsultation(Consultation consultation);
}
