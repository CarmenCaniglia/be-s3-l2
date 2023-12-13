package carmencaniglia.dao;

import carmencaniglia.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em){
        this.em = em;
    }

    public void save (Persona persona){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();

        System.out.println(persona.getNome() + " " + persona.getCognome() + " aggiunto!");
    }

    public Persona findById(long id){
        return em.find(Persona.class, id);
    }

    public void findByIdAndDelete (long id){
        Persona found = this.findById(id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Persona" + found.getNome() + " "+ found.getCognome()+" eliminata!");

        } else {
            System.out.println("Persona non trovata!");
    }}
}
