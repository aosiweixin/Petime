package com.example.petime;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述 在Fragment中要使用ListView，就要用ListFragment
 * */
public class ListFFragment extends ListFragment {

    private String TAG = ListFFragment.class.getName();
    private ListView list ;
    private SimpleAdapter adapter;

    /**
     * @描述 在onCreateView中加载布局
     * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_f, container,false);
        list = (ListView) view.findViewById(android.R.id.list);
        Log.i(TAG, "--------onCreateView");
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //b = savedInstanceState;
        Log.i(TAG, "--------onCreate");
        String[] list = {"Class 1","Class 2","class 3","Class 4","Class 5"};
        adapter = new SimpleAdapter(getActivity(), getData(list), R.layout.fragment_list_f, new String[]{"title"}, new int[]{R.id.title});
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        System.out.println(l.getChildAt(position));
        HashMap<String, Object> view= (HashMap<String, Object>) l.getItemAtPosition(position);
        System.out.println(view.get("title").toString()+"+++++++++title");




        Toast.makeText(getActivity(), TAG+l.getItemIdAtPosition(position), Toast.LENGTH_LONG).show();
        System.out.println(v);

        System.out.println(position);


    }




    private List<? extends Map<String, ?>> getData(String[] strs) {
        List<Map<String ,Object>> list = new ArrayList<Map<String,Object>>();

        for (int i = 0; i < strs.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title", strs[i]);
            list.add(map);

        }

        return list;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "--------onActivityCreated");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "----------onAttach");
    }

}