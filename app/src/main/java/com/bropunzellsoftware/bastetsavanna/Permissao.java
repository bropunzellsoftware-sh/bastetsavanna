/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public final class Permissao {

    private Permissao() {
        // Impede instanciação
    }

    
    public static boolean verificar(Context context, String permissao) {
        return ContextCompat.checkSelfPermission(
                context,
                permissao
        ) == PackageManager.PERMISSION_GRANTED;
    }

    
    public static boolean verificarTodas(Context context, String[] permissoes) {

        for (String permissao : permissoes) {

            if (!verificar(context, permissao)) {
                return false;
            }

        }

        return true;
    }

    
    public static void solicitar(
            Activity activity,
            String permissao,
            int requestCode
    ) {

        ActivityCompat.requestPermissions(
                activity,
                new String[]{permissao},
                requestCode
        );

    }

    
    public static void solicitar(
            Activity activity,
            String[] permissoes,
            int requestCode
    ) {

        ActivityCompat.requestPermissions(
                activity,
                permissoes,
                requestCode
        );

    }

    
    public static boolean deveExplicar(
            Activity activity,
            String permissao
    ) {

        return ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                permissao
        );

    }

} */