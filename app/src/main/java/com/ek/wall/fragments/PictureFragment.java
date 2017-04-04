package com.ek.wall.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ek.wall.R;
import com.ek.wall.core.CoreFragment;
import com.ek.wall.models.ServerData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by Hitesh on 12/28/2016.
 */

public class PictureFragment extends CoreFragment {
    private static final String TAG = "Fragment";
    int color;
    private RecyclerView rvPicData;
    private GridLayoutManager manager;
    private View rootView;

    public PictureFragment() {
    }

    @SuppressLint("ValidFragment")
    public PictureFragment(int color) {
        this.color = color;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PictureFragment newInstance(int sectionNumber) {
        PictureFragment fragment = new PictureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_picture, container, false);
        initUI(rootView);
        return rootView;
    }

    private void initUI(View rootView) {
        rvPicData = (RecyclerView) rootView.findViewById(R.id.rvPicData);
        manager = new GridLayoutManager(getActivity(), 2);
        rvPicData.setLayoutManager(manager);
        rvPicData.setHasFixedSize(true);

//        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-demos.firebaseio.com/status");
        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("status");

        FirebaseRecyclerAdapter<ServerData, PictureFragment.Holder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<ServerData, PictureFragment.Holder>(
                ServerData.class,
                R.layout.row_pics,
                PictureFragment.Holder.class,
                firebaseDatabase) {

            @Override
            protected void populateViewHolder(PictureFragment.Holder holder, ServerData serverData, int position) {
                holder.setImage(getActivity(), serverData.getUrl());
            }
        };

        rvPicData.setAdapter(firebaseRecyclerAdapter);

    }


    public static class Holder extends RecyclerView.ViewHolder {
        ImageView imgPics;

        public Holder(View itemView) {
            super(itemView);
            imgPics = (ImageView) itemView.findViewById(R.id.imgPics);
        }

        public void setImage(Context mContext, String imgUrl) {
            Picasso.with(mContext).load(imgUrl).into(imgPics);
        }
    }
}
