package SistemaAcademicoUnitario;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Nota> notas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Ingrese un número válido.");
                opcion = -1;
            }
            switch (opcion) {
                case 1  -> registrarEstudiante();
                case 2  -> listarEstudiantes();
                case 3  -> buscarEstudiante();
                case 4  -> actualizarEstudiante();
                case 5  -> eliminarEstudiante();
                case 6  -> registrarAsignatura();
                case 7  -> listarAsignaturas();
                case 8  -> buscarAsignatura();
                case 9  -> actualizarAsignatura();
                case 10 -> eliminarAsignatura();
                case 11 -> registrarNota();
                case 12 -> listarNotas();
                case 13 -> buscarNota();
                case 14 -> actualizarNota();
                case 15 -> eliminarNota();
                case 0  -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("⚠ Opción inválida.");
            }
        } while (opcion != 0);
    }

    public static void registrarEstudiante() {
        System.out.println("\n═══════════════════════════════════");
        System.out.println("   REGISTRAR ESTUDIANTE");
        System.out.println("═══════════════════════════════════");

        System.out.print("Código    : ");
        String codigo = sc.nextLine().trim();

        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("⚠ Ya existe un estudiante con ese código.");
                return;
            }
        }

        System.out.print("Nombre    : ");
        String nombre = sc.nextLine().trim();

        System.out.print("Apellido  : ");
        String apellido = sc.nextLine().trim();

        System.out.print("Edad      : ");
        int edad = 0;
        try {
            edad = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠ Edad inválida. Se asigna 0.");
        }

        System.out.print("Semestre  : ");
        int semestre = 0;
        try {
            semestre = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠ Semestre inválido. Se asigna 0.");
        }

        Estudiante nuevo = new Estudiante(codigo, nombre, apellido, edad, semestre);
        estudiantes.add(nuevo);

        System.out.println("✔ Estudiante registrado exitosamente.");
        System.out.println(nuevo);
    }

    public static void mostrarMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       SISTEMA ACADÉMICO - UPC        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  ESTUDIANTES                         ║");
        System.out.println("║  1. Registrar estudiante             ║");
        System.out.println("║  2. Listar estudiantes               ║");
        System.out.println("║  3. Buscar estudiante                ║");
        System.out.println("║  4. Actualizar estudiante            ║");
        System.out.println("║  5. Eliminar estudiante              ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  ASIGNATURAS                         ║");
        System.out.println("║  6. Registrar asignatura             ║");
        System.out.println("║  7. Listar asignaturas               ║");
        System.out.println("║  8. Buscar asignatura                ║");
        System.out.println("║  9. Actualizar asignatura            ║");
        System.out.println("║  10. Eliminar asignatura             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  NOTAS                               ║");
        System.out.println("║  11. Registrar nota                  ║");
        System.out.println("║  12. Listar notas                    ║");
        System.out.println("║  13. Buscar nota                     ║");
        System.out.println("║  14. Actualizar nota                 ║");
        System.out.println("║  15. Eliminar nota                   ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  0. Salir                            ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }
public static void listarEstudiantes() {
    System.out.println("\n=== LISTADO DE ESTUDIANTES ===");

    if (estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes registrados.");
        return;
    }

    for (int i = 0; i < estudiantes.size(); i++) {
        System.out.println((i + 1) + ". " + estudiantes.get(i));
    }
    System.out.println("Total: " + estudiantes.size() + " estudiante(s).");
}

public static void buscarEstudiante() {
    System.out.println("\n=== BUSCAR ESTUDIANTE ===");
    System.out.print("Ingrese el codigo del estudiante: ");
    String codigo = sc.nextLine().trim();

    for (Estudiante e : estudiantes) {
        if (e.getCodigo().equalsIgnoreCase(codigo)) {
            System.out.println("Estudiante encontrado:");
            System.out.println(e);
            return;
        }
    }
    System.out.println("No se encontro ningun estudiante con el codigo: " + codigo);
}
}