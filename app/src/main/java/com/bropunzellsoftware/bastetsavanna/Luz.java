/* package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public final class Luz {

    private Luz() {
    }


    // ==========================
    // HARDWARE
    // ==========================

   
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
                        Sensor.TYPE_LIGHT
                );

        return sensor != null;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    
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

    
    public static boolean disponivel(Context context) {

        return possui(context);

    }

} */