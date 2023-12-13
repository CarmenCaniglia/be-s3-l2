package carmencaniglia;

import carmencaniglia.dao.EventoDAO;
import carmencaniglia.dao.LocationDAO;
import carmencaniglia.dao.PersonaDAO;
import carmencaniglia.entities.*;
import jdk.jfr.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-s3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();


        /* EventoDAO ed = new EventoDAO(em);

        Evento compleanno = new Evento("Compleanno", LocalDate.parse("2023-12-18"),"festa di compleanno", TipoEvento.PRIVATO,20);
        Evento rave = new Evento("rave",LocalDate.parse("2023-12-22"), "rave a tema", TipoEvento.PUBBLICO,100);


        ed.save(compleanno);
        ed.save(rave);

        Evento compleannofromDB = ed.findbyId(1);
        if (compleannofromDB != null){
            System.out.println(compleannofromDB);
        }else{
            System.out.println("Evento non trovato");
        }

        ed.findByIdAndDelete(2); */

        try {
            // nuova persona
            Persona persona = new Persona("Mario", "Rossi", "email@example.com", LocalDate.of(1990, 03, 21), Sesso.M);
            PersonaDAO personaDAO = new PersonaDAO(em);
            personaDAO.save(persona);

            // nuova location
            Location location = new Location("Papete", "Milano");
            LocationDAO locationDAO = new LocationDAO(em);
            locationDAO.save(location);

            // nuovo evento
            Evento evento = new Evento("Serata Papete", LocalDate.of(2023, 12, 31), "Unisciti a noi per l'ultimo dell'anno", TipoEvento.PRIVATO, 100);
            evento.setLocation(location); // location per l'evento
            EventoDAO eventoDAO = new EventoDAO(em);
            eventoDAO.save(evento);

            // partecipazione all'evento
            eventoDAO.addPartecipazione(persona, evento, StatoPartecipazione.CONFERMATA);

            // ricerca di evento per ID
            Evento eventoRisultato = eventoDAO.findbyId(evento.getId());
            if (eventoRisultato != null) {
                System.out.println("Evento trovato: " + eventoRisultato.getTitolo());
            } else {
                System.out.println("Evento non trovato.");
            }
        }finally {

        em.close();
        emf.close();
        }

    }
}
