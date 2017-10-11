/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrstate.ics240.vjp071.listofthings.dialogs;

import edu.metrstate.ics240.vjp071.listofthings.FavoriteMovie;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JDialog;

/**
 * An input form for displaying and modifying the properties of a single
 * FavoriteMovie object.
 * 
 * @author Vincent
 */
public class FavoriteMovieDialog extends JDialog {
    private FavoriteMovie favoriteMovie;

    public FavoriteMovie getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(FavoriteMovie favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }

    /**
     * Creates new form FavoriteMovieDialog
     * @param parent The JFrame that owns this dialog
     * @param modal If true, input to the owner JFrame is restricted until this
     * dialog is dismissed.
     */
    public FavoriteMovieDialog(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }
    /**
     * Creates new form FavoriteMovieDialog
     * @param parent The JFrame that owns this dialog
     * @param modal If true, input to the owner JFrame is restricted until this
     * @param fm The FavoriteMovie to initialize the dialog with.
     * dialog is dismissed.
     */
    public FavoriteMovieDialog(java.awt.Frame parent, boolean modal, FavoriteMovie fm) {
        super(parent, modal);
        initComponents();
        favoriteMovie = fm;
        
        if (favoriteMovie != null) {
            if (favoriteMovie.getImdb() != null) {
                imdbJTextField.setText(favoriteMovie.getImdb().toString());
            }
            if (favoriteMovie.getTitle() != null) {
                titleJTextField.setText(favoriteMovie.getTitle());
            }
            if (favoriteMovie.getReleaseDate() != null) {
                releaseYearJTextField.setText(favoriteMovie.getReleaseDate().toString());
            }
            if (favoriteMovie.getDirector() != null) {
                directorJTextField.setText(favoriteMovie.getDirector().toString());
            }
            if (favoriteMovie.getWriter() != null) {
                writerJTextField.setText(favoriteMovie.getWriter().toString());
            }
            if (favoriteMovie.getGross() != null) {
                grossJTextField.setText(favoriteMovie.getGross().toString());
            }
            if (favoriteMovie.getNominations() != null) {
                nominationsJTextField.setText(favoriteMovie.getNominations().toString());
            }
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        imdbJLabel = new javax.swing.JLabel();
        imdbJTextField = new javax.swing.JTextField();
        titleJLabel = new javax.swing.JLabel();
        titleJTextField = new javax.swing.JTextField();
        releaseYearJLabel = new javax.swing.JLabel();
        releaseYearJTextField = new javax.swing.JTextField();
        directorJLabel = new javax.swing.JLabel();
        directorJTextField = new javax.swing.JTextField();
        writerJLabel = new javax.swing.JLabel();
        writerJTextField = new javax.swing.JTextField();
        grossJLabel = new javax.swing.JLabel();
        grossJTextField = new javax.swing.JTextField();
        nominationsJLabel = new javax.swing.JLabel();
        nominationsJTextField = new javax.swing.JTextField();
        okJButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Favorite Movie");
        setModal(true);
        setName("movieDialog"); // NOI18N
        setResizable(false);

        imdbJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imdbJLabel.setText("IMDB #:");
        imdbJLabel.setToolTipText("The IMDB number for this movie");

        imdbJTextField.setToolTipText("Please enter the the IMDB number for this movie, if any. Limit 7 digits.");

        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleJLabel.setText("Title:");
        titleJLabel.setToolTipText("This movie's title");

        titleJTextField.setToolTipText("Please enter the title of this movie, required. Limit 255 characters.");

        releaseYearJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        releaseYearJLabel.setText("Release Date:");
        releaseYearJLabel.setToolTipText("The date this movie was released in theaters.");

        releaseYearJTextField.setToolTipText("Please enter the year, month, and day this movie was released in theaters (yyyy-MM-dd), if any.");
        releaseYearJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                releaseYearJTextFieldActionPerformed(evt);
            }
        });

        directorJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        directorJLabel.setText("Director:");
        directorJLabel.setToolTipText("The director of this movie.");

        directorJTextField.setToolTipText("Please enter the name of the director for this movie, if any. Limit 120 characters.");

        writerJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        writerJLabel.setText("Writer:");
        writerJLabel.setToolTipText("The writer of this movie.");

        writerJTextField.setToolTipText("Please enter the name of the writer for this movie, if any. Limit 120 characters.");

        grossJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        grossJLabel.setText("Box Office Gross:");
        grossJLabel.setToolTipText("Gross sales at the box-office for this movie.");

        grossJTextField.setToolTipText("Please enter the Box Office Gross for this movie, if any.");

        nominationsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nominationsJLabel.setText("Oscar Nominations:");
        nominationsJLabel.setToolTipText("The total number of Oscar nominations this movie received.");

        nominationsJTextField.setToolTipText("Please enter the number of Oscar nominations this movie received, if any.");

        okJButton.setText("OK");
        okJButton.setToolTipText("Press OK to add or update this movie in the collection.");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, titleJTextField, org.jdesktop.beansbinding.ELProperty.create("${text.size > 0}"), okJButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        okJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nominationsJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grossJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(writerJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(directorJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(releaseYearJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imdbJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(okJButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imdbJTextField)
                        .addComponent(titleJTextField)
                        .addComponent(releaseYearJTextField)
                        .addComponent(directorJTextField)
                        .addComponent(writerJTextField)
                        .addComponent(grossJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nominationsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imdbJLabel)
                    .addComponent(imdbJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleJLabel)
                    .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(releaseYearJLabel)
                    .addComponent(releaseYearJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directorJLabel)
                    .addComponent(directorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(writerJLabel)
                    .addComponent(writerJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grossJLabel)
                    .addComponent(grossJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nominationsJLabel)
                    .addComponent(nominationsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okJButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okJButtonActionPerformed
        // TODO add your handling code here:
        String imdbString = null;
        Integer imdb = null;
        String title = null;
        String releaseDateString = null;
        LocalDate releaseDate = null;
        String director = null;
        String writer = null;
        String grossString = null;
        Double gross = null;
        String nominationsString = null;
        Integer nominations = null;
        
        boolean validated = true;
        
        if (imdbJTextField.getDocument() != null) {
            imdbString = imdbJTextField.getText();
            
            if (imdbString == null || imdbString.trim().isEmpty()) {
                imdbString = null;
            } else {
                try {
                    imdbString = imdbString.trim();
                    
                    if (imdbString.length() <= 7) {
                        imdb = Integer.parseInt(imdbString);

                        if (imdb < 0) {
                            validated = false;
                        }
                    } else {
                        validated = false;
                    }
                } catch (NumberFormatException ex) {
                    validated = false;
                }
            }
        }
        
        if (titleJTextField.getDocument() != null) {
            title = titleJTextField.getText();
            
            if (title == null || title.trim().isEmpty()) {
                title = null;
                validated = false;
            } else {
                title = title.trim();
                
                if (title.length() > 255) {
                    validated = false;
                }
            }
        }
        
        if (releaseYearJTextField.getDocument() != null) {
            releaseDateString = releaseYearJTextField.getText();
            
            if (releaseDateString == null || releaseDateString.trim().isEmpty()) {
                releaseDateString = null;
            } else {
                try {
                    releaseDateString = releaseDateString.trim();
                    
                    releaseDate = LocalDate.parse(releaseDateString);
                } catch (DateTimeParseException ex) {
                    validated = false;
                }
            }
        }
        
        if (directorJTextField.getDocument() != null) {
            director = directorJTextField.getText();
            
            if (director == null || director.trim().isEmpty()) {
                director = null;
            } else {
                director = director.trim();
                
                if (director.length() > 120) {
                    validated = false;
                }
            }
        }
        
        if (writerJTextField.getDocument() != null) {
            writer = writerJTextField.getText();
            
            if (writer == null || writer.trim().isEmpty()) {
                writer = null;
            } else {
                writer = writer.trim();
                
                if (writer.length() > 120) {
                    validated = false;
                }
            }
        }
        
        if (grossJTextField.getDocument() != null) {
            grossString = grossJTextField.getText();
            
            if (grossString == null || grossString.trim().isEmpty()) {
                grossString = null;
            } else {
                try {
                    grossString = grossString.trim();
                    
                    gross = Double.parseDouble(grossString);

                    if (gross < 0) {
                        validated = false;
                    }
                } catch (NumberFormatException ex) {
                    validated = false;
                }
            }
        }
        
        if (nominationsJTextField.getDocument() != null) {
            nominationsString = nominationsJTextField.getText();
            
            if (nominationsString == null || nominationsString.trim().isEmpty()) {
                nominationsString = null;
            } else {
                try {
                    nominationsString = nominationsString.trim();
                    
                    nominations = Integer.parseInt(nominationsString);

                    if (nominations < 0) {
                        validated = false;
                    }
                } catch (NumberFormatException ex) {
                    validated = false;
                }
            }
        }
        
        if (validated) {
            if (favoriteMovie == null) {
                favoriteMovie = new FavoriteMovie();
            }
        
            favoriteMovie.setImdb(imdb);
            favoriteMovie.setTitle(title);
            favoriteMovie.setReleaseDate(releaseDate);
            favoriteMovie.setDirector(director);
            favoriteMovie.setWriter(writer);
            favoriteMovie.setGross(gross);
            favoriteMovie.setNominations(nominations);
            
            dispose();
        }
    }//GEN-LAST:event_okJButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void releaseYearJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_releaseYearJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_releaseYearJTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(FavoriteMovieDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FavoriteMovieDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FavoriteMovieDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FavoriteMovieDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FavoriteMovieDialog dialog = new FavoriteMovieDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel directorJLabel;
    private javax.swing.JTextField directorJTextField;
    private javax.swing.JLabel grossJLabel;
    private javax.swing.JTextField grossJTextField;
    private javax.swing.JLabel imdbJLabel;
    private javax.swing.JTextField imdbJTextField;
    private javax.swing.JLabel nominationsJLabel;
    private javax.swing.JTextField nominationsJTextField;
    private javax.swing.JButton okJButton;
    private javax.swing.JLabel releaseYearJLabel;
    private javax.swing.JTextField releaseYearJTextField;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTextField titleJTextField;
    private javax.swing.JLabel writerJLabel;
    private javax.swing.JTextField writerJTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
