/* package com.bropunzellsoftware.bastetsavanna.acesso;

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

    
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    
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

   
    public static long timestamp() {

        return System.currentTimeMillis();

    }


    
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

    
    public static long uptime() {

        return SystemClock.elapsedRealtime();

    }


    
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

} */