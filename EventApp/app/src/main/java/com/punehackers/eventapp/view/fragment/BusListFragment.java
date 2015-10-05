package com.punehackers.eventapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.Utility.Constants;
import com.punehackers.eventapp.adapters.BusDepotAdapter;
import com.punehackers.eventapp.viewholder.BusDepot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04-10-2015.
 */
public class BusListFragment extends Fragment {

    private View rootView;
    private List<BusDepot> busDepotList;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.bus_depot_list, null);
        initializeScreen();
        return rootView;
    }

    private void initializeScreen() {
        initializeList();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BusDepotAdapter busDepotAdapter = new BusDepotAdapter(getActivity(), busDepotList);
        recyclerView.setAdapter(busDepotAdapter);
    }


    private void initializeList() {
        busDepotList = new ArrayList<BusDepot>();
        for (int i = 0; i <=20; i++) {
            BusDepot busDepot = new BusDepot();
            switch (i) {
                case 0:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Swargate");
                    busDepotList.add(busDepot);
                    break;
                case 1:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Hadapsar");
                    busDepotList.add(busDepot);
                    break;
                case 2:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Bhosari");
                    busDepotList.add(busDepot);
                    break;
                case 3:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Pimpri");
                    busDepotList.add(busDepot);
                    break;
                case 4:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Chinchwad");
                    busDepotList.add(busDepot);
                    break;
                case 5:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Kothrud");
                    busDepotList.add(busDepot);
                    break;
                case 6:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Market Yard");
                    busDepotList.add(busDepot);
                    break;
                case 7:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Saswad");
                    busDepotList.add(busDepot);
                    break;
                case 8:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Pulgate");
                    busDepotList.add(busDepot);
                    break;
                case 9:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Bibvewadi");
                    busDepotList.add(busDepot);
                    break;
                case 10:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Katraj");
                    busDepotList.add(busDepot);
                    break;
                case 11:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Shivajinagar");
                    busDepotList.add(busDepot);
                    break;
                case 12:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Dhanakwadi");
                    busDepotList.add(busDepot);
                    break;
                case 13:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Shanipar");
                    busDepotList.add(busDepot);
                    break;
                case 14:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Nigadi");
                    busDepotList.add(busDepot);
                    break;
                case 15:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Pune Station");
                    busDepotList.add(busDepot);
                    break;
                case 16:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Karvenagar");
                    busDepotList.add(busDepot);
                    break;
                case 17:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Sarasbaug");
                    busDepotList.add(busDepot);
                    break;
                case 18:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Alandi");
                    busDepotList.add(busDepot);
                    break;
                case 19:
                    busDepot.setResourceId(R.drawable.ic_bus);
                    busDepot.setDepotName("Vishrantwadi");
                    busDepotList.add(busDepot);
                    break;
            }
        }

    }
}
