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
}
