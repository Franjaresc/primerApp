package appmoviles.com.holamundo;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.LinearLayout;

import android.widget.TextView;



import java.util.ArrayList;



public class AdapterTemplate extends RecyclerView.Adapter<AdapterTemplate.CustomViewHolder> {


    /**
     * Datos a mostrar en el view
     */
    ArrayList<Persona> data;


    /**
     * View holder respresenta un renglon de la lista
     * metodo de renglon y contruccion
     */
    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout root;

        public CustomViewHolder(LinearLayout v) {

            super(v);

            root = v;

        }

    }



    public AdapterTemplate(){

        data = new ArrayList<>();

    }



    @Override

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.renglon, parent, false);

        CustomViewHolder vh = new CustomViewHolder(v);

        return vh;

    }


    /**
     * Agrega informacion al renglon
     * @param holder
     * @param position
     */
    @Override

    public void onBindViewHolder(CustomViewHolder holder, int position) {

        ((TextView) holder.root.findViewById(R.id.row_name)).setText(data.get(position).getName());

        ((TextView) holder.root.findViewById(R.id.row_number)).setText(data.get(position).getNumber());

    }



    @Override

    public int getItemCount() {

        return data.size();

    }

    public void addPerson(Persona persona){
        data.add(persona);
        notifyDataSetChanged();
    }





}
