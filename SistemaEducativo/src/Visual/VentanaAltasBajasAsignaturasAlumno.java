
package Visual;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

import sistemaeducativo.Alumno;
import sistemaeducativo.Asignatura;
import sistemaeducativo.AsignaturaAprobadaYaRegistradaException;
import sistemaeducativo.Cursada;
import sistemaeducativo.Facultad;

/**
 *
 * @author Usuario
 */
public class VentanaAltasBajasAsignaturasAlumno extends javax.swing.JFrame
{

    /** Creates new form VentanaAltasBajasAsignaturasAlumno */
    private Facultad facultad;
    private VentanaAlumno ventana;
    private DefaultListModel modeloBuscar;
    private DefaultListModel modeloAlta;
    private DefaultListModel modeloBaja;
    public VentanaAltasBajasAsignaturasAlumno(Facultad f, VentanaAlumno ventana)
    {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        facultad=f;
        this.ventana=ventana;
        this.cerrar();
        setResizable(false);
        setTitle("Sistema Educativo -Alumno-Altas/Bajas Asignaturas");
        setLocationRelativeTo(null);
        this.modeloBaja=new DefaultListModel();
        this.modeloBuscar=new DefaultListModel();
        this.modeloAlta=new DefaultListModel();
    }
    public void limpiarModelo()
    {
        this.modeloAlta.clear();
        this.modeloBaja.clear();
        this.modeloBuscar.clear();
        
    }
    
    public void cerrar() {
        try{
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    ventana.setVisible(true);
                }
            });
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelNombreMod = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellidoMod = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jButtonBuscarMod = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabelSeleccionarMod = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAlumnos = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAsignaturasAltas = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonAlta = new javax.swing.JButton();
        jButtonVolverAlta = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListAsignaturasBaja = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButtonBaja = new javax.swing.JButton();
        jButtonVolverBaja = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButtonCargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(new java.awt.GridLayout(2, 2));

        jLabelNombreMod.setText("Nombre del alumno ");
        jPanel4.add(jLabelNombreMod);
        jPanel4.add(jTextFieldNombre);

        jLabelApellidoMod.setText("Apellido del alumno ");
        jPanel4.add(jLabelApellidoMod);
        jPanel4.add(jTextFieldApellido);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jButtonBuscarMod.setText("Buscar");
        jButtonBuscarMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarModActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonBuscarMod);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabelSeleccionarMod.setText("Seleccione el alumno ");
        jPanel6.add(jLabelSeleccionarMod);

        jScrollPane2.setViewportView(jListAlumnos);

        jPanel6.add(jScrollPane2);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Alta");

        jScrollPane1.setViewportView(jListAsignaturasAltas);

        jLabel2.setText("Seleccione una Asignatura");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jButtonAlta.setText("Dar de Alta");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonAlta);

        jButtonVolverAlta.setText("Volver");
        jButtonVolverAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAltaActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonVolverAlta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Baja");

        jScrollPane3.setViewportView(jListAsignaturasBaja);

        jLabel4.setText("Asignaturas aprobadas por el alumno-Seleccione una");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jButtonBaja.setText("Dar de Baja");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });
        jPanel10.add(jButtonBaja);

        jButtonVolverBaja.setText("Volver");
        jButtonVolverBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverBajaActionPerformed(evt);
            }
        });
        jPanel10.add(jButtonVolverBaja);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jButtonCargar.setText("Cargar");
        jButtonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(287, 287, 287)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 445, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(420, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(206, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }//GEN-END:initComponents

    private void jButtonBuscarModActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonBuscarModActionPerformed
    {//GEN-HEADEREND:event_jButtonBuscarModActionPerformed
        // TODO add your handling code here
        this.limpiarModelo();
        String nombre=this.jTextFieldNombre.getText().toUpperCase();
        String apellido=this.jTextFieldApellido.getText().toUpperCase();
        ArrayList<Alumno> alumnos=facultad.buscarAlumnoPorNombre(nombre, apellido);;
        Iterator it=alumnos.iterator();

        while(it.hasNext())
        {
            Alumno a=(Alumno)it.next();
            modeloBuscar.addElement(a);
        }
        this.jListAlumnos.setModel(modeloBuscar);
    }//GEN-LAST:event_jButtonBuscarModActionPerformed

    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAltaActionPerformed
    {//GEN-HEADEREND:event_jButtonAltaActionPerformed
        
        int n=this.jListAlumnos.getSelectedIndex();
        if(n!=-1){
            Alumno a=(Alumno) this.modeloBuscar.getElementAt(n);
            int x=this.jListAsignaturasAltas.getSelectedIndex();
            Asignatura asig=(Asignatura) this.modeloAlta.getElementAt(x);
            try
            {
                this.facultad.aprobarAlumnoAsignatura(a, asig);
            } catch (AsignaturaAprobadaYaRegistradaException e)
            {
                JOptionPane.showMessageDialog(null, "La asignatura ya se encuentra aprobada");
            }
            this.limpiarModelo();   
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAltaActionPerformed

    private void jButtonBajaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonBajaActionPerformed
    {//GEN-HEADEREND:event_jButtonBajaActionPerformed
        // TODO add your handling code here:
        int n=this.jListAlumnos.getSelectedIndex();
        if(n!=-1){
            Alumno a=(Alumno) this.modeloBuscar.getElementAt(n);
            int x=this.jListAsignaturasBaja.getSelectedIndex();
            Asignatura asig=(Asignatura) this.modeloBaja.getElementAt(x);
            this.facultad.eliminarAlumnoAsignatura(a, asig);
            this.limpiarModelo();   
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBajaActionPerformed

    private void jButtonVolverAltaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonVolverAltaActionPerformed
    {//GEN-HEADEREND:event_jButtonVolverAltaActionPerformed
        this.ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverAltaActionPerformed

    private void jButtonVolverBajaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonVolverBajaActionPerformed
    {//GEN-HEADEREND:event_jButtonVolverBajaActionPerformed
        this.ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverBajaActionPerformed

    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCargarActionPerformed
    {//GEN-HEADEREND:event_jButtonCargarActionPerformed
        // TODO add your handling code here:
        int n=this.jListAlumnos.getSelectedIndex();
        if(n!=-1){
            Alumno a=(Alumno) this.modeloBuscar.getElementAt(n);
            ArrayList<Cursada> cursadas=this.facultad.cursadasDeAlumno(a);
            Iterator it =cursadas.iterator();
            Cursada c;
               while(it.hasNext()) {
                    c=(Cursada)it.next();
                   Asignatura asig=c.getAsignatura();
                    this.modeloAlta.addElement(asig);
               }
            this.jListAsignaturasAltas.setModel(modeloAlta);
            
            Hashtable<String,Asignatura> historia=a.getHistoria();
            Enumeration e = historia.elements();
            Asignatura asig;
            while( e.hasMoreElements() ){
              asig =(Asignatura) e.nextElement();
              this.modeloBaja.addElement(asig);
            }
            this.jListAsignaturasBaja.setModel(modeloBaja);   
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCargarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaAltasBajasAsignaturasAlumno.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaAltasBajasAsignaturasAlumno.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaAltasBajasAsignaturasAlumno.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaAltasBajasAsignaturasAlumno.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable()
            {
                public void run()
                {
                    //new VentanaAltasBajasAsignaturasAlumno().setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonBuscarMod;
    private javax.swing.JButton jButtonCargar;
    private javax.swing.JButton jButtonVolverAlta;
    private javax.swing.JButton jButtonVolverBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelApellidoMod;
    private javax.swing.JLabel jLabelNombreMod;
    private javax.swing.JLabel jLabelSeleccionarMod;
    private javax.swing.JList<String> jListAlumnos;
    private javax.swing.JList<String> jListAsignaturasAltas;
    private javax.swing.JList<String> jListAsignaturasBaja;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

}
