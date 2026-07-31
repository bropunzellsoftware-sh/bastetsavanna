package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class Notificacoes {

    public static final int REQUEST_CODE = 1011;

    private Notificacoes() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Todo Android moderno possui sistema
     * de notificações.
     */
    public static boolean possui(Context context) {
        return true;
    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Android 13+ exige permissão.
     */
    public static boolean temPermissao(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return true;
        }

        return Permissao.verificar(
                activity,
                Manifest.permission.POST_NOTIFICATIONS
        );

    }


    /**
     * Solicita permissão de notificações.
     */
    public static void solicitar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            Permissao.solicitar(
                    activity,
                    Manifest.permission.POST_NOTIFICATIONS,
                    REQUEST_CODE
            );

        }

    }


    /**
     * Verifica se deve explicar.
     */
    public static boolean deveExplicar(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return false;
        }

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.POST_NOTIFICATIONS
        );

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Notificações podem ser utilizadas.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}