package com.bropunzellsoftware.bastetsavanna.acesso;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;

import java.util.List;

public final class Acessibilidade {

    private Acessibilidade() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o Android possui
     * serviço de acessibilidade.
     */
    public static boolean possui(Context context) {

        AccessibilityManager manager =
                (AccessibilityManager)
                        context.getSystemService(
                                Context.ACCESSIBILITY_SERVICE
                        );

        return manager != null;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Acessibilidade não é uma permissão
     * comum. O usuário ativa manualmente
     * nas configurações.
     */
    public static boolean ativo(
            Context context
    ) {

        AccessibilityManager manager =
                (AccessibilityManager)
                        context.getSystemService(
                                Context.ACCESSIBILITY_SERVICE
                        );


        if (manager == null)
            return false;


        List<AccessibilityServiceInfo> servicos =
                manager.getEnabledAccessibilityServiceList(
                        AccessibilityServiceInfo.FEEDBACK_ALL_MASK
                );


        return servicos != null
                &&
                !servicos.isEmpty();

    }


    public static boolean temPermissao() {

        return false;

    }


    /**
     * Abre configurações de acessibilidade.
     * Deve ser chamado pela Activity.
     */
    public static void solicitar() {

        // Intent:
        // Settings.ACTION_ACCESSIBILITY_SETTINGS

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

        return possui(context)
                &&
                ativo(context);

    }

}