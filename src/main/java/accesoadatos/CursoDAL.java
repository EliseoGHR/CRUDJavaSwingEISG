/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chello
 */
public class CursoDAL {

    public static ArrayList<Curso> obtenerTodos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT CursoID, Nombre, Descripcion, Duracion, Precio FROM Cursos";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int cursoID = resultSet.getInt("CursoID");
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");
                        int duracion = resultSet.getInt("Duracion");
                        double precio = resultSet.getDouble("Precio");
                        Curso curso = new Curso(cursoID, nombre, descripcion, duracion, precio);
                        cursos.add(curso);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener los cursos", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return cursos;
    }

    public static int crear(Curso curso) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Cursos (Nombre, Descripcion, Duracion, Precio) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {

                statement.setString(1, curso.getNombre());
                statement.setString(2, curso.getDescripcion());
                statement.setInt(3, curso.getDuracion());
                statement.setDouble(4, curso.getPrecio());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el cursp", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static int modificar(Curso curso) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Cursos SET Nombre=?, Descripcion=?, Duracion=?, Precio=? WHERE CursoID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {

                statement.setString(1, curso.getNombre());
                statement.setString(2, curso.getDescripcion());
                statement.setInt(3, curso.getDuracion());
                statement.setDouble(4, curso.getPrecio());
                statement.setInt(5, curso.getCursoID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al modificar el curso", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static int eliminar(Curso curso) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Cursos WHERE CursoID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {

                statement.setInt(1, curso.getCursoID());

                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al eliminar el curso", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static ArrayList<Curso> buscar(Curso cursoSearch) {
        ArrayList<Curso> cursos = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT i.CursoID, i.Nombre, i.Descripcion, i.Duracion, i.Precio FROM Cursos i";       
            sql += " WHERE i.Nombre LIKE ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + cursoSearch.getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Curso curso = new Curso();
                        curso.setCursoID(resultSet.getInt("CursoID"));
                        curso.setNombre(resultSet.getString("Nombre"));
                        curso.setDescripcion(resultSet.getString("Descripcion"));
                        curso.setDuracion(resultSet.getInt("Duracion"));
                        curso.setPrecio(resultSet.getDouble("Precio"));
                        cursos.add(curso);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar el curso", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return cursos;
    }
}
