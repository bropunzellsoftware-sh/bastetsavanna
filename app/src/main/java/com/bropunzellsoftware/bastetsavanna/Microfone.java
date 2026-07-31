package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

public final class Microfone {

    public static final int REQUEST_CODE = 1002;

    private Microfone() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui microfone.
     */
    public static boolean possui(Context context) {
        return Hardware.possuiMicrofone(context);
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Verifica se a permissão foi concedida.
     */
    public static boolean temPermissao(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.RECORD_AUDIO
        );

    }

    /**
     * Solicita a permissão do microfone.
     */
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                Manifest.permission.RECORD_AUDIO,
                REQUEST_CODE
        );

    }

    /**
     * Verifica se o Android recomenda
     * mostrar uma explicação.
     */
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.RECORD_AUDIO
        );

    }

    // ==========================
    // ESTADO
    // ==========================

    /**
     * Retorna true quando o microfone
     * pode ser utilizado.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}