package com.bropunzellsoftware.bastetsavanna.acesso;

import android.app.ActivityManager;
import android.content.Context;

public final class Memoria {

    private Memoria() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui memória RAM.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Memória do sistema não necessita permissão.
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
     * Retorna memória RAM total em bytes.
     */
    public static long total(Context context) {

        ActivityManager manager =
                (ActivityManager)
                        context.getSystemService(
                                Context.ACTIVITY_SERVICE
                        );


        if (manager == null)
            return -1;


        ActivityManager.MemoryInfo info =
                new ActivityManager.MemoryInfo();


        manager.getMemoryInfo(info);


        return info.totalMem;

    }


    /**
     * Retorna memória RAM disponível em bytes.
     */
    public static long disponivel(Context context) {

        ActivityManager manager =
                (ActivityManager)
                        context.getSystemService(
                                Context.ACTIVITY_SERVICE
                        );


        if (manager == null)
            return -1;


        ActivityManager.MemoryInfo info =
                new ActivityManager.MemoryInfo();


        manager.getMemoryInfo(info);


        return info.availMem;

    }


    /**
     * Retorna memória utilizada em bytes.
     */
    public static long utilizada(Context context) {

        long total = total(context);
        long livre = disponivel(context);


        if (total < 0 || livre < 0)
            return -1;


        return total - livre;

    }


    /**
     * Retorna RAM total em GB.
     */
    public static double totalGB(Context context) {

        return total(context)
                /
                (1024.0 * 1024.0 * 1024.0);

    }


    /**
     * Retorna RAM disponível em GB.
     */
    public static double disponivelGB(Context context) {

        return disponivel(context)
                /
                (1024.0 * 1024.0 * 1024.0);

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(Context context) {

        return possui();

    }

}