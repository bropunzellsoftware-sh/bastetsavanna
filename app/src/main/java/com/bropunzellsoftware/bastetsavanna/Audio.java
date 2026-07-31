package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.media.AudioManager;

public final class Audio {

    private Audio() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o sistema possui
     * gerenciamento de áudio.
     */
    public static boolean possui(Context context) {

        AudioManager manager =
                (AudioManager)
                        context.getSystemService(
                                Context.AUDIO_SERVICE
                        );

        return manager != null;

    }


    /**
     * Verifica suporte a microfone.
     */
    public static boolean possuiMicrofone(
            Context context
    ) {

        return Hardware.possuiMicrofone(context);

    }


    /**
     * Verifica suporte a saída de áudio.
     */
    public static boolean possuiSaida(
            Context context
    ) {

        return Hardware.possuiAudio(context);

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Áudio básico não necessita permissão.
     * Microfone possui classe própria.
     */
    public static boolean temPermissao(
            Context context
    ) {

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
     * Volume atual de mídia.
     */
    public static int volume(
            Context context
    ) {

        AudioManager manager =
                (AudioManager)
                        context.getSystemService(
                                Context.AUDIO_SERVICE
                        );


        if (manager == null)
            return -1;


        return manager.getStreamVolume(
                AudioManager.STREAM_MUSIC
        );

    }


    /**
     * Volume máximo de mídia.
     */
    public static int volumeMaximo(
            Context context
    ) {

        AudioManager manager =
                (AudioManager)
                        context.getSystemService(
                                Context.AUDIO_SERVICE
                        );


        if (manager == null)
            return -1;


        return manager.getStreamMaxVolume(
                AudioManager.STREAM_MUSIC
        );

    }


    /**
     * Verifica modo silencioso.
     */
    public static boolean silencioso(
            Context context
    ) {

        AudioManager manager =
                (AudioManager)
                        context.getSystemService(
                                Context.AUDIO_SERVICE
                        );


        if (manager == null)
            return false;


        return manager.getRingerMode()
                ==
                AudioManager.RINGER_MODE_SILENT;

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(
            Context context
    ) {

        return possui(context);

    }

}