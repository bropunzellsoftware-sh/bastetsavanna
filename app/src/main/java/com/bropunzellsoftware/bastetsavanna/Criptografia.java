package com.bropunzellsoftware.bastetsavanna.acesso;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import java.security.KeyStore;

import javax.crypto.KeyGenerator;

public final class Criptografia {

    private Criptografia() {
    }


    // ==========================
    // HARDWARE
    // ==========================

    /**
     * Verifica suporte ao sistema
     * de armazenamento seguro de chaves.
     */
    public static boolean possui() {

        return true;

    }


    // ==========================
    // PERMISSÕES
    // ==========================

    /**
     * Criptografia local não exige
     * permissão do usuário.
     */
    public static boolean temPermissao(
            Context context
    ) {

        return true;

    }


    public static void solicitar() {

        // Não aplicável.

    }


    public static boolean deveExplicar() {

        return false;

    }


    // ==========================
    // KEYSTORE
    // ==========================

    /**
     * Verifica disponibilidade do
     * Android Keystore.
     */
    public static boolean possuiKeystore() {

        try {

            KeyStore keyStore =
                    KeyStore.getInstance(
                            "AndroidKeyStore"
                    );


            keyStore.load(null);


            return true;


        } catch (Exception e) {

            return false;

        }

    }


    /**
     * Cria uma chave AES segura.
     */
    public static boolean criarChave(
            String nome
    ) {

        try {

            KeyGenerator generator =
                    KeyGenerator.getInstance(
                            KeyProperties.KEY_ALGORITHM_AES,
                            "AndroidKeyStore"
                    );


            KeyGenParameterSpec spec =
                    new KeyGenParameterSpec.Builder(
                            nome,
                            KeyProperties.PURPOSE_ENCRYPT
                                    |
                            KeyProperties.PURPOSE_DECRYPT
                    )
                    .setBlockModes(
                            KeyProperties.BLOCK_MODE_GCM
                    )
                    .setEncryptionPaddings(
                            KeyProperties.ENCRYPTION_PADDING_NONE
                    )
                    .build();


            generator.init(spec);

            generator.generateKey();


            return true;


        } catch (Exception e) {

            return false;

        }

    }


    // ==========================
    // ESTADO
    // ==========================

    public static boolean disponivel(
            Context context
    ) {

        return possui()
                &&
                possuiKeystore();

    }

}