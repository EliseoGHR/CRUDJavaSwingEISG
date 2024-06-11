/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import entidades.Curso;
import entidades.Inscripcion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chello
 */
public class InscripcionDAL {

    public static int crear(Inscripcion inscripcion) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Inscripciones (FechaInscripcion, CursoID, EstudianteNombre, EstudianteCorreo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                java.util.Date fechaInscripcionUtil = inscripcion.getFechaInscripcion();
                java.sql.Date fechaInscripcionSQL = new java.sql.Date(fechaInscripcionUtil.getTime());
                statement.setDate(1, fechaInscripcionSQL);
                statement.setInt(2, inscripcion.getCursoID());
                statement.setString(3, inscripcion.getEstudianteNombre());
                statement.setString(4, inscripcion.getEstudianteCorreo());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear la inscripcion", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static int modificar(Inscripcion inscripcion) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Inscripciones SET FechaInscripcion=?, CursoID=?, EstudianteNombre=?, EstudianteCorreo=? WHERE InscripcionID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                java.util.Date fechaInscripcionUtil = inscripcion.getFechaInscripcion();
                java.sql.Date fechaInscripcionSQL = new java.sql.Date(fechaInscripcionUtil.getTime());
                statement.setDate(1, fechaInscripcionSQL);
                statement.setInt(2, inscripcion.getCursoID());
                statement.setString(3, inscripcion.getEstudianteNombre());
                statement.setString(4, inscripcion.getEstudianteCorreo());
                statement.setInt(5, inscripcion.getInscripcionID());

                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al modificar la inscripcion", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int eliminar(Inscripcion inscripcion) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Inscripciones WHERE InscripcionID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                
                statement.setInt(1, inscripcion.getInscripcionID());

                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al eliminar la inscripcion", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
     public static ArrayList<Inscripcion> buscar(Inscripcion inscripcionSearch) {
         ArrayList<Inscripcion> inscripciones = new ArrayList<>();
    try (Connection conn = ComunDB.obtenerConexion()) {
        String sql = "SELECT i.InscripcionID, i.FechaInscripcion, i.CursoID, c.Nombre AS NombreCurso, i.EstudianteNombre, i.EstudianteCorreo FROM Inscripciones i";
        sql += " INNER JOIN Cursos c ON c.CursoID = i.CursoID";
        sql += " WHERE i.EstudianteNombre LIKE ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "%" + inscripcionSearch.getEstudianteNombre() + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Inscripcion inscripcion = new Inscripcion();
                    inscripcion.setInscripcionID(resultSet.getInt("InscripcionID"));
                    inscripcion.setFechaInscripcion(resultSet.getDate("FechaInscripcion"));
                    inscripcion.setCursoID(resultSet.getInt("CursoID"));
                    Curso curso = new Curso();
                    curso.setNombre(resultSet.getString("NombreCurso"));
                    inscripcion.setCurso(curso);
                    inscripcion.setEstudianteNombre(resultSet.getString("EstudianteNombre"));
                    inscripcion.setEstudianteCorreo(resultSet.getString("EstudianteCorreo"));
                    inscripciones.add(inscripcion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar inscripciones", e);
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
    }
    return inscripciones;
     }
}
