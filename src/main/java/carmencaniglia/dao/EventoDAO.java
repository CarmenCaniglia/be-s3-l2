package carmencaniglia.dao;

import carmencaniglia.entities.Evento;

import javax.persistence.EntityManager;

public class EventoDAO {

    private final EntityManager em;
    public EventoDAO(EntityManager em){
        this.em = em;
    }
    public void save(Evento evento){

    }

    public Evento findbyId(long id){}

    public void findByIdAndDelete(long id){}
}
