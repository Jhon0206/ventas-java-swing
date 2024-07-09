/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.michistore.ventas.view;

/**
 *
 * @author jhon_
 */
public class CategoryFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoryFrame
     */
    public CategoryFrame() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        lblCategoryTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCatName = new javax.swing.JLabel();
        txtCatName = new javax.swing.JTextField();
        lblCatDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCatDesc = new javax.swing.JTextArea();
        btnCatConfirm = new javax.swing.JButton();
        btnCatCancel = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCategory = new javax.swing.JTable();
        btnCatAdd = new javax.swing.JButton();
        btnCatDelete = new javax.swing.JButton();
        btnCatEdit = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblCategoryTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("bundles/text"); // NOI18N
        lblCategoryTitle.setText(bundle.getString("category.title")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(lblCategoryTitle, gridBagConstraints);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMinimumSize(new java.awt.Dimension(3, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(3, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jSeparator1, gridBagConstraints);

        lblCatName.setText(bundle.getString("category.lbl.name")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 5, 15);
        getContentPane().add(lblCatName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        getContentPane().add(txtCatName, gridBagConstraints);

        lblCatDesc.setText(bundle.getString("category.lbl.desc")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        getContentPane().add(lblCatDesc, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(16, 100));

        txtCatDesc.setColumns(20);
        txtCatDesc.setRows(5);
        jScrollPane1.setViewportView(txtCatDesc);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 10, 15);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btnCatConfirm.setText(bundle.getString("crud.actions.confirm")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnCatConfirm, gridBagConstraints);

        btnCatCancel.setText(bundle.getString("crud.actions.cancel")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnCatCancel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        getContentPane().add(filler1, gridBagConstraints);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(240, 240));

        tableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableCategory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        btnCatAdd.setText(bundle.getString("crud.actions.add")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnCatAdd, gridBagConstraints);

        btnCatDelete.setText(bundle.getString("crud.actions.delete")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnCatDelete, gridBagConstraints);

        btnCatEdit.setText(bundle.getString("crud.actions.edit")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(btnCatEdit, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        getContentPane().add(filler2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCatAdd;
    public javax.swing.JButton btnCatCancel;
    public javax.swing.JButton btnCatConfirm;
    public javax.swing.JButton btnCatDelete;
    public javax.swing.JButton btnCatEdit;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCatDesc;
    private javax.swing.JLabel lblCatName;
    private javax.swing.JLabel lblCategoryTitle;
    public javax.swing.JTable tableCategory;
    public javax.swing.JTextArea txtCatDesc;
    public javax.swing.JTextField txtCatName;
    // End of variables declaration//GEN-END:variables
}
