package U9.PerSiDeCas;

import java.io.*;
import java.util.Arrays;

public class Ficheros {
    public static void main(String[] args) {
        Integer [] numerosAleatorios = new Integer[10];
        String fichero = "numerosOrdenados.bin";

        // agregar números aleatorios
        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = (int) (Math.random() * 100 );
        }

        // ordenar
        Arrays.sort(numerosAleatorios);

        // guardar en archivo
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))){
            out.writeObject(numerosAleatorios);
        } catch ( FileNotFoundException fileNotFoundException) {
            System.out.println("Fichero no encontrado " + fileNotFoundException.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // resetear la tabla
        numerosAleatorios = new Integer[10];

        // leer
        try (ObjectInputStream in = new ObjectInputStream( new FileInputStream(fichero))){
            numerosAleatorios = (Integer[]) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero" + e.getMessage());
        }  catch (ClassNotFoundException e) {
            System.out.println("El objeto no pertenece a la clase Integer");
        }   catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer n : numerosAleatorios
        ) {
            System.out.println(n);
        }
    }
}
