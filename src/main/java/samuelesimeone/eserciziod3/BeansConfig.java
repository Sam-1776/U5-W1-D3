package samuelesimeone.eserciziod3;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import samuelesimeone.eserciziod3.entities.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")

public class BeansConfig {

    @Bean(name = "Coperto")
    double getCoperto(@Value("${costoCoperto}") double coperto){
        return coperto;
    }

    @Bean
    Aggiunte getPomodoro(){
        return new Aggiunte("Sugo", 100,0.50);
    }

    @Bean
    Aggiunte getFormaggio(){
        return new Aggiunte("Formaggio", 200, 0.70);
    }

    @Bean
    Aggiunte getProsciutto(){
        return new Aggiunte("Prosciutto", 150, 1.00);
    }

    @Bean
    Aggiunte getPanna(){
        return new Aggiunte("Panna", 210, 1.20);
    }

    @Bean
    List<Aggiunte> getListaIngredientiMargherita(){
        ArrayList<Aggiunte> ingredienti = new ArrayList<>();
        ingredienti.add(getPomodoro());
        ingredienti.add(getFormaggio());
        return ingredienti;
    }

    @Bean
    List<Aggiunte> getIngredientiProscPanna(){
        ArrayList<Aggiunte> ingredienti = new ArrayList<>();
       ingredienti.addAll(getListaIngredientiMargherita());
        ingredienti.add(getPanna());
        ingredienti.add(getProsciutto());
        return ingredienti;
    }

    @Bean(name = "Margherita")
    Pizze getMargherita(){
    ArrayList<Aggiunte> ingredienti = new ArrayList<>();
    ingredienti.addAll(getListaIngredientiMargherita());
    long cal = 500 + ingredienti.stream().mapToLong(Alimenti::getCal).sum();
    double prezzo = 2.00 + ingredienti.stream().mapToDouble(Alimenti::getPrezzo).sum();
    return new Pizze("Margherita", cal, prezzo, ingredienti);
    }

    @Bean(name = "PannaProsciutto")
    Pizze getProsciuttoPanna(){
        ArrayList<Aggiunte> ingredienti = new ArrayList<>();
        ingredienti.addAll(getIngredientiProscPanna());
        long cal = 500 + ingredienti.stream().mapToLong(Alimenti::getCal).sum();
        double prezzo = 2.00 + ingredienti.stream().mapToDouble(Alimenti::getPrezzo).sum();
        return new Pizze("Panna e Prosciutto", cal, prezzo, ingredienti);
    }

    @Bean(name = "Cola")
    Bevande getCola(){
        return new Bevande("Coca-Cola", 150, 2.00, 0.6);
    }

    @Bean(name = "Acqua")
    Bevande getAcqua(){
        return new Bevande("Acqua", 0, 1.00, 1);
    }

    @Bean(name = "Tavolo1")
    Tavoli getTavolo1(){ return new Tavoli(1, 4 , Stato.LIBERO);}

    @Bean(name = "Tavolo2")
    Tavoli getTavolo2(){ return new Tavoli(2, 6, Stato.LIBERO);}

    @Bean(name = "Tavolo3")
    Tavoli getTavolo3(){ return new Tavoli(3, 2, Stato.LIBERO);}

    @Bean(name = "Tavolo4")
    Tavoli getTavolo4(){ return new Tavoli(4, 3, Stato.LIBERO);}

}
