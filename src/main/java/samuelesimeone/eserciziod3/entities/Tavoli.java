package samuelesimeone.eserciziod3.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tavoli {
    private int numero;
    private int coperti_max;
    private Stato stato;

    public Tavoli(int numero, int coperti_max, Stato stato) {
        this.numero = numero;
        this.coperti_max = coperti_max;
        this.stato = stato;
    }
}
