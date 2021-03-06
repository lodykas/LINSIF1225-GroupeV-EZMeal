package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import static android.R.attr.data;
import static android.R.attr.fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {



    private Recipe[] r;

    public static String cat;
    public static String souscat;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      View   view = inflater.inflate(R.layout.fragment_food, container, false);
        if (mListener != null) {
            //mListener.onFragmentInteraction("Fragment 2");
        }


        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

       // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

         //setting list adapter
        expListView.setAdapter(listAdapter);


        //Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                 //Toast.makeText(getContext(),
                 //"Group Clicked " + listDataHeader.get(groupPosition),
                 //Toast.LENGTH_SHORT).show();
                return false;
            }
        });

         //Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                //Toast.makeText(getContext(),
                      // listDataHeader.get(groupPosition) + " Expanded",
                      // Toast.LENGTH_SHORT).show();
            }
        });

         //Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                //Toast.makeText(getContext(),
                       //listDataHeader.get(groupPosition) + " Collapsed",
                       // Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override


            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                 //TODO Auto-generated method stub
                Fragment fragment = null;
                cat= listDataHeader.get(groupPosition);
                if(cat.equals("Appetizers and Snack Recipes")){
                    cat="entree";
                }
                else if(cat.equals("Main dishes")){
                    cat="plat";
                }
                else{
                    cat="dessert";
                }
                Menuetage.doubletap=false;

                souscat =listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                souscat=souscat.toLowerCase();



                Fragment newFragment = new PlusFrag2();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                transaction.replace(R.id.mainFrame, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();

                return false;
            }
        });

     return view;
    }





    /*
     * Preparing the list data
     */

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Appetizers and Snack Recipes");
        listDataHeader.add("Main dishes");
        listDataHeader.add("Dessert");

        // Adding child data
        List<String> app = new ArrayList<String>();
        app.add("Hot");
        app.add("Cold");
        app.add("Soups");
        app.add("Asian");
        app.add("Italian");
        app.add("American");
        app.add("Other origine");

        List<String> dishes= new ArrayList<String>();
        dishes.add("Meat");
        dishes.add("Fish");
        dishes.add("Vegetarian");
        dishes.add("Asian");
        dishes.add("Italian");
        dishes.add("American");
        dishes.add("Other origine");

        List<String> dessert = new ArrayList<String>();
        dessert.add("Quick and easy");
        dessert.add("Hot");
        dessert.add("Cake");
        dessert.add("Asian");
        dessert.add("Italian");
        dessert.add("American");
        dessert.add("Other origine");

        listDataChild.put(listDataHeader.get(0), app); // Header, Child data
        listDataChild.put(listDataHeader.get(1), dishes);
        listDataChild.put(listDataHeader.get(2), dessert);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }

}
