package com.bropunzellsoftware.bastetsavanna.acesso;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public final class Permissao {

    private Permissao() {
        // Impede instanciação
    }

    /**
     * Verifica se uma permissão foi concedida.
     */
    public static boolean verificar(Context context, String permissao) {
        return ContextCompat.checkSelfPermission(
                context,
                permissao
        ) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Verifica se todas as permissões foram concedidas.
     */
    public static boolean verificarTodas(Context context, String[] permissoes) {

        for (String permissao : permissoes) {

            if (!verificar(context, permissao)) {
                return false;
            }

        }

        return true;
    }

    /**
     * Solicita uma única permissão.
     */
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

    /**
     * Solicita várias permissões.
     */
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

    /**
     * Informa se o Android recomenda explicar
     * ao usuário o motivo da permissão.
     */
    public static boolean deveExplicar(
            Activity activity,
            String permissao
    ) {

        return ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                permissao
        );

    }

}