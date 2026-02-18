import java.io.*;
import java.util.*;

public class Archivo {

    private String nombreArchivo = "SistemaPersonas/personas.txt";

    public ArrayList<Persona> cargar() {

        ArrayList<Persona> lista = new ArrayList<>();

        try {

            File archivo = new File(nombreArchivo);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {

                if (!linea.isEmpty()) {

                    String[] datos = linea.split(",");

                    Persona p = new Persona(
                            datos[0], datos[1], datos[2], datos[3],
                            datos[4], datos[5],
                            Integer.parseInt(datos[6]),
                            datos[7], datos[8], datos[9]
                    );

                    lista.add(p);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo.");
        }

        return lista;
    }

    public void guardar(ArrayList<Persona> lista) {

        try {

            FileWriter fw = new FileWriter(nombreArchivo);

            for (Persona p : lista) {
                fw.write(p.toArchivo());
                fw.write("\n");
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Error al guardar el archivo.");
        }
    }
}