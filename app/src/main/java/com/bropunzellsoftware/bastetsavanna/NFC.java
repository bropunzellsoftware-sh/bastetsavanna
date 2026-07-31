package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.nfc.NfcAdapter;

public final class NFC {

    private NFC() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui NFC.
     */
    public static boolean possui(Context context) {

        return Hardware.possuiNFC(context);

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * NFC não possui permissão runtime.
     */
    public static boolean temPermissao(Context context) {

        return true;

    }


    /**
     * Não existe solicitação de permissão.
     */
    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Verifica se o NFC está ligado.
     */
    public static boolean ligado(Context context) {

        NfcAdapter adapter =
                NfcAdapter.getDefaultAdapter(context);

        return adapter != null
                && adapter.isEnabled();

    }


    /**
     * NFC pronto para utilização.
     */
    public static boolean disponivel(Context context) {

        return possui(context)
                && ligado(context);

    }

}