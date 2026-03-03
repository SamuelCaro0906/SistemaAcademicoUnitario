/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaacademicounitario;

/**
 *
 * @author Csamu
 */
public class SistemaAcademicoUnitario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {}
    
    public static void registrarAsignatura() {
    System.out.println("\n=== REGISTRAR ASIGNATURA ===");

    System.out.print("Codigo: ");
    String codigo = sc.nextLine().trim();

    for (Asignatura a : asignaturas) {
        if (a.getCodigo().equalsIgnoreCase(codigo)) {
            System.out.println("Ya existe una asignatura con ese codigo.");
            return;
        }
    }

    System.out.print("Nombre: ");
    String nombre = sc.nextLine().trim();

    System.out.print("Creditos: ");
    int creditos = 0;
    try {
        creditos = Integer.parseInt(sc.nextLine().trim());
    } catch (NumberFormatException e) {
        System.out.println("Creditos invalidos. Se asigna 0.");
    }

    System.out.print("Docente: ");
    String docente = sc.nextLine().trim();

    Asignatura nueva = new Asignatura(codigo, nombre, creditos, docente);
    asignaturas.add(nueva);
    System.out.println("Asignatura registrada exitosamente.");
    System.out.println(nueva);
}
    public static void listarAsignaturas() {
    System.out.println("\n=== LISTADO DE ASIGNATURAS ===");

    if (asignaturas.isEmpty()) {
        System.out.println("No hay asignaturas registradas.");
        return;
    }

    for (int i = 0; i < asignaturas.size(); i++) {
        System.out.println((i + 1) + ". " + asignaturas.get(i));
    }
    System.out.println("Total: " + asignaturas.size() + " asignatura(s).");
}
    public static void buscarAsignatura() {
    System.out.println("\n=== BUSCAR ASIGNATURA ===");
    System.out.print("Ingrese el codigo de la asignatura: ");
    String codigo = sc.nextLine().trim();

    for (Asignatura a : asignaturas) {
        if (a.getCodigo().equalsIgnoreCase(codigo)) {
            System.out.println("Asignatura encontrada:");
            System.out.println(a);
            return;
        }
    }
    System.out.println("No se encontro ninguna asignatura con el codigo: " + codigo);
}
    
    }
