package it_school.sumdu.edu.ua.recipebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        int recipeNumber = getIntent().getIntExtra(WordListAdapter.RECIPE_NUMBER_STRING, 1);
        Resources resources = getResources();

        String[] recipeIngredients = resources.getStringArray(R.array.recipe_ingredients);
        String[] recipeInstructions = resources.getStringArray(R.array.recipe_instructions);
        String[] images = resources.getStringArray(R.array.images);
        String[] headers = resources.getStringArray(R.array.recipe_headers);

        TextView ingredientsView = findViewById(R.id.ingredients);
        TextView instructionsView = findViewById(R.id.instructions);
        ImageView image = findViewById(R.id.image);
        int imageId = resources.getIdentifier(images[recipeNumber], "drawable", getPackageName());

        ingredientsView.setText(recipeIngredients[recipeNumber]);
        instructionsView.setText(recipeInstructions[recipeNumber]);
        image.setImageResource(imageId);
        Objects.requireNonNull(this.getSupportActionBar()).setTitle(headers[recipeNumber]);
    }
}