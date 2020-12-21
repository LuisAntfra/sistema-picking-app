package com.example.pickingapp;

import androidx.fragment.app.Fragment;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class PickUpFragment extends Fragment {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_up, container, false);
        //btn lista
        Button btnLista = view.findViewById(R.id.button_lista);
        btnLista.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Lista.class);
                        startActivity(intent);
                    }
                }
        );

        //btnEscaneo
        Button btnEscaneo = view.findViewById(R.id.button_scan);
        btnEscaneo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Escaneo.class);
                startActivity(intent);
            }
        });

        // Creacion de card views
        models = new ArrayList<>();
        models.add(new Model("SKU: 508241", "LENTES PRE GRADUADOS AZUL", "A.01.01.02"));
        models.add(new Model("SKU: 508754", "TRENZADO TIPO PIEL", "A.04.03.05"));
        models.add(new Model("SKU: 508755", "KPKMEX", "A.04.03.06"));

        adapter = new Adapter(models, getContext());

        viewPager =  (ViewPager) view.findViewById(R.id.productsPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
//
//        // TODO: Cambiar imagenes de planograma
//        // TODO: Cambiar por metodo no depreciado
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        return view;
    }
}
