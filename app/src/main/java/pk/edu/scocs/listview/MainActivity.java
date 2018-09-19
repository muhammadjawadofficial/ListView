package pk.edu.scocs.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean backPressed = false;

    EditText etData;
    ListView lvList;
    Button btAdd;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.inputField);
        lvList = findViewById(R.id.lvCars);
        btAdd = findViewById(R.id.btnAdd);

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        lvList.setAdapter(arrayAdapter);

        addItem();
        ToastClick();
    }

    private void ToastClick() {
        ListView lvCars = (ListView) findViewById(R.id.lvCars);
        lvCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView tvCarName = (TextView) viewClicked;
                String message = "You Clicked #" + position + ". Which is " + tvCarName.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!backPressed) {
            backPressed = true;
            Toast.makeText(MainActivity.this, "Press Back Again to Exit", Toast.LENGTH_SHORT).show();
        } else
            super.onBackPressed();
    }
    public void addItem() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = etData.getText().toString();
                if(!item.trim().isEmpty()) {
                    etData.getText().clear();
                    arrayList.add(item);
                    arrayAdapter.notifyDataSetChanged();
                }
                else
                    Toast.makeText(MainActivity.this, "No data found. Please write something", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
