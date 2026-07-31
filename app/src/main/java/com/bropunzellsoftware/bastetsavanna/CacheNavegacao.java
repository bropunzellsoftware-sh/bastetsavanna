package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.content.SharedPreferences;

public final class CacheNavegacao {

    private static final String NOME_CACHE =
            "CacheNavegacao";


    private static final String PAGINA_ATUAL =
            "paginaAtual";


    private static final String PAGINA_SEGUINTE =
            "paginaSeguinte";


    private static final String PAGINA_ANTERIOR =
            "paginaAnterior";


    private CacheNavegacao() {
    }


    // ==========================
    // SALVAR
    // ==========================


    public static void salvarPaginaAtual(
            Context context,
            String pagina
    ) {

        obter(context)
                .edit()
                .putString(
                        PAGINA_ATUAL,
                        pagina
                )
                .apply();

    }



    public static void salvarPaginaSeguinte(
            Context context,
            String pagina
    ) {

        obter(context)
                .edit()
                .putString(
                        PAGINA_SEGUINTE,
                        pagina
                )
                .apply();

    }



    public static void salvarPaginaAnterior(
            Context context,
            String pagina
    ) {

        obter(context)
                .edit()
                .putString(
                        PAGINA_ANTERIOR,
                        pagina
                )
                .apply();

    }



    // ==========================
    // LER
    // ==========================


    public static String paginaAtual(
            Context context
    ) {

        return obter(context)
                .getString(
                        PAGINA_ATUAL,
                        ""
                );

    }



    public static String paginaSeguinte(
            Context context
    ) {

        return obter(context)
                .getString(
                        PAGINA_SEGUINTE,
                        ""
                );

    }



    public static String paginaAnterior(
            Context context
    ) {

        return obter(context)
                .getString(
                        PAGINA_ANTERIOR,
                        ""
                );

    }



    // ==========================
    // LIMPAR
    // ==========================


    public static void limpar(
            Context context
    ) {

        obter(context)
                .edit()
                .clear()
                .apply();

    }



    // ==========================
    // INTERNO
    // ==========================


    private static SharedPreferences obter(
            Context context
    ) {

        return context
                .getSharedPreferences(
                        NOME_CACHE,
                        Context.MODE_PRIVATE
                );

    }

}