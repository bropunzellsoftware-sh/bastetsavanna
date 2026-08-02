/* package com.bropunzellsoftware.bastetsavanna.acesso;

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

    
    public static boolean temChamadas(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.CALL_PHONE
        );

    }


    
    public static boolean temEstado(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_PHONE_STATE
        );

    }


    
    public static boolean temPermissao(Activity activity) {

        return temChamadas(activity)
                && temEstado(activity);

    }


    
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


   
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.CALL_PHONE
        );

    }


    // ==========================
    // ESTADO
    // ==========================

   
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }


    
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

} */