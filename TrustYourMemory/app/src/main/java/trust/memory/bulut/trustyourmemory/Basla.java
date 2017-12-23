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

public class Basla extends AppCompatActivity {

    private Button kolay;
    private Button orta;
    private Button zor;
    private Button geri;

    //private AdView adView;
    private String reklam="ca-app-pub-2467257044607400/9379772375";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basla);

        kolay = (Button) findViewById(R.id.kolay);
        orta  = (Button) findViewById(R.id.orta);
        zor   = (Button) findViewById(R.id.zor);
        geri  = (Button) findViewById(R.id.geri);



        kolay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Basla.this, Kolay.class);
                startActivity(intent);
            }
        });

        orta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Basla.this, Orta.class);
                startActivity(intent);
            }
        });

        zor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Basla.this, Zor.class);
                startActivity(intent);
            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Basla.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Basla.this, MainActivity.class);
        startActivity(intent);
    }
}
