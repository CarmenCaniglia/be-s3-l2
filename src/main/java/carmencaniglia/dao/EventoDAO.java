package carmencaniglia.dao;

import carmencaniglia.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;
    public EventoDAO(EntityManager em){
        this.em = em;
    }
    public void save(Evento evento){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(evento);
    transaction.commit();

        System.out.println("evento "+evento.getTitolo() + " aggiunto!");
    }

    public Evento findbyId(long id){
        return em.find(Evento.class,id);
    }

    public void findByIdAndDelete(long id){
        Evento found = this.findbyId(id);
        if (found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);

            transaction.commit();
            System.out.println("Evento "+ found.getTitolo() + " eliminato");
        }else{
            System.out.println("Evento non trovato");
        }

    }
}
