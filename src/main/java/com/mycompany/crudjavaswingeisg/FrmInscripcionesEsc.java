/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crudjavaswingeisg;

import javax.swing.JOptionPane;
import utilerias.OpcionesCRUD;
import accesoadatos.CursoDAL;
import accesoadatos.InscripcionDAL;
import entidades.Curso;
import entidades.Inscripcion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Chello
 */
public class FrmInscripcionesEsc extends javax.swing.JFrame {

    private OpcionesCRUD opcionCRUD;

    private Inscripcion inscripcionActual = new Inscripcion();
    private HashMap<Integer, Curso> mapCursos = new HashMap<Integer, Curso>();

    /**
     * Creates new form FrmInscripcionesEsc
     */
    public FrmInscripcionesEsc(OpcionesCRUD opcion, Inscripcion inscripcion) {
        this.opcionCRUD = opcion;
        initComponents();
        ArrayList<Curso> cursos = CursoDAL.obtenerTodos();
        DefaultComboBoxModel<Curso> modelCombox = new DefaultComboBoxModel(cursos.toArray());
        for (Curso cur : cursos) {
            mapCursos.put(cur.getCursoID(), cur);
        }
        jComboCursos.setModel(modelCombox);
        if (opcion != OpcionesCRUD.CREAR) {
            asignarDatos(inscripcion);
            inscripcionActual = inscripcion;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtFechaIns = new javax.swing.JTextField();
        jTxtNombreEs = new javax.swing.JTextField();
        jTxtCorreoEs = new javax.swing.JTextField();
        jComboCursos = new javax.swing.JComboBox<>();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setTitle("Inscripciones de estudiantes");

        jLabel1.setText("Fecha Inscripcion:");

        jLabel2.setText("Curso:");

        jLabel3.setText("Nombre del estudiante:");

        jLabel4.setText("Correo del estudiante:");

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jBtnGuardar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtnCancelar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFechaIns, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNombreEs, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(jTxtCorreoEs))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtFechaIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtNombreEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtCorreoEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    private Inscripcion obtenerDatos() {
        Inscripcion inscripcion = new Inscripcion();
        // Validate date format
        String fechaInscripcion = jTxtFechaIns.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = dateFormat.parse(fechaInscripcion);
            inscripcion.setFechaInscripcion(fechaInscripcion);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "La fecha de inscripción debe tener el formato 'dd-MM-yyyy'.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Curso curso = (Curso) jComboCursos.getSelectedItem();
        inscripcion.setCursoID(curso.getCursoID());
        inscripcion.setEstudianteNombre(jTxtNombreEs.getText());
        String correoEstudiante = jTxtCorreoEs.getText();
        if (validarCorreo(correoEstudiante)) {
            inscripcion.setEstudianteCorreo(correoEstudiante);
        } else {
            JOptionPane.showMessageDialog(null, "El correo electrónico ingresado no es válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        inscripcion.setInscripcionID(inscripcionActual.getInscripcionID());
        return inscripcion;
    }

    private boolean validarDatos() {
        boolean valid = true;

        // Validar campo de fecha de inscripción
        if (jTxtFechaIns.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "La fecha de inscripción es obligatoria", "Validar campo", JOptionPane.WARNING_MESSAGE);
        }

        // Validar campo de curso
        if (jComboCursos.getSelectedItem() == null) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Validar campo", JOptionPane.WARNING_MESSAGE);
        }

        // Validar campo de nombre del estudiante
        if (jTxtNombreEs.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "El nombre del estudiante es obligatorio", "Validar campo", JOptionPane.WARNING_MESSAGE);
        }

        // Validar campo de correo del estudiante
        if (jTxtCorreoEs.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "El correo del estudiante es obligatorio", "Validar campo", JOptionPane.WARNING_MESSAGE);
        }

        return valid;
    }

    private void asignarDatos(Inscripcion inscripcion) {

        jTxtFechaIns.setText(inscripcion.getFechaInscripcion());
        jTxtNombreEs.setText(inscripcion.getEstudianteNombre());
        jTxtCorreoEs.setText(inscripcion.getEstudianteCorreo());
        Curso curso = mapCursos.get(inscripcion.getCursoID());
        jComboCursos.setSelectedItem(curso);

    }

    private void crearReg() {
        try {
            Inscripcion inscripcion = obtenerDatos();
            int result = InscripcionDAL.crear(inscripcion);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "La inscripcion fue registrado existosamente", "CREAR INSCRIPCION",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al crear la inscripcion", "ERROR INSCRIPCION",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR INSCRIPCION",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void modificarReg() {
        try {
            Inscripcion inscripcion = obtenerDatos();
            int result = InscripcionDAL.modificar(inscripcion);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "El producto fue modificado existosamente", "MODIFICAR PRODUCTO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al modificar el producto", "ERROR PRODUCTO",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR PRODUCTO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void eliminarReg() {
        try {
            Inscripcion inscripcion = obtenerDatos();
            int result = InscripcionDAL.eliminar(inscripcion);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "La inscripcion fue eliminar existosamente", "ELIMINAR INSCRIPCION",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al eliminar la inscripcion", "ERROR INSCRIPCION",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR INSCRIPCION",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {
            if (null != opcionCRUD) {
                switch (opcionCRUD) {
                    case CREAR:
                        crearReg();
                        this.setVisible(false);
                        break;
                    case MODIFICAR:
                        modificarReg();
                        this.setVisible(false);
                        break;
                    case ELIMINAR:
                        eliminarReg();
                        this.setVisible(false);
                        break;
                    default:
                        break;
                }
            }
        }
    }//GEN-LAST:event_jBtnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JComboBox<Curso> jComboCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTxtCorreoEs;
    private javax.swing.JTextField jTxtFechaIns;
    private javax.swing.JTextField jTxtNombreEs;
    // End of variables declaration//GEN-END:variables
}
