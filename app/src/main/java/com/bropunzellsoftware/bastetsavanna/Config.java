package com.bropunzellsoftware.bastetsavanna;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class Config extends Activity {


    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(
                savedInstanceState
        );


        criarTela();

    }



    private void criarTela(){

        // ==========================
        // FUNDO
        // ==========================


        FrameLayout tela =
                new FrameLayout(
                        this
                );


        tela.setBackgroundColor(
                Color.rgb(
                        18,
                        18,
                        18
                )
        );



        // ==========================
        // BARRA SUPERIOR
        // ==========================


        FrameLayout barra =
                new FrameLayout(
                        this
                );


        barra.setBackgroundColor(
                Color.rgb(
                        25,
                        25,
                        25
                )
        );


        FrameLayout.LayoutParams barraParams =
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        70
                );


        barraParams.gravity =
                Gravity.TOP;



        tela.addView(
                barra,
                barraParams
        );



        // ==========================
        // VOLTAR
        // ==========================


        Button voltar =
                new Button(
                        this
                );


        voltar.setText(
                "<"
        );


        voltar.setOnClickListener(
                v -> finish()
        );


        FrameLayout.LayoutParams voltarParams =
                new FrameLayout.LayoutParams(
                        70,
                        70
                );


        voltarParams.gravity =
                Gravity.LEFT
                |
                Gravity.TOP;



        barra.addView(
                voltar,
                voltarParams
        );



        // ==========================
        // TITULO
        // ==========================


        TextView titulo =
                new TextView(
                        this
                );


        titulo.setText(
                "Config"
        );


        titulo.setTextColor(
                Color.WHITE
        );


        titulo.setTextSize(
                22
        );


        titulo.setGravity(
                Gravity.CENTER
        );



        FrameLayout.LayoutParams tituloParams =
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        70
                );


        tituloParams.gravity =
                Gravity.CENTER;



        barra.addView(
                titulo,
                tituloParams
        );



        setContentView(
                tela
        );

    }

}