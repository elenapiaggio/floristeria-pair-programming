package floristeria.view;

import floristeria.application.FloreriaController;
import floristeria.domain.Arbre;
import floristeria.domain.Decoracio;
import floristeria.domain.Floristeria;
import floristeria.domain.Flors;

public class Main {

<<<<<<< HEAD
=======
    private static FloreriaController controller = new FloreriaController();

    public static void main(String[] args) throws Exception{

        Arbre arbre = new Arbre(20, 30);
        Flors flor = new Flors(20, 30);
        Decoracio decoracio = new Decoracio(10, 60);

        controller.createArbre(arbre);
        controller.createFlors(flor);
        controller.createDecoracio(decoracio);

        controller.getAllProducte();

    }


>>>>>>> 4d2e6e2ee151ba09a3b3cf4f141dabc65abea1b2
}
