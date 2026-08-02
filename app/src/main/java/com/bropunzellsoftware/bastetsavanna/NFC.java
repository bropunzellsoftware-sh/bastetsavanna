/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.nfc.NfcAdapter;

public final class NFC {

    private NFC() {
    }

    // ==========================
    // HARDWARE
    // ==========================

   
    public static boolean possui(Context context) {

        return Hardware.possuiNFC(context);

    }


    // ==========================
    // PERMISSÕES
    // ==========================

   
    public static boolean temPermissao(Context context) {

        return true;

    }


   
    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

   
    public static boolean ligado(Context context) {

        NfcAdapter adapter =
                NfcAdapter.getDefaultAdapter(context);

        return adapter != null
                && adapter.isEnabled();

    }


   
    public static boolean disponivel(Context context) {

        return possui(context)
                && ligado(context);

    }

} */