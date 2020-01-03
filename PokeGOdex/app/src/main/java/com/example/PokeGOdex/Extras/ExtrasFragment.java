package com.example.PokeGOdex.Extras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.PokeGOdex.Jugar;
import com.example.PokeGOdex.LoginActivity;
import com.example.PokeGOdex.R;

import java.util.ArrayList;


public class ExtrasFragment extends ListFragment {


    private ArrayList<String> Extras_List = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;
    ListView listView;


    public static ExtrasFragment newInstance(String param1, String param2) {
        ExtrasFragment fragment = new ExtrasFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        FragmentManager fragmentManager = getFragmentManager();
        String item = listView.getAdapter().getItem(position).toString();

        switch (item) {
            case "Game":
                Intent intente = new Intent(getContext(), Jugar.class);
                startActivity(intente);
                break;
            case "Log Out":
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_extras, container, false);
        listView = v.findViewById(android.R.id.list);
        getOptions();
        mAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Extras_List);
        listView.setAdapter(mAdapter);
        return v;
    }

    public void getOptions() {
        Extras_List.add("Game");
        Extras_List.add("Log Out");
    }


}
