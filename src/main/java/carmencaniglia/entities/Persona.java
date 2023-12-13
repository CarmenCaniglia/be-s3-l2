package carmencaniglia.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate compleanno;
    private Sesso sesso;
    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> partecipazioni = new ArrayList<>();

    public void aggiungiPartecipazione(Partecipazione partecipazione) {
        partecipazioni.add(partecipazione);
        partecipazione.setPersona(this);
    }

    public Persona(){}
    public Persona(String nome, String cognome, String email, LocalDate compleanno, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.compleanno = compleanno;
        this.sesso = sesso;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCompleanno() {
        return compleanno;
    }

    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }


}
