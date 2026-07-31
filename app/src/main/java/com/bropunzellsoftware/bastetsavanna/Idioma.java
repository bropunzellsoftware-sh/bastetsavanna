package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

public final class Idioma {

    private Idioma() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Sistema possui configuração
     * regional por padrão.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Idioma do sistema não necessita
     * permissão.
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
     * Retorna idioma atual.
     */
    public static String atual(
            Context context
    ) {

        Locale locale =
                obterLocale(context);


        return locale
                .getLanguage();

    }


    /**
     * Retorna região atual.
     */
    public static String regiao(
            Context context
    ) {

        Locale locale =
                obterLocale(context);


        return locale
                .getCountry();

    }


    /**
     * Retorna idioma completo.
     */
    public static String completo(
            Context context
    ) {

        Locale locale =
                obterLocale(context);


        return locale
                .toLanguageTag();

    }


    /**
     * Obtém configuração regional.
     */
    private static Locale obterLocale(
            Context context
    ) {

        Configuration config =
                context.getResources()
                        .getConfiguration();


        if (android.os.Build.VERSION.SDK_INT >= 24) {

            return config
                    .getLocales()
                    .get(0);

        }


        return config.locale;

    }


    // ==========================
    // COMPARAÇÃO
    // ==========================

    /**
     * Verifica idioma.
     */
    public static boolean e(
            Context context,
            String idioma
    ) {

        return atual(context)
                .equalsIgnoreCase(
                        idioma
                );

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(
            Context context
    ) {

        return possui();

    }

}