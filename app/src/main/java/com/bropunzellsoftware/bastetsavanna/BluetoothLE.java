package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;

public final class BluetoothLE {

    public static final int REQUEST_CODE = 1018;

    private BluetoothLE() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui Bluetooth.
     */
    public static boolean possui(Context context) {

        BluetoothManager manager =
                (BluetoothManager)
                        context.getSystemService(
                                Context.BLUETOOTH_SERVICE
                        );


        return manager != null
                &&
                manager.getAdapter() != null;

    }


    /**
     * Verifica suporte ao Bluetooth Low Energy.
     */
    public static boolean possuiBLE(Context context) {

        return context
                .getPackageManager()
                .hasSystemFeature(
                        "android.hardware.bluetooth_le"
                );

    }


    /**
     * Verifica se Bluetooth está ativo.
     */
    public static boolean ativo(Context context) {

        BluetoothManager manager =
                (BluetoothManager)
                        context.getSystemService(
                                Context.BLUETOOTH_SERVICE
                        );


        if (manager == null)
            return false;


        BluetoothAdapter adapter =
                manager.getAdapter();


        return adapter != null
                &&
                adapter.isEnabled();

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Android 12+ exige permissões novas.
     */
    public static boolean temPermissao(
            Activity activity
    ) {

        if (Build.VERSION.SDK_INT >= 31) {

            return Permissao.verificar(
                    activity,
                    Manifest.permission.BLUETOOTH_SCAN
            )
            &&
            Permissao.verificar(
                    activity,
                    Manifest.permission.BLUETOOTH_CONNECT
            );

        }


        return true;

    }


    /**
     * Solicita permissões BLE.
     */
    public static void solicitar(
            Activity activity
    ) {

        if (Build.VERSION.SDK_INT >= 31) {

            Permissao.solicitar(
                    activity,
                    new String[]{

                        Manifest.permission.BLUETOOTH_SCAN,
                        Manifest.permission.BLUETOOTH_CONNECT

                    },
                    REQUEST_CODE
            );

        }

    }


    public static boolean deveExplicar(
            Activity activity
    ) {

        if (Build.VERSION.SDK_INT >= 31) {

            return Permissao.deveExplicar(
                    activity,
                    Manifest.permission.BLUETOOTH_SCAN
            );

        }


        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(
            Activity activity
    ) {

        return possui(activity)
                &&
                possuiBLE(activity)
                &&
                temPermissao(activity);

    }

}