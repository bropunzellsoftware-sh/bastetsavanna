package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public final class Umidade {

    private Umidade() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica se o aparelho possui
     * sensor de umidade relativa.
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
                        Sensor.TYPE_RELATIVE_HUMIDITY
                );

        return sensor != null;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Sensor de umidade não necessita permissão.
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
     * Sensor de umidade disponível.
     */
    public static boolean disponivel(Context context) {

        return possui(context);

    }

}