package michael.co.myfirstgithub;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import michael.co.model.Sum;

public class MainActivity extends AppCompatActivity {
    private     TextInputEditText   etGetNumber;
    private     MaterialButton      btnAddNumber;
    private     MaterialButton      btnRemoveNumber;
    private     MaterialButton      btnShowResult;
    private     Sum                 sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeObjects();
        initializeViews();
    }

    private void initializeViews() {
        etGetNumber =       (TextInputEditText) findViewById(R.id.etGetNumber);
        btnAddNumber =      (MaterialButton)    findViewById(R.id.btnAddNumber);
        btnRemoveNumber =   (MaterialButton)    findViewById(R.id.btnRemoveNumber);
        btnShowResult =     (MaterialButton)    findViewById(R.id.btnShowResult);
        initializeOnClickListeners();
    }

    private void initializeOnClickListeners() {
        btnAddNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.requireNonNull(etGetNumber.getText()).toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Number missing", Toast.LENGTH_SHORT).show();
                }
                else{
                    sum.insert(Integer.parseInt(etGetNumber.getText().toString()));
                    etGetNumber.setText("");
                }
            }
        });
        btnRemoveNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sum.isEmpty()){
                    Toast.makeText(MainActivity.this, "Nothing to delete: empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    sum.deletePrevious();
                    Toast.makeText(MainActivity.this, "Previous deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "The sum is: " + sum.getSum(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initializeObjects() {
        sum = new Sum();
    }
}