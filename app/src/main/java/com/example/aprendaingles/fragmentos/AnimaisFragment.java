package com.example.aprendaingles.fragmentos;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimaisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimaisFragment<ImageButtom> extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton cao,gato,ovelha,vaca,leao,macaco;
    private MediaPlayer mediaPlayer;

    public AnimaisFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimaisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimaisFragment newInstance(String param1, String param2) {
        AnimaisFragment fragment = new AnimaisFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animais, container, false);
        cao = view.findViewById(R.id.imageButtonCao);
        gato = view.findViewById(R.id.imageButtonGato);
        macaco = view.findViewById(R.id.imageButtonMacaco);
        leao = view.findViewById(R.id.imageButtonLeao);
        ovelha = view.findViewById(R.id.imageButtonOvelha);
        vaca = view.findViewById(R.id.imageButtonVaca);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        macaco.setOnClickListener(this);
        leao.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Elemento clicado", "Item: "+ v.getId());
        switch (v.getId()){
            case R.id.imageButtonCao:
                tocarSom(R.raw.dog);
                break;
            case R.id.imageButtonGato:
                tocarSom(R.raw.cat);
                break;
            case R.id.imageButtonLeao:
                tocarSom(R.raw.lion);
                break;
            case R.id.imageButtonMacaco:
                tocarSom(R.raw.monkey);
                break;
            case R.id.imageButtonOvelha:
                tocarSom(R.raw.sheep);
                break;
            case R.id.imageButtonVaca:
                tocarSom(R.raw.cow);
                break;
        }
    }

    public void tocarSom(int id){
        mediaPlayer = MediaPlayer.create(getContext(),id);
        if(mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
        }
    }
}