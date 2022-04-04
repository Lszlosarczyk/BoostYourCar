package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ui.AdapterRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KosmetykiSamochodoweFragment extends Fragment
{
    private RecyclerView mRecyclerView;
    private AdapterRecyclerView mAdapter;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_kosmetykisamochodowe, container, false);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        mAdapter = new AdapterRecyclerView(getContext());
        mRecyclerView.setAdapter(mAdapter);


        ClientHttp clientAPI = new ClientHttp();
        clientAPI.get("products", new MyCallback()
        {
            @Override
            public void onSuccess(Product[] list)
            {
                mAdapter.setList(list);
                getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onFailure(String error)
            {
                //niepowodzenie.
                Log.e("TAG", "onFailure: "+error);
            }
        });

        return rootView;
    }

}
