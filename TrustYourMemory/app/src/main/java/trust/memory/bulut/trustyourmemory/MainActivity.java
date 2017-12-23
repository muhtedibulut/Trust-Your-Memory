package trust.memory.bulut.trustyourmemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;*/
import com.memory.bulut.trustyourmemory.R;

public class MainActivity extends AppCompatActivity {

    private Button oyna;
    private Button nasil;
    private Button cikis;

    //private AdView adView;
    private String reklam="ca-app-pub-2467257044607400/7903039178";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oyna =  (Button) findViewById(R.id.oyna);
        nasil = (Button) findViewById(R.id.nasiloynanir);
        cikis = (Button) findViewById(R.id.cikis);



        oyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Basla.class);
                startActivity(intent);
            }
        });

        nasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NasilOynanir.class);
                startActivity(intent);
            }
        });

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
