/*******************************************************************************
 * ImKAB_XMLKutuphanesi.java
 *
 * AMA�:
 *
 * Bu s�n�f ile ImKAB_XMLKutuphanesi i�lemleri ger�eklenmektedir. 
 * Bu s�n�f Im_YeniDosyaAcmaAyari, Im_VarolanDosyayiAcmaAyari, Im_BelgedenStringYarat, Im_XMLOlustur, Im_XMLVeriOku,
 * Im_XMLEtiketEkle, Im_XMLEtiketIsmiGuncelle, Im_XMLEtiketSil, Im_XMLVeriYaz, Im_XMLVeriGuncelle, Im_XMLVeriSil
 * fonksiyonlar�n� i�ermektedir. 
 *
 * ER���M: Public
 *
 * GLOBAL DE���KENKER:
 *
 * FONKS�YON PROTOT�PLER�:
 *
 * public Document Im_YeniDosyaAcmaAyari()
 * 
 * public Document Im_VarolanDosyayiAcmaAyari( String str_dosya_klasoru,
 *		   									   String str_XML_dosyasi_ismi)
 * 
 * public String Im_BelgedenStringYarat(Document belge)
 * 
 * public void Im_DosyaKaydet( String str_klasor_adi,
 *		   					   	String str_dosya_adi,
 *		   					   	String str_kaydedilecek_dosya )
 * 
 * public void Im_XMLOlustur( String str_dosya_adi, 
 * 							  String str_klasor_adi, 
 * 							  String str_kok_etiket,
 *							  String [] str_alt_eleman )
 *
 * public void Im_XMLOlustur()
 * 
 * public String Im_XMLVeriOku( String str_dosya_klasoru, 
 * 								String str_XML_dosyasi_ismi, 
 *			   					String str_veri_okunacak_etiket )
 *
 * public void Im_XMLEtiketEkle( String str_dosya_klasoru,
 * 							     String str_XML_dosyasi_ismi, 
 * 							     String str_belirtec_etiket,
 * 							     String str_eklenecek_etiket_ismi,
 * 							     String str_icerisine_yazilacak_deger )
 * 
 * public void Im_XMLEtiketIsmiGuncelle( String str_dosya_klasoru,
 * 									     String str_XML_dosyasi_ismi, 
 *		 						   	  	 String str_ismi_degistirilecek_olan_etiket, 
 *									  	 String str_yeni_isim )
 *
 * public void Im_XMLEtiketSil( String str_dosya_klasoru,
 * 							    String str_XML_dosyasi_ismi,
 * 							    String str_silinecek_etiket )
 * 
 * public void Im_XMLVeriYaz( String str_dosya_klasoru, 
 * 							  String str_acilacak_XML_dosyasi_ismi, 
 * 							  String str_icinde_degisiklik_yapilacak_etiket, 
 * 							  String str_veri_girilecek_etiket_elemani, 
 *							  String str_girilecek_veri, 
 *							  String str_yeni_dosya_ismi, 
 *							  String str_yeni_XMLin_kaydedilecegi_dosya )
 *
 * public void Im_XMLVeriGuncelle( String str_dosya_klasoru, 
 *                                 String str_gulcellencek_XML_dosyasi_ismi, 
 * 								   String str_icerisinde_guncelleme_yapilacak_etiket,
 * 								   String str_guncelleme_yap�lacak_etiket_elemani, 
 *								   String str_yeni_veri	)
 *
 * public void Im_XMLVeriSil( String str_dosya_klasoru,
 * 							  String str_XML_dosyasi_ismi, 
 * 							  String str_icinde_degisiklik_yapilacak_etiket,
 *							  String str_verisi_silinecek_etiket_eleman� )
 * 
 * NOTLAR: Fonksiyonlar i�erisinde t�rk�e karakter i�eren etiket ismi, klas�r ismi, dosya ad� gibi 
 * parametreler girilmesi durumunda fonksiyonlar herhangi bir hata vermemektedir. Fakat i�levlerini
 * ger�ekle�tirememektedir.	
 * 
 * GEL��T�RME GE�M���:
 *
 * Yazar: Cem YEN��ER� ve Tolga TUNA
 * Tarih: 25.04.2013
 * G�ncelleme Tarihi: 
 * Versiyon: v_1.0
 *
 */
package com.example.kab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class ImKAB_XMLKutuphanesi
{
	 /********************************************************************************************
	 * 
	 * FONKS�YON ADI: 				Im_YeniDosyaAcmaAyari
	 * FONKS�YON A�IKLAMASI: 		Bu fonksiyon, di�er fonksiyonlarda kullan�lmak i�in yaz�lm�� olup,
	 * herhangi bir ImKAB_XMLKutuphanesi dosya i�leminin yap�labilmesi i�in gerekli d�zenlemeleri yapan fonksiyondur.
	 *
	 * ER���M: Public
	 * 
	 * PARAMETRELER: YOK
	 * 			ADI				T�P�				A�IKLAMASI
	 *
	 * D�N��:	
	 * 			ADI				T�P�				A�IKLAMASI
	 *			belge			Document			Gerekli d�zenlemeler yap�larak belge de�i�keni haz�rlan�r ve d�nd�r�l�r.			
	 *
	 * GEREKL�L�K: 	Herhangi bir ImKAB_XMLKutuphanesi dosyas� i�lemi yapabilabilmesi i�in �ncelikle bu fonksiyonun 
	 * �a�r�lmas� gerekmektedir.
	 *
	*********************************************************************************************/	
    public Document Im_YeniDosyaAcmaAyari()
    {
        try
        {
        	/**
	  		 * ImKAB_XMLKutuphanesi belgesi olu�turmak i�in ilk olarak belge_ureteci nesnesi olu�turuldu.
	  		 * Normal JAVA dan farkl� olarak Android i�in newInstance metodu kullan�lmas� gerekmektedir.
	  		 * 
	  		 * belge_yapici nesnesi bir ImKAB_XMLKutuphanesi belgesinden DOM belgesi elde edebilmek i�in olu�turuldu.
	  		 * 
	  		 * belge isimli bir DOM �rne�i yarat�ld�. DOM ile bir ImKAB_XMLKutuphanesi belgesinin i�eri�i,stili ve yap�s� g�r�l�p de�i�tirilebilir.
	  		 */ 	
        	DocumentBuilderFactory belge_ureteci = DocumentBuilderFactory.newInstance();
	   		DocumentBuilder belge_yapici = belge_ureteci.newDocumentBuilder();
	   		Document belge = belge_yapici.newDocument();
	   		return belge;
	    } 
        catch (ParserConfigurationException e) 
        {
			e.printStackTrace();
			return null;
	    }		
    }
    
    
	 /********************************************************************************************
	 * 
	 * FONKS�YON ADI: 				Im_VarolanDosyayiAcmaAyari
	 * FONKS�YON A�IKLAMASI: 		Bu fonksiyon di�er fonksiyonlarda kullan�lmak i�in yaz�lm�� olup
	 * herhangi varolan ImKAB_XMLKutuphanesi dosyas� �zerinde i�lem yap�labilmmek i�in gerekli d�zenlemeleri yapan fonk
	 * siyondur.
	 *
	 * ER���M: Public
	 * 
	 * PARAMETRELER: YOK
	 * 			ADI						T�P�				A�IKLAMASI
	 *			str_dosya_klasoru		String				A��lacak dosyan�n bulundu�u klas�r� tutan de�i�kendir.
	 *			str_XML_dosyasi_ismi	String				A��lacak olan dosyan�n ismini tutan de�i�kendir.
	 * D�N��:	
	 * 			ADI						T�P�				A�IKLAMASI
	 *			belge					Document			Gerekli d�zenlemeler yap�larak belge de�i�keni haz�rlan�r ve d�nd�r�l�r.			
	 *
	 * GEREKL�L�K: 	Herhangi bir ImKAB_XMLKutuphanesi dosyas� i�lemi yapabilabilmesi i�in �ncelikle bu fonksiyonun 
	 * �a�r�lmas� gerekmektedir.
	 *
	*********************************************************************************************/	
   public Document Im_VarolanDosyayiAcmaAyari( String str_dosya_klasoru,
		   									   String str_XML_dosyasi_ismi )
   {
       try
       {	
    	   /**
    	    * ??
    	    */
    	   	DocumentBuilderFactory dosya_uretici = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dosya_yapici = dosya_uretici.newDocumentBuilder();
		    Document dosya = null;
			try {
				dosya = dosya_yapici.parse(new File("/sdcard/"+ str_dosya_klasoru +"/"+ str_XML_dosyasi_ismi + ".xml"));
				dosya.normalizeDocument(); 
		   		return dosya;
			} catch (SAXException e) {
				e.printStackTrace();
				return dosya;
			} catch (IOException e) {
				e.printStackTrace();
				return dosya;
			}
	    } 
       catch (ParserConfigurationException e) 
       {
			e.printStackTrace();
			return null;
	    }		
   }
    
     /********************************************************************************************
	 *
	 * FONKS�YON ADI: 				Im_BelgedenStringYarat
	 * FONKS�YON A�IKLAMASI: 		Belgeden String yarat�lmas� i�lemini ger�ekle�tirir.
	 * 
	 * ER���M: Public
	 * 
	 * PARAMETRELER:
	 * 			ADI				T�P�				A�IKLAMASI
	 *		   	belge		   	Document			D�n��t�r�lmesi gereken belge parametre olarak verilir.
	 *
	 * D�N��:
	 * 			ADI				T�P�				A�IKLAMASI
	 *			str_yazici		String				Belgenin kullan�lmak �zere String olarak d�nd�r�lece�i de�i�kendir.
	 *
	 * GEREKL�L�K: 	Bu fonksiyon ile yarat�lmas� planlanan ImKAB_XMLKutuphanesi dosya yap�s� String e d�n��t�r�l�p
	 * dosyan�n yarat�lmas� i�leminin ger�ekle�ti�i k�s�ma aktar�lmas�nda kullan�l�r. 
	 *
	*********************************************************************************************/
    public String Im_BelgedenStringYarat(Document belge)
    {
        try
        {
        	/**
        	 * ??
        	 */
           DOMSource belge_kaynagi = new DOMSource(belge);
           StringWriter yazici = new StringWriter();
           StreamResult sonuc = new StreamResult(yazici);
           TransformerFactory donusum_ureteci = TransformerFactory.newInstance();
           Transformer donusturucu = donusum_ureteci.newTransformer();
           donusturucu.transform(belge_kaynagi, sonuc);
           String str_yazici = yazici.toString();;
           return str_yazici;
        }
        catch(TransformerException ex)
        {
           ex.printStackTrace();
           return null;
        }
    }
    
    
     /********************************************************************************************
	 *
	 * FONKS�YON ADI: 				Im_DosyaKaydet
	 * FONKS�YON A�IKLAMASI: 		��lemi tamamlanan bir ImKAB_XMLKutuphanesi doyas�n� belirtilen klas�r alt�nda belir
	 * tilen isim ile kaydeden fonksiyondur.
	 * 
	 * ER���M: Public
	 * 
	 * PARAMETRELER:
	 * 			ADI						T�P�				A�IKLAMASI
	 *		  	str_klasor_adi			String				��erisine kaydedilecek olan klas�re ait ismi tutan de�i�kendir.
	 *			str_dosya_adi			String				Kaydedilecek olan dosyaya ait ismi tutan de�i�kendir.
	 *			str_kaydedilecek_dosya	String				Kaydedilecek olan dosyan�n tutuldu�u de�i�kendir.
	 *
	 * D�N��: YOK
	 * 			ADI						T�P�				A�IKLAMASI
	 *		
	 * GEREKL�L�K: 	�stenildi�i �ekilde d�zenlenen ImKAB_XMLKutuphanesi dosyalar�n�n kaydedilmesi i�leminin yap�lmas�
	 * i�in gereklidir.
	 *
	*********************************************************************************************/
    public void Im_DosyaKaydet( String str_klasor_adi,
		   					   	String str_dosya_adi,
		   					   	String str_kaydedilecek_dosya
		   					  )
    {
		try 
		{
			/*Dosyan�n kaydedilece�i dizin olu�turulmaktad�r.*/
			String str_dizin = "/sdcard/" + str_klasor_adi + "/" + str_dosya_adi + ".xml";
			
			/*Belirtilen dizinde dosya yap�land�r�r.*/
			File yeni_dosya = new File(str_dizin);
			
			/**
			 * E�er b�yle bir klas�r belirtilen dizinde yoksa,�ncelikle klas�r yarat�l�r.  
			 */
			if(!yeni_dosya.exists())
			{
				yeni_dosya.getParentFile().mkdir();	    				
			}
			
			/**
			 * �zellikleri belirtilen dosya yarat�l�r
			 * ve ImKAB_XMLKutuphanesi den String e d�n��t�r�len yap� dosya i�erisine byte byte at�l�r.
			 * Daha sonra olu�turulan dosya kapan�r. 
			 */
			yeni_dosya.createNewFile();
			
			FileOutputStream dosya_cikti = new FileOutputStream(yeni_dosya);
			
			OutputStreamWriter cikti_yazici = new OutputStreamWriter(dosya_cikti);
			cikti_yazici.append(str_kaydedilecek_dosya);
			cikti_yazici.close();
			
			dosya_cikti.close();
		} 
		catch (Exception e)
		{
		}
    }
    
	
     /********************************************************************************************
	 *
	 * FONKS�YON ADI: 				Im_XMLOlustur
	 * FONKS�YON A�IKLAMASI: 		Bu fonksiyon istenilen klas�rde ve dosya isminde, istenilen yap�da 
	 * ImKAB_XMLKutuphanesi belgesi olu�turabilen fonksiyondur.
	 *
	 * ER���M: Public
	 * 
	 * PARAMETRELER:
	 * 			ADI					T�P�				A�IKLAMASI
	 *			str_klas�r_adi		String				Dosyan�n /sdcard/ yolu i�erisinde kaydedilece�i klas�r�n ad�n� tutan de�i�kendir.
	 *			str_dosya_adi		String				Dosyan�n /sdcard/klas�r_adi/ yolu i�inde hangi isimle kaydedilece�ini tutan de�i�kendir.
	 *			str_kok_etiket		String				ImKAB_XMLKutuphanesi dosyas�n�n sahip olaca�� k�k eleman�n tutuld�u de�i�kendir.	
	 *			str_alt_eleman		String Array		ImKAB_XMLKutuphanesi dosyas�nda k�k eleman alt�nda bulunacak alt elemanlar� tutan dizi de�i�kenidir.
	 *
	 * D�N��: YOK
	 * 			ADI					T�P�				A�IKLAMASI
	 *
	 * GEREKL�L�K: 	Bu fonksiyon daha �nce olu�turulmam�� bir ImKAB_XMLKutuphanesi belgesinin istenilen �zelliklerde
	 * olu�turulmas�na esnek bir �ekilde olanak sa�lamaktad�r.
	 *
	*********************************************************************************************/
	public void Im_XMLOlustur ( String str_klasor_adi,
								String str_dosya_adi,
							    String str_kok_etiket,
							    String [] str_alt_eleman
							  )
	{
		try
		{	 
			Document belge= Im_YeniDosyaAcmaAyari(); /*Dosya a�mak i�in ayar fonksiyonu �a�r�lmaktad�r.*/
		  	
	   		Element kok_eleman = belge.createElement(str_kok_etiket);	 /* kok_eleman isimli ImKAB_XMLKutuphanesi k�k etiketi yarat�ld�*/
	   		belge.appendChild(kok_eleman);								 /* Olu�turulan kok_eleman belgeye eklendi.*/
		   		
	   		/**
	   		 * Bu d�ng� ile kok_eleman etiketinin alt�nda yer alacak alt elemanlar yarat�lm��t�r.
	   		 * alt1_eleman ile temsil edileceklerdir.
	   		 */
		   	for(int i = 0; i < str_alt_eleman.length; i++)
		   	{	
	   	  		
	   			/*Parametre olarak tan�ml� alt1 eleman� yarat�l�p kok_eleman �n alt�na eklenmi�tir.*/
	   	  		Element alt1_eleman = belge.createElement(str_alt_eleman[i]);	
	   	  		kok_eleman.appendChild(alt1_eleman);
	   	      	   
	   	  		/*alt2_1_eleman alt1_eleman �n alt�nda yer alacak alt elemanlardan birisidir.*/
	   	  		Element alt2_1_eleman = belge.createElement("XKoordinat");
	   	  		alt1_eleman.appendChild(alt2_1_eleman);
	   	    
	   	  		/*alt2_2_eleman alt1_eleman �n alt�nda yer alacak alt elemanlardan birisidir.*/
	   	  		Element alt2_2_eleman = belge.createElement("YKoordinat");
	   	  		alt1_eleman.appendChild(alt2_2_eleman);
	   	  		
	   	  		/*alt2_3_eleman alt1_eleman �n alt�nda yer alacak alt elemanlardan birisidir.*/	
	   	  		Element alt2_3 = belge.createElement("ZKoordinat");
	   	  		alt1_eleman.appendChild(alt2_3);	
	   		} 	
		   		
	   		/* belgeden String e d�n���m yapabilmek i�in str_string_belgeden nesnesi yarat�lm��t�r.*/
	   		String str_string_belgeden = Im_BelgedenStringYarat(belge);
	   		/*Dosya kaydet fonksiyonu �a�r�larak yap�lan i�lemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_klasor_adi, str_dosya_adi, str_string_belgeden);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	/********************************************************************************************
	 *
	 * FONKS�YON ADI: 				Im_XMLOlustur
	 * FONKS�YON A�IKLAMASI: 		Bu fonksiyon varsay�lan de�erler kullanarak ImKAB_XMLKutuphanesi belgesi olu�turmak
	 * tad�r.
	 * 
	 * ER���M: Public
	 * 
	 * PARAMETRELER: YOK
	 * 			ADI					T�P�				A�IKLAMASI
	 *
	 * D�N��: YOK
	 * 			ADI					T�P�				A�IKLAMASI
	 *
	 * GEREKL�L�K: 	Herhangi bir parametre girilmemesi durumunda varsay�lan de�erler kullan�larak
	 * bir hata olu�mas�n� �nlemek i�in gereklidir.
	 *
	*********************************************************************************************/
	public void Im_XMLOlustur()
	{
		/*Varsay�lan de�erlerin tutuldu�u string arrayi*/
		String [] alt_eleman = {"Varsayilan1","Varsayilan2","Varsayilan3","Varsayilan4","Varsayilan5"};
		/*Varsay�lan de�erler kullan�larak daha �nce haz�rlanan Im_XMLOlustur(...) fonksiyonu �a�r�lm��t�r. */
		Im_XMLOlustur("VarsayilanKlasor", "VarsayilanDosya", "VarsayilanEtiket", alt_eleman);
	} 
		     
	
		     
	/********************************************************************************************
	*
	* FONKS�YON ADI: 				Im_XMLVeriOku
	* FONKS�YON A�IKLAMASI: 		Bu fonksiyon belirtilen ImKAB_XMLKutuphanesi belgesi i�erisinde belirtilen etikete ait
	* de�eri okuma i�lemini yapmaktad�r.
	* 
	* ER���M: public
	* 
	* PARAMETRELER:	
	* 		ADI							T�P�			A�IKLAMASI
	*		str_dosya_klasoru			String			��erisinden veri okunacak olan ImKAB_XMLKutuphanesi belgesinin bulundu�u klas�r�n tutuldu�u de�i�kendir.
	*		str_XML_dosyasi_ismi		String			��erisinden etiket de�eri okunacak olan ImKAB_XMLKutuphanesi belgesinin isminin tutuldu�u de�i�kendir.	
	*		str_veri_okunacak_etiket	String			Hangi etikete ait de�erin okunaca��n�n tutuldu�u de�i�kendir.
	* 
	* D�N��:
	* 		ADI							T�P�			A�IKLAMASI
	* 		str_okunan_veri					String
	*	
	* GEREKL�L�K: 	Bir ImKAB_XMLKutuphanesi belgesi i�erisinde herhangi bir etiket alt�ndaki de�erin okunmas� gerekti�i
	* durumlar i�in kullan�lmaktad�r.
	* 
	*********************************************************************************************/
	public String Im_XMLVeriOku( String str_dosya_klasoru, 
   						 		 String str_XML_dosyasi_ismi, 
   						 	     String str_veri_okunacak_etiket
		  					   )
	{
		String str_okunan_veri = "Veri Yok!"; /*Belirtilen yolda herhangi bir veri bulunamazsa d�necek de�erdir.*/
		try
		{
			Document belge = Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Dosya a�mak i�in ayar fonksiyonu �a�r�lmaktad�r.*/
	    
		    /**
		     * belge.getElementsByTagName ile i�erisinde de�i�iklik yap�lmak istenen etiketler, NodeList tipinde
		     * etiketlere atand� ve olu�turulan NodeList etiketlerinden istenen etikete ait i�erik getTextContent() ile �a�r�ld�.
		     * Okunmak istenen de�er str_okunan_veri de�i�kenine atand�.
		     */
		    NodeList etiketler = belge.getElementsByTagName(str_veri_okunacak_etiket);
			for (int i =0; i<etiketler.getLength();i++)
			{
			    Node eleman = etiketler.item(i);
			    
			    if(str_veri_okunacak_etiket.equals(eleman.getNodeName()))
			    {
			        str_okunan_veri=eleman.getTextContent(); 	/*Verinin d�n�� de�erine y�klenme i�lemi*/
			    }
		    }
	 	}
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
		return str_okunan_veri;
	}
	
	
	/********************************************************************************************
 	*
 	* FONKS�YON ADI: 				Im_XMLEtiketEkle
 	* FONKS�YON A�IKLAMASI: 		Bu Fonksiyon istenilen etiket �st�ne yeni bir etiket ve etikete ait de�er
 	* eklenmesini sa�layan fonksiyondur.
 	* 
 	* ER���M:	public
 	* 
 	* PARAMETRELER:	
 	* 		ADI								T�P�						A�IKLAMASI
 	*		str_dosya_klasoru				String		i�erisinden etiket eklenecek olan ImKAB_XMLKutuphanesi dosyas�n�n bulundu�u klas�r�n tutuldu�u de�i�kendir.
 	*		str_XML_dosyasi_ismi			String		��erisinden etiket eklenecek olan ImKAB_XMLKutuphanesi dosyas�n�n isminin tutuldu�u de�i�kendir.	
 	*		str_belirtec_etiket				String		Hangi etiketin belirte� olarak (o etiketin yukar�s�na eklenmesi) kullan�laca��n�n tutuldu�u de�i�kendir.
 	* 		str_eklenecek_etiket_ismi		String		Yeni eklenecek olan etiketin ismidir.
 	* 		str_icerisine_yazilacak_deger	String		Yeni eklenecek olan etiketin i�erisine yaz�lacak olan de�eridir.
 	* 
 	* D�N��: YOK
 	* 		ADI							T�P�						A�IKLAMASI
 	*	
 	* GEREKL�L�K: 	Herhangi bir ImKAB_XMLKutuphanesi dosyas� i�erisinden istenilen etiket �zerine yeni bir etiket ekleme i�lemi
 	* i�in gereklidir.
 	* 
	*********************************************************************************************/
	public void Im_XMLEtiketEkle( String str_dosya_klasoru, 
	   						      String str_XML_dosyasi_ismi, 
	   						      String str_belirtec_etiket,
	   						      String str_eklenecek_etiket_ismi,
	   						      String str_icerisine_yazilacak_deger
	   						    )
	{
		try
		{
			Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyay� kullan�m i�in haz�r hale getirir.*/
			    
		    /* belge.getElementsByTagName ile i�erisinde de�i�iklik yap�lmak istenen etiketler �a�r�ld�. */
			NodeList etiketler = belge.getElementsByTagName(str_belirtec_etiket);
			
			/**
			 * String tipinde parametre olarak al�nan etiket alt�na yaz�lacak de�er Text haline d�n��t�r�lm��t�r.
			 * str_eklenecek_etiket_ismi parametresi ile al�nan etiket ismi ile yeni Element yarat�lm��t�r.
			 * Bu yeni etikete i�erisine yaz�lmas� istenilen de�er ili�tirilmi�tir.
			 * Yeni etiket parametre olarak al�nan belirte� etiketinin �zerine eklenmi�tir.
			 */
			Text icerisine_yazilacak_deger = belge.createTextNode(str_icerisine_yazilacak_deger); 
			Element yeni_etiket = belge.createElement(str_eklenecek_etiket_ismi); 
			yeni_etiket.appendChild(icerisine_yazilacak_deger);
			etiketler.item(0).getParentNode().insertBefore(yeni_etiket, etiketler.item(0));
			
			/* belgeden String e d�n���m yapabilmek i�in str_string_belgeden nesnesi yarat�lm��t�r.*/
			String str_dosya_icerigi = Im_BelgedenStringYarat(belge);
			
			/*Dosya kaydet fonksiyonu �a�r�larak yap�lan i�lemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		 }
 		catch (Exception e) 
 		{	
 			e.printStackTrace();
 		}
	}

	
	/********************************************************************************************
	*
	* FONKS�YON ADI: 				Im_XMLEtiketIsmiGuncelle
	* FONKS�YON A�IKLAMASI: 		Bu fonksiyon belirtilen ImKAB_XMLKutuphanesi dosyas�na ait, belirtilen etiketin
	* isminin de�i�tirilmesini sa�layan fonksiyondur.
	* 
	* ER���M: public
	* 
	* PARAMETRELER:	
	* 		ADI									T�P�			A�IKLAMASI
	*		str_dosya_klasoru					String			��erisinde de�i�iklik yap�lacak olan ImKAB_XMLKutuphanesi dosyas�n�n bulundu�u klas�r�n tutuldu�u de�i�kendir.
	*		str_XML_dosyasi_ismi				String			��erisinde de�i�iklik yap�lacak olan ImKAB_XMLKutuphanesi isminin tutuldu�u de�i�kendir.	
	*		str_ismi_degistirilecek_olan_etiket	String			Hangi etiketin isminin de�i�tirilece�inin tutuldu�u de�i�kenidir.
	* 		str_yeni_isim						String			Yeni ismin tutuldu�u de�i�kendir.
	* 
	* D�N��: YOK
	* 		ADI									T�P�			A�IKLAMASI
	*	
	* GEREKL�L�K: 	Herhangi bir ImKAB_XMLKutuphanesi dosyas� i�erisinden istenilen etiketin isminin de�i�tirilmesi
	* gerekti�i durumlarda kullan�l�r.
	* 
	*********************************************************************************************/
	public void Im_XMLEtiketIsmiGuncelle( String str_dosya_klasoru, 
 						   			   	  String str_XML_dosyasi_ismi, 
 						   			      String str_ismi_degistirilecek_olan_etiket,
 						   			      String str_yeni_isim
 								        )
 	{
		try
		{
			Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyay� kullan�m i�in haz�r hale getirir.*/	
			
			/*�smi de�i�tirilecek olan etiket se�ilir.*/
			NodeList etiket = belge.getElementsByTagName(str_ismi_degistirilecek_olan_etiket);
		 		    
		 	/*Se�ilen etiket arat�larak isminin de�i�tirilmesi ve verilerini kaybetmemesi sa�lan�r.*/
 		    for (int i = 0; i < etiket.getLength(); i++) {
 		    	belge.renameNode(etiket.item(i), null, str_yeni_isim);
 		    }

 		    /*Belgeden stringe ge�i� yapabilmek i�in belgeden_string_yarat fonksiyonu �a�r�lm��t�r.*/
		 	String str_dosya_icerigi=Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu �a�r�larak yap�lan i�lemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		}
 		catch (Exception e) 
 		{	
 			e.printStackTrace();
 		}
	}
		 	
	
	/********************************************************************************************
	*
	* FONKS�YON ADI: 				Im_XMLEtiketSil
	* FONKS�YON A�IKLAMASI: 		Bu fonksiyon belirtilen ImKAB_XMLKutuphanesi etiketinin tamamen silinmesini sa�layan
	* fonksiyondur.
	* 
	* ER���M:	public
	* 
	* PARAMETRELER:	
	* 		ADI						T�P�			A�IKLAMASI
	*		str_dosya_klasoru		String			i�erisinden etiket silinecek olan ImKAB_XMLKutuphanesi dosyas�n�n bulundu�u klas�r�n tutuldu�u de�i�kendir.
	*		str_XML_dosyasi_ismi	String			��erisinden etiket silinecek olan ImKAB_XMLKutuphanesi dosyas�n�n isminin tutuldu�u de�i�kendir.	
	*		str_silinecek_etiket	String			Hangi etiketin silinece�inin tutuldu�u string de�i�kendir.
	* 
	* D�N��: YOK
	* 		ADI						T�P�			A�IKLAMASI
	*	
	* GEREKL�L�K: 	Herhangi bir ImKAB_XMLKutuphanesi dosyas� i�erisinden istenilen etiketin tamamen silinmesi gerekti�i
	* durumlarda kullan�l�r.
	* 
	*********************************************************************************************/		 	
	public void Im_XMLEtiketSil( String str_dosya_klasoru, 
						   	  	 String str_XML_dosyasi_ismi, 
						   	  	 String str_silinecek_etiket
						       )
	{
		try
		{
			Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyay� kullan�m i�in haz�r hale getirir.*/
			
 		    /**
 		     * belge.getElementsByTagName(str_silinecek_etiket).item(0) ile silinmek istenen etiket �a�r�ld�
 		     * silinecek_olan_eleman.getParentNode().removeChild(silinecek_olan_eleman) ile etiket ImKAB_XMLKutuphanesi belgesi i�ersinden ��kar�ld�.
 		     * belge.normalize() ile belgede olabilecek bir uyumsuzluk (etiketler aras� de�er varm�� gibi g�sterme) giderildi.
 		     */
 		    Element silinecek_olan_eleman = (Element) belge.getElementsByTagName(str_silinecek_etiket).item(0);
 		    silinecek_olan_eleman.getParentNode().removeChild(silinecek_olan_eleman);
 		    belge.normalize(); 
		 	
 		    /*Belgeden string ge�i� yapabilmek i�in belgeden_string_yarat fonksiyonu �a�r�lm��t�r.*/
		 	String str_dosya_icerigi=Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu �a�r�larak yap�lan i�lemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		 }
 		catch (Exception e) 
 		{	
 			e.printStackTrace();
 		}
	}
		 
		  
	/********************************************************************************************
	 *
	 * FONKS�YON ADI: 				Im_XMLVeriYaz
	 * FONKS�YON A�IKLAMASI: 		Bu fonksiyon daha �nce haz�rlanm�� olan ImKAB_XMLKutuphanesi belgesinde; belir
	 * tilen etiket i�erisine, belirtilen veriyi yazma i�lemini yapar. Daha sonras�nda belirtilen
	 * isim ile ImKAB_XMLKutuphanesi belgesini, belirtilen dosya klas�r� i�erisine kaydeder. 
	 * 
	 * ER���M: public
	 * 
	 * PARAMETRELER:	
	 * 		ADI										T�P�		A�IKLAMASI
	 *		str_dosya_klasoru						String		Kullan�lacak olan ImKAB_XMLKutuphanesi dosyas�n�n bulundu�u klas�r�n�n tutuldu�u de�i�kenidir.
	 *		str_acilacak_XML_dosyasi_ismi			String		Kullan�lacak olan ImKAB_XMLKutuphanesi dosyas�n�n isminin tutuldu�u de�i�kendir
	 *		str_icinde_degisiklik_yapilacak_etiket	String		Yap�lacak de�i�ikli�in hangi etiket alt�nda olaca��n�n belirtildi�i de�i�kendir.
	 *		str_veri_girilecek_etiket_elemani		String		Etiket i�erisinde hangi elemana veri girilece�inin belirtildi�i de�i�kendir.
	 *		str_girilecek_veri						String		Yaz�lacak olan verinin tutuldu�u de�i�kendir.
	 *		str_yeni_dosya_ismi						String		Dosyan�n son hali ile kaydedilece�i ismin tutuldu�u de�i�kendir.
	 *		str_yeni_XMLin_kaydedilecegi_dosya		String		Yeni olu�turulan dosyan�n hangi klas�r i�erisine kaydedilece�inin tutuldu�u de�i�kendir.
	 * 
	 * D�N��: YOK
	 * 		ADI										T�P�		A�IKLAMASI
	 *	
	 * GEREKL�L�K: 	Bu fonksiyon taslak olarak haz�rlanm�� ImKAB_XMLKutuphanesi belgeri i�erisine veri yazabilmek
	 * i�in gereklidir.
	 * 
	*********************************************************************************************/		 	
	public void Im_XMLVeriYaz( String str_dosya_klasoru, 
							   String str_acilacak_XML_dosyasi_ismi, 
							   String str_icinde_degisiklik_yapilacak_etiket, 
							   String str_veri_girilecek_etiket_elemani, 
							   String str_girilecek_veri, 
							   String str_yeni_dosya_ismi, 
							   String str_yeni_XMLin_kaydedilecegi_dosya
							 )
	{
		 try
		 {
			 Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_acilacak_XML_dosyasi_ismi); /*Varolan dosyay� kullan�m i�in haz�r hale getirir.*/			 
		     /**
		      * belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0) ile i�erisinde de�i�iklik yap�lmak istenen etiket �a�r�ld� ve
		      * olu�turulan NodeList liste de�i�keni i�erisine alt elemanlar� "elemani.getChildNodes()"
		      * fonksiyonu ile at�ld�.
		      */
		    Node elemani = belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0);
		    NodeList liste = elemani.getChildNodes();

		    /**
		     * Listede tutulan elemanlar, i�erisinde de�i�iklik yap�lmak istenen etiket eleman� ile
		     * kar��la�t�r�larak, do�ru olan yer i�erisine "eleman.setTextContent(str_girilecek_veri)"
		     * yard�m� ile istenilen veri yaz�l�r.
		     */
			for (int i = 0; i < liste.getLength(); i++)
			{
			    Node eleman = liste.item(i);
			    
			    if(str_veri_girilecek_etiket_elemani.equals(eleman.getNodeName()))
			    {
			        eleman.setTextContent(str_girilecek_veri);		/*Verinin Tag i�erisinde yazd�r�lma i�lemi*/
			    }
			}
			
 		    /*Belgeden string ge�i� yapabilmek i�in belgeden_string_yarat fonksiyonu �a�r�lm��t�r.*/
		 	String str_dosya_icerigi=Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu �a�r�larak yap�lan i�lemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_yeni_XMLin_kaydedilecegi_dosya, str_yeni_dosya_ismi, str_dosya_icerigi);
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
	}
	

	/********************************************************************************************
	 *
	 * FONKS�YON ADI: 				Im_XMLVeriGuncelle
	 * FONKS�YON A�IKLAMASI: 		Bu fonksiyon daha �nce olu�turulmu� olan ImKAB_XMLKutuphanesi dosyas�n�n i�eri
	 * sinde belirtilen etiket alt�nda bulunan ��elerden, se�ilen ��enin g�ncellemesini yapmaktad�r.
	 * 
	 * ER���M:	public
	 * 
	 * PARAMETRELER:	
	 * 		ADI											T�P�		A�IKLAMASI
	 *		str_dosya_klasoru							String		Kullan�lacak olan ImKAB_XMLKutuphanesi dosyas�n�n bulundu�u klas�r de�i�kenidir.
	 *		str_gulcellencek_XML_dosyasi_ismi			String		G�ncellenecek olan ImKAB_XMLKutuphanesi dosyas�n�n isminin tutuldu�u de�i�kendir.	
	 *		str_i�erisinde_guncelleme_yapilacak_etiket	String		Yap�lacak de�i�ikli�in hangi TAG alt�nda yap�ld���n� belirten de�i�kendir.
	 *		str_guncelleme_yap�lacak_etiket_elemani		String		Tag i�erisinde hangi eleman�n verisinin g�ncellenece�inin belirtildi�i de�i�kendir.
	 *		str_yeni_veri								String		Yeni veriye ait de�i�kendir.
	 * 
	 * D�N��: YOK
	 * 		ADI											T�P�		A�IKLAMASI
	 *	
	 * GEREKL�L�K: 	Bu foksiyon var olan ImKAB_XMLKutuphanesi dosyalar�ndan herhangi biri i�erisinde de�i�iklik 
	 * yapmak i�in gereklidir.
	 * 
	***********************************************************************************************/
	public void Im_XMLVeriGuncelle( String str_dosya_klasoru, 
								 	String str_gulcellencek_XML_dosyasi_ismi, 
								 	String str_icerisinde_guncelleme_yapilacak_etiket, 
								 	String str_guncelleme_yap�lacak_etiket_elemani, 
								 	String str_yeni_veri 
								  )
	{
		/**
		 * Daha �nce olu�turulan Im_XMLVeriYaz fonksiyonu, dosyay� ayn� yere ayn� isim
		 * ile kaydedecek �ekilde d�zenlenerek g�ncelleme i�lemi i�in de kullan�lm��t�r. 
		 */
		Im_XMLVeriYaz(str_dosya_klasoru, str_gulcellencek_XML_dosyasi_ismi, 
				str_icerisinde_guncelleme_yapilacak_etiket, str_guncelleme_yap�lacak_etiket_elemani, 
				str_yeni_veri, str_gulcellencek_XML_dosyasi_ismi, str_dosya_klasoru);
	}

	
	/*******************************************************************************************
	*
	* FONKS�YON ADI: 				Im_XMLVeriSil
	* FONKS�YON A�IKLAMASI: 		Bu fonksiyon belirtilen etikete ait etiket eleman�n�n i�eri�inin
	* temizlenmesi i�lemini yapan fonksiyondur.
	* 
	* ER���M:	public
	* 
	* PARAMETRELER:	
	* 		ADI										T�P�		A�IKLAMASI
	*		str_dosya_klasoru						String		i�erisinden veri silinecek olan ImKAB_XMLKutuphanesi dosyas�n�n klas�r�n tutuldu�u de�i�kenidir.
	*		str_XML_dosyasi_ismi					String		��erisinden veri silinecek olan ImKAB_XMLKutuphanesi dosyas�n�n isminin tutuldu�u de�i�kenidir.	
	*		str_icinde_degisiklik_yapilacak_etiket	String		Silinecek verinin hangi etiket alt�nda bulundu�unun tutuldu�u de�i�kendir.
	* 		str_verisi_silinecek_etiket_eleman�		String		Silinecek verinin hangi elemana ait oldu�ununun tutuldu�u de�i�kendir.
	* 
	* D�N��: YOK
	* 		ADI										T�P�		A�IKLAMASI
	*	
	* GEREKL�L�K: 	Herhangi bir ImKAB_XMLKutuphanesi dosyas� i�erisinden istenilen etiket eleman�n�n verisini silmek i�in
	* gereklidir.
	***********************************************************************************************/  
	
	public void Im_XMLVeriSil(  String str_dosya_klasoru, 
							 	String str_XML_dosyasi_ismi, 
							 	String str_icinde_degisiklik_yapilacak_etiket,
							 	String str_verisi_silinecek_etiket_eleman�
						  	 )
	{
		 try
		 {
			 Document belge = Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyay� kullan�m i�in haz�r hale getirir.*/	
			 
		     /**
		      * belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0) ile i�erisinde de�i�iklik yap�lmak istenen etiket �a�r�ld�
		      * ve olu�turulan NodeList liste de�i�keni i�erisine alt elemanlar� "elemani.getChildNodes()"
		      * fonksiyonu ile at�ld�.
		      */
			 Node elemani = belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0);
			 NodeList liste = elemani.getChildNodes();
	
		    /**
		     * Listede tutulan elemanlar, i�erisi bo�alt�lmak istenen etiket eleman� ile
		     * kar��la�t�r�l�r. Do�ru olan etiket eleman�-> "eleman.setTextContent("")"
		     * yard�m� ile bo�alt�l�r.
		     */
			for (int i = 0; i < liste.getLength(); i++)
			{
			    Node eleman = liste.item(i);
			    
			    if(str_verisi_silinecek_etiket_eleman�.equals(eleman.getNodeName()))
			    {
			        eleman.setTextContent("");		/*Verinin Temizlenme ��lemi*/
			    }
			}
			
			/*Belgeden string ge�i� yapabilmek i�in belgeden_string_yarat fonksiyonu �a�r�lm��t�r.*/
		 	String str_dosya_icerigi = Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu �a�r�larak yap�lan i�lemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
	}
	
}
