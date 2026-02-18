import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Archivo archivo = new Archivo();
    static ArrayList<Persona> lista = archivo.cargar();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: adicionar(); break;
                case 2: modificar(); break;
                case 3: eliminar(); break;
                case 4: buscar(); break;
                case 5: listar(); break;
                case 6:
                    archivo.guardar(lista);
                    System.out.println("Datos guardados. Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);
    }

    // -------- MENU --------
    public static void mostrarMenu() {

        System.out.println("\n------ MENU ------");
        System.out.println("1. Adicion");
        System.out.println("2. Modificacion");
        System.out.println("3. Eliminacion");
        System.out.println("4. Busqueda");
        System.out.println("5. Listado");
        System.out.println("6. Salir");
        System.out.print("Opcion: ");
    }

    // -------- ADICION --------
    public static void adicionar() {

        System.out.print("Codigo: ");
        String codigo = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Sexo: ");
        String sexo = sc.nextLine();

        System.out.print("Tipo de Documento: ");
        String documento = sc.nextLine();

        System.out.print("Numero Documento: ");
        String numDoc = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Estado (Activo / No Activo): ");
        String activo = sc.nextLine();

        Persona p = new Persona(codigo, nombre, apellido, sexo,
                documento, numDoc, edad, ciudad, correo, activo);

        lista.add(p);

        System.out.println("Persona agregada correctamente.");
    }

    // -------- MODIFICACION --------
    public static void modificar() {

        System.out.print("Codigo a modificar: ");
        String codigo = sc.nextLine();

        for (Persona p : lista) {

            if (p.codigo.equals(codigo)) {

                System.out.println("Ingrese los nuevos datos:");

                System.out.print("Nombre: ");
                p.nombre = sc.nextLine();

                System.out.print("Apellido: ");
                p.apellido = sc.nextLine();

                System.out.print("Sexo: ");
                p.sexo = sc.nextLine();

                System.out.print("Tipo de Documento: ");
                p.documento = sc.nextLine();

                System.out.print("Numero Documento: ");
                p.numeroDocumento = sc.nextLine();

                System.out.print("Edad: ");
                p.edad = sc.nextInt();
                sc.nextLine();

                System.out.print("Ciudad: ");
                p.ciudad = sc.nextLine();

                System.out.print("Correo: ");
                p.correo = sc.nextLine();

                System.out.print("Estado (Activo / No Activo): ");
                p.activo = sc.nextLine();

                System.out.println("Persona modificada correctamente.");
                return;
            }
        }

        System.out.println("Codigo no encontrado.");
    }

    // -------- ELIMINACION --------
    public static void eliminar() {

        System.out.print("Codigo a eliminar: ");
        String codigo = sc.nextLine();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).codigo.equals(codigo)) {
                lista.remove(i);
                System.out.println("Persona eliminada.");
                return;
            }
        }

        System.out.println("Codigo no encontrado.");
    }

    // -------- BUSQUEDA --------
    public static void buscar() {

        System.out.print("Codigo a buscar: ");
        String codigo = sc.nextLine();

        for (Persona p : lista) {

            if (p.codigo.equals(codigo)) {

                System.out.println(
                        p.codigo + " - " +
                        p.nombre + " " + p.apellido + " - " +
                        p.sexo + " - " +
                        "Tipo Doc: " + p.documento + " - " +
                        p.numeroDocumento + " - " +
                        p.edad + " años - " +
                        p.ciudad + " - " +
                        p.correo + " - " +
                        "Estado: " + p.activo
                );
                return;
            }
        }

        System.out.println("Codigo no encontrado.");
    }

    // -------- LISTADO --------
    public static void listar() {

        if (lista.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }

        System.out.println("\n------ LISTADO COMPLETO ------");

        for (Persona p : lista) {

            System.out.println(
                    p.codigo + " - " +
                    p.nombre + " " + p.apellido + " - " +
                    p.sexo + " - " +
                    "Tipo Doc: " + p.documento + " - " +
                    p.numeroDocumento + " - " +
                    p.edad + " años - " +
                    p.ciudad + " - " +
                    p.correo + " - " +
                    "Estado: " + p.activo
            );
        }
    }
}