package com.bropunzellsoftware.bastetsavanna.acesso;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

public final class AdminDispositivo {

    private AdminDispositivo() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica suporte ao gerenciamento
     * administrativo do dispositivo.
     */
    public static boolean possui(Context context) {

        DevicePolicyManager manager =
                (DevicePolicyManager)
                        context.getSystemService(
                                Context.DEVICE_POLICY_SERVICE
                        );

        return manager != null;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Administração do dispositivo não é
     * uma permissão comum.
     * Depende de ativação manual do usuário.
     */
    public static boolean ativo(
            Context context,
            ComponentName componente
    ) {

        DevicePolicyManager manager =
                (DevicePolicyManager)
                        context.getSystemService(
                                Context.DEVICE_POLICY_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.isAdminActive(
                componente
        );

    }


    /**
     * Solicitação é feita via Intent:
     *
     * ACTION_ADD_DEVICE_ADMIN
     */
    public static void solicitar() {

        // Chamado pela Activity.

    }


    public static boolean temPermissao() {

        return false;

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // RECURSOS
    // ==========================

    /**
     * Verifica se o app pode bloquear tela.
     */
    public static boolean podeBloquear(
            Context context,
            ComponentName componente
    ) {

        return ativo(
                context,
                componente
        );

    }


    /**
     * Verifica se o app é administrador.
     */
    public static boolean disponivel(
            Context context,
            ComponentName componente
    ) {

        return possui(context)
                &&
                ativo(
                        context,
                        componente
                );

    }

}