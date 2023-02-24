package it_school.sumdu.edu.ua.recipebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    public static final String RECIPE_NUMBER_STRING = "recipe number";
    private String[] headers;
    private String[] descriptions;
    private LayoutInflater mInflater;
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    public WordListAdapter(Context context, String[] headers, String[] descriptions) {
        mInflater = LayoutInflater.from(context);
        this.headers = headers;
        this.descriptions = descriptions;
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        holder.headerItemView.setText(headers[position]);
        holder.descriptionItemView.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return headers.length;
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView headerItemView;
        public final TextView descriptionItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            headerItemView = itemView.findViewById(R.id.recipe_header);
            descriptionItemView = itemView.findViewById(R.id.recipe_description);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra(RECIPE_NUMBER_STRING, getLayoutPosition());
            context.startActivity(intent);
        }
    }
}
