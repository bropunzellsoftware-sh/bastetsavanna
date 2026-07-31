package com.bropunzellsoftware.bastetsavanna.acesso;

import android.opengl.GLES10;
import android.opengl.GLES20;

public final class GPU {

    private GPU() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se existe suporte OpenGL ES.
     */
    public static boolean possuiOpenGL() {

        return true;

    }


    /**
     * Retorna versão do OpenGL ES.
     *
     * Observação:
     * precisa ser chamada em contexto
     * OpenGL ativo para valores precisos.
     */
    public static String versaoOpenGL() {

        return GLES10
                .glGetString(
                        GLES10.GL_VERSION
                );

    }


    /**
     * Fabricante da GPU.
     */
    public static String fabricante() {

        return GLES10
                .glGetString(
                        GLES10.GL_VENDOR
                );

    }


    /**
     * Renderer da GPU.
     */
    public static String renderer() {

        return GLES10
                .glGetString(
                        GLES10.GL_RENDERER
                );

    }


    // ==========================
    // CAPACIDADES
    // ==========================

    /**
     * Verifica suporte OpenGL ES 2.0.
     */
    public static boolean suportaOpenGLES2() {

        String versao =
                versaoOpenGL();


        return versao != null
                &&
                versao.contains("2");

    }


    /**
     * Verifica suporte OpenGL ES 3.
     */
    public static boolean suportaOpenGLES3() {

        String versao =
                versaoOpenGL();


        return versao != null
                &&
                (
                    versao.contains("3")
                    ||
                    versao.contains("4")
                );

    }


    /**
     * Limite aproximado de textura.
     */
    public static int texturaMaxima() {

        int[] valor =
                new int[1];


        GLES20.glGetIntegerv(
                GLES20.GL_MAX_TEXTURE_SIZE,
                valor,
                0
        );


        return valor[0];

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel() {

        return possuiOpenGL();

    }

}