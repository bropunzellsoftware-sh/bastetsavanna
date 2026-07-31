package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

public final class SMS {

    public static final int REQUEST_CODE = 1015;

    private SMS() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui
     * suporte a telefonia/SMS.
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
     * Permissão para enviar SMS.
     */
    public static boolean temEnvio(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.SEND_SMS
        );

    }


    /**
     * Permissão para ler SMS.
     */
    public static boolean temLeitura(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_SMS
        );

    }


    /**
     * Permissão para receber SMS.
     */
    public static boolean temRecebimento(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.RECEIVE_SMS
        );

    }


    /**
     * Verifica todas as permissões.
     */
    public static boolean temPermissao(Activity activity) {

        return temEnvio(activity)
                && temLeitura(activity)
                && temRecebimento(activity);

    }


    /**
     * Solicita permissões SMS.
     */
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                new String[]{

                        Manifest.permission.SEND_SMS,
                        Manifest.permission.READ_SMS,
                        Manifest.permission.RECEIVE_SMS

                },
                REQUEST_CODE
        );

    }


    /**
     * Verifica se precisa explicar.
     */
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.SEND_SMS
        );

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * SMS disponível.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}