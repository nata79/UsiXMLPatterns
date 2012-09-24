/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usixmlpatterns;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.usixml.aui.AbstractUIModel;
import org.usixml.domain.DomainModel;
import org.usixml.task.TaskModel;
import usixmlpatterns.Exceptions.ActionNotSupportedException;
import usixmlpatterns.Exceptions.IsNotAnInstantiationOfThePatternException;

/**
 *
 * @author albmail88
 */
public class mainWindow extends javax.swing.JFrame {

    /**
     * Creates new form mainWindow
     */
    public mainWindow() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        patternAuiModelTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        patternTaskModelTextField = new javax.swing.JTextField();
        patternDomainModelTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        modelAuiModelTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        modelTaskModelTextField = new javax.swing.JTextField();
        modelDomainModelTextField = new javax.swing.JTextField();
        generateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pattern"));

        jLabel1.setText("Domain model:");

        patternAuiModelTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldClicked(evt);
            }
        });

        jLabel2.setText("Task Model:");

        jLabel3.setText("AUI Model (Template):");

        patternTaskModelTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldClicked(evt);
            }
        });

        patternDomainModelTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(patternAuiModelTextField)
                    .add(patternTaskModelTextField)
                    .add(patternDomainModelTextField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(patternDomainModelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(patternTaskModelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(patternAuiModelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("New Model"));

        jLabel4.setText("Domain model:");

        modelAuiModelTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldClicked(evt);
            }
        });

        jLabel5.setText("Task Model:");

        jLabel6.setText("AUI Model (Generated):");

        modelTaskModelTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldClicked(evt);
            }
        });

        modelDomainModelTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel6)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel5)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(modelAuiModelTextField)
                    .add(modelTaskModelTextField)
                    .add(modelDomainModelTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(modelDomainModelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(modelTaskModelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(modelAuiModelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(clearButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(generateButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(generateButton)
                    .add(clearButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldClicked
        if(evt.getSource() instanceof javax.swing.JTextField){
            javax.swing.JTextField textField = (javax.swing.JTextField) evt.getSource();
            
            JFileChooser fc = new JFileChooser();
            int result;
            if(textField.equals(this.modelAuiModelTextField)){
                result = fc.showSaveDialog(this);
            }
            else{
                result = fc.showOpenDialog(this);
            }
            
            if(result == JFileChooser.APPROVE_OPTION){
                textField.setText(fc.getSelectedFile().getAbsolutePath());
            }
        }
    }//GEN-LAST:event_textFieldClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        modelAuiModelTextField.setText("");
        modelDomainModelTextField.setText("");
        modelTaskModelTextField.setText("");
        patternAuiModelTextField.setText("");
        patternDomainModelTextField.setText("");
        patternTaskModelTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // Load pattern models
        TaskModel patternTask = new TaskModel();
        patternTask.fromFile(patternTaskModelTextField.getText());
        
        DomainModel patternDomain = new DomainModel();
        patternDomain.fromFile(patternDomainModelTextField.getText());
        
        AbstractUIModel patternAui = new AbstractUIModel();
        patternAui.fromFile(patternAuiModelTextField.getText());
        
        Pattern pattern = new Pattern(patternDomain, patternTask, patternAui);
        
        // Load model
        TaskModel modelTask = new TaskModel();
        modelTask.fromFile(modelTaskModelTextField.getText());
        
        DomainModel modelDomain = new DomainModel();
        modelDomain.fromFile(modelDomainModelTextField.getText());
        try {
            // Generate model Abstract user interface
            AbstractUIModel modelAui = pattern.buildAbstractUIModel(modelTask);            
            modelAui.toFile(modelAuiModelTextField.getText());
            
            JOptionPane.showMessageDialog(this, 
                    "Abstract user interface successfully generated.", "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException | InstantiationException | IllegalAccessException | ActionNotSupportedException ex) {
            JOptionPane.showMessageDialog(this, 
                    "An error ocurred and prevented the generation of the Abstract user interface.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } catch (IsNotAnInstantiationOfThePatternException ex) {
            JOptionPane.showMessageDialog(this, 
                    "The provided model isn't compatible with the provided pattern.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_generateButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField modelAuiModelTextField;
    private javax.swing.JTextField modelDomainModelTextField;
    private javax.swing.JTextField modelTaskModelTextField;
    private javax.swing.JTextField patternAuiModelTextField;
    private javax.swing.JTextField patternDomainModelTextField;
    private javax.swing.JTextField patternTaskModelTextField;
    // End of variables declaration//GEN-END:variables
}
