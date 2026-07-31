package com.bropunzellsoftware.bastetsavanna.acesso;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.provider.Settings;

public final class EstadoDispositivo {

    private EstadoDispositivo() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o sistema suporta
     * gerenciamento de estado.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // ESTADO DA TELA
    // ==========================

    /**
     * Verifica se a tela está ligada.
     */
    public static boolean telaLigada(
            Context context
    ) {

        PowerManager manager =
                (PowerManager)
                        context.getSystemService(
                                Context.POWER_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.isInteractive();

    }


    // ==========================
    // BLOQUEIO
    // ==========================

    /**
     * Verifica se o aparelho está bloqueado.
     */
    public static boolean bloqueado(
            Context context
    ) {

        KeyguardManager manager =
                (KeyguardManager)
                        context.getSystemService(
                                Context.KEYGUARD_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.isKeyguardLocked();

    }


    // ==========================
    // MODO AVIÃO
    // ==========================

    /**
     * Verifica modo avião.
     */
    public static boolean modoAviao(
            Context context
    ) {

        return Settings.Global.getInt(
                context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON,
                0
        ) != 0;

    }


    // ==========================
    // ENERGIA
    // ==========================

    /**
     * Verifica se está em modo economia.
     */
    public static boolean economiaEnergia(
            Context context
    ) {

        PowerManager manager =
                (PowerManager)
                        context.getSystemService(
                                Context.POWER_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.isPowerSaveMode();

    }


    // ==========================
    // INTENÇÕES DO SISTEMA
    // ==========================

    /**
     * Retorna Intent para abrir
     * configurações do aparelho.
     */
    public static Intent abrirConfiguracoes() {

        return new Intent(
                Settings.ACTION_SETTINGS
        );

    }


    // ==========================
    // ESTADO GERAL
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}