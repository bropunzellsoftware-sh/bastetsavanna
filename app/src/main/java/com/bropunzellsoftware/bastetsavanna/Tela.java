package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class Tela {

    private Tela() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Todo dispositivo Android possui uma tela
     * ou sistema de saída gráfica.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Informações da tela não precisam de permissão.
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

    private static DisplayMetrics metricas(Context context) {

        WindowManager wm =
                (WindowManager)
                        context.getSystemService(
                                Context.WINDOW_SERVICE
                        );


        Display display =
                wm.getDefaultDisplay();


        DisplayMetrics metrics =
                new DisplayMetrics();


        display.getMetrics(metrics);


        return metrics;

    }


    /**
     * Largura em pixels.
     */
    public static int largura(Context context) {

        return metricas(context).widthPixels;

    }


    /**
     * Altura em pixels.
     */
    public static int altura(Context context) {

        return metricas(context).heightPixels;

    }


    /**
     * Densidade da tela.
     */
    public static float densidade(Context context) {

        return metricas(context).density;

    }


    /**
     * DPI aproximado.
     */
    public static int dpi(Context context) {

        return metricas(context).densityDpi;

    }


    /**
     * Resolução completa.
     */
    public static String resolucao(Context context) {

        return largura(context)
                + "x"
                + altura(context);

    }


    /**
     * Verifica orientação horizontal.
     */
    public static boolean horizontal(Context context) {

        return largura(context)
                >
                altura(context);

    }


    /**
     * Verifica orientação vertical.
     */
    public static boolean vertical(Context context) {

        return altura(context)
                >
                largura(context);

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}