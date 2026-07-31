package com.bropunzellsoftware.bastetsavanna.acesso;

import android.os.Build;

public final class Sistema {

    private Sistema() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Sistema Android disponível.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Informações do sistema não precisam de permissão.
     */
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

    /**
     * Versão do Android em número.
     */
    public static int androidAPI() {

        return Build.VERSION.SDK_INT;

    }


    /**
     * Nome da versão Android.
     */
    public static String androidVersao() {

        return Build.VERSION.RELEASE;

    }


    /**
     * Fabricante do aparelho.
     */
    public static String fabricante() {

        return Build.MANUFACTURER;

    }


    /**
     * Marca do aparelho.
     */
    public static String marca() {

        return Build.BRAND;

    }


    /**
     * Modelo comercial.
     */
    public static String modelo() {

        return Build.MODEL;

    }


    /**
     * Nome do dispositivo.
     */
    public static String dispositivo() {

        return Build.DEVICE;

    }


    /**
     * Produto interno.
     */
    public static String produto() {

        return Build.PRODUCT;

    }


    /**
     * Identificação completa.
     */
    public static String identificacao() {

        return fabricante()
                + " "
                + modelo();

    }


    /**
     * Verifica se é Android recente.
     */
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