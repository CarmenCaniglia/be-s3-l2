package carmencaniglia.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table (name = "partita_di_calcio")
@NamedQueries({
        @NamedQuery(name = "winHome", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa > p.numeroGolSquadraOspite"),
        @NamedQuery(name = "winAway", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa < p.numeroGolSquadraOspite"),
        @NamedQuery(name = "draw", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa = p.numeroGolSquadraOspite")
})

public class PartitaDiCalcio extends Evento{
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int nGolSquadraCasa;
    private int nGolSquadraOspite;

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Location location, int numPartecipanti, String squadraCasa, String squadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, location, numPartecipanti);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = null;
        this.nGolSquadraCasa = 0;
        this.nGolSquadraOspite = 0;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {

        if (this.nGolSquadraCasa > this.nGolSquadraOspite) {
            return this.squadraCasa + " won against " + this.squadraOspite + "  " + this.nGolSquadraCasa + " - " + this.nGolSquadraOspite;
        } else if (this.nGolSquadraCasa < this.nGolSquadraOspite) {
            return this.squadraOspite + " won against " + this.squadraCasa + "  " + this.nGolSquadraOspite + " - " + this.nGolSquadraCasa;
        } else {
            return this.squadraCasa + " draw with " + this.squadraOspite + "  " + this.nGolSquadraCasa + " - " + this.nGolSquadraOspite;
        }
    }

    public int getnGolSquadraCasa() {
        return nGolSquadraCasa;
    }

    public void setnGolSquadraCasa(int nGolSquadraCasa) {
        this.nGolSquadraCasa = nGolSquadraCasa;
        setVittoria();
    }

    public int getnGolSquadraOspite() {
        return nGolSquadraOspite;
    }

    public void setnGolSquadraOspite(int nGolSquadraOspite) {
        this.nGolSquadraOspite = nGolSquadraOspite;
        setVittoria();
    }

    private void setVittoria() {
        if (this.nGolSquadraCasa > this.nGolSquadraOspite) {
            this.squadraVincente = this.squadraCasa + " won " + this.nGolSquadraCasa + " - " + this.nGolSquadraOspite;
        } else if (this.nGolSquadraCasa < this.nGolSquadraOspite) {
            this.squadraVincente = this.squadraOspite + " won " + this.nGolSquadraOspite + " - " + this.nGolSquadraCasa;
        } else {
            this.squadraVincente = null;
        }
    }
}
