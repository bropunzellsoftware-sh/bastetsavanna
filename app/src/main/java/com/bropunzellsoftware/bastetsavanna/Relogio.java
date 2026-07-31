package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.os.SystemClock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class Relogio {

    private Relogio() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica suporte ao relógio
     * do sistema.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Relógio do sistema não exige
     * permissão.
     */
    public static boolean temPermissao(
            Context context
    ) {

        return true;

    }


    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // DATA E HORA
    // ==========================

    /**
     * Retorna timestamp atual.
     */
    public static long timestamp() {

        return System.currentTimeMillis();

    }


    /**
     * Retorna data formatada.
     */
    public static String data() {

        SimpleDateFormat formato =
                new SimpleDateFormat(
                        "dd/MM/yyyy",
                        Locale.getDefault()
                );


        return formato.format(
                new Date()
        );

    }


    /**
     * Retorna hora formatada.
     */
    public static String hora() {

        SimpleDateFormat formato =
                new SimpleDateFormat(
                        "HH:mm:ss",
                        Locale.getDefault()
                );


        return formato.format(
                new Date()
        );

    }


    /**
     * Retorna data e hora completa.
     */
    public static String completo() {

        SimpleDateFormat formato =
                new SimpleDateFormat(
                        "dd/MM/yyyy HH:mm:ss",
                        Locale.getDefault()
                );


        return formato.format(
                new Date()
        );

    }


    // ==========================
    // SISTEMA
    // ==========================

    /**
     * Tempo desde inicialização
     * do aparelho.
     */
    public static long uptime() {

        return SystemClock.elapsedRealtime();

    }


    /**
     * Retorna fuso horário atual.
     */
    public static String fuso() {

        return TimeZone
                .getDefault()
                .getID();

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}