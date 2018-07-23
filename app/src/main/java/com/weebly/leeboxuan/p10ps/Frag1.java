package com.weebly.leeboxuan.p10ps;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btnChangeColor;
    LinearLayout ly;
    ZoomageView zm;
    public Frag1() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_frag1, container, false);

        btnChangeColor = (Button) v.findViewById(R.id.btnChange);
        ly = (LinearLayout) v.findViewById(R.id.ly);
        zm = (ZoomageView) v.findViewById(R.id.myZoomageView);

        String imageUrl = "https://78.media.tumblr.com/13a0abf71668db34da356fe7d904ce1a/tumblr_pbd8kxXujZ1roqv59o1_500.png";
        Picasso.with(v.getContext()).load(imageUrl).into(zm);
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ly.setBackgroundColor(getResources().getColor(R.color.blue));



            }
        });
        return v;




    }

}
