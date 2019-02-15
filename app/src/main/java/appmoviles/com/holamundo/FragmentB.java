package appmoviles.com.holamundo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class FragmentB extends Fragment implements View.OnClickListener {

    private EditText ETLibretaNumero, ETLibretaNombre;
    private Button BTAgregar;
    private RecyclerView libreta;
    private AdapterTemplate adapter;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        ETLibretaNombre = v.findViewById(R.id.ETLibretaNombre);
        ETLibretaNumero = v.findViewById(R.id.ETLibretaNumero);
        BTAgregar = v.findViewById(R.id.BTAgregarContacto);
        libreta = v.findViewById(R.id.libreta);
        adapter = new AdapterTemplate();
        libreta.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        libreta.setLayoutManager(manager);
        libreta.setAdapter(adapter);
        BTAgregar.setOnClickListener(this);


        return v;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BTAgregarContacto:
                Persona p = new Persona(ETLibretaNombre.getText().toString(),ETLibretaNumero.getText().toString());
                adapter.addPerson(p);
                break;
        }
    }
}
