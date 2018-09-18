package pk.edu.scocs.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
boolean backPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCars = findViewById(R.id.lvCars);
        String[] cars = {
                "Bugatti",
                "Honda Civic",
                "Honda City",
                "Lamborghini",
                "Porsche",
                "Alto",
                "Corolla",
                "Vitz",
                "Cultus",
                "Ferrari",
                "McLaren",
                "Aston Martin",
                "Audi",
                "BMW",
                "Cadillac",
                "Chevrolet",
                "Datsun",
                "Ford",
                "Mercedes"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, cars);
        lvCars.setAdapter(adapter);

        ToastClick();
    }

    private void ToastClick() {
        ListView lvCars = (ListView) findViewById(R.id.lvCars);
        lvCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView tvCarName = (TextView) viewClicked;
                String message = "You Clicked #" + position + ". Which is " + tvCarName.getText().toString();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(!backPressed) {
            backPressed = true;
            Toast.makeText(MainActivity.this, "Press Back Again to Exit", Toast.LENGTH_SHORT).show();
        }
        else
            super.onBackPressed();
    }
}
