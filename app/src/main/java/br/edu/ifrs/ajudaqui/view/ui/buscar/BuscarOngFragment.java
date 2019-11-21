package br.edu.ifrs.ajudaqui.view.ui.buscar;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.view.Origem;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarOngFragment extends Fragment implements View.OnClickListener {


    public BuscarOngFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar_ong, container, false);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (FragmentListener) context;
    }
    public static interface FragmentListener {
        void itemClicked(Origem origemm, int posicao);
    }

    private FragmentListener listener;
}
