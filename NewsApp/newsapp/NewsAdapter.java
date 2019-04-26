package com.newsapp1.ragab.newsapp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class NewsAdapter extends ArrayAdapter<News> {

    NewsAdapter(Context context, ArrayList<News> news) {
        super(context, -1, new ArrayList<News>());
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView
                    = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView section = (TextView) convertView.findViewById(R.id.section);

        News currentNews = getItem(position);
        assert currentNews != null;
        title.setText(currentNews.getTitle());
        author.setText(currentNews.getAuthor());
        date.setText(currentNews.getDate());
        section.setText(currentNews.getSection());

        return convertView;
    }
}
