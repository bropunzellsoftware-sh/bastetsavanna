package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.provider.Settings;
import android.net.Uri;
import android.content.Intent;

public final class JanelaSobreposta {

    private JanelaSobreposta() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica suporte a janelas flutuantes.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Verifica permissão:
     * SYSTEM_ALERT_WINDOW
     */
    public static boolean temPermissao(
            Context context
    ) {

        return Settings.canDrawOverlays(
                context
        );

    }


    /**
     * Abre tela de autorização.
     */
    public static void solicitar(
            Context context
    ) {

        Intent intent =
                new Intent(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse(
                                "package:"
                                +
                                context.getPackageName()
                        )
                );


        context.startActivity(intent);

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Verifica se pode criar janela
     * sobre outros aplicativos.
     */
    public static boolean disponivel(
            Context context
    ) {

        return possui()
                &&
                temPermissao(context);

    }

}