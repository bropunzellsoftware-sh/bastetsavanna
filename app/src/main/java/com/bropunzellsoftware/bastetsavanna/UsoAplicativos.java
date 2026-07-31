package com.bropunzellsoftware.bastetsavanna.acesso;

import android.app.AppOpsManager;
import android.content.Context;
import android.provider.Settings;

public final class UsoAplicativos {

    private UsoAplicativos() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica suporte ao controle de uso.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Verifica acesso ao histórico de uso
     * dos aplicativos.
     *
     * Essa autorização é concedida
     * manualmente pelo usuário.
     */
    public static boolean temPermissao(
            Context context
    ) {

        AppOpsManager manager =
                (AppOpsManager)
                        context.getSystemService(
                                Context.APP_OPS_SERVICE
                        );


        if (manager == null)
            return false;


        int modo =
                manager.checkOpNoThrow(
                        AppOpsManager.OPSTR_GET_USAGE_STATS,
                        android.os.Process.myUid(),
                        context.getPackageName()
                );


        return modo == AppOpsManager.MODE_ALLOWED;

    }


    /**
     * Abre tela de permissão.
     */
    public static void solicitar(
            Context context
    ) {

        context.startActivity(
                new android.content.Intent(
                        Settings.ACTION_USAGE_ACCESS_SETTINGS
                )
        );

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(
            Context context
    ) {

        return possui()
                &&
                temPermissao(context);

    }

}