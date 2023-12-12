package carmencaniglia;

import carmencaniglia.dao.EventoDAO;
import carmencaniglia.entities.Evento;
import carmencaniglia.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-s3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        Evento compleanno = new Evento("Compleanno", LocalDate.parse("2023-12-18"),"festa di compleanno", TipoEvento.PRIVATO,20);

        ed.save(compleanno);


        em.close();
        emf.close();
    }
}
