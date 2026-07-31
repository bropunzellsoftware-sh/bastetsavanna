package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class Arquivos {

    public static final int REQUEST_CODE = 1004;

    private Arquivos() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Todo dispositivo Android possui armazenamento.
     */
    public static boolean possui(Context context) {
        return true;
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Verifica se o aplicativo possui acesso ao armazenamento.
     */
    public static boolean temPermissao(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            return Permissao.verificar(
                    activity,
                    Manifest.permission.READ_MEDIA_IMAGES
            )
            && Permissao.verificar(
                    activity,
                    Manifest.permission.READ_MEDIA_VIDEO
            )
            && Permissao.verificar(
                    activity,
                    Manifest.permission.READ_MEDIA_AUDIO
            );

        }

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
        );

    }

    /**
     * Solicita acesso ao armazenamento.
     */
    public static void solicitar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            Permissao.solicitar(
                    activity,
                    new String[]{
                            Manifest.permission.READ_MEDIA_IMAGES,
                            Manifest.permission.READ_MEDIA_VIDEO,
                            Manifest.permission.READ_MEDIA_AUDIO
                    },
                    REQUEST_CODE
            );

            return;
        }

        Permissao.solicitar(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                REQUEST_CODE
        );

    }

    /**
     * Verifica se deve exibir explicação ao usuário.
     */
    public static boolean deveExplicar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            return Permissao.deveExplicar(
                    activity,
                    Manifest.permission.READ_MEDIA_IMAGES
            );

        }

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
        );

    }

    // ==========================
    // ESTADO
    // ==========================

    /**
     * Arquivos disponíveis para utilização.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}