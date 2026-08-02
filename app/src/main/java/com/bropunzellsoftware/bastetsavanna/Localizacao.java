/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

public final class Localizacao {

    public static final int REQUEST_CODE = 1003;

    private Localizacao() {
    }

    // ==========================
    // HARDWARE
    // ==========================

   
    public static boolean possuiGPS(Context context) {
        return Hardware.possuiGPS(context);
    }

    
    public static boolean possuiRede(Context context) {
        return Hardware.possuiLocalizacaoRede(context);
    }

   
    public static boolean possui(Context context) {

        return possuiGPS(context)
                || possuiRede(context);

    }

    // ==========================
    // PERMISSÕES
    // ==========================

   
    public static boolean temAproximada(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.ACCESS_COARSE_LOCATION
        );

    }

   
    public static boolean temPrecisa(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
        );

    }

   
    public static boolean temPermissao(Activity activity) {

        return temAproximada(activity)
                && temPrecisa(activity);

    }

    
    public static void solicitarAproximada(Activity activity) {

        Permissao.solicitar(
                activity,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                REQUEST_CODE
        );

    }

    
    public static void solicitarPrecisa(Activity activity) {

        Permissao.solicitar(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION,
                REQUEST_CODE
        );

    }

    
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                new String[]{

                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION

                },
                REQUEST_CODE
        );

    }

    public static boolean deveExplicar(Activity activity) {

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