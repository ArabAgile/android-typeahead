package com.arabagile.typeahead;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arabagile.typeahead.model.User;
import com.arabagile.typeahead.util.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agile on 5/26/15.
 */
public final class MentionAdapter extends ArrayAdapter<User> {

    private static final String LOG_TAG = MentionAdapter.class.getSimpleName();

    Context context;
    int layoutResourceId;

    private ArrayList<User> suggestions;
    private List<User> users; // Dataset

    private LayoutInflater mInflater;

    public MentionAdapter(Context context, int layoutResourceId, List<User> users) {
        super(context, layoutResourceId, users);
        this.users = users;
        _init(context, layoutResourceId);
    }

    public MentionAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);
        _init(context, layoutResourceId);
    }

    public void _init(Context context, int resource) {
        this.suggestions      = new ArrayList<User>();
        this.context          = context;
        this.layoutResourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        UserHolder holder = null;

        if(row == null)
        {
            mInflater = ((Activity)context).getLayoutInflater();
            row = mInflater.inflate(layoutResourceId, parent, false);

            holder = new UserHolder();
            holder.photo          = (ImageView)row.findViewById(R.id.photo);
            holder.fullname       = (TextView)row.findViewById(R.id.fullname);
            holder.username       = (TextView)row.findViewById(R.id.username);

            row.setTag(holder);
        }
        else
        {
            holder = (UserHolder)row.getTag();
        }

        User user = suggestions.get(position);
        String fullname   = user.getFullname();
        String username   = user.getUsername();
        String photoUrl   = user.getPhoto();

        holder.fullname.setText(fullname);
        holder.username.setText("@" + username);
        Image.load(context, photoUrl, holder.photo);

        return row;
    }

    @Override
    public int getCount() {
        return suggestions.size();
    }

    @Override
    public User getItem(int position) {
        return suggestions.get(position);
    }

    static class UserHolder
    {
        TextView fullname;
        TextView username;
        ImageView photo;
    }

    @Override
    public Filter getFilter() {

        Filter userFilter = new Filter() {
            public String convertResultToString(Object resultValue) {
                String str = ((User) (resultValue)).getUsername();
                return str;
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint != null && !constraint.toString().contains("\n")
                        && !constraint.toString().contains(" ")) {
                    suggestions.clear();

                    String query = constraint.toString().toLowerCase();
                    if (users.size() > 0) {
                        suggestions.clear();
                        // Disable popup menu when user already selected
                        if (users.size() == 1 && users.get(0).getUsername().contentEquals(query)) {
                            // Do nothing!
                        } else {
                            for (int i = 0; i < users.size(); i++) {
                                // Perform search query
                                if (users.get(i).getUsername().toLowerCase().startsWith(query)
                                        || users.get(i).getFullname().toLowerCase().startsWith(query))
                                {
                                    suggestions.add(users.get(i));
                                }
                            }
                        }
                    }

                    filterResults.count  = suggestions.size();
                    filterResults.values = suggestions;
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
            }
        };

        return userFilter;
    }
}
