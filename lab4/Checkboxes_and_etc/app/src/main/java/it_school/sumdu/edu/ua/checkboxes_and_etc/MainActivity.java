package it_school.sumdu.edu.ua.checkboxes_and_etc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.checkboxes);
            String toastMessage = "Toppings: ";
            for (int i = 0; i < layout.getChildCount(); i++) {
                CheckBox checkBox = (CheckBox) layout.getChildAt(i);
                if (checkBox.isChecked()) {
                    toastMessage += checkBox.getText() + " ";
                }
            }
            System.out.println(toastMessage);
            Toast toast = Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}