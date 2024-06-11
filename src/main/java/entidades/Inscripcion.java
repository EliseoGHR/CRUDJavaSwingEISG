/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Chello
 */
public class Inscripcion {

    private int inscripcionID;
    private Date fechaInscripcion;
    private int cursoID;
    private String estudianteNombre;
    private String estudianteCorreo;
    private Curso curso;

    public Inscripcion() {
    }

    public Inscripcion(int inscripcionID, Date fechaInscripcion, int cursoID, String estudianteNombre, String estudianteCorreo, Curso curso) {
        this.inscripcionID = inscripcionID;
        this.fechaInscripcion = fechaInscripcion;
        this.cursoID = cursoID;
        this.estudianteNombre = estudianteNombre;
        this.estudianteCorreo = estudianteCorreo;
        this.curso = curso;
    }

    public int getInscripcionID() {
        return inscripcionID;
    }

    public void setInscripcionID(int inscripcionID) {
        this.inscripcionID = inscripcionID;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public String getEstudianteNombre() {
        return estudianteNombre;
    }

    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }

    public String getEstudianteCorreo() {
        return estudianteCorreo;
    }

    public void setEstudianteCorreo(String estudianteCorreo) {
        this.estudianteCorreo = estudianteCorreo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
