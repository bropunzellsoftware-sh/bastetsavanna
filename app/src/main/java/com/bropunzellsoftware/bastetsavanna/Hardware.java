package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;

import androidx.biometric.BiometricManager;

public final class Hardware {

    private Hardware() {
    }

    private static PackageManager pm(Context context) {
        return context.getPackageManager();
    }

    // ==========================
    // CÂMERA
    // ==========================

    public static boolean possuiCamera(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY
        );
    }

    public static boolean possuiCameraFrontal(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_CAMERA_FRONT
        );
    }

    public static boolean possuiFlash(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_CAMERA_FLASH
        );
    }

    // ==========================
    // ÁUDIO
    // ==========================

    public static boolean possuiMicrofone(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_MICROPHONE
        );
    }

    // ==========================
    // LOCALIZAÇÃO
    // ==========================

    public static boolean possuiGPS(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_LOCATION_GPS
        );
    }

    public static boolean possuiLocalizacaoRede(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_LOCATION_NETWORK
        );
    }

    // ==========================
    // CONECTIVIDADE
    // ==========================

    public static boolean possuiBluetooth(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_BLUETOOTH
        );
    }

    public static boolean possuiBluetoothLE(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_BLUETOOTH_LE
        );
    }

    public static boolean possuiWifi(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_WIFI
        );
    }

    public static boolean possuiWifiDirect(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_WIFI_DIRECT
        );
    }

    public static boolean possuiNFC(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_NFC
        );
    }

    // ==========================
    // USB
    // ==========================

    public static boolean possuiUSBHost(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_USB_HOST
        );
    }

    public static boolean possuiUSBAccessory(Context context) {
        return pm(context).hasSystemFeature(
                PackageManager.FEATURE_USB_ACCESSORY
        );
    }

    // ==========================
    // BIOMETRIA
    // ==========================

    public static boolean possuiBiometria(Context context) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return false;
        }

        BiometricManager biometric =
                BiometricManager.from(context);

        return biometric.canAuthenticate(
                BiometricManager.Authenticators.BIOMETRIC_STRONG
                | BiometricManager.Authenticators.BIOMETRIC_WEAK
        ) == BiometricManager.BIOMETRIC_SUCCESS;
    }

    // ==========================
    // SENSORES
    // ==========================

    private static SensorManager sensores(Context context) {
        return (SensorManager)
                context.getSystemService(Context.SENSOR_SERVICE);
    }

    private static boolean possuiSensor(
            Context context,
            int tipo
    ) {

        SensorManager sm = sensores(context);

        if (sm == null)
            return false;

        return sm.getDefaultSensor(tipo) != null;
    }

    public static boolean possuiAcelerometro(Context context) {
        return possuiSensor(context, Sensor.TYPE_ACCELEROMETER);
    }

    public static boolean possuiGiroscopio(Context context) {
        return possuiSensor(context, Sensor.TYPE_GYROSCOPE);
    }

    public static boolean possuiMagnetometro(Context context) {
        return possuiSensor(context, Sensor.TYPE_MAGNETIC_FIELD);
    }

    public static boolean possuiBarometro(Context context) {
        return possuiSensor(context, Sensor.TYPE_PRESSURE);
    }

    public static boolean possuiLuz(Context context) {
        return possuiSensor(context, Sensor.TYPE_LIGHT);
    }

    public static boolean possuiProximidade(Context context) {
        return possuiSensor(context, Sensor.TYPE_PROXIMITY);
    }

    public static boolean possuiGravidade(Context context) {
        return possuiSensor(context, Sensor.TYPE_GRAVITY);
    }

    public static boolean possuiRotacao(Context context) {
        return possuiSensor(context, Sensor.TYPE_ROTATION_VECTOR);
    }

    public static boolean possuiUmidade(Context context) {
        return possuiSensor(context, Sensor.TYPE_RELATIVE_HUMIDITY);
    }

    public static boolean possuiTemperatura(Context context) {
        return possuiSensor(
                context,
                Sensor.TYPE_AMBIENT_TEMPERATURE
        );
    }

}