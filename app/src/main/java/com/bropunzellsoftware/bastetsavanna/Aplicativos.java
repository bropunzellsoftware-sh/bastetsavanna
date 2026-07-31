package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

public final class Aplicativos {

    private Aplicativos() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Aplicativos são um recurso lógico do sistema.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Acesso básico aos próprios aplicativos
     * não exige permissão.
     */
    public static boolean temPermissao(Context context) {

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
     * Retorna quantidade de aplicativos instalados.
     */
    public static int quantidade(Context context) {

        PackageManager pm =
                context.getPackageManager();


        List<ApplicationInfo> apps =
                pm.getInstalledApplications(
                        PackageManager.GET_META_DATA
                );


        return apps.size();

    }


    /**
     * Verifica se um pacote está instalado.
     */
    public static boolean instalado(
            Context context,
            String pacote
    ) {

        PackageManager pm =
                context.getPackageManager();

        try {

            pm.getPackageInfo(
                    pacote,
                    0
            );

            return true;

        } catch (PackageManager.NameNotFoundException e) {

            return false;

        }

    }


    /**
     * Retorna versão de um aplicativo.
     */
    public static String versao(
            Context context,
            String pacote
    ) {

        try {

            PackageInfo info =
                    context.getPackageManager()
                            .getPackageInfo(
                                    pacote,
                                    0
                            );

            return info.versionName;


        } catch (Exception e) {

            return null;

        }

    }


    /**
     * Lista aplicativos instalados.
     */
    public static List<ApplicationInfo> listar(
            Context context
    ) {

        return context
                .getPackageManager()
                .getInstalledApplications(
                        PackageManager.GET_META_DATA
                );

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possui();

    }

}