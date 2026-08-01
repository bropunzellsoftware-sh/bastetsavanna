/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.net.VpnService;

public final class VPN {

    private VPN() {
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

        return false;

    }


   
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

   
    public static boolean disponivel(
            Context context
    ) {

        return possui()
                &&
                preparar(context);

    }

} */