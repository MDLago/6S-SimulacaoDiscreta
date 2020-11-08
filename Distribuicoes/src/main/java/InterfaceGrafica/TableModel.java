/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Core.Sistema;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class TableModel extends AbstractTableModel{
    
    private final String[] colunas = {"Tempo","Entidade Entraram","Tamanho Fila","Recurso Livre","Tempo Atendimento","Entidades Sairam", "Max Entidades no Sistema"};
    private final Sistema sistema;

    public TableModel(Sistema sistema) {
        this.sistema = sistema;
    }

    @Override
    public int getRowCount() {
       return sistema.getTempo();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0: return sistema.getTempo();
            case 1: return sistema.getEntidadeEntraram();
            case 2: return sistema.getQtdFila().size();
            case 3: return sistema.rec.isRecursoLivre();
            case 4: return sistema.rec.getContador();
            case 5: return sistema.getEntidadeSairam();
            case 6: return sistema.getQtdMaximoEntidadeDentro();
        }
        return null;
    }
    
}
