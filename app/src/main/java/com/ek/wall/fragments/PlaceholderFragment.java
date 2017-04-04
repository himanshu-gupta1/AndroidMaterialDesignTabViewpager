package com.ek.wall.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ek.wall.R;
import com.ek.wall.core.CoreFragment;
import com.ek.wall.models.ServerData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends CoreFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private static final String TAG = "Fragment";
    int color;
    private RecyclerView rvData;
    private LinearLayoutManager manager;

    public PlaceholderFragment() {
    }

    @SuppressLint("ValidFragment")
    public PlaceholderFragment(int color) {
        this.color = color;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initUI(rootView);
        return rootView;
    }

    private void initUI(View rootView) {
        rvData = (RecyclerView) rootView.findViewById(R.id.rvData);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(manager);
        rvData.setHasFixedSize(true);

//        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-demos.firebaseio.com/status");
        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("status");

        FirebaseRecyclerAdapter<ServerData, Holder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<ServerData, Holder>(
                ServerData.class,
                R.layout.row_item,
                Holder.class,
                firebaseDatabase) {

            @Override
            protected void populateViewHolder(Holder holder, ServerData serverData, int i) {
                holder.setMessage(serverData.getMessage());

            }
        };

        rvData.setAdapter(firebaseRecyclerAdapter);

    }


    public static class Holder extends RecyclerView.ViewHolder {
        TextView txtMessage;

        public Holder(View itemView) {
            super(itemView);
            txtMessage = (TextView) itemView.findViewById(R.id.txtMessage);
        }

        public void setMessage(String message) {
            txtMessage.setText(message.trim());
        }
    }

}