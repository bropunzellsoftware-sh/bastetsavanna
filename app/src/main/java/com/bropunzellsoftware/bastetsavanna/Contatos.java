package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

public final class Contatos {

    public static final int REQUEST_CODE = 1012;

    private Contatos() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Contatos não dependem de hardware.
     */
    public static boolean possui(Context context) {
        return true;
    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Permissão de leitura da agenda.
     */
    public static boolean temLeitura(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_CONTACTS
        );

    }


    /**
     * Permissão de alteração da agenda.
     */
    public static boolean temEscrita(Activity activity) {

        return Permissao.verificar(
                activity,
                Manifest.permission.WRITE_CONTACTS
        );

    }


    /**
     * Possui todas as permissões necessárias.
     */
    public static boolean temPermissao(Activity activity) {

        return temLeitura(activity)
                && temEscrita(activity);

    }


    /**
     * Solicita acesso aos contatos.
     */
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                new String[]{

                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_CONTACTS

                },
                REQUEST_CODE
        );

    }


    /**
     * Verifica se deve explicar a solicitação.
     */
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.READ_CONTACTS
        );

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Contatos disponíveis para uso.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}