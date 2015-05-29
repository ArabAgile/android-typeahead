package com.arabagile.typeahead.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MultiAutoCompleteTextView;

import com.arabagile.typeahead.AtTokenizer;
import com.arabagile.typeahead.MentionAdapter;
import com.arabagile.typeahead.MentionTextWatcher;
import com.arabagile.typeahead.R;
import com.arabagile.typeahead.model.User;
import com.arabagile.typeahead.widget.TypeaheadTextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    MultiAutoCompleteTextView tvAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAutoComplete = (TypeaheadTextView) findViewById(R.id.tvAutoComplete);

        // Dummy dataset
        List<User> users = new ArrayList<>();
        users.add(new User("Arab Agile", "arabagile", "http://www.gravatar.com/avatar/fc58e5bfbdf68ae2d7cc0b145cd27794?s=64"));
        users.add(new User("Ammar Basha", "elbasha", "http://gravatar.com/avatar/73883b3fe159213faa5c80e7b5f33ef8?s=65"));
        users.add(new User("Mary Angel", "mariana", "http://gravatar.com/avatar/38bc81642c20ff6181f3b39d91829ef8?s=64"));
        users.add(new User("Cristina", "cristina", "http://gravatar.com/avatar/55abbae35d82f050bc482aa5b457ce28?s=64"));
        users.add(new User("Bob Alexander", "bob", "http://gravatar.com/avatar/d6924c79ed9ba7fdc49c1b591a051c2f?s=64"));

        MentionAdapter adapter = new MentionAdapter(this, R.layout.mention_menu, users);

        tvAutoComplete.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
