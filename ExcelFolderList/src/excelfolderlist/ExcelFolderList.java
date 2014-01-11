/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excelfolderlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ExcelFolderList extends javax.swing.JFrame {
    private File folder;
    private ArrayList<String> fileNames;

    public ExcelFolderList() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaFileList = new javax.swing.JTextArea();
        jlSelectedFolder = new javax.swing.JLabel();
        jbWriteCSV = new javax.swing.JButton();
        jbOpenFolder = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiOpen = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();

        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File List");

        jtaFileList.setEditable(false);
        jtaFileList.setColumns(20);
        jtaFileList.setRows(5);
        jScrollPane1.setViewportView(jtaFileList);

        jlSelectedFolder.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlSelectedFolder.setText("All Files in Selected Folder: ");
        jlSelectedFolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbWriteCSV.setText("Write File List");
        jbWriteCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWriteCSVActionPerformed(evt);
            }
        });

        jbOpenFolder.setText("Open Folder");
        jbOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOpenFolderActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jmiOpen.setText("Open");
        jmiOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jmiOpen);

        jmiExit.setText("Exit");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jMenu1.add(jmiExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jlSelectedFolder, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(jbOpenFolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jbWriteCSV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );

        layout.linkSize(new java.awt.Component[] {jbOpenFolder, jbWriteCSV}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jlSelectedFolder)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 455, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbWriteCSV)
                    .add(jbOpenFolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(new java.awt.Component[] {jbOpenFolder, jbWriteCSV}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenActionPerformed
        openFolderDialog();
    }//GEN-LAST:event_jmiOpenActionPerformed

    
    private void openFolderDialog() {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            folder = fileChooser.getSelectedFile();
            jlSelectedFolder.setToolTipText(folder.getAbsolutePath());
            jlSelectedFolder.setText("All Files in Selected Folder: " + folder.getName());
            jtaFileList.setText("");
            fileNames = new ArrayList<String>();
            getFolderNames(folder);
            for (String file : fileNames) {
                jtaFileList.append(file + "\n");
            }
            
            writeFile();
            
        } else {
            System.out.println("File access cancelled by user.");
        }
    }
    private void getFolderNames(File folder) {
        File[] files = folder.listFiles();
        
        for (File file : files) {
            if (file.isDirectory()) {
                getFolderNames(file);
            } else {
                if (file.getName().toLowerCase().contains(".pdf") 
                        || file.getName().toLowerCase().contains(".txt") 
                        || file.getName().toLowerCase().contains(".rar") 
                        || file.getName().toLowerCase().contains(".lit") 
                        || file.getName().toLowerCase().contains(".zip")
                        || file.getName().toLowerCase().contains(".doc")
                        || file.getName().toLowerCase().contains(".html")
                        || file.getName().toLowerCase().contains(".chm")
                        || file.getName().toLowerCase().contains(".epub")
                        || file.getName().toLowerCase().contains(".mobi")
                        || file.getName().toLowerCase().contains(".tif")
                        || file.getName().toLowerCase().contains(".rtf")) {
                    
                    fileNames.add(file.getName());
                }
            }
        }
        
    }
    
    private void writeFile() {
        File csvFile = new File(folder.getName() + "_FileList.csv");
        if (!csvFile.exists()) {
            try {
                csvFile.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        FileWriter fw;
        BufferedWriter bw = null;
        String authorName;
        try {
            fw = new FileWriter(csvFile);
            bw = new BufferedWriter(fw);
            bw.write("FileName,Author\n");
            for (String file : fileNames) {
                //System.out.println(fileName);
                if (file.contains("-")) {
                    authorName = file.substring(0, file.indexOf("-"));
                    bw.write("\"" + file + "\"" 
                        + ","  
                        + "\"" + authorName + "\""
                        + "\n");
                } else {
                    bw.write("\"" + file + "\"\n");
                }
            }
            
            JOptionPane.showMessageDialog(null, "File written: " + csvFile.getAbsoluteFile());
        } catch (IOException ex) {
            Logger.getLogger(ExcelFolderList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelFolderList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jbWriteCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWriteCSVActionPerformed
        writeFile();
    }//GEN-LAST:event_jbWriteCSVActionPerformed

    private void jbOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOpenFolderActionPerformed
        openFolderDialog();
    }//GEN-LAST:event_jbOpenFolderActionPerformed

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
            java.util.logging.Logger.getLogger(ExcelFolderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcelFolderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcelFolderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcelFolderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExcelFolderList().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbOpenFolder;
    private javax.swing.JButton jbWriteCSV;
    private javax.swing.JLabel jlSelectedFolder;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiOpen;
    private javax.swing.JTextArea jtaFileList;
    // End of variables declaration//GEN-END:variables
}
