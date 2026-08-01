/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class Wifi {

    public static final int REQUEST_CODE = 1010;

    private Wifi() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui Wi-Fi.
     */
    public static boolean possui(Context context) {
        return Hardware.possuiWifi(context);
    } 

    /**
     * Verifica se possui Wi-Fi Direct.
     */
    public static boolean possuiDirect(Context context) {
        return Hardware.possuiWifiDirect(context);
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Para escanear redes Wi-Fi, o Android exige
     * permissão de localização.
     */
    public static boolean temPermissao(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

            return Permissao.verificar(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION
            );

        }

        return true;
    }

    /**
     * Solicita a permissão necessária.
     */
    public static void solicitar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

            Permissao.solicitar(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    REQUEST_CODE
            );

        }

    }

    /**
     * Verifica se o Android recomenda
     * exibir uma justificativa.
     */
    public static boolean deveExplicar(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            return false;
        }

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
        );

    }

    // ==========================
    // ESTADO
    // ==========================

    /**
     * Retorna true quando o Wi-Fi pode ser utilizado.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

} */