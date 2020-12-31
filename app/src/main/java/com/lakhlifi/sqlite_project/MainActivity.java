package com.lakhlifi.sqlite_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.lakhlifi.sqlite_project.Adapters.PersonAdapter;
import com.lakhlifi.sqlite_project.Models.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        MyDatabase db = new MyDatabase(this);
        db.addPerson(new Person(1,"mmmmmm","Essaddiq",  19.57));
        db.addPerson(new Person(2,"LAkhlifi","nnnnnnn",  18.54));
        db.addPerson(new Person(3,"Anas","Anis",  17.23));
        db.addPerson(new Person(4,"Liam","mmmmmmm", 18.5));
        db.addPerson(new Person(1,"mmmmmmmmm","Essaddiq",  19.57));
        db.addPerson(new Person(2,"LAkhlifi","Imad",  18.54));
        System.out.println("***********************************************************************"+db);

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Person> persons = db.getAllPersons();

        for (Person cn : persons) {
            String log = "Id: " + cn.getCode() + " ,Name: " + cn.getFirst_name() + " ,Phone: " +
                    cn.getLast_name();
            // Writing Contacts to log
            System.out.println("___________>"+cn);
        }

       // Construct the data source
        ArrayList<Person> arrayOfPersons = new ArrayList<Person>();
        arrayOfPersons.add(new Person(1,"Lakhlifi","Essaddiq",  19.57));

        // Create the adapter to convert the array to views
        PersonAdapter adapter = new PersonAdapter(this, (ArrayList<Person>) persons);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }


}