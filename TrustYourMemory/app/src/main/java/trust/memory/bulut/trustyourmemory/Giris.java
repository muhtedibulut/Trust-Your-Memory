package trust.memory.bulut.trustyourmemory;

import  android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.memory.bulut.trustyourmemory.R;

public class Giris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        /*Oyun ilk açıldığında 3 saniye boyunca bu sayfada kalacak*/
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    /*Saniye bitttikten sonra "MainActivity" sınıfına geçecek*/
                    Intent intent = new Intent(Giris.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
    /*Telefonun "exit" tuşuna bastığında*/
    @Override
    public void onBackPressed() {
        /*Uygulamadan çıkacak*/
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
