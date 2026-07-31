package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

public final class Telefone {

    public static final int REQUEST_CODE = 1014;

    private Telefone() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui
     * suporte à telefonia.
     */
    public static boolean possui(Context context) {

        TelephonyManager tm =
                (TelephonyManager)
                        context.getSystemService(
                                Context.TELEPHONY_SERVICE
                        );

        return tm != null;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Permissão para realizar chamadas.
     */
    public static boolean temChamadas(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.CALL_PHONE
        );

    }


    /**
     * Permissão para acessar estado do telefone.
     */
    public static boolean temEstado(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_PHONE_STATE
        );

    }


    /**
     * Verifica todas as permissões.
     */
    public static boolean temPermissao(Activity activity) {

        return temChamadas(activity)
                && temEstado(activity);

    }


    /**
     * Solicita permissões de telefone.
     */
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                new String[]{

                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.READ_PHONE_STATE

                },
                REQUEST_CODE
        );

    }


    /**
     * Verifica se deve mostrar explicação.
     */
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.CALL_PHONE
        );

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Telefone pronto para utilização.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }


    /**
     * Verifica se existe serviço de voz.
     */
    public static boolean possuiRedeMovel(Context context) {

        TelephonyManager tm =
                (TelephonyManager)
                        context.getSystemService(
                                Context.TELEPHONY_SERVICE
                        );

        if (tm == null)
            return false;

        return tm.getPhoneType()
                != TelephonyManager.PHONE_TYPE_NONE;

    }

}