package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public final class Acelerometro {

    private Acelerometro() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui acelerômetro.
     */
    public static boolean possui(Context context) {

        SensorManager manager =
                (SensorManager)
                        context.getSystemService(
                                Context.SENSOR_SERVICE
                        );

        if (manager == null)
            return false;


        Sensor sensor =
                manager.getDefaultSensor(
                        Sensor.TYPE_ACCELEROMETER
                );

        return sensor != null;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Acelerômetro não necessita permissão.
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
    // ESTADO
    // ==========================

    /**
     * Acelerômetro pronto para uso.
     */
    public static boolean disponivel(Context context) {

        return possui(context);

    }

}