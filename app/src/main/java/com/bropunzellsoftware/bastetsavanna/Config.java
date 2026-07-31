package com.bropunzellsoftware.bastetsavanna;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bropunzellsoftware.bastetsavanna.acesso.CacheNavegacao;


public class Config extends Activity {


    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(
                savedInstanceState
        );


        CacheNavegacao.salvarPaginaAnterior(
                this,
                "Main"
        );


        CacheNavegacao.salvarPaginaAtual(
                this,
                "Config"
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
        // BOTÃO VOLTAR
        // ==========================


        Button voltar =
                new Button(
                        this
                );


        voltar.setText(
                "<"
        );


        voltar.setOnClickListener(
                v -> {


                    String anterior =
                            CacheNavegacao.paginaAnterior(
                                    this
                            );


                    if(anterior.equals("Main")) {


                        CacheNavegacao.salvarPaginaAtual(
                                this,
                                "Main"
                        );


                        CacheNavegacao.salvarPaginaAnterior(
                                this,
                                ""
                        );


                        startActivity(
                                new Intent(
                                        this,
                                        Main.class
                                )
                        );


                        finish();

                    }

                }
        );



        FrameLayout.LayoutParams voltarParams =
                new FrameLayout.LayoutParams(
                        80,
                        80
                );


        voltarParams.gravity =
                Gravity.TOP
                |
                Gravity.LEFT;


        voltarParams.topMargin =
                20;


        voltarParams.leftMargin =
                20;



        tela.addView(
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
                24
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



        setContentView(
                tela
        );

    }

}