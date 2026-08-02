/* package com.bropunzellsoftware.bastetsavanna.acesso;

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

   
    public static boolean possui(Context context) {
        return Hardware.possuiMicrofone(context);
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    
    public static boolean temPermissao(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.RECORD_AUDIO
        );

    }

    
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                Manifest.permission.RECORD_AUDIO,
                REQUEST_CODE
        );

    }

    
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.RECORD_AUDIO
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