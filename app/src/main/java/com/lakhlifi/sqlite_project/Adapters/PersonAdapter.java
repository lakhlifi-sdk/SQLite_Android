package com.lakhlifi.sqlite_project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lakhlifi.sqlite_project.Models.Person;
import com.lakhlifi.sqlite_project.R;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Person> {

    public PersonAdapter(Context context, ArrayList<Person> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.person_row, parent, false);
        }

        TextView firstName = (TextView) convertView.findViewById(R.id.txt_v_first_name);
        TextView lastName = (TextView) convertView.findViewById(R.id.txt_v_last_name);
        TextView avgNote = (TextView) convertView.findViewById(R.id.txt_v_note);
        // Populate the data into the template view using the data object
        firstName.setText(person.getFirst_name());
        lastName.setText(person.getLast_name());
        avgNote.setText(  person.getNotes_average()+"");
        return convertView;

    }
}
