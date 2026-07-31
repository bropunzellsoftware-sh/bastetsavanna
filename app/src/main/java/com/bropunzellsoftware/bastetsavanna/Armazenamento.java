package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

public final class Armazenamento {

    private Armazenamento() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se existe armazenamento interno.
     */
    public static boolean possui() {

        return true;

    }


    /**
     * Verifica se existe armazenamento externo.
     */
    public static boolean possuiExterno() {

        return Environment
                .getExternalStorageState()
                .equals(
                        Environment.MEDIA_MOUNTED
                );

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Informações de armazenamento próprio
     * não exigem permissão.
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
    // INFORMAÇÕES
    // ==========================

    /**
     * Espaço total interno em bytes.
     */
    public static long totalInterno() {

        File path =
                Environment
                        .getDataDirectory();


        StatFs stat =
                new StatFs(
                        path.getPath()
                );


        return stat.getBlockCountLong()
                *
                stat.getBlockSizeLong();

    }


    /**
     * Espaço livre interno em bytes.
     */
    public static long livreInterno() {

        File path =
                Environment
                        .getDataDirectory();


        StatFs stat =
                new StatFs(
                        path.getPath()
                );


        return stat.getAvailableBlocksLong()
                *
                stat.getBlockSizeLong();

    }


    /**
     * Espaço utilizado interno.
     */
    public static long usadoInterno() {

        return totalInterno()
                -
                livreInterno();

    }


    /**
     * Total em GB.
     */
    public static double totalGB() {

        return totalInterno()
                /
                (1024.0 * 1024.0 * 1024.0);

    }


    /**
     * Livre em GB.
     */
    public static double livreGB() {

        return livreInterno()
                /
                (1024.0 * 1024.0 * 1024.0);

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}