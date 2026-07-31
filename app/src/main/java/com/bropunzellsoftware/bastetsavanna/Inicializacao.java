package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class Inicializacao {

    private Inicializacao() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * RECEIVE_BOOT_COMPLETED
     */
    public static boolean temPermissao(
            Context context
    ) {

        return true;

    }


    /**
     * Solicitação de permissão.
     *
     * Essa permissão é declarativa,
     * portanto não usa popup runtime.
     */
    public static void solicitar() {

        // Permissão declarada no Manifest.

    }


    /**
     * Verifica se precisa explicar.
     */
    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // REGISTRO
    // ==========================

    public static void registrar(
            Context context,
            BroadcastReceiver receiver
    ) {

        IntentFilter filtro =
                new IntentFilter(
                        Intent.ACTION_BOOT_COMPLETED
                );


        context.registerReceiver(
                receiver,
                filtro
        );

    }


    public static void remover(
            Context context,
            BroadcastReceiver receiver
    ) {

        try {

            context.unregisterReceiver(
                    receiver
            );

        } catch (Exception ignored) {

        }

    }


    public static IntentFilter filtro() {

        return new IntentFilter(
                Intent.ACTION_BOOT_COMPLETED
        );

    }


    // ==========================
    // RECEIVER
    // ==========================

    public static class Receiver
            extends BroadcastReceiver {


        @Override
        public void onReceive(
                Context context,
                Intent intent
        ) {


            if (Intent.ACTION_BOOT_COMPLETED
                    .equals(intent.getAction())) {


                // Inicialização do sistema


            }

        }

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui()
                &&
                temPermissao(null);

    }

}