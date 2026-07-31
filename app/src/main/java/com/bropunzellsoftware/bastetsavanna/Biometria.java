package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import androidx.biometric.BiometricManager;

public final class Biometria {

    private Biometria() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui
     * algum sistema biométrico disponível.
     */
    public static boolean possui(Context context) {

        BiometricManager manager =
                BiometricManager.from(context);

        int resultado =
                manager.canAuthenticate(
                        BiometricManager.Authenticators
                                .BIOMETRIC_STRONG
                        |
                        BiometricManager.Authenticators
                                .BIOMETRIC_WEAK
                );

        return resultado ==
                BiometricManager.BIOMETRIC_SUCCESS;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Biometria não possui permissão runtime.
     */
    public static boolean temPermissao(Context context) {

        return true;

    }


    /**
     * Não existe solicitação de permissão.
     */
    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // TIPOS
    // ==========================

    /**
     * Verifica suporte a biometria forte.
     */
    public static boolean possuiForte(Context context) {

        BiometricManager manager =
                BiometricManager.from(context);

        return manager.canAuthenticate(
                BiometricManager.Authenticators
                        .BIOMETRIC_STRONG
        )
        == BiometricManager.BIOMETRIC_SUCCESS;

    }


    /**
     * Verifica suporte a biometria fraca.
     */
    public static boolean possuiFraca(Context context) {

        BiometricManager manager =
                BiometricManager.from(context);

        return manager.canAuthenticate(
                BiometricManager.Authenticators
                        .BIOMETRIC_WEAK
        )
        == BiometricManager.BIOMETRIC_SUCCESS;

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Biometria pronta para uso.
     */
    public static boolean disponivel(Context context) {

        return possui(context);

    }

}