package com.bropunzellsoftware.bastetsavanna.acesso;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

import java.util.ArrayList;
import java.util.List;

public final class Codec {

    private Codec() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se existe suporte multimídia.
     */
    public static boolean possui() {

        return MediaCodecList
                .getCodecCount() > 0;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Codecs não precisam de permissão.
     */
    public static boolean temPermissao() {

        return true;

    }


    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // CODECS
    // ==========================

    /**
     * Lista todos os codecs disponíveis.
     */
    public static List<String> listar() {

        List<String> lista =
                new ArrayList<>();


        MediaCodecList codecs =
                new MediaCodecList(
                        MediaCodecList.ALL_CODECS
                );


        for (MediaCodecInfo info :
                codecs.getCodecInfos()) {

            lista.add(
                    info.getName()
            );

        }


        return lista;

    }


    /**
     * Verifica suporte a determinado formato.
     *
     * Exemplos:
     * video/avc
     * video/hevc
     * audio/mp4a-latm
     */
    public static boolean suporta(
            String mime
    ) {

        MediaCodecList codecs =
                new MediaCodecList(
                        MediaCodecList.ALL_CODECS
                );


        for (MediaCodecInfo info :
                codecs.getCodecInfos()) {


            for (String tipo :
                    info.getSupportedTypes()) {


                if (tipo.equalsIgnoreCase(mime)) {

                    return true;

                }

            }

        }


        return false;

    }


    /**
     * Verifica codecs de vídeo.
     */
    public static boolean suportaVideo(
            String formato
    ) {

        return formato.startsWith(
                "video/"
        )
        &&
        suporta(formato);

    }


    /**
     * Verifica codecs de áudio.
     */
    public static boolean suportaAudio(
            String formato
    ) {

        return formato.startsWith(
                "audio/"
        )
        &&
        suporta(formato);

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}