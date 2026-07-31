package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

public final class Camera {

    public static final int REQUEST_CODE = 1001;

    private Camera() {
    }

    /**
     * Verifica se o aparelho possui câmera.
     */
    public static boolean possui(Context context) {
        return Hardware.possuiCamera(context);
    }

    /**
     * Verifica se possui câmera frontal.
     */
    public static boolean possuiFrontal(Context context) {
        return Hardware.possuiCameraFrontal(context);
    }

    /**
     * Verifica se possui flash.
     */
    public static boolean possuiFlash(Context context) {
        return Hardware.possuiFlash(context);
    }

    /**
     * Verifica se a permissão foi concedida.
     */
    public static boolean temPermissao(Activity activity) {
        return Permissao.verificar(
                activity,
                Manifest.permission.CAMERA
        );
    }

    /**
     * Solicita a permissão da câmera.
     */
    public static void solicitar(Activity activity) {

        Permissao.solicitar(
                activity,
                Manifest.permission.CAMERA,
                REQUEST_CODE
        );

    }

    /**
     * Verifica se deve explicar ao usuário
     * o motivo da permissão.
     */
    public static boolean deveExplicar(Activity activity) {

        return Permissao.deveExplicar(
                activity,
                Manifest.permission.CAMERA
        );

    }

    /**
     * Verifica se a câmera está pronta para uso.
     */
    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

}