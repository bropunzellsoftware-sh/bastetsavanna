/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.os.Build;

public final class Processador {

    private Processador() {
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

    
    public static int nucleos() {

        return Runtime
                .getRuntime()
                .availableProcessors();

    }


    
    public static String arquitetura() {

        if (Build.SUPPORTED_ABIS.length > 0) {

            return Build.SUPPORTED_ABIS[0];

        }

        return "Desconhecida";

    }


   
    public static String[] arquiteturas() {

        return Build.SUPPORTED_ABIS;

    }


    
    public static String fabricante() {

        return Build.HARDWARE;

    }


   
    public static String modelo() {

        return Build.DEVICE;

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

} */