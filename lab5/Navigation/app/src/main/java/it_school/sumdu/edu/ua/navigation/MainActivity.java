package it_school.sumdu.edu.ua.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView donutImage;
    ImageView iceCreamImage;
    ImageView froyoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutImage = (ImageView) findViewById(R.id.donut);
        iceCreamImage = (ImageView) findViewById(R.id.ice_cream);
        froyoImage = (ImageView) findViewById(R.id.froyo);
        donutImage.setOnClickListener(this);
        iceCreamImage.setOnClickListener(this);
        froyoImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.donut:
                intent = new Intent(MainActivity.this, DonutActivity.class);
                break;
            case R.id.ice_cream:
                intent = new Intent(MainActivity.this, IceCreamActivity.class);
                break;
            case R.id.froyo:
                intent = new Intent(MainActivity.this, FroyoActivity.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        startActivity(intent);

    }
}