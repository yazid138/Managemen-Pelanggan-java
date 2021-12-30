/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yazid.model.data;

import java.util.ArrayList;

/**
 *
 * @author ma39i
 */
public class Pelanggan {
    private String id;
    private String nama;
    private String tahunLahir;
    private String jenis;

    public Pelanggan(String id, String nama, String tahunLahir, String jenis) {
        this.id = id;
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.jenis = jenis;
    }
    
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTahunLahir() {
        return tahunLahir;
    }

    public String getJenis() {
        return jenis;
    }
    
    
}
