/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoop.dao;

import com.mysql.jdbc.Connection;
import javaoop.config.Koneksi;
import javaoop.entity.HargaKacamata;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaoop.service.ServiceKacamata;

/**
 *
 * @author fachr DAO = Data Access Object
 */
public class DaoKacamata implements ServiceKacamata {

    private Connection connection;

    public DaoKacamata() throws SQLException {
        connection = Koneksi.getConnection();
    }

    @Override
    public void insertKacamata(HargaKacamata m) throws SQLException {
        PreparedStatement st = null;
        String sql = "INSERT INTO kacamata VALUE(?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, m.getKode());
            st.setString(2, m.getNama());
            st.setString(3, m.getHarga());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public void updateKacamata(HargaKacamata m) throws SQLException {
        PreparedStatement st = null;
        String sql = "UPDATE kacamata SET nama=?, harga=? WHERE kode=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, m.getNama());
            st.setString(2, m.getHarga());
            st.setString(3, m.getKode());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public void deleteKacamata(HargaKacamata m) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM kacamata WHERE kode=?";

        try {
            st = connection.prepareCall(sql);
            st.setString(1, m.getKode());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public HargaKacamata getKacamataBykode(String kode) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        HargaKacamata m = null;
        String sql = "SELECT * FROM kacamata WHERE kode=?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, kode);
            rs = st.executeQuery();
            while (rs.next()) {
                m = new HargaKacamata();
                m.setKode(rs.getString("kode"));
                m.setNama(rs.getString("nama"));
                m.setHarga(rs.getString("harga"));
            }
            return m;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    @Override
    public ArrayList<HargaKacamata> getKacamata() throws SQLException {
        PreparedStatement st = null;
        ArrayList<HargaKacamata> listKacamata = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM kacamata";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                HargaKacamata m = new HargaKacamata();
                m.setKode(rs.getString("kode"));
                m.setNama(rs.getString("nama"));
                m.setHarga(rs.getString("harga"));
                listKacamata.add(m);
            }
            return listKacamata;
        } catch (SQLException e) {
            throw e;
        } finally {
            if(st != null){
                st.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }

}
