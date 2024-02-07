package samuelesimeone.eserciziod3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import samuelesimeone.eserciziod3.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;


@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private Menu menu;


    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(esercizioD3Application.class);

        menu.print();
        ArrayList<Alimenti> elementi = new ArrayList<>();
        Tavoli tavolo = (Tavoli) ctx.getBean("Tavolo1");
        tavolo.setStato(Stato.OCCUPATO);
        elementi.add((Alimenti) ctx.getBean("Margherita"));
        elementi.add((Alimenti) ctx.getBean("Margherita"));
        elementi.add((Alimenti) ctx.getBean("PannaProsciutto"));
        elementi.add((Alimenti) ctx.getBean("Acqua"));
        Ordini ordine1 = new Ordini(tavolo, elementi,1, StatoO.IN_CORSO, 3, LocalDate.now(),(double)ctx.getBean("Coperto"));
        ordine1.setStato(StatoO.SERVITO);
        ordine1.setTotale(ordine1.takePrice(elementi));
        ordine1.print();

        ctx.close();
    }
}
