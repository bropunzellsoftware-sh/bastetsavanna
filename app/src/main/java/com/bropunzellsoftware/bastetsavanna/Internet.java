package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

public final class Internet {

    private Internet() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Todo aparelho Android possui suporte à rede.
     */
    public static boolean possui(Context context) {
        return true;
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * INTERNET é concedida automaticamente
     * quando declarada no AndroidManifest.xml.
     */
    public static boolean temPermissao(Context context) {
        return true;
    }

    /**
     * Não existe solicitação em tempo de execução.
     */
    public static void solicitar() {
        // Não aplicável.
    }

    public static boolean deveExplicar() {
        return false;
    }

    // ==========================
    // CONECTIVIDADE
    // ==========================

    /**
     * Verifica se existe alguma conexão ativa.
     */
    public static boolean conectado(Context context) {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);

        if (cm == null)
            return false;

        Network network = cm.getActiveNetwork();

        if (network == null)
            return false;

        NetworkCapabilities nc =
                cm.getNetworkCapabilities(network);

        return nc != null &&
                (
                        nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                     || nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                     || nc.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                     || nc.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)
                );
    }

    /**
     * Internet pronta para uso.
     */
    public static boolean disponivel(Context context) {

        return possui(context)
                && conectado(context);

    }

}