package trust.memory.bulut.trustyourmemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;*/
import com.memory.bulut.trustyourmemory.R;

public class GameOver extends AppCompatActivity {

    int puan;
    int derece;

    //private AdView adView;
    private String reklam="ca-app-pub-2467257044607400/1716904779";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Button tekrardene= (Button) findViewById(R.id.tekrardene);
        Button yenioyun = (Button) findViewById(R.id.yenioyun);
        TextView score = (TextView) findViewById(R.id.score);



        Bundle vericekme = getIntent().getExtras();
        puan = vericekme.getInt("puan");
        derece = vericekme.getInt("derece");
        score.setText("Score :" + puan);

        /*Tekrar Dene butonuna bastığında*/
        tekrardene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Eğer derece 3 ise "kolay" sayfasına git demektir*/
                if(derece==3)
                {
                    Intent intent = new Intent(GameOver.this, Kolay.class);
                    startActivity(intent);
                }
                /*Eğer derece 4 ise "orta" sayfasına git demektir*/
                else if(derece==4)
                {
                    Intent intent = new Intent(GameOver.this, Orta.class);
                    startActivity(intent);
                }
                /*Eğer derece 5 ise "zor" sayfasına git demektir*/
                else
                {
                    Intent intent = new Intent(GameOver.this, Zor.class);
                    startActivity(intent);
                }
            }
        });

        /*Yeni Oyun butonuna bastığında "Basla" sayfasına git*/
        yenioyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOver.this, Basla.class);
                startActivity(intent);
            }
        });
    }
    /*Telefonun "exit" tuşuna bastığında*/
    @Override
    public void onBackPressed() {
        /*Basla sayfasına git*/
        Intent intent = new Intent(GameOver.this, Basla.class);
        startActivity(intent);
    }
}
