package br.com.sa.busca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class BuscaAvaTabelModel extends AbstractTableModel{
    //criando a lista para a tabela
    private List<BuscaAva> dados = new ArrayList<>();
    private String[] colunas = {"Nº","Data", "Id"};

    //para colocar o nome das colunas automaticamente;
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;

    }

    @Override

    //retornando os dados da busca
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getItem();
            case 1:
                return dados.get(linha).getData();
            case 2:
                return dados.get(linha).getIdava();

        }
        return null;

    }
    

    public void addRow(BuscaAva c) {//adiciona uma unica linha na tabela
        this.dados.add(c);
        this.fireTableDataChanged();

    }


    public void removeAll() {

        this.dados.removeAll(dados);
        this.fireTableDataChanged();
    }

    
}
