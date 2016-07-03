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

	/** XML i�erisinde onClick �zelli�i onYonetici olarak tan�mlanm�� butonun kodland��� k�s�md�r. 
	 * 	Ekran referans al�n�r.
	 * Sayfa ge�i�inin yap�labilmesi i�in ilgili s�n�f ile gidilecek s�n�f aras�ndaki ba�lant�n�n yap�ld��� intent yarat�l�r.
	 * ve Activitiy yarat�lan intent referans verilerek ba�lat�l�r.
	 * */
public class Yonetici extends Activity {

	/** Tab i�in gerekli olan parametreler tan�mlanm��t�r.
	 * 	Tabhost s�n�f�ndan tabhost ad� alt�nda daha sonra kullan�lmak �zere bir nesne yarat�lm��t�r.
   */
    TabHost tabHost;
	
	/** Uygulama  ilk ba�lad���nda onCreate metodu �a�r�l�r.
	 *  ->setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) => Ekran�n ba�lang��ta yatay olarak a��lmas�n� sa�lar.
	 *  ->setContentView(R.layout.activity_yonetici_ekrani) => Ekran�n "activity_yonetici_ekrani" layoutu ile doldurulmas�n� sa�lar.
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
			/** tabhost nesnesi XML kodunda tan�mlanan tab g�r�n�m�n�n Java taraf�nda referans edilmesini sa�lar.
			 * ->tabHost.setup() => tab�n ekran i�ine kurulumu ger�ekle�tirilir.*/
			tabHost = (TabHost) findViewById(android.R.id.tabhost);
            tabHost.setup();
            
            /** Dinamik ve Kinematik tab�n� temsil eden spec1 Tabspec i yarat�lm��t�r.
             * ��eri�inin XML id si tab1 olaca�� belirtilmi�tir.
             * Ekranda yer alan Tab �zerinde kullan�c�ya "Dinamik ve Kinematik" ismiyle g�r�nmesi sa�lanm��t�r.   */
            TabSpec spec1=tabHost.newTabSpec("Dinamik ve Kinematik");
            spec1.setContent(R.id.tab1);
            spec1.setIndicator("Dinamik ve Kinematik");
            
            /** Denetleyici Parametreler tab�n� temsil eden spec2 Tabspec i yarat�lm��t�r.
             * ��eri�inin XML id si tab2 olaca�� belirtilmi�tir.
             * Ekranda yer alan Tab �zerinde kullan�c�ya "Denetleyici Parametreler " ismiyle g�r�nmesi sa�lanm��t�r.   */
            TabSpec spec2=tabHost.newTabSpec("Denetleyici Parametreler");
            spec2.setContent(R.id.tab2);
            spec2.setIndicator("Denetleyici Parametreler");
            
            /** Sens�r Bilgileri tab�n� temsil eden spec3 Tabspec i yarat�lm��t�r.
             * ��eri�inin XML id si tab3 olaca�� belirtilmi�tir.
             * Ekranda yer alan Tab �zerinde kullan�c�ya "Sens�r Bilgileri " ismiyle g�r�nmesi sa�lanm��t�r.   */
            TabSpec spec3=tabHost.newTabSpec("Sens�r Bilgileri");
            spec3.setContent(R.id.tab3);
            spec3.setIndicator("Sens�r Bilgileri");
            
            /** Yarat�lan bu tabspecler tabhost nesnemize teker teker eklenmi�tir. */
            
            tabHost.addTab(spec1);
            tabHost.addTab(spec2);
            tabHost.addTab(spec3);
            
            /** �lk �nce 0 indeksine sahip tab�n aktif olaca�� belirtilmi�tir.*/
            tabHost.setCurrentTab(0);
		}
		
		/** Bir hata ile kar��la��ld���nda uygulaman�n kendi kendini zorla kapatmamas� i�in ekranda kullan�c�ya bir hata mesaj� verilmesi sa�lanm��t�r.*/
		catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
	}
	 
	/** Cihaz �zerindeki men� d��melerinin kullan�m� i�in gereklidir
	 *  E�er men� d��melerine farkl� anlamlar y�klenmek istenirse kod geli�tirilmelidir. 
	 *   
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
