/* package com.bropunzellsoftware.bastetsavanna.acesso;

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

   
    public static boolean temEnvio(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.SEND_SMS
        );

    }


   
    public static boolean temLeitura(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_SMS
        );

    }


    
    public static boolean temRecebimento(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.RECEIVE_SMS
        );

    }


   
    public static boolean temPermissao(Activity activity) {

        return temEnvio(activity)
                && temLeitura(activity)
                && temRecebimento(activity);

    }


    
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


    
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.SEND_SMS
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