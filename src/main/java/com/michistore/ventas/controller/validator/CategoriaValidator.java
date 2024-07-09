package com.michistore.ventas.controller.validator;

import com.michistore.ventas.dao.DaoCategoria;
import com.michistore.ventas.dao.impl.DaoCategoriaImpl;
import com.michistore.ventas.entidades.Categoria;
import com.michistore.ventas.util.Utilitario;
import com.michistore.ventas.view.CategoryFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhon_
 */
public class CategoriaValidator {

    CategoryFrame frame;
    DaoCategoria dao;
    DefaultTableModel tableModel;
    boolean insUpd;
    Categoria categoria;

    public CategoriaValidator(CategoryFrame frame) {
        this.frame = frame;
        dao = new DaoCategoriaImpl();
        categoria = new Categoria();
        tableModel = (DefaultTableModel) frame.tableCategory.getModel();
        tableModel.addColumn(Utilitario.bundle.getString("crud.lbl.id"));
        tableModel.addColumn(Utilitario.bundle.getString("category.lbl.name"));
        tableModel.addColumn(Utilitario.bundle.getString("category.lbl.desc"));
        frame.tableCategory.setModel(tableModel);
        formEnable(false);
    }

    public void categoriaSel() {
        try {
            tableModel.setRowCount(0);
            dao.selectAll().forEach(e -> {
                tableModel.addRow(new Object[]{e.getId(), e.getNombre(), e.getDescripcion()});
            });
        } catch (Exception e) {
            Utilitario.errorMessage(dao.getMessage());
        }
    }

    private void formEnable(boolean opcion) {
        frame.btnCatAdd.setEnabled(!opcion);
        frame.btnCatEdit.setEnabled(!opcion);
        frame.btnCatDelete.setEnabled(!opcion);
        frame.txtCatName.setEnabled(opcion);
        frame.txtCatDesc.setEnabled(opcion);
        frame.btnCatConfirm.setEnabled(opcion);
        frame.btnCatCancel.setEnabled(opcion);
    }

    public void categoriaAdd() {
        formEnable(true);
        insUpd = true;
    }

    public void cancel() {
        formEnable(false);
        cleanFields();
    }

    public void categoriaEdit() {
        int row = frame.tableCategory.getSelectedRow();
        if (row == -1) {
            Utilitario.noRowSelectedMessage();
            return;
        }
        categoria.setId(Utilitario.getIdOfTable(row, frame.tableCategory));
        frame.txtCatName.setText(frame.tableCategory.getValueAt(row, 1).toString());
        frame.txtCatDesc.setText(frame.tableCategory.getValueAt(row, 2) == null
                ? null
                : frame.tableCategory.getValueAt(row, 2).toString());
        formEnable(true);
        insUpd = false;
    }

    public void categoriaDel() {
        int row = frame.tableCategory.getSelectedRow();
        if (row == -1) {
            Utilitario.noRowSelectedMessage();
            return;
        }
        try {
            dao.delete(
                    Utilitario.getIdOfTable(row, frame.tableCategory)
            );
            if (dao.getMessage() != null) {
                Utilitario.errorMessage(dao.getMessage());
            } else {
                categoriaSel();
            }
        } catch (Exception e) {
            Utilitario.errorMessage(dao.getMessage());
        }
    }

    private void cleanFields() {
        frame.txtCatDesc.setText(null);
        frame.txtCatName.setText(null);
    }

    public void categoriaConfirm() {
        try {
            categoria.setNombre(frame.txtCatName.getText());
            categoria.setDescripcion(frame.txtCatDesc.getText());
            if (insUpd) {
                dao.insert(categoria);
                categoriaSel();
                formEnable(false);
            } else {
                dao.update(categoria);
                categoriaSel();
                formEnable(false);
            }
            categoria = new Categoria();
            cleanFields();
        } catch (Exception e) {
            Utilitario.errorMessage(dao.getMessage());
        }
    }

}
