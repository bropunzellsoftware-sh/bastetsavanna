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

    
    public static boolean possui(Context context) {
        return Hardware.possuiWifi(context);
    } 

    
    public static boolean possuiDirect(Context context) {
        return Hardware.possuiWifiDirect(context);
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    
    public static boolean temPermissao(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

            return Permissao.verificar(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION
            );

        }

        return true;
    }

    
    public static void solicitar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

            Permissao.solicitar(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    REQUEST_CODE
            );

        }

    }

    
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

    
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

} */