package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;

public final class GPS {

    public static final int REQUEST_CODE = 1017;

    private GPS() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui
     * serviço de localização.
     */
    public static boolean possui(Context context) {

        LocationManager manager =
                (LocationManager)
                        context.getSystemService(
                                Context.LOCATION_SERVICE
                        );

        return manager != null;

    }


    /**
     * Verifica se GPS por satélite existe.
     */
    public static boolean possuiGPS(Context context) {

        LocationManager manager =
                (LocationManager)
                        context.getSystemService(
                                Context.LOCATION_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.isProviderEnabled(
                LocationManager.GPS_PROVIDER
        );

    }


    /**
     * Verifica localização por rede.
     */
    public static boolean possuiRede(Context context) {

        LocationManager manager =
                (LocationManager)
                        context.getSystemService(
                                Context.LOCATION_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Localização aproximada.
     */
    public static boolean temAproximada(
            Activity activity
    ) {

        return Permissao.verificar(
                activity,
                Manifest.permission.ACCESS_COARSE_LOCATION
        );

    }


    /**
     * Localização precisa.
     */
    public static boolean temPrecisa(
            Activity activity
    ) {

        return Permissao.verificar(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
        );

    }


    /**
     * Verifica todas permissões.
     */
    public static boolean temPermissao(
            Activity activity
    ) {

        return temAproximada(activity)
                &&
                temPrecisa(activity);

    }


    /**
     * Solicita localização.
     */
    public static void solicitar(
            Activity activity
    ) {

        Permissao.solicitar(
                activity,
                new String[]{

                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION

                },
                REQUEST_CODE
        );

    }


    /**
     * Verifica necessidade de explicação.
     */
    public static boolean deveExplicar(
            Activity activity
    ) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
        );

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * GPS pronto para uso.
     */
    public static boolean disponivel(
            Activity activity
    ) {

        return possui(activity)
                &&
                temPermissao(activity);

    }

}