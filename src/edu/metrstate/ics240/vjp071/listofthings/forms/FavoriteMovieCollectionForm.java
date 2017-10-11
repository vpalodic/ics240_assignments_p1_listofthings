/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrstate.ics240.vjp071.listofthings.forms;

import edu.metrstate.ics240.vjp071.listofthings.FavoriteMovie;
import edu.metrstate.ics240.vjp071.listofthings.FavoriteMovieCollection;
import edu.metrstate.ics240.vjp071.listofthings.dialogs.FavoriteMovieDialog;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Vincent
 */
public class FavoriteMovieCollectionForm extends javax.swing.JFrame {

    private FavoriteMovieCollection movieCollection;

    /**
     * Get the value of movieCollection
     *
     * @return the value of movieCollection
     */
    public FavoriteMovieCollection getMovieCollection() {
        return movieCollection;
    }

    /**
     * Creates new form FavoriteMovieCollectionForm
     */
    public FavoriteMovieCollectionForm() {
        movieCollection = new FavoriteMovieCollection();

        initComponents();

        clearJButton.setEnabled(false);
        editJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        searchJButton.setEnabled(false);
        searchJTextField.setEnabled(false);

        moviesJList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();

                if (lsm.isSelectionEmpty()) {
                    editJButton.setEnabled(false);
                    deleteJButton.setEnabled(false);
                } else {
                    // Find out which indexes are selected.
                    int minIndex = lsm.getMinSelectionIndex();
                    int maxIndex = lsm.getMaxSelectionIndex();
                    for (int i = minIndex; i <= maxIndex; i++) {
                        if (lsm.isSelectedIndex(i)) {
                            editJButton.setEnabled(true);
                            deleteJButton.setEnabled(true);
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchJTextField = new javax.swing.JTextField();
        searchJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        searchJLabel = new javax.swing.JLabel();
        clearJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        moviesJList = new javax.swing.JList<>();
        mainJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie Collection Manager");
        setName("moviesFrame"); // NOI18N
        setResizable(false);

        searchJTextField.setToolTipText("The movie title to search for");

        searchJButton.setText("Search");
        searchJButton.setToolTipText("Search the Favorite Movie Collection by movie title");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });

        addJButton.setText("Add Movie");
        addJButton.setToolTipText("Click to add a new favorite movie to the collection");
        addJButton.setActionCommand("add");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        editJButton.setText("Edit");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });

        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        searchJLabel.setLabelFor(searchJTextField);
        searchJLabel.setText("Movie Title:");

        clearJButton.setText("Clear");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });

        moviesJList.setModel(movieCollection);
        moviesJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(moviesJList);

        fileJMenu.setText("File");

        openJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openJMenuItem.setText("Open...");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openJMenuItem);

        saveJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveJMenuItem.setText("Save...");
        saveJMenuItem.setActionCommand("Save...");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);
        fileJMenu.add(jSeparator1);

        exitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitJMenuItem.setText("Exit");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        mainJMenuBar.add(fileJMenu);

        setJMenuBar(mainJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(addJButton)
                        .addGap(18, 18, 18)
                        .addComponent(editJButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteJButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchJButton)
                    .addComponent(searchJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton)
                    .addComponent(editJButton)
                    .addComponent(deleteJButton)
                    .addComponent(clearJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(584, 319));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed
        // TODO add your handling code here:
        if (searchJTextField.getDocument() != null) {
            String search = searchJTextField.getText();

            if (!movieCollection.isEmpty()) {
                int index = movieCollection.search(search);

                if (index >= 0) {
                    moviesJList.setSelectedIndex(index);
                    editJButton.setEnabled(true);
                    deleteJButton.setEnabled(true);
                } else {
                    moviesJList.getSelectionModel().clearSelection();
                }
            }
        }
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        if (evt.getActionCommand().toLowerCase().equals("add")) {
            FavoriteMovieDialog fmd = new FavoriteMovieDialog(this, true);

            fmd.setVisible(true);

            FavoriteMovie fm = fmd.getFavoriteMovie();

            if (fm != null) {
                if (movieCollection.isEmpty()) {
                    clearJButton.setEnabled(true);
                    searchJButton.setEnabled(true);
                    searchJTextField.setEnabled(true);
                }
                
                movieCollection.add(fm);
            }
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        if (evt.getActionCommand().toLowerCase().equals("edit")) {
            int index = moviesJList.getSelectedIndex();

            if (index >= 0) {
                FavoriteMovie fm = movieCollection.getAt(index);

                FavoriteMovieDialog fmd = new FavoriteMovieDialog(this, true, fm);

                fmd.setVisible(true);

                movieCollection.fireUpdateAt(index);
            }
        }
    }//GEN-LAST:event_editJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        int index = moviesJList.getSelectedIndex();

        if (index >= 0) {
            String title = String.format("Delete Movie Confirmation");
            String message = String.format("Are you sure you want to delete %s?", movieCollection.getAt(index).getTitle());
            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION) {
                movieCollection.remove(index);
                moviesJList.getSelectionModel().clearSelection();
            }
        }

        if (movieCollection.isEmpty()) {
            clearJButton.setEnabled(false);
            searchJButton.setEnabled(false);
            searchJTextField.setEnabled(false);
        }

    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        String title = String.format("Clear Movie Collection Confirmation");
        String message = String.format("Are you sure you want to delete all movies?");
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            if (!movieCollection.isEmpty()) {
                movieCollection.removeAll();
                clearJButton.setEnabled(false);
                editJButton.setEnabled(false);
                deleteJButton.setEnabled(false);
                searchJButton.setEnabled(false);
                searchJTextField.setEnabled(false);
            }
        }
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        dispose();
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    private void openJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser openFile = new JFileChooser();
        openFile.showOpenDialog(null);
        File file = openFile.getSelectedFile();
        
        if (file != null) {
            movieCollection.addFromFile(file);
        }
    }//GEN-LAST:event_openJMenuItemActionPerformed

    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser openFile = new JFileChooser();
        openFile.showSaveDialog(null);
        File file = openFile.getSelectedFile();
        
        if (file != null) {
            movieCollection.saveToFile(file);
        }
    }//GEN-LAST:event_saveJMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(FavoriteMovieCollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FavoriteMovieCollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FavoriteMovieCollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FavoriteMovieCollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FavoriteMovieCollectionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton clearJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton editJButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar mainJMenuBar;
    private javax.swing.JList<String> moviesJList;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JButton searchJButton;
    private javax.swing.JLabel searchJLabel;
    private javax.swing.JTextField searchJTextField;
    // End of variables declaration//GEN-END:variables
}
