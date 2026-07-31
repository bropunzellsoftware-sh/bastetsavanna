package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class Bluetooth {

    public static final int REQUEST_CODE = 1009;

    private Bluetooth() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    public static boolean possui(Context context) {
        return Hardware.possuiBluetooth(context);
    }

    public static boolean possuiBLE(Context context) {
        return Hardware.possuiBluetoothLE(context);
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Android 12+ (API 31)
     */
    public static boolean temConectar(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S)
            return true;

        return Permissao.verificar(
                activity,
                Manifest.permission.BLUETOOTH_CONNECT
        );

    }

    /**
     * Android 12+ (API 31)
     */
    public static boolean temEscanear(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S)
            return true;

        return Permissao.verificar(
                activity,
                Manifest.permission.BLUETOOTH_SCAN
        );

    }

    /**
     * Android 12+ (API 31)
     */
    public static boolean temAnunciar(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S)
            return true;

        return Permissao.verificar(
                activity,
                Manifest.permission.BLUETOOTH_ADVERTISE
        );

    }

    /**
     * Verifica se todas as permissões necessárias foram concedidas.
     */
    public static boolean temPermissao(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            return temConectar(activity)
                    && temEscanear(activity)
                    && temAnunciar(activity);

        }

        // Android 11 e anteriores
        return true;

    }

    /**
     * Solicita as permissões necessárias.
     */
    public static void solicitar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            Permissao.solicitar(
                    activity,
                    new String[]{
                            Manifest.permission.BLUETOOTH_CONNECT,
                            Manifest.permission.BLUETOOTH_SCAN,
                            Manifest.permission.BLUETOOTH_ADVERTISE
                    },
                    REQUEST_CODE
            );

        }

    }

    public static boolean deveExplicar(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S)
            return false;

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.BLUETOOTH_CONNECT
        );

    }

    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}