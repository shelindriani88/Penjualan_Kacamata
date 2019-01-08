/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoop.service;

import javaoop.entity.HargaKacamata;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fachr
 */
public interface ServiceKacamata {
    
    public void insertKacamata(HargaKacamata m) throws SQLException;
    public void updateKacamata(HargaKacamata m) throws SQLException;
    public void deleteKacamata(HargaKacamata m) throws SQLException;
    public HargaKacamata getKacamataBykode(String nim) throws SQLException;
    public ArrayList<HargaKacamata> getKacamata() throws SQLException;
    
}
