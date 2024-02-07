package samuelesimeone.eserciziod3.entities;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Aggiunte extends Alimenti{
    public Aggiunte(String nome, long cal, double prezzo) {
        super(nome, cal, prezzo);
    }

    public String toString() {
        return "Aggiunte{" +
                "nome= " + getNome() +
                " cal= " + getCal() +
                " prezzo= " + getPrezzo() +
                '}';
    }
}
