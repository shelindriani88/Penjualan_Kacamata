/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoop.tablemodel;

import java.util.ArrayList;
import javaoop.entity.HargaKacamata;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fachr
 */
public class TableModelKacamata extends AbstractTableModel{
    
    private ArrayList<HargaKacamata> listKacamata = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listKacamata.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return listKacamata.get(rowIndex).getKode();
            case 1: return listKacamata.get(rowIndex).getNama();
            case 2: return listKacamata.get(rowIndex).getHarga();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Kode";
            case 1: return "Nama";
            case 2: return "Harga";
            default: return null;
        }
    }
    
    public void insertKacamata(HargaKacamata m){
        listKacamata.add(m);
        fireTableDataChanged();
    }
    
    public void updateKacamata(int index, HargaKacamata m){
        listKacamata.set(index, m);
        fireTableDataChanged();
    }
    
    public void deleteKacamata(int index){
        listKacamata.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<HargaKacamata> listKacamata){
        this.listKacamata = listKacamata;
        fireTableDataChanged();
    }
    
    public HargaKacamata getKacamata(int index){
        return listKacamata.get(index);
    }
    
    public void clear(){
        listKacamata.clear();
    }
    
    
    
    
    
}
