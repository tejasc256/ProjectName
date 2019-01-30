package com.example.android.projectname;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.example.android.projectname.SearchResults;
import com.example.android.projectname.SearchActivity;

public class AdvancedSearchDialog extends AppCompatDialogFragment {
    private EditText searchtext;
    private AdvancedDialogListner listner;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.advanced_search_dialog_1, null);
        searchtext = (EditText) view.findViewById(R.id.adv_search_string);
        final Intent i = new Intent(view.getContext(), SearchResults.class);

        builder.setView(view)
                .setTitle("Advanced Search")
                .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String search = searchtext.getText().toString();
                        i.putExtra("searchstring", search);
                        startActivity(i);

                    }
                });

        searchtext = (EditText) view.findViewById(R.id.adv_search_string);

        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listner = (AdvancedDialogListner) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement AdvancedDialogListener");
        }

    }

    public interface AdvancedDialogListner{
        void applyTexts(String searchterm);
    }

    public void onSearchClick(View v, String searchterm){


    }
}
