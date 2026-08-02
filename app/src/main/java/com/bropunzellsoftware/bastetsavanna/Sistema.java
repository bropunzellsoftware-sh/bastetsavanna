package com.bropunzellsoftware.bastetsavanna.acesso;

import android.os.Build;

public final class Sistema {

    private Sistema() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

   
    public static boolean temPermissao() {

        return true;

    }


    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // INFORMAÇÕES
    // ==========================

    
    public static int androidAPI() {

        return Build.VERSION.SDK_INT;

    }


    
    public static String androidVersao() {

        return Build.VERSION.RELEASE;

    }


   
    public static String fabricante() {

        return Build.MANUFACTURER;

    }


   
    public static String marca() {

        return Build.BRAND;

    }


  
    public static String modelo() {

        return Build.MODEL;

    }


    
    public static String dispositivo() {

        return Build.DEVICE;

    }


   
    public static String produto() {

        return Build.PRODUCT;

    }


   
    public static String identificacao() {

        return fabricante()
                + " "
                + modelo();

    }


    
    public static boolean androidModerno() {

        return Build.VERSION.SDK_INT
                >= Build.VERSION_CODES.O;

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}