/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoop.entity;

/**
 *
 * @author fachr
 */
public class HargaKacamata extends Menu{
    
    private String kode;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }        
  public void showMahasiswa(){
        System.out.println("==Mahasiswa==");
        System.out.println("Kode:" + kode);
        System.out.println("Nama:" + super.getNama());
    }  
}
