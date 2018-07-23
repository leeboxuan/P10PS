package com.weebly.leeboxuan.p10ps;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {
    Button btnChangeColor;
    LinearLayout ly;
    ZoomageView zm;


    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_frag2, container, false);

        btnChangeColor = (Button) v.findViewById(R.id.btnChange);
        ly = (LinearLayout) v.findViewById(R.id.ly);
        zm = (ZoomageView) v.findViewById(R.id.myZoomageView);

        String imageUrl = "https://78.media.tumblr.com/30136fe9d5d3c92dd8832c41bbbca7fc/tumblr_p7d3boiq1n1roqv59o1_500.png";
        Picasso.with(v.getContext()).load(imageUrl).into(zm);


        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ly.setBackgroundColor(getResources().getColor(R.color.green));



            }
        });
        return v;
    }

}
