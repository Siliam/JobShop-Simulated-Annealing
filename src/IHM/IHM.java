/*
    Interface graphique
 */
package IHM;

import IHM.Gantt.GanttjDialog;
import Jobshop.Données;
import Jobshop.Recuit;
import Jobshop.Tour;
import Jobshop.TourManager;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IHM extends javax.swing.JFrame {
    Tour best;
    Recuit recs = new Recuit();
    public IHM() {
        initComponents();
        setTitle("Jobshop - Recuit Simulé - ENSA Tanger 2016");
        btnGantt.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnParcourir = new javax.swing.JButton();
        btnGantt = new javax.swing.JButton();
        txtTemp = new javax.swing.JTextField();
        txtTaux = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNbMachines = new javax.swing.JLabel();
        lblJobs = new javax.swing.JLabel();
        lblMakespan = new javax.swing.JLabel();
        btnMakespan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnParcourir.setText("Parcourir");
        btnParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcourirActionPerformed(evt);
            }
        });

        btnGantt.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnGantt.setText("Générer le Gantt");
        btnGantt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanttActionPerformed(evt);
            }
        });

        txtTemp.setText("50000");

        txtTaux.setText("0.0005");

        jLabel1.setText("Température Initiale :");

        jLabel2.setText("Taux de refroidissement :");

        jLabel3.setText("Nombre de Machines : ");

        jLabel4.setText("Nombre de Jobs : ");

        lblNbMachines.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNbMachines.setText("  ");

        lblJobs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblJobs.setText("  ");

        lblMakespan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMakespan.setText("Makespan : ");

        btnMakespan.setText("<html>Calculer le<br> Makespan</html>");
        btnMakespan.setEnabled(false);
        btnMakespan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakespanActionPerformed(evt);
            }
        });

        jLabel5.setText("Fichier de données :");

        txtPath.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnParcourir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblJobs, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblNbMachines, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTaux, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addComponent(btnMakespan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 9, Short.MAX_VALUE)))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnGantt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMakespan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnParcourir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblJobs)
                    .addComponent(jLabel4)
                    .addComponent(lblNbMachines, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMakespan))
                .addGap(18, 18, 18)
                .addComponent(lblMakespan)
                .addGap(18, 18, 18)
                .addComponent(btnGantt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGanttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanttActionPerformed
        if(best.getMakespan() == 999999)
        {
            JOptionPane.showMessageDialog(this, "Aucune solution n'a été trouvé pour cette"
                    + " configuration. Veuillez réessayer.");
            return;
        }
        try
        {
            GanttjDialog gantt = new GanttjDialog(this, rootPaneCheckingEnabled, best.temps, Données.nbMachines, Données.nbJobs,
                            best.getMakespan(),null);
            gantt.setVisible(true);
            recs = new Recuit();
        }
        catch(Exception E)
        {
            JOptionPane.showMessageDialog(this, "Erreur : " + E.getMessage());
            return;
        }
    }//GEN-LAST:event_btnGanttActionPerformed

    private void btnMakespanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakespanActionPerformed
        recs.Lancer(Integer.parseInt(txtTemp.getText()), Double.parseDouble(txtTaux.getText()));
        best = recs.optimum;
        int ms = best.getMakespan();
        ms = (ms == 999999) ? -1 : ms;
        lblMakespan.setText("Makespan : " + ms);
        btnGantt.setEnabled(true);
    }//GEN-LAST:event_btnMakespanActionPerformed

    private void btnParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcourirActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Fichier de données (.csv)", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            try
            {
                String nomFichier = chooser.getSelectedFile().getPath();
                txtPath.setText(nomFichier);
                TourManager.Vider();
                recs.Alimenter(nomFichier);
                lblJobs.setText("" + (Données.nbJobs - 1));
                lblNbMachines.setText("" + Données.nbMachines);
                btnMakespan.setEnabled(true);
            }
            catch(Exception E)
            {
                System.err.println("Exception : " + E.getMessage());
            }
                    
        }
    }//GEN-LAST:event_btnParcourirActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGantt;
    private javax.swing.JButton btnMakespan;
    private javax.swing.JButton btnParcourir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblJobs;
    private javax.swing.JLabel lblMakespan;
    private javax.swing.JLabel lblNbMachines;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtTaux;
    private javax.swing.JTextField txtTemp;
    // End of variables declaration//GEN-END:variables
}
