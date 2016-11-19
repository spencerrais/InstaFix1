package com.example.spencer.instafix.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.spencer.instafix.R;
import com.example.spencer.instafix.fragments.dummy.DummyContent;
import com.example.spencer.instafix.fragments.dummy.DummyContent.DummyItem;
import com.example.spencer.instafix.panels.ListAdapter;
import com.example.spencer.instafix.panels.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class FaultFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ListAdapter mAdapter;
    private ArrayList<ListItem> exampleListItemList; // at the top of your fragment list

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FaultFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FaultFragment newInstance(int columnCount) {
        FaultFragment fragment = new FaultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        exampleListItemList = new ArrayList<ListItem>();
        exampleListItemList.add(new ListItem("Example 1"));
        exampleListItemList.add(new ListItem("Example 2"));
        exampleListItemList.add(new ListItem("Example 3"));
        mAdapter = new ListAdapter(getActivity(), exampleListItemList);
    }



   // @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListItem item = this.exampleListItemList.get(position);
        exampleListItemList.toString();
        for(ListItem l : exampleListItemList){
            l.toString();
        }
       // Toast.makeText(getActivity(), item.getItemTitle() + " Clicked!"
        //        , Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fault_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
      //      recyclerView.setAdapter(new MyFaultRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
