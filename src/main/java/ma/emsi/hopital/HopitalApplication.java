package ma.emsi.hopital;

import ma.emsi.hopital.Service.IHospitalService;
import ma.emsi.hopital.entities.*;
import ma.emsi.hopital.repositories.ConsultationRepository;
import ma.emsi.hopital.repositories.MedecinRepository;
import ma.emsi.hopital.repositories.PatientRepository;
import ma.emsi.hopital.repositories.RendezvousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,
                            RendezvousRepository rendezvousRepository,MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Mohammed","Hassan","Najat").forEach(name->{
                Patient patient=new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });
            Stream.of("ayman","Hanane","Yassmine").forEach(name->{
                Medecin medecin=new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(medecin);
        });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohammed");

            Medecin medecin=medecinRepository.findByNom("yasmine");
            Rendezvous rendezvous=new Rendezvous();
            rendezvous.setDate(new Date());
            rendezvous.setStatus(StatusRDV.PENDING);
            rendezvous.setMedecin(medecin);
            rendezvous.setPatient(patient);
             Rendezvous saveDRDV= hospitalService.saveRDV(rendezvous);
             System.out.println(saveDRDV.getId());

            Rendezvous rendezvous1=rendezvousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezvous(rendezvous1);
            consultation.setRapport("Rapport de la consulattion");
            hospitalService.saveconsultation(consultation);
    };

}}
