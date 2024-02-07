package samuelesimeone.eserciziod3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import samuelesimeone.eserciziod3.entities.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BeansTest {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(esercizioD3Application.class);
    private Menu menu = ctx.getBean(Menu.class);

    @Test
    public void checkCoperto(){
        double coperto = (double) ctx.getBean("Coperto");
        assertEquals(1.5, coperto);
    }

    @Test
    public void checkSumOrder(){
        ArrayList<Alimenti> elementi = new ArrayList<>();
        Tavoli tavolo = (Tavoli) ctx.getBean("Tavolo1");
        tavolo.setStato(Stato.OCCUPATO);
        elementi.add((Alimenti) ctx.getBean("Margherita"));
        elementi.add((Alimenti) ctx.getBean("Margherita"));
        elementi.add((Alimenti) ctx.getBean("PannaProsciutto"));
        elementi.add((Alimenti) ctx.getBean("Acqua"));
        Ordini ordine1 = new Ordini(tavolo, elementi,1, StatoO.IN_CORSO, 3, LocalDate.now(),(double)ctx.getBean("Coperto"));
        // tolta riga 33 crea errore
        ordine1.setTotale(ordine1.takePrice(elementi));
        double conto = ordine1.getTotale();
        assertEquals(14.3, conto);
    }

    @Test
    public void checkElementMenu(){
        List<Alimenti> elements = new ArrayList<>();
        elements.addAll(menu.getPizzes());
        elements.addAll(menu.getAggiuntes());
        elements.addAll(menu.getBevandes());
        assertEquals(8, elements.size());
    }

    @Test
    public void isPizzaXL(){
        Pizze margherita = (Pizze) ctx.getBean("Margherita");
        Pizze PannaProsciutto = (Pizze) ctx.getBean("PannaProsciutto");
        margherita.setXL(true);
        assertAll(
                () -> assertFalse(PannaProsciutto.isXL()),
                () -> assertTrue(margherita.isXL())
        );

    }

    @ParameterizedTest
    @CsvSource({"Margherita, 2", "Panna e Prosciutto, 1"})
    public void checkIsOnOrder(String pizza, int expectedResult){
        ArrayList<Alimenti> elementi = new ArrayList<>();
        Tavoli tavolo = (Tavoli) ctx.getBean("Tavolo1");
        tavolo.setStato(Stato.OCCUPATO);
        elementi.add((Alimenti) ctx.getBean("Margherita"));
        elementi.add((Alimenti) ctx.getBean("Margherita"));
        elementi.add((Alimenti) ctx.getBean("PannaProsciutto"));
        elementi.add((Alimenti) ctx.getBean("Acqua"));
        Ordini ordine1 = new Ordini(tavolo, elementi,1, StatoO.IN_CORSO, 3, LocalDate.now(),(double)ctx.getBean("Coperto"));
        List<Alimenti> list = ordine1.getElementi().stream().filter(prodotto -> prodotto.getNome().equals(pizza)).toList();
        assertEquals(expectedResult, list.size());
    }
}
