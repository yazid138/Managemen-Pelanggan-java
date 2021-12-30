/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yazid.model.data;

import com.yazid.db.DbService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ma39i
 */
public class PelangganService {

    private static Statement statement;
    private ArrayList<Pelanggan> pelangganList;

    public ArrayList<Pelanggan> all() {
        pelangganList = new ArrayList<>();
        try {
            String query = "SELECT * FROM data";
            ResultSet result = DbService.get(query);
            while (result.next()) {
                pelangganList.add(new Pelanggan(
                        result.getString("id"),
                        result.getString("nama"),
                        result.getString("tahun_lahir"),
                        result.getString("jenis")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DbService.closeStatement();
        }
        return pelangganList;
    }

    public ArrayList<Pelanggan> where(String where) {
        pelangganList = new ArrayList<>();
        try {
            String query = "SELECT * FROM data WHERE " + where;
            ResultSet result = DbService.get(query);
            while (result.next()) {
                pelangganList.add(new Pelanggan(
                        result.getString("id"),
                        result.getString("nama"),
                        result.getString("tahun_lahir"),
                        result.getString("jenis")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DbService.closeStatement();
        }
        return pelangganList;
    }

    public boolean delete(String id) {
        try {
            String query = "DELETE FROM data WHERE id = '" + id + "'";
            int deleted = DbService.query(query);
            if (deleted > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DbService.closeStatement();
        }
        return false;
    }

    public boolean insert(Pelanggan pelanggan) {
        try {
            Connection conn = DbService.openConnection();
            String query = "INSERT INTO data(id, nama, tahun_lahir, jenis) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, pelanggan.getId());
            statement.setString(2, pelanggan.getNama());
            statement.setString(3, pelanggan.getTahunLahir());
            statement.setString(4, pelanggan.getJenis());
            int created = statement.executeUpdate();
            if (created > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DbService.closeStatement();
        }
        return false;
    }
}
