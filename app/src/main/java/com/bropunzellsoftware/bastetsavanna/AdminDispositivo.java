/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

public final class AdminDispositivo {

    private AdminDispositivo() {
    }


    // ==========================
    // HARDWARE
    // ==========================

   
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

   
    public static boolean podeBloquear(
            Context context,
            ComponentName componente
    ) {

        return ativo(
                context,
                componente
        );

    }


    
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

} */