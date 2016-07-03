package com.example.kab;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;

/** Android uygulamalarýnda tüm ekranlar Activity sýnýfýndan türetilmek zorundadýr.*/
public class SurusDestek extends Activity {
	
	/** Uygulama  ilk baþladýðýnda onCreate metodu çaðrýlýr.
	 *  ->setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) => Ekranýn baþlangýçta yatay olarak açýlmasýný saðlar.
	 *  ->setContentView(R.layout.activity_kullanici_ekrani) => Ekranýn "activity_kullanici_ekrani" layoutu ile doldurulmasýný saðlar. 
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_kullanici_ekrani);
    }
    
	/** Cihaz üzerindeki menü düðmelerinin kullanýmý için gereklidir
	 *  Eðer menü düðmelerine farklý anlamlar yüklenmek istenirse kod geliþtirilmelidir. 
	 *   
	 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** XML içerisinde onClick özelliði onYonetici olarak tanýmlanmýþ butonun kodlandýðý kýsýmdýr. 
     * 	Ekran referans alýnýr.
     * Sayfa geçiþinin yapýlabilmesi için ilgili sýnýf ile gidilecek sýnýf arasýndaki baðlantýnýn yapýldýðý intent yaratýlýr.
     * ve Activitiy yaratýlan intent referans verilerek baþlatýlýr.
     * */
    public void onNavigasyon(View v){
		   Intent intent = new Intent(this, Navigasyon.class);
		   startActivity(intent);
		   }
    
    /** XML içerisinde onClick özelliði onYonetici olarak tanýmlanmýþ butonun kodlandýðý kýsýmdýr. 
     * 	Ekran referans alýnýr.
     * Sayfa geçiþinin yapýlabilmesi için ilgili sýnýf ile gidilecek sýnýf arasýndaki baðlantýnýn yapýldýðý intent yaratýlýr.
     * ve Activitiy yaratýlan intent referans verilerek baþlatýlýr.
     * */
    public void onYonetici(View v){
		   Intent intent = new Intent(this, Yonetici.class);
		   startActivity(intent);
		   }
}
