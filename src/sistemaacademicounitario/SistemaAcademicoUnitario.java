package sistemaacademicounitario;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademicoUnitario {

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Nota> notas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // aquí va el menú, no los métodos
    }

    public static void registrarNota() {
        System.out.println("\n=== REGISTRAR NOTA ===");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }
        System.out.print("Codigo del estudiante: ");
        String codigoEstudiante = sc.nextLine().trim();
        Estudiante estudiante = null;
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigoEstudiante)) {
                estudiante = e;
                break;
            }
        }
        if (estudiante == null) {
            System.out.println("No se encontro ningun estudiante con ese codigo.");
            return;
        }
        System.out.print("Codigo de la asignatura: ");
        String codigoAsignatura = sc.nextLine().trim();
        Asignatura asignatura = null;
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigoAsignatura)) {
                asignatura = a;
                break;
            }
        }
        if (asignatura == null) {
            System.out.println("No se encontro ninguna asignatura con ese codigo.");
            return;
        }
        System.out.print("Valor de la nota: ");
        double valor = 0;
        try {
            valor = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido. Se asigna 0.");
        }
        System.out.print("Periodo: ");
        String periodo = sc.nextLine().trim();
        Nota nueva = new Nota(estudiante, asignatura, valor, periodo);
        notas.add(nueva);
        System.out.println("Nota registrada exitosamente.");
        System.out.println(nueva);
    }
public static void listarNotas() {
    System.out.println("\n=== LISTADO DE NOTAS ===");

    if (notas.isEmpty()) {
        System.out.println("No hay notas registradas.");
        return;
    }

    for (int i = 0; i < notas.size(); i++) {
        System.out.println((i + 1) + ". " + notas.get(i));
    }
    System.out.println("Total: " + notas.size() + " nota(s).");
}
public static void buscarNota() {
    System.out.println("\n=== BUSCAR NOTA ===");
    System.out.print("Ingrese el codigo del estudiante: ");
    String codigo = sc.nextLine().trim();

    boolean encontrada = false;
    for (Nota n : notas) {
        if (n.getEstudiante().getCodigo().equalsIgnoreCase(codigo)) {
            System.out.println(n);
            encontrada = true;
        }
    }

    if (!encontrada) {
        System.out.println("No se encontraron notas para el estudiante con codigo: " + codigo);
    }
}
public static void eliminarNota() {
    System.out.println("\n=== ELIMINAR NOTA ===");
    System.out.print("Ingrese el codigo del estudiante: ");
    String codigoEstudiante = sc.nextLine().trim();

    System.out.print("Ingrese el codigo de la asignatura: ");
    String codigoAsignatura = sc.nextLine().trim();

    Nota encontrada = null;
    for (Nota n : notas) {
        if (n.getEstudiante().getCodigo().equalsIgnoreCase(codigoEstudiante) &&
            n.getAsignatura().getCodigo().equalsIgnoreCase(codigoAsignatura)) {
            encontrada = n;
            break;
        }
    }

    if (encontrada == null) {
        System.out.println("No se encontro ninguna nota con esos datos.");
        return;
    }

    System.out.println("Nota a eliminar:");
    System.out.println(encontrada);
    System.out.print("Confirmar eliminacion (S/N): ");
    String confirmacion = sc.nextLine().trim();

    if (confirmacion.equalsIgnoreCase("S")) {
        notas.remove(encontrada);
        System.out.println("Nota eliminada exitosamente.");
    } else {
        System.out.println("Eliminacion cancelada.");
    }
}
}
