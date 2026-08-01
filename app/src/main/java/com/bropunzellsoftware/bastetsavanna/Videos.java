/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class Videos {

    public static final int REQUEST_CODE = 1006;

    private Videos() {
    }

    // ==========================
    // HARDWARE
    // ==========================

    public static boolean possui(Context context) {
        return true;
    }

    // ==========================
    // PERMISSÕES
    // ==========================

    public static boolean temPermissao(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            return Permissao.verificar(
                    activity,
                    Manifest.permission.READ_MEDIA_VIDEO
            );

        }

        return Permissao.verificar(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
        );

    }

    public static void solicitar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            Permissao.solicitar(
                    activity,
                    Manifest.permission.READ_MEDIA_VIDEO,
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

    public static boolean deveExplicar(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            return Permissao.deveExplicar(
                    activity,
                    Manifest.permission.READ_MEDIA_VIDEO
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

    public static boolean disponivel(Activity activity) {

        return possui(activity)
                && temPermissao(activity);

    }

} */