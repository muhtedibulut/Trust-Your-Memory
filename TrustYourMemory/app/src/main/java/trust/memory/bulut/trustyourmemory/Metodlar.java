package trust.memory.bulut.trustyourmemory;


import java.util.Random;

public class Metodlar {

    Random rand=new Random();

    public int[][] matrisAtama(int a[][],int level)
    {
        int satir,sutun;

        /*Gelecek olan  level matrisin toplam boyundan küçükse (ÖR.3X3 matrisin toplam boyutu yani alabileceği değer 9 tanedir) */
        if(level<(a.length * a.length) + 1)
        {
            for(int i=0;i<level;i++)
            {
                /*Random ile rastgele satir ve sutun al*/
                satir=rand.nextInt(a.length);
                sutun=rand.nextInt(a.length);
                /*gelecek olan matriste rasgele seçilmiş olan konumudaki değer eğer sıfır ise oraya (i+1) ekle*/
                if(a[satir][sutun]==0)
                {
                    a[satir][sutun]=i+1;
                }
                /*Değil ise tekrar  random alması için "for" bir daha çalışması lazım ve "i" bir azaltılır */
                else
                {
                    i--;
                }
            }
        }
        /*Gelecek olan  level matrisin toplam boyundan büyükse */
        else
        {
            for(int i=0;i<a.length * a.length ;i++)
            {
                satir=rand.nextInt(a.length);
                sutun=rand.nextInt(a.length);
                if(a[satir][sutun]==0)
                {
                    a[satir][sutun]=i+1;
                }
                else
                {
                    i--;
                }
            }
        }

        return a;
    }
    /*gelecek olan matrisin tüm elemanları sıfırlar*/
    public int[][] sifirla(int a[][])
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length;j++)
            {
                a[i][j]=0;
            }
        }
        return a;
    }
}
