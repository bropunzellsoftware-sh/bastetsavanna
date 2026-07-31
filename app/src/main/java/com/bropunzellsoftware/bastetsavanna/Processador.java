package com.bropunzellsoftware.bastetsavanna.acesso;

import android.os.Build;

public final class Processador {

    private Processador() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se existe processador.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Informações da CPU não necessitam permissão.
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
     * Quantidade de núcleos disponíveis.
     */
    public static int nucleos() {

        return Runtime
                .getRuntime()
                .availableProcessors();

    }


    /**
     * Arquitetura do processador.
     */
    public static String arquitetura() {

        if (Build.SUPPORTED_ABIS.length > 0) {

            return Build.SUPPORTED_ABIS[0];

        }

        return "Desconhecida";

    }


    /**
     * Lista todas arquiteturas suportadas.
     */
    public static String[] arquiteturas() {

        return Build.SUPPORTED_ABIS;

    }


    /**
     * Fabricante do chipset quando disponível.
     */
    public static String fabricante() {

        return Build.HARDWARE;

    }


    /**
     * Modelo da CPU informado pelo sistema.
     */
    public static String modelo() {

        return Build.DEVICE;

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}