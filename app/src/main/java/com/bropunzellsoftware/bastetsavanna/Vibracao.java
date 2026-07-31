package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public final class Vibracao {

    private Vibracao() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui
     * motor de vibração.
     */
    public static boolean possui(Context context) {

        Vibrator vibrator =
                (Vibrator)
                        context.getSystemService(
                                Context.VIBRATOR_SERVICE
                        );

        return vibrator != null
                && vibrator.hasVibrator();

    }


    /**
     * Verifica suporte a vibração avançada.
     */
    public static boolean possuiEfeito(Context context) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return false;
        }

        Vibrator vibrator =
                (Vibrator)
                        context.getSystemService(
                                Context.VIBRATOR_SERVICE
                        );

        return vibrator != null
                && vibrator.areEffectsSupported(
                        VibrationEffect.EFFECT_CLICK
                )
                != Vibrator.VIBRATION_EFFECT_SUPPORT_NO;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Vibração utiliza permissão normal.
     * Não precisa solicitação em runtime.
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
     * Vibração disponível.
     */
    public static boolean disponivel(Context context) {

        return possui(context);

    }

}