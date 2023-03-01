package it_school.sumdu.edu.ua.testdrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private int level = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton buttonMinus = findViewById(R.id.btn_minus);
        ImageButton buttonPlus = findViewById(R.id.btn_plus);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        imageView = findViewById(R.id.imageView);
        imageView.setImageLevel(level);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_minus:
                if (level > 0) {
                    level--;
                }
                break;
            case R.id.btn_plus:
                if (level < 7) {
                    level++;
                }
                break;
        }
        imageView.setImageLevel(level);
    }
}
