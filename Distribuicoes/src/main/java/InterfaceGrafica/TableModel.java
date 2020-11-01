/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class TableModel extends AbstractTableModel{
    
    private final String[] colunas = {"Entidade","Relogio","TEC","TS","Tempo Inicio Servico","Tempo Entidade Fila","Tempo Final Servico","Tempo Entidade Sistema","Tempo Livre Recurso"};

    @Override
    public int getRowCount() {
        
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
