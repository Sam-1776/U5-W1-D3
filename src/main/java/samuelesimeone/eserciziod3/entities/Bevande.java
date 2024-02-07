package samuelesimeone.eserciziod3.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bevande extends Alimenti{
    private double litri;

    public Bevande(String nome, long cal, double prezzo, double litri) {
        super(nome, cal, prezzo);
        this.litri = litri;
    }

    public String toString() {
        return "Bevande{" +
                "nome= " + getNome() +
                " litri= " + litri +
                " cal= " + getCal() +
                " prezzo= " + getPrezzo() +
                '}';
    }
}
