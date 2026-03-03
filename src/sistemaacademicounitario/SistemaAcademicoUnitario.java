package sistemaacademicounitario;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademicoUnitario {

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
                System.out.println("Ingrese un numero valido.");
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
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n=== SISTEMA ACADEMICO UPC ===");
        System.out.println("-- ESTUDIANTES --");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Actualizar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("-- ASIGNATURAS --");
        System.out.println("6. Registrar asignatura");
        System.out.println("7. Listar asignaturas");
        System.out.println("8. Buscar asignatura");
        System.out.println("9. Actualizar asignatura");
        System.out.println("10. Eliminar asignatura");
        System.out.println("-- NOTAS --");
        System.out.println("11. Registrar nota");
        System.out.println("12. Listar notas");
        System.out.println("13. Buscar nota");
        System.out.println("14. Actualizar nota");
        System.out.println("15. Eliminar nota");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    // ===================== ESTUDIANTES =====================

    public static void registrarEstudiante() {
        System.out.println("\n=== REGISTRAR ESTUDIANTE ===");
        System.out.print("Codigo: ");
        String codigo = sc.nextLine().trim();

        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Ya existe un estudiante con ese codigo.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine().trim();

        System.out.print("Edad: ");
        int edad = 0;
        try {
            edad = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Edad invalida. Se asigna 0.");
        }

        System.out.print("Semestre: ");
        int semestre = 0;
        try {
            semestre = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Semestre invalido. Se asigna 0.");
        }

        Estudiante nuevo = new Estudiante(codigo, nombre, apellido, edad, semestre);
        estudiantes.add(nuevo);
        System.out.println("Estudiante registrado exitosamente.");
        System.out.println(nuevo);
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

    public static void actualizarEstudiante() {
        System.out.println("\n=== ACTUALIZAR ESTUDIANTE ===");
        System.out.print("Ingrese el codigo del estudiante a actualizar: ");
        String codigo = sc.nextLine().trim();

        Estudiante encontrado = null;
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = e;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun estudiante con el codigo: " + codigo);
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(encontrado);
        System.out.println("Ingrese los nuevos datos (ENTER para mantener el valor actual):");

        System.out.print("Nuevo nombre [" + encontrado.getNombre() + "]: ");
        String nombre = sc.nextLine().trim();
        if (!nombre.isEmpty()) encontrado.setNombre(nombre);

        System.out.print("Nuevo apellido [" + encontrado.getApellido() + "]: ");
        String apellido = sc.nextLine().trim();
        if (!apellido.isEmpty()) encontrado.setApellido(apellido);

        System.out.print("Nueva edad [" + encontrado.getEdad() + "]: ");
        String edadStr = sc.nextLine().trim();
        if (!edadStr.isEmpty()) {
            try {
                encontrado.setEdad(Integer.parseInt(edadStr));
            } catch (NumberFormatException e) {
                System.out.println("Edad invalida, no se modifico.");
            }
        }

        System.out.print("Nuevo semestre [" + encontrado.getSemestre() + "]: ");
        String semestreStr = sc.nextLine().trim();
        if (!semestreStr.isEmpty()) {
            try {
                encontrado.setSemestre(Integer.parseInt(semestreStr));
            } catch (NumberFormatException e) {
                System.out.println("Semestre invalido, no se modifico.");
            }
        }

        System.out.println("Estudiante actualizado exitosamente.");
        System.out.println(encontrado);
    }

    public static void eliminarEstudiante() {
        System.out.println("\n=== ELIMINAR ESTUDIANTE ===");
        System.out.print("Ingrese el codigo del estudiante a eliminar: ");
        String codigo = sc.nextLine().trim();

        Estudiante encontrado = null;
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = e;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun estudiante con el codigo: " + codigo);
            return;
        }

        System.out.println("Estudiante a eliminar:");
        System.out.println(encontrado);
        System.out.print("Confirmar eliminacion (S/N): ");
        String confirmacion = sc.nextLine().trim();

        if (confirmacion.equalsIgnoreCase("S")) {
            estudiantes.remove(encontrado);
            System.out.println("Estudiante eliminado exitosamente.");
        } else {
            System.out.println("Eliminacion cancelada.");
        }
    }

    // ===================== ASIGNATURAS =====================

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

    public static void actualizarAsignatura() {
        System.out.println("\n=== ACTUALIZAR ASIGNATURA ===");
        System.out.print("Ingrese el codigo de la asignatura a actualizar: ");
        String codigo = sc.nextLine().trim();

        Asignatura encontrada = null;
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                encontrada = a;
                break;
            }
        }

        if (encontrada == null) {
            System.out.println("No se encontro ninguna asignatura con el codigo: " + codigo);
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(encontrada);
        System.out.println("Ingrese los nuevos datos (ENTER para mantener el valor actual):");

        System.out.print("Nuevo nombre [" + encontrada.getNombre() + "]: ");
        String nombre = sc.nextLine().trim();
        if (!nombre.isEmpty()) encontrada.setNombre(nombre);

        System.out.print("Nuevos creditos [" + encontrada.getCreditos() + "]: ");
        String creditosStr = sc.nextLine().trim();
        if (!creditosStr.isEmpty()) {
            try {
                encontrada.setCreditos(Integer.parseInt(creditosStr));
            } catch (NumberFormatException e) {
                System.out.println("Creditos invalidos, no se modificaron.");
            }
        }

        System.out.print("Nuevo docente [" + encontrada.getDocente() + "]: ");
        String docente = sc.nextLine().trim();
        if (!docente.isEmpty()) encontrada.setDocente(docente);

        System.out.println("Asignatura actualizada exitosamente.");
        System.out.println(encontrada);
    }

    public static void eliminarAsignatura() {
        System.out.println("\n=== ELIMINAR ASIGNATURA ===");
        System.out.print("Ingrese el codigo de la asignatura a eliminar: ");
        String codigo = sc.nextLine().trim();

        Asignatura encontrada = null;
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                encontrada = a;
                break;
            }
        }

        if (encontrada == null) {
            System.out.println("No se encontro ninguna asignatura con el codigo: " + codigo);
            return;
        }

        System.out.println("Asignatura a eliminar:");
        System.out.println(encontrada);
        System.out.print("Confirmar eliminacion (S/N): ");
        String confirmacion = sc.nextLine().trim();

        if (confirmacion.equalsIgnoreCase("S")) {
            asignaturas.remove(encontrada);
            System.out.println("Asignatura eliminada exitosamente.");
        } else {
            System.out.println("Eliminacion cancelada.");
        }
    }

    // ===================== NOTAS =====================

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

    public static void actualizarNota() {
        System.out.println("\n=== ACTUALIZAR NOTA ===");
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

        System.out.println("Datos actuales:");
        System.out.println(encontrada);
        System.out.println("Ingrese los nuevos datos (ENTER para mantener el valor actual):");

        System.out.print("Nuevo valor [" + encontrada.getValor() + "]: ");
        String valorStr = sc.nextLine().trim();
        if (!valorStr.isEmpty()) {
            try {
                encontrada.setValor(Double.parseDouble(valorStr));
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido, no se modifico.");
            }
        }

        System.out.print("Nuevo periodo [" + encontrada.getPeriodo() + "]: ");
        String periodo = sc.nextLine().trim();
        if (!periodo.isEmpty()) encontrada.setPeriodo(periodo);

        System.out.println("Nota actualizada exitosamente.");
        System.out.println(encontrada);
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