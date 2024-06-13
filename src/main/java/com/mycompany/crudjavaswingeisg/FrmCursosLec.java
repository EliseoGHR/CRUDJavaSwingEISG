/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crudjavaswingeisg;

import utilerias.OpcionesCRUD;
import entidades.Curso;
import accesoadatos.CursoDAL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilerias.OpcionesCRUD;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chello
 */
public class FrmCursosLec extends javax.swing.JFrame {

    private OpcionesCRUD opcionCRUD;

    /**
     * Creates new form FrmCursosLec
     */
    public FrmCursosLec() {
        initComponents();
        interactuarBuscar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jBtnIrACrear = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setTitle("Buscar Cursos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Curso", "Nombre", "Descripcion", "Duracion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCursos);

        jLabel1.setText("Nombre:");

        jTxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtNombreKeyReleased(evt);
            }
        });

        jBtnBuscar.setText("Actualizar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jBtnIrACrear.setText("Ir a crear");
        jBtnIrACrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIrACrearActionPerformed(evt);
            }
        });

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
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
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBuscar)
                        .addGap(24, 24, 24)
                        .addComponent(jBtnIrACrear))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCancelar)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar)
                    .addComponent(jBtnIrACrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private Curso obtenerDatos() {
        Curso curso = new Curso();
        int row = jTableCursos.getSelectedRow();
        curso.setCursoID((int) jTableCursos.getValueAt(row, 0));
        curso.setNombre(jTableCursos.getValueAt(row, 1).toString());
        curso.setDescripcion(jTableCursos.getValueAt(row, 2).toString());
        curso.setDuracion((int)jTableCursos.getValueAt(row, 3));
        curso.setPrecio((double)jTableCursos.getValueAt(row, 4));
        return curso;
    }
    
    private void interactuarBuscar(){
        Curso curso = new Curso();
        curso.setNombre(jTxtNombre.getText());
        ArrayList<Curso> cursos = CursoDAL.buscar(curso);
        String[] columnas = {"ID Curso", "Nombre", "Descripcion", "Duracion", "Precio"};
        Object[][] datos = new Object[cursos.size()][5];
        for (int i = 0; i < cursos.size(); i++) {
            Curso item = cursos.get(i);
            datos[i][0] = item.getCursoID();
            datos[i][1] = item.getNombre();
            datos[i][2] = item.getDescripcion();
            datos[i][3] = item.getDuracion();
            datos[i][4] = item.getPrecio();
           
        }
        DefaultTableModel modelTable = new DefaultTableModel(datos, columnas);
        jTableCursos.setModel(modelTable);
    }
    private void jTxtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNombreKeyReleased
        // TODO add your handling code here:
        interactuarBuscar();
    }//GEN-LAST:event_jTxtNombreKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        FrmInicio frmInicio = new FrmInicio();
        frmInicio.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jBtnIrACrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIrACrearActionPerformed
        // TODO add your handling code here:
         opcionCRUD = OpcionesCRUD.CREAR;
        FrmCursosEsc frmCursosEsc = new FrmCursosEsc(opcionCRUD, new Curso());
        frmCursosEsc.setTitle("Crear curso");
        frmCursosEsc.setVisible(true);
        this.setVisible(false);
       
    }//GEN-LAST:event_jBtnIrACrearActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        // TODO add your handling code here:
        interactuarBuscar();
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
          FrmInicio frmInicio = new FrmInicio();
        frmInicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        // TODO add your handling code here:
         int row = jTableCursos.getSelectedRow();
        if (row != -1) {
            opcionCRUD = OpcionesCRUD.MODIFICAR;
            FrmCursosEsc frmcursosEsc = new FrmCursosEsc(opcionCRUD, obtenerDatos());
            frmcursosEsc.setTitle("Modificar producto");
            frmcursosEsc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccionar una fila", "Producto",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:
         int row = jTableCursos.getSelectedRow();
        if (row != -1) {
            opcionCRUD = OpcionesCRUD.ELIMINAR;
            FrmCursosEsc frmcursosEsc = new FrmCursosEsc(opcionCRUD, obtenerDatos());
            frmcursosEsc.setTitle("Eliminar producto");
            frmcursosEsc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccionar una fila", "Producto",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCursosLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCursosLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCursosLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCursosLec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCursosLec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnIrACrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCursos;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
