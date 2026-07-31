package com.bropunzellsoftware.bastetsavanna;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bropunzellsoftware.bastetsavanna.acesso.CacheNavegacao;


public class Main extends Activity {


    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(
                savedInstanceState
        );


        String pagina =
                CacheNavegacao.paginaAtual(this);


        // Restaura última página aberta

        if (pagina.equals("Config")) {


            startActivity(
                    new Intent(
                            this,
                            Config.class
                    )
            );


            return;

        }


        CacheNavegacao.salvarPaginaAtual(
                this,
                "Main"
        );


        criarTela();

    }



    private void criarTela() {


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
        // TITULO
        // ==========================


        TextView titulo =
                new TextView(
                        this
                );


        titulo.setText(
                "Bastet Savanna"
        );


        titulo.setTextColor(
                Color.WHITE
        );


        titulo.setTextSize(
                28
        );


        titulo.setGravity(
                Gravity.CENTER
        );



        FrameLayout.LayoutParams tituloParams =
                new FrameLayout.LayoutParams(
                        -1,
                        -2
                );


        tituloParams.gravity =
                Gravity.CENTER;



        tela.addView(
                titulo,
                tituloParams
        );



        // ==========================
        // BOTÃO CONFIG
        // ==========================


        Button config =
                new Button(
                        this
                );


        config.setText(
                "..."
        );



        config.setOnClickListener(
                v -> {


                    CacheNavegacao.salvarPaginaAnterior(
                            this,
                            "Main"
                    );


                    CacheNavegacao.salvarPaginaAtual(
                            this,
                            "Config"
                    );


                    startActivity(
                            new Intent(
                                    this,
                                    Config.class
                            )
                    );


                }
        );



        FrameLayout.LayoutParams configParams =
                new FrameLayout.LayoutParams(
                        80,
                        80
                );


        configParams.gravity =
                Gravity.TOP
                |
                Gravity.RIGHT;


        configParams.topMargin =
                20;


        configParams.rightMargin =
                20;



        tela.addView(
                config,
                configParams
        );



        setContentView(
                tela
        );

    }

}