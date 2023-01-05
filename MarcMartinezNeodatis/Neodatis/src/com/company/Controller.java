package com.company;

import Utilities.Utilities;
import models.TipusContingut;
import models.Youtuber;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private ArrayList<Youtuber> youtubers = new ArrayList<>();

    public void afegirYoutuber() {
        int any, mes, dia;
        LocalDate dataNaixement;

        any = Utilities.llegirInt("Escriu l'any de naixement del Youtuber", 1950, LocalDate.now().getYear());
        mes = Utilities.llegirInt("Escriu el mes de naixement del Youtuber", 1, 12);
        dia = Utilities.llegirInt("Escriu el dia de naixement del Youtuber", 1, 31);


        youtubers.add(new Youtuber(Utilities.llegirParaula("Escriu el nikcname")
                , Utilities.llegirParaula("Escriu el país d'origen")
                , TipusContingut.valueOf(Utilities.llegirParaula("Escriu el tipus de contingut GAMER, HUMOR, CIÈNCIA"))
        ));

        NeodatisDB db = new NeodatisDB("youtubers");
        db.inserirObjecte(youtubers.get(youtubers.size() - 1));
        db.mostrarObjectes(youtubers.get(youtubers.size()-1));
        db.shutDown();
    }

    public void deleteYoutube() {
        int i = 0;
        NeodatisDB db = new NeodatisDB("youtubers");
        db.mostrarObjectes(Youtuber.class);
        String checker = Utilities.llegirParaula("Digues el nom de la persona a esborrar");
        db.eliminarObjectes(checker);
        db.shutDown();
        }

    public void updateYoutuber() {
        int i = 0;
        NeodatisDB db = new NeodatisDB("youtubers");
        String youtuber = Utilities.llegirParaula("Escolleix quin youtuber vols actualitzar");
        db.updateYoutuber(youtuber);
        db.shutDown();
        }
        public void printarYoutubers(){
            NeodatisDB db = new NeodatisDB("youtubers");
            Youtuber y = new Youtuber("checker","españa",TipusContingut.valueOf(("HUMOR")));
            db.mostrarObjectes(y);
            db.shutDown();
        }
    }
