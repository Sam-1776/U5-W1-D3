package samuelesimeone.eserciziod3.entities;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Ordini {
    private Tavoli tavolo;
    private List<Alimenti> elementi;
    private int numero;
    private StatoO stato;
    private int coperti;
    private LocalDate acquisizione;
    private double totale;

    public Ordini(Tavoli tavolo, List<Alimenti> elementi, int numero, StatoO stato, int coperti, LocalDate acquisizione, double totale) {
        this.tavolo = tavolo;
        this.elementi = elementi;
        this.numero = numero;
        this.stato = stato;
        this.coperti = coperti;
        this.acquisizione = acquisizione;
        this.totale = totale;
    }

    public double takePrice(List<Alimenti> x){
        this.totale += x.stream().mapToDouble(Alimenti::getPrezzo).sum();
       return this.totale;
    }


    public void print(){
        System.out.println("Ordini{" +
                "tavolo=" + tavolo +
                "\n, elementi=" + elementi +
                "\n, numero=" + numero +
                "\n, stato=" + stato +
                "\n, coperti=" + coperti +
                "\n, acquisizione=" + acquisizione +
                "\n, totale=" + totale +
                '}');
    }
}
