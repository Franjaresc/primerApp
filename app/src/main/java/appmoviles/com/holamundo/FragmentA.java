package appmoviles.com.holamundo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment {

    public FragmentA() {
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
        View v= inflater.inflate(R.layout.fragment_a, container, false);
        Button BT_a_fragmente_a = v.findViewById(R.id.BT_a_fragment_a);
        BT_a_fragmente_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null) {
                    listener.onMessage("Hola desde el fragment A");
                }
            }
        });
        return v;
    }

    public interface FragmentAActions{
       void onMessage(String msn);
    }

    private FragmentAActions listener;

    public void setListener(FragmentAActions listener){
        this.listener = listener;
    }


}
