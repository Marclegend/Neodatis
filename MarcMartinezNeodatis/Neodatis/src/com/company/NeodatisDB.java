package com.company;

import Utilities.Utilities;
import models.Youtuber;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class NeodatisDB {
    private ODB odb = null;

    public NeodatisDB(String rutaDB){
        try {
            this.odb = ODBFactory.open(rutaDB + ".neodatis");
            System.out.println("Connexió oberta amb la BD " + rutaDB + ".neodatis");
        }catch(Exception e){
            System.out.println("ERROR: " + e);

            if (this.odb != null){
                odb.close();
            }
        }
    }

    public boolean inserirObjecte(Object o){
        try {
            odb.store(o);
        }catch(Exception e){
            System.out.println("ERROR: " + e);
            return false;
        }
        return true;
    }
    public void eliminarObjectes(String nom){
        IQuery query = new CriteriaQuery(Youtuber.class, Where.equal("nickname", nom));
        Youtuber youtu=(Youtuber) odb.getObjects(query).getFirst();
        odb.delete(youtu);
        System.out.println("Esborrat!");
    }
    public  void mostrarObjectes(Object o){
        Class c = o.getClass();
        Objects<Object> objectes = odb.getObjects(c);
        while(objectes.hasNext()){
            System.out.println(objectes.next());
        }
    }
    public void updateYoutuber(String nom){
        IQuery query = new CriteriaQuery(Youtuber.class, Where.equal("nickname", nom));
        Youtuber youtuber=(Youtuber) odb.getObjects(query).getFirst();
        String nomacambiar = Utilities.llegirParaula("Digues el nom que li vols possar");
        youtuber.setNickname(nomacambiar);
        odb.store(youtuber);
    }
    public void shutDown(){
        odb.close();
    }
}
