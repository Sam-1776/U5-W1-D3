package samuelesimeone.eserciziod3.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Pizze extends Alimenti{
    private List<Aggiunte> ingredienti;
    private boolean XL;

    public Pizze(String nome, long cal, double prezzo, List<Aggiunte> ingredienti) {
        super(nome, cal, prezzo);
        this.ingredienti = ingredienti;
        this.XL = false;
    }

    @Override
    public String toString() {
        return "Pizze{" +
                "nome= " + getNome() +
                " ingredienti= " + ingredienti +
                " cal= " + getCal() +
                " prezzo= " + getPrezzo() +
                '}';
    }
}
