package com.example.kab;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

	/** XML içerisinde onClick özelliði onYonetici olarak tanýmlanmýþ butonun kodlandýðý kýsýmdýr. 
	 * 	Ekran referans alýnýr.
	 * Sayfa geçiþinin yapýlabilmesi için ilgili sýnýf ile gidilecek sýnýf arasýndaki baðlantýnýn yapýldýðý intent yaratýlýr.
	 * ve Activitiy yaratýlan intent referans verilerek baþlatýlýr.
	 * */
public class Yonetici extends Activity {

	/** Tab için gerekli olan parametreler tanýmlanmýþtýr.
	 * 	Tabhost sýnýfýndan tabhost adý altýnda daha sonra kullanýlmak üzere bir nesne yaratýlmýþtýr.
   */
    TabHost tabHost;
	
	/** Uygulama  ilk baþladýðýnda onCreate metodu çaðrýlýr.
	 *  ->setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) => Ekranýn baþlangýçta yatay olarak açýlmasýný saðlar.
	 *  ->setContentView(R.layout.activity_yonetici_ekrani) => Ekranýn "activity_yonetici_ekrani" layoutu ile doldurulmasýný saðlar.
	 *   
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.activity_yonetici_ekrani);
		String [] alt_eleman = {"CEM","Bora","UUR","Tolga","Veli"};
		ImKAB_XMLKutuphanesi xml = new ImKAB_XMLKutuphanesi();
		
		xml.Im_XMLOlustur("TEST","TEST","test_kok_etiket_deneme",alt_eleman);
		xml.Im_XMLOlustur();
		//String asd = xml.Im_XMLVeriOku("DenemeKlasoru", "imasdinpar", "SurtunmeKatSayisi");
		//TextView asdasd = (TextView) findViewById(R.id.txt1);
		//asdasd.setText(asd);
		
		//xml.Im_XMLEtiketEkle("TOLGA DENEME DOSYASI", "TOLGADENEME", "OFSETZ", "denemeTAG", "DenemeText");
		//xml.Im_XMLEtiketIsmiGuncelle("TEST", "TEST", "CEM", "Deneme_Cem");
		//xml.Im_XMLEtiketSil("TEST", "TEST", "Veli");
		//xml.Im_XMLVeriGuncelle("DenemeKlasoru", "calismamodu", "CalismaModu", "Kullanici", "CEMI_SEV");
		//xml.Im_XMLVeriYaz("TEST", "TEST", "Bora", "XKoordinat", "Zuhoo", "TEST_v2", "TEST");
		try
		{
			/** tabhost nesnesi XML kodunda tanýmlanan tab görünümünün Java tarafýnda referans edilmesini saðlar.
			 * ->tabHost.setup() => tabýn ekran içine kurulumu gerçekleþtirilir.*/
			tabHost = (TabHost) findViewById(android.R.id.tabhost);
            tabHost.setup();
            
            /** Dinamik ve Kinematik tabýný temsil eden spec1 Tabspec i yaratýlmýþtýr.
             * Ýçeriðinin XML id si tab1 olacaðý belirtilmiþtir.
             * Ekranda yer alan Tab üzerinde kullanýcýya "Dinamik ve Kinematik" ismiyle görünmesi saðlanmýþtýr.   */
            TabSpec spec1=tabHost.newTabSpec("Dinamik ve Kinematik");
            spec1.setContent(R.id.tab1);
            spec1.setIndicator("Dinamik ve Kinematik");
            
            /** Denetleyici Parametreler tabýný temsil eden spec2 Tabspec i yaratýlmýþtýr.
             * Ýçeriðinin XML id si tab2 olacaðý belirtilmiþtir.
             * Ekranda yer alan Tab üzerinde kullanýcýya "Denetleyici Parametreler " ismiyle görünmesi saðlanmýþtýr.   */
            TabSpec spec2=tabHost.newTabSpec("Denetleyici Parametreler");
            spec2.setContent(R.id.tab2);
            spec2.setIndicator("Denetleyici Parametreler");
            
            /** Sensör Bilgileri tabýný temsil eden spec3 Tabspec i yaratýlmýþtýr.
             * Ýçeriðinin XML id si tab3 olacaðý belirtilmiþtir.
             * Ekranda yer alan Tab üzerinde kullanýcýya "Sensör Bilgileri " ismiyle görünmesi saðlanmýþtýr.   */
            TabSpec spec3=tabHost.newTabSpec("Sensör Bilgileri");
            spec3.setContent(R.id.tab3);
            spec3.setIndicator("Sensör Bilgileri");
            
            /** Yaratýlan bu tabspecler tabhost nesnemize teker teker eklenmiþtir. */
            
            tabHost.addTab(spec1);
            tabHost.addTab(spec2);
            tabHost.addTab(spec3);
            
            /** Ýlk önce 0 indeksine sahip tabýn aktif olacaðý belirtilmiþtir.*/
            tabHost.setCurrentTab(0);
		}
		
		/** Bir hata ile karþýlaþýldýðýnda uygulamanýn kendi kendini zorla kapatmamasý için ekranda kullanýcýya bir hata mesajý verilmesi saðlanmýþtýr.*/
		catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
	}
	 
	/** Cihaz üzerindeki menü düðmelerinin kullanýmý için gereklidir
	 *  Eðer menü düðmelerine farklý anlamlar yüklenmek istenirse kod geliþtirilmelidir. 
	 *   
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
