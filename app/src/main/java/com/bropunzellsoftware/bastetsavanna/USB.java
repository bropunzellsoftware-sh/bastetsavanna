package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;

public final class USB {

    private USB() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica suporte a USB Host (OTG).
     */
    public static boolean possuiHost(Context context) {

        return Hardware.possuiUSBHost(context);

    }


    /**
     * Verifica suporte a USB Accessory.
     */
    public static boolean possuiAccessory(Context context) {

        return Hardware.possuiUSBAccessory(context);

    }


    /**
     * Verifica se possui algum suporte USB.
     */
    public static boolean possui(Context context) {

        return possuiHost(context)
                || possuiAccessory(context);

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * USB não utiliza permissão runtime.
     */
    public static boolean temPermissao(Context context) {

        return true;

    }


    /**
     * A autorização USB é concedida
     * por dispositivo conectado.
     */
    public static void solicitar() {

        // Controle feito pelo sistema Android.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * USB disponível para utilização.
     */
    public static boolean disponivel(Context context) {

        return possui(context);

    }

}