package com.company;

import Utilities.Utilities;

public class Main {
    public static void main(String[] args) {
        int flag = 0;
        Controller programa = new Controller();
        while (flag != 5) {
            System.out.println();
            flag = Utilities.llegirInt("Escolleix que vols fer: \n 1- Afegir Youtuber \n 2- Actualitzar youtuber \n 3- Esborrar youtuber \n 4- Mostrar els youtubers \n 5- Sortir",1,5);
            switch (flag){
                case 1:
                    programa.afegirYoutuber();
                    break;
                case 2:
                    programa.updateYoutuber();
                    break;
                case 3:
                    programa.deleteYoutube();
                    break;
                case 4:
                    programa.printarYoutubers();
                    break;
                case 5:
                    flag = 5;
                    System.out.println("Sortint del programa");
                    break;
            }
        }
    }
}
