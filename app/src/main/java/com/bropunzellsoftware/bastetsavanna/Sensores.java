package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;

public final class Sensores {

    private Sensores() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    public static boolean possui(Context context) {

        return possuiAcelerometro(context)
                || possuiGiroscopio(context)
                || possuiMagnetometro(context);

    }


    public static boolean possuiAcelerometro(Context context) {

        return Hardware.possuiAcelerometro(context);

    }


    public static boolean possuiGiroscopio(Context context) {

        return Hardware.possuiGiroscopio(context);

    }


    public static boolean possuiMagnetometro(Context context) {

        return Hardware.possuiMagnetometro(context);

    }


    public static boolean possuiBarometro(Context context) {

        return Hardware.possuiBarometro(context);

    }


    public static boolean possuiSensorLuz(Context context) {

        return Hardware.possuiLuz(context);

    }


    public static boolean possuiProximidade(Context context) {

        return Hardware.possuiProximidade(context);

    }


    public static boolean possuiGravidade(Context context) {

        return Hardware.possuiGravidade(context);

    }


    public static boolean possuiRotacao(Context context) {

        return Hardware.possuiRotacao(context);

    }


    public static boolean possuiUmidade(Context context) {

        return Hardware.possuiUmidade(context);

    }


    public static boolean possuiTemperatura(Context context) {

        return Hardware.possuiTemperatura(context);

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Sensores comuns não precisam de permissão.
     */
    public static boolean temPermissao(Context context) {

        return true;

    }


    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Algum sensor está disponível.
     */
    public static boolean disponivel(Context context) {

        return possui(context);

    }


    /**
     * Verifica se todos os sensores principais existem.
     */
    public static boolean pacoteCompleto(Context context) {

        return possuiAcelerometro(context)
                && possuiGiroscopio(context)
                && possuiMagnetometro(context);

    }

}