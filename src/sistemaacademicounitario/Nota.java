/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademicounitario;

/**
 *
 * @author Csamu
 */
public class Nota {
     private Estudiante estudiante;
    private Asignatura asignatura;
    private double valor;
    private String periodo;   

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
         return "Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido() +
           " | Asignatura: " + asignatura.getNombre() +
           " | Valor: " + valor +
           " | Periodo: " + periodo;
    }
    
}
