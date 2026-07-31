package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public final class Barometro {

    private Barometro() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui
     * sensor de pressão atmosférica.
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
                        Sensor.TYPE_PRESSURE
                );

        return sensor != null;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Barômetro não necessita permissão.
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
     * Barômetro pronto para uso.
     */
    public static boolean disponivel(Context context) {

        return possui(context);

    }

}