package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public final class Bateria {

    private Bateria() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Todo dispositivo Android possui
     * gerenciamento de bateria.
     */
    public static boolean possui(Context context) {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Bateria não necessita permissão.
     */
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
    // INFORMAÇÕES
    // ==========================

    /**
     * Retorna porcentagem atual da bateria.
     */
    public static int nivel(Context context) {

        IntentFilter filter =
                new IntentFilter(
                        Intent.ACTION_BATTERY_CHANGED
                );

        Intent intent =
                context.registerReceiver(
                        null,
                        filter
                );


        if (intent == null)
            return -1;


        int nivel =
                intent.getIntExtra(
                        BatteryManager.EXTRA_LEVEL,
                        -1
                );


        int escala =
                intent.getIntExtra(
                        BatteryManager.EXTRA_SCALE,
                        -1
                );


        if (nivel < 0 || escala <= 0)
            return -1;


        return (nivel * 100) / escala;

    }


    /**
     * Verifica se está carregando.
     */
    public static boolean carregando(Context context) {

        BatteryManager manager =
                (BatteryManager)
                        context.getSystemService(
                                Context.BATTERY_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.isCharging();

    }


    /**
     * Tipo de carregamento.
     */
    public static int tipoCarregamento(Context context) {

        IntentFilter filter =
                new IntentFilter(
                        Intent.ACTION_BATTERY_CHANGED
                );

        Intent intent =
                context.registerReceiver(
                        null,
                        filter
                );


        if (intent == null)
            return -1;


        return intent.getIntExtra(
                BatteryManager.EXTRA_PLUGGED,
                -1
        );

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(Context context) {

        return possui(context);

    }

}