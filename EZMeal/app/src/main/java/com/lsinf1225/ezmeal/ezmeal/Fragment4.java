package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment4 newInstance(String param1, String param2) {
        Fragment4 fragment = new Fragment4();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_statistics, container, false);
        Button b = (Button) view.findViewById(R.id.calculate);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteManager db = new SQLiteManager(getActivity().getApplicationContext());
                String usermail = getActivity().getIntent().getStringExtra("usermail");
                TextView recipeshow = (TextView)getActivity().findViewById(R.id.MostRecipeShow);
                List<String> Recipes = db.mostRecipe(usermail);
                String mostRecipe = Recipes.get(0).toString();
                recipeshow.setText(mostRecipe);

                TextView ingredientshow = (TextView)getActivity().findViewById(R.id.MostIngredientShow);
                List<String> Ingredients = db.mostIngredient(usermail);
                String mostIngredient = Ingredients.get(0).toString();
                ingredientshow.setText(mostIngredient);

                TextView originshow = (TextView)getActivity().findViewById(R.id.OriginShow);
                List<String> Origins = db.mostOrigin(usermail);
                String mostOrigin = Origins.get(0).toString();
                originshow.setText(mostOrigin);

                TextView categoryshow = (TextView)getActivity().findViewById(R.id.CategoryShow);
                List<String> Categorys = db.mostCategory(usermail);
                String mostCategory = Categorys.get(0).toString();
                categoryshow.setText(mostCategory);

                TextView timeshow = (TextView)getActivity().findViewById(R.id.TimeShow);
                List<String> Times = db.mostTime(usermail);
                String mostTime = Times.get(0).toString();
                timeshow.setText(mostTime);

                TextView allergeneshow = (TextView)getActivity().findViewById(R.id.AllergeneShow);
                List<String> Allergenes = db.AllergenesConsomm(usermail);
                String allergenes = "";
                for (int i=0; i<Allergenes.size(); i++) {
                    allergenes += Allergenes.get(i) + " ";
                }
                allergeneshow.setText(allergenes);
            }
        });
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            //mListener.onFragmentInteraction("Fragment 4");
        }

        // Here we will can create click listners etc for all the gui elements on the fragment.
        // For eg: Button btn1= (Button) view.findViewById(R.id.frag1_btn1);
        // btn1.setOnclickListener(...

        return view;
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
