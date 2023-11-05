/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.actividadm4.vista;

import com.mycompany.actividadm4.controlador.ControllerTareas;
import com.mycompany.actividadm4.model.Tareas;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nico Morales
 */
public class VentanaListado extends javax.swing.JPanel {

    ControllerTareas control = new ControllerTareas();
    
    public VentanaListado() {
        initComponents();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 135, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(58, 58, 58)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(jButton1))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
       //        Verificamos si se selecciono una fila

        if (tabla.getRowCount() > 0) {
            
            if (tabla.getSelectedRow() != -1) {
                
//                Traemos el indice de la fila seleccionada y eliminamos

                int index = tabla.getSelectedRow();
                Object id = tabla.getValueAt(index, 0);
                Long indetificador = Long.parseLong(id.toString()) ;
                control.eliminarTarea(indetificador);
                llenarTabla();
                JOptionPane.showMessageDialog(null,"Tarea borrada correctamente!!");
                
            } else {
                
                 JOptionPane.showMessageDialog(null, "No selecciono un registro para eliminar!");

            }
            
        } else {
                JOptionPane.showMessageDialog(null,"La tabla esta vacia, no se puede eliminar!");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        Tareas tarea = new Tareas();
        
        if (tabla.getRowCount() > 0) {
            
            if (tabla.getSelectedRow() != 1) {
                
                Long id = Long.parseLong( tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
                String titulo = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 1));
                String descripcion = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 2));

                tarea.setId(id);
                tarea.setTitulo(titulo);
                tarea.setDescripcion(descripcion);
                
                VentanaEditar modif = new VentanaEditar(tarea);
                modif.setVisible(true);
                modif.setLocationRelativeTo(null);
                
                llenarTabla();
            } else {
                
                 JOptionPane.showInternalMessageDialog(null, "No selecciono un registro para  modificar!");

            }
            
        } else {
                JOptionPane.showInternalMessageDialog(null, "La tabla esta vacia, no se puede modificar!");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void llenarTabla (){
        
         DefaultTableModel modeloTable = new DefaultTableModel () {
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        String titulos[]={
            "Id",
            "Titulo",
            "Descripcion"
        };
        
        modeloTable.setColumnIdentifiers(titulos);
              
  
                   
        List <Tareas> lista =   control.traerTareas();
        if (lista != null) {
            
            for (Tareas tarea : lista){
                Object[] object = {tarea.getId(),tarea.getTitulo(), tarea.getDescripcion()};
                modeloTable.addRow(object);
            }
        }
        
        //Asignamos el modelo de tabla al componente TablaDatos
        tabla.setModel(modeloTable);
      
           
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}