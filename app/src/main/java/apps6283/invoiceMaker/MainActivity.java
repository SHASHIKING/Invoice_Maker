package apps6283.invoiceMaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {
                Intent startActivity = new Intent(MainActivity.this, Home.class);
                startActivity(startActivity);
                finish();
            }
        }, 2000);


    }
}