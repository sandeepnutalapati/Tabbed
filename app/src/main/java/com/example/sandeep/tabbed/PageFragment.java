package com.example.sandeep.tabbed;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by SANDEEP on 2/21/2018.
 */

public class PageFragment extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_page, container, false);

        final TextView textView =  view.findViewById(R.id.textView);
        String tabTitles[] = new String[] { "sunsign", "food", "career", "love", "money", "wellness" };




        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String category = ""+tabTitles[mPage-1];
        String url = "";
        if(category.equals("money")||category.equals("food")){
            url = "https://infinite-chamber-78657.herokuapp.com/"+category+"/1";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            textView.setText(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textView.setText("That didn't work!");
                }
            });
            queue.add(stringRequest);
        }
        else{
            url = "https://infinite-chamber-78657.herokuapp.com/"+category+"/1";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            textView.setText(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textView.setText("That didn't work!");
                }
            });
            queue.add(stringRequest);
        }

        textView.setText("Fragment #" + mPage);
        return view;
    }
}
