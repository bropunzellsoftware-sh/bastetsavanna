/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class Notificacoes {

    public static final int REQUEST_CODE = 1011;

    private Notificacoes() {
    }

    // ==========================
    // HARDWARE
    // ==========================

   
    public static boolean possui(Context context) {
        return true;
    }


    // ==========================
    // PERMISSÕES
    // ==========================

    
    public static boolean temPermissao(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return true;
        }

        return Permissao.verificar(
                activity,
                Manifest.permission.POST_NOTIFICATIONS
        );

    }


  
    public static void solicitar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            Permissao.solicitar(
                    activity,
                    Manifest.permission.POST_NOTIFICATIONS,
                    REQUEST_CODE
            );

        }

    }


    
    public static boolean deveExplicar(Activity activity) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return false;
        }

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.POST_NOTIFICATIONS
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