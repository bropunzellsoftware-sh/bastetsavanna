package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.net.VpnService;

public final class VPN {

    private VPN() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o Android possui
     * suporte ao serviço VPN.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * VPN não utiliza permissão comum.
     * O Android exige autorização do usuário
     * através do sistema.
     */
    public static boolean temPermissao() {

        return false;

    }


    /**
     * Solicita autorização do usuário.
     *
     * Deve ser chamado em uma Activity:
     *
     * Intent intent =
     * VpnService.prepare(context);
     */
    public static boolean preparar(
            Context context
    ) {

        return VpnService
                .prepare(context)
                == null;

    }


    public static void solicitar() {

        // A solicitação é feita
        // através de Intent do VpnService.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Verifica se VPN está disponível
     * para uso pelo aplicativo.
     */
    public static boolean disponivel(
            Context context
    ) {

        return possui()
                &&
                preparar(context);

    }

}