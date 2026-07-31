package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;

public final class Lanterna {

    private Lanterna() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui flash.
     */
    public static boolean possui(Context context) {

        return Hardware.possuiFlash(context);

    }


    /**
     * Verifica se existe uma câmera com flash.
     */
    public static boolean possuiCameraFlash(Context context) {

        CameraManager manager =
                (CameraManager)
                        context.getSystemService(
                                Context.CAMERA_SERVICE
                        );

        if (manager == null)
            return false;


        try {

            for (String id : manager.getCameraIdList()) {

                CameraCharacteristics c =
                        manager.getCameraCharacteristics(id);

                Boolean flash =
                        c.get(
                                CameraCharacteristics
                                        .FLASH_INFO_AVAILABLE
                        );

                if (Boolean.TRUE.equals(flash)) {
                    return true;
                }

            }

        } catch (Exception e) {

            return false;

        }


        return false;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Usa a permissão da câmera para controle do flash.
     */
    public static boolean temPermissao(
            android.app.Activity activity
    ) {

        return Camera.temPermissao(activity);

    }


    public static void solicitar(
            android.app.Activity activity
    ) {

        Camera.solicitar(activity);

    }


    public static boolean deveExplicar(
            android.app.Activity activity
    ) {

        return Camera.deveExplicar(activity);

    }


    // ==========================
    // ESTADO
    // ==========================

    /**
     * Lanterna disponível.
     */
    public static boolean disponivel(
            android.app.Activity activity
    ) {

        return possui(activity)
                && temPermissao(activity);

    }

}