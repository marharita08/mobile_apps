package it_school.sumdu.edu.ua.recipebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String[] headers;
    private String[] descriptions;

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headers = getResources().getStringArray(R.array.recipe_headers);
        descriptions = getResources().getStringArray(R.array.recipe_descriptions);
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, headers, descriptions);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}