package floristeria.view;

import floristeria.application.FloreriaController;
import floristeria.domain.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static FloreriaController controller = new FloreriaController();

    public static void main(String[] args) throws Exception {

        controller.createFloristeria("Lirios");

        controller.createArbre(20,30);
        controller.createFlors(20,"blue");

        controller.createArbre(20,30);
        controller.createFlors(20,"blue");

        controller.createDecoracio(20, "FUSTA");
        controller.createDecoracio(20, "FUSTA");


        String missatge = "1:[Afegir producte]  2:[Eliminar producte]  3:[Veure Stock]  0:[Sortir]";

        System.out.println(missatge);
        String userOption = JOptionPane.showInputDialog(missatge);

        while (!userOption.equals("0")) {

            switch (userOption) {

                case "1": // Afegir
                    afegir();

                    userOption = JOptionPane.showInputDialog(missatge);
                    break;

                case "2": //Eliminar
                    eliminar();

                    userOption = JOptionPane.showInputDialog(missatge);
                    break;

                case "3": //Veure stock
                    System.out.println(controller.getAllProducte());

                    userOption = JOptionPane.showInputDialog(missatge);
                    break;

                default:
                    System.out.println("Error, torna a introduir 1,2,3  o 0");

                    userOption = JOptionPane.showInputDialog(missatge);
                    break;
            }
        }
    }

    private static void eliminar() throws Exception {
        Object[] possibleValues = { "Arbre", "Flors", "Decoracio" };
        Object userOption = JOptionPane.showInputDialog(null, "Que vols eliminar?", "ELIMINAR",
                JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);

        List<Producte> productes = new ArrayList<>();
        int idProductToDelete = 0;

        switch (userOption.toString()){
            case "Arbre":
                productes = controller.getArbres();
                iterarArrayList(productes);
                idProductToDelete = Integer.parseInt(JOptionPane.showInputDialog("Introdueix id del producte per a eliminar:"));
                controller.deleteProducte(idProductToDelete);
                break;
            case "Flors":
                productes = controller.getFlors();
                iterarArrayList(productes);
                idProductToDelete = Integer.parseInt(JOptionPane.showInputDialog("Introdueix id del producte per a eliminar:"));
                controller.deleteProducte(idProductToDelete);
                break;
            case "Decoracio":
                productes = controller.getDecoracions();
                iterarArrayList(productes);
                idProductToDelete = Integer.parseInt(JOptionPane.showInputDialog("Introdueix id del producte per a eliminar:"));
                controller.deleteProducte(idProductToDelete);
                break;
            default:
                System.out.println("Error");
        }
    }

    private static void afegir() throws Exception {

        Object[] possibleValues = { "Arbre", "Flors", "Decoracio" };
        Object userOption = JOptionPane.showInputDialog(null, "Que vols afegir?", "AFEGIR",
                JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);


        if ("Arbre".equals(userOption)) {

            int preu = Integer.parseInt(JOptionPane.showInputDialog("Introdueix preu:"));
            int altura = Integer.parseInt(JOptionPane.showInputDialog("Introdueix l'altura:"));

            controller.createArbre(preu, altura);


        } else if ("Flors".equals(userOption)) {

            int preu = Integer.parseInt(JOptionPane.showInputDialog("Introdueix preu:"));
            String color = (JOptionPane.showInputDialog("Introdueix color:"));

            controller.createFlors(preu,color);

        } else if ("Decoracio".equals(userOption)) {

            int preu = Integer.parseInt(JOptionPane.showInputDialog("Introdueix preu:"));
            Object[] OpcioMaterial = { "FUSTA", "PLASTIC"};
            Object material = JOptionPane.showInputDialog(null, "Quin material?", "AFEGIR",
                    JOptionPane.INFORMATION_MESSAGE, null, OpcioMaterial, OpcioMaterial[0]);

            controller.createDecoracio(preu, (String) material);

        } else {
            System.out.println("Error");
        }
    }

    public static void iterarArrayList(List<Producte> productes){
        Iterator it = productes.iterator();
        System.out.println("******** Llistat actual, trii el ID a esborrar **********");
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
