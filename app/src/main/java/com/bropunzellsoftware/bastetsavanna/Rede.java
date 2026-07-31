package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public final class Rede {

    private Rede() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Todo Android possui gerenciamento de rede.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Estado da rede não necessita
     * permissão runtime.
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
    // CONEXÃO
    // ==========================

    /**
     * Verifica se existe conexão ativa.
     */
    public static boolean conectado(Context context) {

        ConnectivityManager manager =
                (ConnectivityManager)
                        context.getSystemService(
                                Context.CONNECTIVITY_SERVICE
                        );


        if (manager == null)
            return false;


        Network network =
                manager.getActiveNetwork();


        if (network == null)
            return false;


        NetworkCapabilities capabilities =
                manager.getNetworkCapabilities(
                        network
                );


        return capabilities != null
                &&
                capabilities.hasCapability(
                        NetworkCapabilities
                                .NET_CAPABILITY_INTERNET
                );

    }


    /**
     * Verifica Wi-Fi.
     */
    public static boolean wifi(Context context) {

        return transporte(
                context,
                NetworkCapabilities
                        .TRANSPORT_WIFI
        );

    }


    /**
     * Verifica dados móveis.
     */
    public static boolean dadosMoveis(Context context) {

        return transporte(
                context,
                NetworkCapabilities
                        .TRANSPORT_CELLULAR
        );

    }


    /**
     * Verifica Ethernet.
     */
    public static boolean ethernet(Context context) {

        return transporte(
                context,
                NetworkCapabilities
                        .TRANSPORT_ETHERNET
        );

    }


    private static boolean transporte(
            Context context,
            int tipo
    ) {

        ConnectivityManager manager =
                (ConnectivityManager)
                        context.getSystemService(
                                Context.CONNECTIVITY_SERVICE
                        );


        if (manager == null)
            return false;


        Network network =
                manager.getActiveNetwork();


        if (network == null)
            return false;


        NetworkCapabilities capabilities =
                manager.getNetworkCapabilities(
                        network
                );


        return capabilities != null
                &&
                capabilities.hasTransport(tipo);

    }


    /**
     * Tipo de conexão atual.
     */
    public static String tipo(Context context) {

        if (wifi(context))
            return "Wi-Fi";


        if (dadosMoveis(context))
            return "Dados móveis";


        if (ethernet(context))
            return "Ethernet";


        return "Desconhecida";

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(Context context) {

        return possui()
                && conectado(context);

    }

}