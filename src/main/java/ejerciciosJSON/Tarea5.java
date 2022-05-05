/**
 * Se desea Se desea generar una cadena en formato json que contenga
 * la alineación de la selección española que ganó el mundial de Fútbol.
 *
 * Se tiene por tanto, que implementar una clase Futbolista, que contenga un entero para el dorsal,
 * un String para el nombre y una lista de dermacaciones posibles en las que puede jugar.
 * También se tendrá un atributo (un String) para el equipo del que procede.
 * @autor ISABEL PASTOR LÓPEZ
 * @version 1.0
 */
package ejerciciosJSON;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Tarea5 {
    public static void main(String[] args) {
        Futbolista f1 = new Futbolista(1, "Casillas", "Real Madrid");
        Futbolista f2 = new Futbolista(15, "Ramos", "Real Madrid");
        Futbolista f3 = new Futbolista(3, "Pique", "Real Madrid");
        Futbolista f4 = new Futbolista(5, "Puyol", "FC Barcelona");
        Futbolista f5 = new Futbolista(11, "Capdevila", "VillaReal");
        Futbolista f6 = new Futbolista(14, "Xavi Alonso", "Real Madrid");
        Futbolista f7 = new Futbolista(16, "Busquets", "FC Barcelona");
        Futbolista f8 = new Futbolista(8, "Xavi Hernández", "FC Barcelona");
        Futbolista f9 = new Futbolista(18, "Pedrito", "FC Barcelona");
        Futbolista f10 = new Futbolista(6, "Iniesta", "FC Barcelona");
        Futbolista f11 = new Futbolista(7, "Villa Maravilla", "Valencia CF");

        ArrayList<Futbolista> futbolistas =  new ArrayList<>();
        futbolistas.add(f1);
        futbolistas.add(f2);
        futbolistas.add(f3);
        futbolistas.add(f4);
        futbolistas.add(f5);
        futbolistas.add(f6);
        futbolistas.add(f7);
        futbolistas.add(f8);
        futbolistas.add(f9);
        futbolistas.add(f10);
        futbolistas.add(f11);

        Gson gson = new Gson();
        String cadenaJSON = gson.toJson(futbolistas);
        System.out.println(cadenaJSON);


        Demarcacion demarcacion1 = new Demarcacion("Portero");
        Demarcacion demarcacion2 = new Demarcacion("Lateral derecho");
        Demarcacion demarcacion3 = new Demarcacion("Central");
        Demarcacion demarcacion4 = new Demarcacion("Lateral izquierdo");
        Demarcacion demarcacion5 = new Demarcacion("Defensa mediocampo");
        Demarcacion demarcacion6 = new Demarcacion("Mediocampo");
        Demarcacion demarcacion7 = new Demarcacion("Falso extremo");
        Demarcacion demarcacion8 = new Demarcacion("Extremo izquierdo");
        Demarcacion demarcacion9 = new Demarcacion("Extremo derecho");
        Demarcacion demarcacion10 = new Demarcacion("Delantero centro");
        Demarcacion demarcacion11 = new Demarcacion("Mediocentro");

        ArrayList<Demarcacion> demarcaciones = new ArrayList<>();
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion1);
        f1.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion2);
        demarcaciones.add(demarcacion11);
        f2.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion3);
        f3.setDemarcaciones(demarcaciones);
        f4.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion4);
        f5.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion5);
        f7.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion6);
        f6.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion6);
        f8.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion9);
        f10.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion7);
        demarcaciones.add(demarcacion8);
        f9.setDemarcaciones(demarcaciones);
        demarcaciones = new ArrayList<>();
        demarcaciones.add(demarcacion10);
        f11.setDemarcaciones(demarcaciones);


        cadenaJSON = gson.toJson(futbolistas);
        System.out.println("-----con demarcaciones------");
        System.out.println(cadenaJSON);

        // demarcacion Sergio Ramos
        cadenaJSON = gson.toJson(f2.getDemarcaciones());
        System.out.println("-----Demarcacion Sergio Ramos------");
        System.out.println(cadenaJSON);

    }

}
