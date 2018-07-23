package com.weebly.leeboxuan.p10ps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.Channel;
import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * A simple {@link Fragment} subclass.

 */
@SuppressLint("ValidFragment")

public class RssFragments extends Fragment  implements RssReader.RssCallback{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private RssReader rssReader = new RssReader(this);


    // TODO: Rename and change types of parameters
     Channel.Item currentItem;
     int currentPosition;


    public RssFragments(Channel.Item item, int position) {
        // Required empty public constructor
        currentItem = item;
        currentPosition = position;
    }


    TextView tv;
    ZoomageView zm;

    @SuppressLint({"SetTextI18n"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rss_fragments, container, false);
        tv = v.findViewById(R.id.tv);
        zm = (ZoomageView) v.findViewById(R.id.myZoomageView);
        String description = currentItem.getDescription();
        String[] component = description.split("<br/>");
        String imgXML = component[0];
        tv.setText(currentPosition
                + "\n" + currentItem.getTitle() + "\n" + component[1]);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(imgXML)));

            NamedNodeMap img = document.getElementsByTagName("img").item(0).getAttributes();
            String imgURL = img.getNamedItem("src").getNodeValue()
                    .trim().replaceAll(" ", "%20").replaceAll("http", "https");

            Picasso.with(v.getContext()).load(imgURL).into(zm);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return v;
    }


    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {

    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {

    }
}

