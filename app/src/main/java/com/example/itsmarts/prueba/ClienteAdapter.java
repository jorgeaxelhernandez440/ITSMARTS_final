package com.example.itsmarts.prueba;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.itsmarts.R;
import com.example.itsmarts.adapter.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//este es el adapter para que muestre el recycler view los clientes
public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder>{

    private List<Cliente> mData;
    private List<Cliente>original;
    private LayoutInflater Inflater;
    private Context context;
    private View.OnClickListener delete;


    public void setOnclick(View.OnClickListener delete){
        this.delete = delete;
    }

    public interface onClick{
        void Onclick(Cliente cliente);
    }



    public ClienteAdapter(List<Cliente> itemList, Context context){
        this.Inflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.original = new ArrayList<>();
        original.addAll(mData);


    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    //busca el nombre en el search por el filtrado
    public void filtrado(String search){
        if (search.length() == 0){
            mData.clear();
            mData.addAll(original);
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                mData.clear();
                List<Cliente> collect = original.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(search))
                        .collect(Collectors.toList());
                mData.addAll(collect);

            }else {
                mData.clear();
                for (Cliente i : original){
                    if (i.getNombre().toLowerCase().contains(search)){
                        mData.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = Inflater.inflate(R.layout.cardview,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.binData(mData.get(position));
    }

    //pone el nombre y apellido en el recycler con el card

    public void setItems(List<Cliente> items){
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,apellidoP;

        ViewHolder(View itemView){
            super(itemView);
            nombre = itemView.findViewById(R.id.nombretxt);
            apellidoP = itemView.findViewById(R.id.apellidoPatxt);
        }

        void binData(final Cliente item){
            nombre.setText(item.getNombre());
            apellidoP.setText(item.getApellidoP());
        }
    }
}
