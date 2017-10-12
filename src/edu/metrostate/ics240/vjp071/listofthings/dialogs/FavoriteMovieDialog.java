/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrostate.ics240.vjp071.listofthings.dialogs;

import edu.metrostate.ics240.vjp071.listofthings.FavoriteMovie;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JDialog;
import org.jdesktop.beansbinding.Converter;

/**
 * An input form for displaying and modifying the properties of a single
 * FavoriteMovie object.
 *
 * @author Vincent
 */
public class FavoriteMovieDialog extends JDialog {

    private boolean cancelled;
    
    public final FavoriteMovie getFavoriteMovie() {
        return favoriteMovie;
    }

    public final void setFavoriteMovie(FavoriteMovie fm) {
        if (fm != null) {
            favoriteMovie.setImdb(fm.getImdb());
            favoriteMovie.setTitle(fm.getTitle());
            favoriteMovie.setReleaseDate(fm.getReleaseDate());
            favoriteMovie.setDirector(fm.getDirector());
            favoriteMovie.setWriter(fm.getWriter());
            favoriteMovie.setGross(fm.getGross());
            favoriteMovie.setNominations(fm.getNominations());
        }
    }

    /**
     * Creates new form FavoriteMovieDialog
     *
     * @param parent The JFrame that owns this dialog
     * @param modal If true, input to the owner JFrame is restricted until this
     * dialog is dismissed.
     */
    public FavoriteMovieDialog(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    /**
     * Creates new form FavoriteMovieDialog
     *
     * @param parent The JFrame that owns this dialog
     * @param modal If true, input to the owner JFrame is restricted until this
     * @param fm The FavoriteMovie to initialize the dialog with. dialog is
     * dismissed.
     */
    public FavoriteMovieDialog(java.awt.Frame parent, boolean modal, FavoriteMovie fm) {
        super(parent, modal);
        initComponents();
        setFavoriteMovie(fm);

        okJButton.setEnabled(isValidMovie());
        cancelled = true;
    }

    /**
     * 
     * @return 
     */
    public FavoriteMovieDialog setDefaultButtonAndPack() {
        getRootPane().setDefaultButton(okJButton);
        pack();
        return this;
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

        favoriteMovie = new edu.metrostate.ics240.vjp071.listofthings.FavoriteMovie();
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
        imdbJTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteMovie, org.jdesktop.beansbinding.ELProperty.create("${imdb}"), imdbJTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        imdbJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FavoriteMovieDialog.this.keyReleased(evt);
            }
        });

        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleJLabel.setText("Title:");
        titleJLabel.setToolTipText("This movie's title");

        titleJTextField.setToolTipText("Please enter the title of this movie, required. Limit 255 characters.");
        titleJTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteMovie, org.jdesktop.beansbinding.ELProperty.create("${title}"), titleJTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        titleJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FavoriteMovieDialog.this.keyReleased(evt);
            }
        });

        releaseYearJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        releaseYearJLabel.setText("Release Date:");
        releaseYearJLabel.setToolTipText("The date this movie was released in theaters.");

        releaseYearJTextField.setToolTipText("Please enter the year, month, and day this movie was released in theaters (yyyy-MM-dd), if any.");
        releaseYearJTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteMovie, org.jdesktop.beansbinding.ELProperty.create("${releaseDate}"), releaseYearJTextField, org.jdesktop.beansbinding.BeanProperty.create("text_ON_ACTION_OR_FOCUS_LOST"));
        binding.setConverter(new Converter<java.time.LocalDate, java.lang.String>()
            {

                @Override
                public java.lang.String convertForward(java.time.LocalDate value)
                {
                    if (value == null) {
                        return null;
                    }

                    return String.format("%s", value);
                }

                @Override
                public java.time.LocalDate convertReverse(java.lang.String value)
                {
                    java.time.LocalDate releaseDate;

                    if (value == null) {
                        releaseDate = null;
                    } else {
                        try {
                            value = value.trim();

                            releaseDate = LocalDate.parse(value);
                        } catch (DateTimeParseException ex) {
                            releaseDate = null;
                        }
                    }
                    return releaseDate;
                }
            }
        );
        bindingGroup.addBinding(binding);

        releaseYearJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FavoriteMovieDialog.this.keyReleased(evt);
            }
        });

        directorJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        directorJLabel.setText("Director:");
        directorJLabel.setToolTipText("The director of this movie.");

        directorJTextField.setToolTipText("Please enter the name of the director for this movie, if any. Limit 120 characters.");
        directorJTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteMovie, org.jdesktop.beansbinding.ELProperty.create("${director}"), directorJTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        directorJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FavoriteMovieDialog.this.keyReleased(evt);
            }
        });

        writerJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        writerJLabel.setText("Writer:");
        writerJLabel.setToolTipText("The writer of this movie.");

        writerJTextField.setToolTipText("Please enter the name of the writer for this movie, if any. Limit 120 characters.");
        writerJTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteMovie, org.jdesktop.beansbinding.ELProperty.create("${writer}"), writerJTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        writerJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FavoriteMovieDialog.this.keyReleased(evt);
            }
        });

        grossJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        grossJLabel.setText("Box Office Gross:");
        grossJLabel.setToolTipText("Gross sales at the box-office for this movie.");

        grossJTextField.setToolTipText("Please enter the Box Office Gross for this movie, if any.");
        grossJTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteMovie, org.jdesktop.beansbinding.ELProperty.create("${gross}"), grossJTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(new Converter<java.lang.Double, java.lang.String>()
            {

                @Override
                public java.lang.String convertForward(java.lang.Double value)
                {
                    if (value == null) {
                        return null;
                    }

                    return String.format("%.2f", value);
                }

                @Override
                public java.lang.Double convertReverse(java.lang.String value)
                {
                    java.lang.Double gross;

                    if (value == null) {
                        gross = null;
                    } else {
                        try {
                            value = value.trim();

                            gross = Double.parseDouble(value);
                        } catch (NumberFormatException ex) {
                            gross = null;
                        }
                    }
                    return gross;
                }
            }
        );
        bindingGroup.addBinding(binding);

        grossJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FavoriteMovieDialog.this.keyReleased(evt);
            }
        });

        nominationsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nominationsJLabel.setText("Oscar Nominations:");
        nominationsJLabel.setToolTipText("The total number of Oscar nominations this movie received.");

        nominationsJTextField.setToolTipText("Please enter the number of Oscar nominations this movie received, if any.");
        nominationsJTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteMovie, org.jdesktop.beansbinding.ELProperty.create("${nominations}"), nominationsJTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        nominationsJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FavoriteMovieDialog.this.keyReleased(evt);
            }
        });

        okJButton.setText("OK");
        okJButton.setToolTipText("Press OK to add or update this movie in the collection.");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, titleJTextField, org.jdesktop.beansbinding.ELProperty.create("${text.size > 0}"), okJButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        okJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Click cancel to dismiss this dialog and disregard any pending changes.");
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
                    .addComponent(titleJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(releaseYearJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(directorJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(writerJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grossJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nominationsJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imdbJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imdbJLabel)
                    .addComponent(imdbJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleJLabel)
                    .addComponent(titleJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(releaseYearJLabel)
                    .addComponent(releaseYearJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directorJLabel)
                    .addComponent(directorJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(writerJLabel)
                    .addComponent(writerJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grossJLabel)
                    .addComponent(grossJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nominationsJLabel)
                    .addComponent(nominationsJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        if (isValidMovie()) {
            cancelled = false;

            dispose();
        }
    }//GEN-LAST:event_okJButtonActionPerformed

    public boolean isCancelled() {
        return cancelled;
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void keyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyReleased
        // TODO add your handling code here:
        if (isValidMovie()) {
            okJButton.setEnabled(true);
        } else {
            okJButton.setEnabled(false);
        }
    }//GEN-LAST:event_keyReleased

    private boolean isValidMovie() {
        Integer imdb;
        String title;
        String releaseDateString;
        String director;
        String writer;
        Double gross;
        Integer nominations;

        boolean validated = true;

        imdb = favoriteMovie.getImdb();

        if (imdb != null && imdb < 0) {
            validated = false;
        }

        title = favoriteMovie.getTitle();

        if (title == null || title.trim().isEmpty()) {
            validated = false;
        } else {
            title = title.trim();

            if (title.length() > 255) {
                validated = false;
            }
        }

        if (releaseYearJTextField.getDocument() != null) {
            releaseDateString = releaseYearJTextField.getText();

            if (releaseDateString != null && !releaseDateString.trim().isEmpty()) {
                try {
                    releaseDateString = releaseDateString.trim();

                    LocalDate ld = LocalDate.parse(releaseDateString);
                } catch (DateTimeParseException ex) {
                    validated = false;
                }
            }
        }

        director = favoriteMovie.getDirector();

        if (director != null && !director.trim().isEmpty()) {
            director = director.trim();

            if (director.length() > 120) {
                validated = false;
            }
        }

        writer = favoriteMovie.getWriter();

        if (writer != null && !writer.trim().isEmpty()) {
            writer = writer.trim();

            if (writer.length() > 120) {
                validated = false;
            }
        }

        if (grossJTextField.getDocument() != null) {
            String grossString = grossJTextField.getText();

            if (grossString != null && !grossString.trim().isEmpty()) {
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

        nominations = favoriteMovie.getNominations();

        if (nominations != null && nominations < 0) {
            validated = false;
        }
        return validated;
    }

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
        java.awt.EventQueue.invokeLater(() -> {
            FavoriteMovieDialog dialog = new FavoriteMovieDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setDefaultButtonAndPack();
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel directorJLabel;
    private javax.swing.JTextField directorJTextField;
    private edu.metrostate.ics240.vjp071.listofthings.FavoriteMovie favoriteMovie;
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