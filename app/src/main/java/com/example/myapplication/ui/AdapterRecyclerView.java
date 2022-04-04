package com.example.myapplication.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Product;
import com.example.myapplication.R;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>
{
    private Context mContext;
    private Product[] mList;

    public AdapterRecyclerView(Context context)
    {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        if (position % 2 == 0)
        {
            holder.image.setImageDrawable(mContext.getDrawable(R.drawable.bbs));
        }
        else
        {
            holder.image.setImageDrawable(mContext.getDrawable(R.drawable.work));
        }

        Log.d("TAG", "onBindViewHolder: " + mList[position].cena_detaliczna);
        holder.desc.setText(mList[position].nazwa);
        holder.price.setText("" + mList[position].cena_detaliczna);
    }

    @Override
    public int getItemCount()
    {
        if (mList != null)
        {
            return mList.length;
        }
        else
        {
            return 0;
        }
    }


    public void setList(Product[] list)
    {
        this.mList = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView desc, price;
        ImageView image;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            desc = itemView.findViewById(R.id.desc);
            price = itemView.findViewById(R.id.price);
        }
    }
}
