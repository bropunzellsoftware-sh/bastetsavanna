/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;

public final class USB {

    private USB() {
    }


    // ==========================
    // HARDWARE
    // ==========================

   
    public static boolean possuiHost(Context context) {

        return Hardware.possuiUSBHost(context);

    }


    
    public static boolean possuiAccessory(Context context) {

        return Hardware.possuiUSBAccessory(context);

    }


   
    public static boolean possui(Context context) {

        return possuiHost(context)
                || possuiAccessory(context);

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    
    public static boolean temPermissao(Context context) {

        return true;

    }


    
    public static void solicitar() {

        // Controle feito pelo sistema Android.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    
    public static boolean disponivel(Context context) {

        return possui(context);

    }

} */