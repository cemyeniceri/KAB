package com.example.kab;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;

/** Android uygulamalar�nda t�m ekranlar Activity s�n�f�ndan t�retilmek zorundad�r.*/
public class Navigasyon extends Activity {
	
	/** Uygulama  ilk ba�lad���nda onCreate metodu �a�r�l�r.
	 *  ->setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) => Ekran�n ba�lang��ta yatay olarak a��lmas�n� sa�lar.
	 *  ->setContentView(R.layout.activity_navigasyon_ekrani) => Ekran�n "activity_navigasyon_ekrani" layoutu ile doldurulmas�n� sa�lar. 
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_navigasyon_ekrani);
    }
    
	/** Cihaz �zerindeki men� d��melerinin kullan�m� i�in gereklidir
	 *  E�er men� d��melerine farkl� anlamlar y�klenmek istenirse kod geli�tirilmelidir. 
	 *   
	 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** XML i�erisinde onClick �zelli�i onYonetici olarak tan�mlanm�� butonun kodland��� k�s�md�r. 
     * 	Ekran referans al�n�r.
     * Sayfa ge�i�inin yap�labilmesi i�in ilgili s�n�f ile gidilecek s�n�f aras�ndaki ba�lant�n�n yap�ld��� intent yarat�l�r.
     * ve Activitiy yarat�lan intent referans verilerek ba�lat�l�r.
     * */ 
    public void onKullanici(View view){
		   Intent intent = new Intent(this, SurusDestek.class);
		   startActivity(intent);
    }
    
    /** XML i�erisinde onClick �zelli�i onYonetici olarak tan�mlanm�� butonun kodland��� k�s�md�r. 
     * 	Ekran referans al�n�r.
     * Sayfa ge�i�inin yap�labilmesi i�in ilgili s�n�f ile gidilecek s�n�f aras�ndaki ba�lant�n�n yap�ld��� intent yarat�l�r.
     * ve Activitiy yarat�lan intent referans verilerek ba�lat�l�r.
     * */ 
    public void onYonetici(View view){
		   Intent intent = new Intent(this, Yonetici.class);
		   startActivity(intent);
 }
}
