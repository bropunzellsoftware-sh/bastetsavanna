package com.bropunzellsoftware.bastetsavanna;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.content.Intent;


public class Main extends Activity {


    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(
                savedInstanceState
        );


        start();

    }



    public void start(){


        System.out.println(
                "Bastet Savanna started"
        );


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
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
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
                new View.OnClickListener(){

                    @Override
                    public void onClick(
                            View v
                    ){

                        Intent intent =
                                new Intent(
                                        Main.this,
                                        Config.class
                                );


                        startActivity(
                                intent
                        );

                    }

                }
        );



        FrameLayout.LayoutParams botaoParams =
                new FrameLayout.LayoutParams(
                        80,
                        80
                );


        botaoParams.gravity =
                Gravity.TOP
                |
                Gravity.RIGHT;


        botaoParams.topMargin =
                20;


        botaoParams.rightMargin =
                20;



        tela.addView(
                config,
                botaoParams
        );



        setContentView(
                tela
        );


    }

}