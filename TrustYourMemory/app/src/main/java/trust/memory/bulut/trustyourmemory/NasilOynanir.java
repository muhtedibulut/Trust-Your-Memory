package trust.memory.bulut.trustyourmemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;*/
import com.memory.bulut.trustyourmemory.R;

public class NasilOynanir extends AppCompatActivity {

    //private AdView adView;
    private String reklam="ca-app-pub-2467257044607400/3193637979";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasil_oynanir);


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NasilOynanir.this, MainActivity.class);
        startActivity(intent);
    }


}
