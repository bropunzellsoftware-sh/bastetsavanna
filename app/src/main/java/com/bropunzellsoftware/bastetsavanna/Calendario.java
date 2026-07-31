package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

public final class Calendario {

    public static final int REQUEST_CODE = 1013;

    private Calendario() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Calendário é um recurso lógico.
     */
    public static boolean possui(Context context) {
        return true;
    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Permissão para visualizar eventos.
     */
    public static boolean temLeitura(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_CALENDAR
        );

    }


    /**
     * Permissão para criar e alterar eventos.
     */
    public static boolean temEscrita(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.WRITE_CALENDAR
        );

    }


    /**
     * Verifica todas as permissões.
     */
    public static boolean temPermissao(Activity activity) {

        return temLeitura(activity)
                && temEscrita(activity);

    }


    /**
     * Solicita acesso ao calendário.
     */
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                new String[]{

                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.WRITE_CALENDAR

                },
                REQUEST_CODE
        );

    }


    /**
     * Verifica se deve explicar.
     */
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.READ_CALENDAR
        );

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Calendário pronto para utilização.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}