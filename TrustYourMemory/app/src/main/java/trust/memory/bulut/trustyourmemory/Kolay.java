package trust.memory.bulut.trustyourmemory;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
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

public class Kolay extends AppCompatActivity {
    /*oyunda kullanılan renkler*/
    /*kırmızı erenk*/
    private String Renk="#ff0000";
    /*yeşi erenk*/
    private String Renk1="#40ff00";
    /*siyah erenk*/
    private String Renk2="#000000";
    final int KirmiziRenk = Color.parseColor(Renk);
    final int MaviRenk =Color.parseColor(Renk1);
    final int SiyahRenk=Color.parseColor(Renk2);
    /*üstünde işlem yapacağımız matris tanımlanıyor */
    int[][] matris= new int[3][3];
    private int sayac;
    private int i,j;
    /*Metodlar sınıfından nesne oluşturuluyor*/
    public Metodlar oyna = new Metodlar();
    //TextView[][] gosterim = new TextView[3][3];
    /*butonlar oluşturuluyor*/
    Button[][] btn = new Button[3][3];

    /*Kullanıcıya kaç hamle kaldığını, kaçıncı levelde olduğunu ve kaç saniyesi kaldığını göstermek için gereken değişkenler*/
    private TextView txt,seviye,kalan;
    int level;
    /*zamanlayı başlatmak için gereken fonksiyon (CountDownTimer)*/
    private CountDownTimer timer;
    private CountDownTimer timer1,timer2,timer3;

    //private AdView adView;
    private String reklam="ca-app-pub-2467257044607400/1856505570";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolay);

        /*Kullanıcıya kaç hamle kaldığını, kaçıncı levelde olduğunu ve kaç saniyesi kaldığını göstermek için gereken değişkenler tanımlanıyor*/
        seviye = (TextView) findViewById(R.id.seviye);
        txt = (TextView) findViewById(R.id.saniye);
        kalan = (TextView) findViewById(R.id.kalan);

        /*butonlar tanımlanıyor*/
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                String butonid="btn_" + i + "_" + j;
                int btnid = getResources().getIdentifier(butonid , "id" ,getPackageName());
                btn[i][j] = (Button) findViewById(btnid);
            }
        }


        /*gosterim[0][0] = (TextView) findViewById(R.id.t00);
        gosterim[0][1] = (TextView) findViewById(R.id.t01);
        gosterim[0][2] = (TextView) findViewById(R.id.t02);
        gosterim[1][0] = (TextView) findViewById(R.id.t10);
        gosterim[1][1] = (TextView) findViewById(R.id.t11);
        gosterim[1][2] = (TextView) findViewById(R.id.t12);
        gosterim[2][0] = (TextView) findViewById(R.id.t20);
        gosterim[2][1] = (TextView) findViewById(R.id.t21);
        gosterim[2][2] = (TextView) findViewById(R.id.t22);*/


        /*Oyun ilk açıldığında çalışacak olan metod*/
        resetle();

        /*6 saniye içinde */
        timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {
                /*Kulanıcıya kaç saniyesi kaldığını gösterir*/
                //txt1.setText("" + l/1000);
                txt.setTextColor(KirmiziRenk);
                txt.setText("" + l/1000);
                /*bu metodu "true" paremetresi göndererek tüm butonların yazısı gösterir */
                buton_text(true);
                /*bu metodu "false" parametresini gönndererek tüm butonları devre dışı bırakır*/
                buton_enabled(false);
            }
            /*6 saniye bittiğinde yapılacak olanlar*/
            @Override
            public void onFinish() {
                //txt1.setText("" + "");
                txt.setText("" + "");
                /*bu metodu "false" paremetresi göndererek tüm butonların yazısı siler*/
                buton_text(false);
                /*bu metodu "true" parametresini göndererek tüm butonları aktifleştirir */
                buton_enabled(true);
                /*kullanıcının sayıları bilmesi için 20 saniye verilir*/
                timer1 = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long l) {
                        /*saniye 5'ten büyükse saniyeyi siyah renkle göster değilse kırmızı renkle göster*/
                        if(l/1000 >5)
                        {
                            txt.setTextColor(SiyahRenk);
                        }
                        else
                        {
                            txt.setTextColor(KirmiziRenk);
                        }
                        txt.setText("" + l/1000);
                    }
                    /*20 saniye bittiğinde kullanıcı verilen saniye içinde bilememiş demektir ve saniye bittikten sonra yapılacak olanlar*/
                    @Override
                    public void onFinish() {
                        /*GameOver sayfasına git*/
                        Intent intent = new Intent(Kolay.this, GameOver.class);
                        /*Scoru GameOver sayfasına gönder*/
                        intent.putExtra("puan",(level - 2));
                        intent.putExtra("derece",3);
                        startActivity(intent);
                    }
                }.start();
            }
        }.start();


        /*6 saniye içinde */
        timer2 = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                /*Kulanıcıya kaç saniyesi kaldığını gösterir*/
                //txt1.setText("" + l/1000);
                txt.setTextColor(KirmiziRenk);
                txt.setText("" + l/1000);
                /*bu metodu "true" paremetresi göndererek tüm butonların yazısı gösterir */
                buton_text(true);
                /*bu metodu "false" parametresini gönndererek tüm butonları devre dışı bırakır*/
                buton_enabled(false);
            }
            /*6 saniye bittiğinde yapılacak olanlar*/
            @Override
            public void onFinish() {
                //txt1.setText("" + "");
                txt.setText("" + "");
                /*bu metodu "false" paremetresi göndererek tüm butonların yazısı siler*/
                buton_text(false);
                /*bu metodu "true" parametresini göndererek tüm butonları aktifleştirir */
                buton_enabled(true);
                /*kullanıcının sayıları bilmesi için 20 saniye verilir*/
                timer3 = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long l) {
                        /*saniye 5'ten büyükse saniyeyi siyah renkle göster değilse kırmızı renkle göster*/
                        if(l/1000 >5)
                        {
                            txt.setTextColor(SiyahRenk);
                        }
                        else
                        {
                            txt.setTextColor(KirmiziRenk);
                        }
                        txt.setText("" + l/1000);
                    }
                    /*20 saniye bittiğinde kullanıcı verilen saniye içinde bilememiş demektir ve saniye bittikten sonra yapılacak olanlar*/
                    @Override
                    public void onFinish() {
                        /*GameOver sayfasına git*/
                        Intent intent = new Intent(Kolay.this, GameOver.class);
                        /*Scoru GameOver sayfasına gönder*/
                        intent.putExtra("puan",(level - 2));
                        intent.putExtra("derece",3);
                        startActivity(intent);
                    }
                }.start();
            }
        };
    }
    /*Telefonun "exit" tuşuna bastığında*/
    @Override
    public void onBackPressed() {
        /*zamanlamaları kapat*/
        if(level <7)
        {
            if(timer1!=null){
                timer1.cancel();
            }
            timer.cancel();
        }
        else
        {
            if(timer3!=null){
                timer3.cancel();
            }
            timer2.cancel();
        }
        /*if(timer1!=null){
            timer1.cancel();
        }
        timer.cancel();*/
        /*Basla sayfasına git*/
        Intent intent = new Intent(Kolay.this, Basla.class);
        startActivity(intent);
    }



    /*Level atladığında çalışacak olan metod*/
    public void levelAtla()
    {
        level++;
        sayac=1;
        txt.setText("");
        /*matris sıfırlanır*/
        matris=oyna.sifirla(matris);
        /*matrise değer atılır*/
        matris=oyna.matrisAtama(matris,level);
        /* bu metodu çağırarak tüm butonların rengini siyahlaştır*/
        buton_textColor();
        //goster();
        /*bu metodu "true" parametresini gönndererek tüm butonları aktifleştirir */
        buton_enabled(true);
        /*zamanlamayı başlat*/
        if(level<7)
        {
            timer.start();
        }
        else
        {
            timer2.start();
        }
        //timer.start();
        /*bu metodu "false" paremetresi göndererek tüm butonların yazısı siler*/
        buton_text(false);
        /*kullanıcıya kaçıncı levelde olduğunu gösterir*/
        seviye.setText("" + (level - 2));
        if(level<10)
        {
            kalan.setText("" + level);
        }
        else
        {
            kalan.setText("" + 9);
        }
    }
    /*public void goster()
    {
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                gosterim[i][j].setText("" + matris[i][j]);
            }
        }
    }*/
    /*Oyun ilk açılırken başlatılacak olan metod*/
    public void resetle()
    {
        level=3;
        sayac=1;
        /*matris sıfırlanır*/
        matris=oyna.sifirla(matris);
        /*matrise değer atılır*/
        matris=oyna.matrisAtama(matris,level);
        /* bu metodu çağırarak tüm butonların rengini siyahlaştır*/
        buton_textColor();
        //goster();
        /*bu metodu "true" parametresini gönndererek tüm butonları aktifleştirir*/
        buton_enabled(true);
        /*kullanıcıya kaçıncı levelde olduğunu gösterir*/
        seviye.setText("" + (level - 2));
        /*kullanıcıya kaç hamle olduğunu gösterir*/
        kalan.setText("" + level);
    }
    /*gelen paremetreye göre butonları devre dışı  bırakır veya aktifleştirir*/
    public  void buton_enabled(boolean bool)
    {
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                btn[i][j].setEnabled(bool);
            }
        }
    }
    /*bu metod çalıştığında tüm butonların yazı rengi siyah olur*/
    public void buton_textColor()
    {
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                btn[i][j].setTextColor(SiyahRenk);
            }
        }
    }
    /*bu metod çalıştığında gelecek olan boolean değerine göre butonların yazısının gösterilip gösterilmiyeceğini belirler*/
    public void buton_text(boolean a)
    {
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                if(a==true)
                {
                    if(matris[i][j]!=0)
                    {
                        btn[i][j].setText("" + matris[i][j]);
                    }
                }
                else
                {
                    btn[i][j].setText("");
                }
            }
        }
    }
    /*Her butona basıldığında bu metod çalışır*/
    public void buton_basildi(View v)
    {
        final Button buton = (Button) v;
        /*Butonun "id" sini alır(ÖR. btn_0_0)*/
        String IdAsString = buton.getResources().getResourceName(buton.getId());
        /*aldığı id'yi "_" karakterine göre parçalar*/
        String[] parts = IdAsString.split("_");
        /*butonun konumunun belli olduğu değerleri alır*/
        String part2 = parts[1];
        String part3 = parts[2];
        final int satir,sutun;
        /*butonun kunumunu int "satir" ve "sutun" değişkenlerine pars eder*/
        satir = Integer.parseInt(part2);
        sutun = Integer.parseInt(part3);
        /*Eğer bastığın buton matrisin o kkonumundaki değer ile sayac aynı ise*/
        if(matris[satir][sutun]==sayac)
        {
            /*o butonun yazısını matristeki değerini göster*/
            buton.setText("" + matris[satir][sutun]);
            /*butonun yazı rengini yeşil yap*/
            buton.setTextColor(MaviRenk);
            /*sayacı artır*/
            sayac++;
            /*Kalan hamle sayısını göster*/
            if(level<10)
            {
                kalan.setText("" + (level - sayac + 1));
            }
            else
            {
                kalan.setText("" + (10 - sayac));
            }
        }
        /*Değil ise bilememiş demektir*/
        else
        {
            /*2 saniye bekle*/
            new CountDownTimer(2000, 1000) {
                @Override
                public void onTick(long l) {
                    /*matristeki tüm değerleri göster*/
                    buton_text(true);
                    /*bastığın yerde matristeki değeri sıfır ise "X" karakterini  kırmızı renkle göster*/
                    if(matris[satir][sutun]==0)
                    {
                        buton.setText("X");
                        buton.setTextColor(KirmiziRenk);
                    }
                    /*bastığın yerde matristeki değeri sıfır  değil ise matrisin o kunumdaki değerini  kırmızı renkle göster*/
                    else
                    {
                        buton.setText("" + matris[satir][sutun]);
                        buton.setTextColor(KirmiziRenk);
                    }
                    /*butonları devre dışı bırak*/
                    buton_enabled(false);
                    /*zamanlamaları kapat*/
                    if(level<7)
                    {
                        timer.cancel();
                        timer1.cancel();
                    }
                    else
                    {
                        timer2.cancel();
                        timer3.cancel();
                    }
                    //timer.cancel();
                    //timer1.cancel();
                    txt.setText("");
                }
                /*2 saniye bittiğinde*/
                @Override
                public void onFinish() {
                    /*GameOver sayfasına git*/
                    Intent intent = new Intent(Kolay.this, GameOver.class);
                    /*Scorun kaç olduğunu gönder*/
                    intent.putExtra("puan",(level - 2));
                    intent.putExtra("derece",3);
                    startActivity(intent);
                }
            }.start();
        }
        if(level<10)
        {
            /*hamle sayısı kalmadığında(yani kullanıcı tüm sayıları bildiğinde)*/
            if(sayac - 1 ==level)
            {
                /*butonları devre dışı bırak*/
                buton_enabled(false);
                /*zamanlamaları kapat*/
                if(level<7)
                {
                    timer.cancel();
                    timer1.cancel();
                }
                else
                {
                    timer2.cancel();
                    timer3.cancel();
                }
                //timer.cancel();
                //timer1.cancel();
                txt.setText("");
                /*1 saniye bekle*/
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        /*butonları devre dışı bırak*/
                        buton_enabled(false);
                    }
                    /*saniye bittiğinde*/
                    @Override
                    public void onFinish() {
                        /*level atla*/
                        levelAtla();
                    }
                }.start();
            }
        }
        else
        {
            /*hamle sayısı kalmadığında(yani kullanıcı tüm sayıları bildiğinde)*/
            if(sayac==10)
            {
                /*butonları devre dışı bırak*/
                buton_enabled(false);
                /*zamanlamaları kapat*/
                if(level<7)
                {
                    timer.cancel();
                    timer1.cancel();
                }
                else
                {
                    timer2.cancel();
                    timer3.cancel();
                }
                //timer.cancel();
                //timer1.cancel();
                txt.setText("");
                /*1 saniye bekle*/
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        /*butonları devre dışı bırak*/
                        buton_enabled(false);
                    }

                    @Override
                    public void onFinish() {
                        /*level atla*/
                        levelAtla();
                    }
                }.start();
            }
        }
    }
}
