/*******************************************************************************
 * ImKAB_XMLKutuphanesi.java
 *
 * AMAÇ:
 *
 * Bu sýnýf ile ImKAB_XMLKutuphanesi iþlemleri gerçeklenmektedir. 
 * Bu sýnýf Im_YeniDosyaAcmaAyari, Im_VarolanDosyayiAcmaAyari, Im_BelgedenStringYarat, Im_XMLOlustur, Im_XMLVeriOku,
 * Im_XMLEtiketEkle, Im_XMLEtiketIsmiGuncelle, Im_XMLEtiketSil, Im_XMLVeriYaz, Im_XMLVeriGuncelle, Im_XMLVeriSil
 * fonksiyonlarýný içermektedir. 
 *
 * ERÝÞÝM: Public
 *
 * GLOBAL DEÐÝÞKENKER:
 *
 * FONKSÝYON PROTOTÝPLERÝ:
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
 * 								   String str_guncelleme_yapýlacak_etiket_elemani, 
 *								   String str_yeni_veri	)
 *
 * public void Im_XMLVeriSil( String str_dosya_klasoru,
 * 							  String str_XML_dosyasi_ismi, 
 * 							  String str_icinde_degisiklik_yapilacak_etiket,
 *							  String str_verisi_silinecek_etiket_elemaný )
 * 
 * NOTLAR: Fonksiyonlar içerisinde türkçe karakter içeren etiket ismi, klasör ismi, dosya adý gibi 
 * parametreler girilmesi durumunda fonksiyonlar herhangi bir hata vermemektedir. Fakat iþlevlerini
 * gerçekleþtirememektedir.	
 * 
 * GELÝÞTÝRME GEÇMÝÞÝ:
 *
 * Yazar: Cem YENÝÇERÝ ve Tolga TUNA
 * Tarih: 25.04.2013
 * Güncelleme Tarihi: 
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
	 * FONKSÝYON ADI: 				Im_YeniDosyaAcmaAyari
	 * FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon, diðer fonksiyonlarda kullanýlmak için yazýlmýþ olup,
	 * herhangi bir ImKAB_XMLKutuphanesi dosya iþleminin yapýlabilmesi için gerekli düzenlemeleri yapan fonksiyondur.
	 *
	 * ERÝÞÝM: Public
	 * 
	 * PARAMETRELER: YOK
	 * 			ADI				TÝPÝ				AÇIKLAMASI
	 *
	 * DÖNÜÞ:	
	 * 			ADI				TÝPÝ				AÇIKLAMASI
	 *			belge			Document			Gerekli düzenlemeler yapýlarak belge deðiþkeni hazýrlanýr ve döndürülür.			
	 *
	 * GEREKLÝLÝK: 	Herhangi bir ImKAB_XMLKutuphanesi dosyasý iþlemi yapabilabilmesi için öncelikle bu fonksiyonun 
	 * çaðrýlmasý gerekmektedir.
	 *
	*********************************************************************************************/	
    public Document Im_YeniDosyaAcmaAyari()
    {
        try
        {
        	/**
	  		 * ImKAB_XMLKutuphanesi belgesi oluþturmak için ilk olarak belge_ureteci nesnesi oluþturuldu.
	  		 * Normal JAVA dan farklý olarak Android için newInstance metodu kullanýlmasý gerekmektedir.
	  		 * 
	  		 * belge_yapici nesnesi bir ImKAB_XMLKutuphanesi belgesinden DOM belgesi elde edebilmek için oluþturuldu.
	  		 * 
	  		 * belge isimli bir DOM örneði yaratýldý. DOM ile bir ImKAB_XMLKutuphanesi belgesinin içeriði,stili ve yapýsý görülüp deðiþtirilebilir.
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
	 * FONKSÝYON ADI: 				Im_VarolanDosyayiAcmaAyari
	 * FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon diðer fonksiyonlarda kullanýlmak için yazýlmýþ olup
	 * herhangi varolan ImKAB_XMLKutuphanesi dosyasý üzerinde iþlem yapýlabilmmek için gerekli düzenlemeleri yapan fonk
	 * siyondur.
	 *
	 * ERÝÞÝM: Public
	 * 
	 * PARAMETRELER: YOK
	 * 			ADI						TÝPÝ				AÇIKLAMASI
	 *			str_dosya_klasoru		String				Açýlacak dosyanýn bulunduðu klasörü tutan deðiþkendir.
	 *			str_XML_dosyasi_ismi	String				Açýlacak olan dosyanýn ismini tutan deðiþkendir.
	 * DÖNÜÞ:	
	 * 			ADI						TÝPÝ				AÇIKLAMASI
	 *			belge					Document			Gerekli düzenlemeler yapýlarak belge deðiþkeni hazýrlanýr ve döndürülür.			
	 *
	 * GEREKLÝLÝK: 	Herhangi bir ImKAB_XMLKutuphanesi dosyasý iþlemi yapabilabilmesi için öncelikle bu fonksiyonun 
	 * çaðrýlmasý gerekmektedir.
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
	 * FONKSÝYON ADI: 				Im_BelgedenStringYarat
	 * FONKSÝYON AÇIKLAMASI: 		Belgeden String yaratýlmasý iþlemini gerçekleþtirir.
	 * 
	 * ERÝÞÝM: Public
	 * 
	 * PARAMETRELER:
	 * 			ADI				TÝPÝ				AÇIKLAMASI
	 *		   	belge		   	Document			Dönüþtürülmesi gereken belge parametre olarak verilir.
	 *
	 * DÖNÜÞ:
	 * 			ADI				TÝPÝ				AÇIKLAMASI
	 *			str_yazici		String				Belgenin kullanýlmak üzere String olarak döndürüleceði deðiþkendir.
	 *
	 * GEREKLÝLÝK: 	Bu fonksiyon ile yaratýlmasý planlanan ImKAB_XMLKutuphanesi dosya yapýsý String e dönüþtürülüp
	 * dosyanýn yaratýlmasý iþleminin gerçekleþtiði kýsýma aktarýlmasýnda kullanýlýr. 
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
	 * FONKSÝYON ADI: 				Im_DosyaKaydet
	 * FONKSÝYON AÇIKLAMASI: 		Ýþlemi tamamlanan bir ImKAB_XMLKutuphanesi doyasýný belirtilen klasör altýnda belir
	 * tilen isim ile kaydeden fonksiyondur.
	 * 
	 * ERÝÞÝM: Public
	 * 
	 * PARAMETRELER:
	 * 			ADI						TÝPÝ				AÇIKLAMASI
	 *		  	str_klasor_adi			String				Ýçerisine kaydedilecek olan klasöre ait ismi tutan deðiþkendir.
	 *			str_dosya_adi			String				Kaydedilecek olan dosyaya ait ismi tutan deðiþkendir.
	 *			str_kaydedilecek_dosya	String				Kaydedilecek olan dosyanýn tutulduðu deðiþkendir.
	 *
	 * DÖNÜÞ: YOK
	 * 			ADI						TÝPÝ				AÇIKLAMASI
	 *		
	 * GEREKLÝLÝK: 	Ýstenildiði þekilde düzenlenen ImKAB_XMLKutuphanesi dosyalarýnýn kaydedilmesi iþleminin yapýlmasý
	 * için gereklidir.
	 *
	*********************************************************************************************/
    public void Im_DosyaKaydet( String str_klasor_adi,
		   					   	String str_dosya_adi,
		   					   	String str_kaydedilecek_dosya
		   					  )
    {
		try 
		{
			/*Dosyanýn kaydedileceði dizin oluþturulmaktadýr.*/
			String str_dizin = "/sdcard/" + str_klasor_adi + "/" + str_dosya_adi + ".xml";
			
			/*Belirtilen dizinde dosya yapýlandýrýr.*/
			File yeni_dosya = new File(str_dizin);
			
			/**
			 * Eðer böyle bir klasör belirtilen dizinde yoksa,öncelikle klasör yaratýlýr.  
			 */
			if(!yeni_dosya.exists())
			{
				yeni_dosya.getParentFile().mkdir();	    				
			}
			
			/**
			 * Özellikleri belirtilen dosya yaratýlýr
			 * ve ImKAB_XMLKutuphanesi den String e dönüþtürülen yapý dosya içerisine byte byte atýlýr.
			 * Daha sonra oluþturulan dosya kapanýr. 
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
	 * FONKSÝYON ADI: 				Im_XMLOlustur
	 * FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon istenilen klasörde ve dosya isminde, istenilen yapýda 
	 * ImKAB_XMLKutuphanesi belgesi oluþturabilen fonksiyondur.
	 *
	 * ERÝÞÝM: Public
	 * 
	 * PARAMETRELER:
	 * 			ADI					TÝPÝ				AÇIKLAMASI
	 *			str_klasör_adi		String				Dosyanýn /sdcard/ yolu içerisinde kaydedileceði klasörün adýný tutan deðiþkendir.
	 *			str_dosya_adi		String				Dosyanýn /sdcard/klasör_adi/ yolu içinde hangi isimle kaydedileceðini tutan deðiþkendir.
	 *			str_kok_etiket		String				ImKAB_XMLKutuphanesi dosyasýnýn sahip olacaðý kök elemanýn tutuldðu deðiþkendir.	
	 *			str_alt_eleman		String Array		ImKAB_XMLKutuphanesi dosyasýnda kök eleman altýnda bulunacak alt elemanlarý tutan dizi deðiþkenidir.
	 *
	 * DÖNÜÞ: YOK
	 * 			ADI					TÝPÝ				AÇIKLAMASI
	 *
	 * GEREKLÝLÝK: 	Bu fonksiyon daha önce oluþturulmamýþ bir ImKAB_XMLKutuphanesi belgesinin istenilen özelliklerde
	 * oluþturulmasýna esnek bir þekilde olanak saðlamaktadýr.
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
			Document belge= Im_YeniDosyaAcmaAyari(); /*Dosya açmak için ayar fonksiyonu çaðrýlmaktadýr.*/
		  	
	   		Element kok_eleman = belge.createElement(str_kok_etiket);	 /* kok_eleman isimli ImKAB_XMLKutuphanesi kök etiketi yaratýldý*/
	   		belge.appendChild(kok_eleman);								 /* Oluþturulan kok_eleman belgeye eklendi.*/
		   		
	   		/**
	   		 * Bu döngü ile kok_eleman etiketinin altýnda yer alacak alt elemanlar yaratýlmýþtýr.
	   		 * alt1_eleman ile temsil edileceklerdir.
	   		 */
		   	for(int i = 0; i < str_alt_eleman.length; i++)
		   	{	
	   	  		
	   			/*Parametre olarak tanýmlý alt1 elemaný yaratýlýp kok_eleman ýn altýna eklenmiþtir.*/
	   	  		Element alt1_eleman = belge.createElement(str_alt_eleman[i]);	
	   	  		kok_eleman.appendChild(alt1_eleman);
	   	      	   
	   	  		/*alt2_1_eleman alt1_eleman ýn altýnda yer alacak alt elemanlardan birisidir.*/
	   	  		Element alt2_1_eleman = belge.createElement("XKoordinat");
	   	  		alt1_eleman.appendChild(alt2_1_eleman);
	   	    
	   	  		/*alt2_2_eleman alt1_eleman ýn altýnda yer alacak alt elemanlardan birisidir.*/
	   	  		Element alt2_2_eleman = belge.createElement("YKoordinat");
	   	  		alt1_eleman.appendChild(alt2_2_eleman);
	   	  		
	   	  		/*alt2_3_eleman alt1_eleman ýn altýnda yer alacak alt elemanlardan birisidir.*/	
	   	  		Element alt2_3 = belge.createElement("ZKoordinat");
	   	  		alt1_eleman.appendChild(alt2_3);	
	   		} 	
		   		
	   		/* belgeden String e dönüþüm yapabilmek için str_string_belgeden nesnesi yaratýlmýþtýr.*/
	   		String str_string_belgeden = Im_BelgedenStringYarat(belge);
	   		/*Dosya kaydet fonksiyonu çaðrýlarak yapýlan iþlemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_klasor_adi, str_dosya_adi, str_string_belgeden);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	/********************************************************************************************
	 *
	 * FONKSÝYON ADI: 				Im_XMLOlustur
	 * FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon varsayýlan deðerler kullanarak ImKAB_XMLKutuphanesi belgesi oluþturmak
	 * tadýr.
	 * 
	 * ERÝÞÝM: Public
	 * 
	 * PARAMETRELER: YOK
	 * 			ADI					TÝPÝ				AÇIKLAMASI
	 *
	 * DÖNÜÞ: YOK
	 * 			ADI					TÝPÝ				AÇIKLAMASI
	 *
	 * GEREKLÝLÝK: 	Herhangi bir parametre girilmemesi durumunda varsayýlan deðerler kullanýlarak
	 * bir hata oluþmasýný önlemek için gereklidir.
	 *
	*********************************************************************************************/
	public void Im_XMLOlustur()
	{
		/*Varsayýlan deðerlerin tutulduðu string arrayi*/
		String [] alt_eleman = {"Varsayilan1","Varsayilan2","Varsayilan3","Varsayilan4","Varsayilan5"};
		/*Varsayýlan deðerler kullanýlarak daha önce hazýrlanan Im_XMLOlustur(...) fonksiyonu çaðrýlmýþtýr. */
		Im_XMLOlustur("VarsayilanKlasor", "VarsayilanDosya", "VarsayilanEtiket", alt_eleman);
	} 
		     
	
		     
	/********************************************************************************************
	*
	* FONKSÝYON ADI: 				Im_XMLVeriOku
	* FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon belirtilen ImKAB_XMLKutuphanesi belgesi içerisinde belirtilen etikete ait
	* deðeri okuma iþlemini yapmaktadýr.
	* 
	* ERÝÞÝM: public
	* 
	* PARAMETRELER:	
	* 		ADI							TÝPÝ			AÇIKLAMASI
	*		str_dosya_klasoru			String			Ýçerisinden veri okunacak olan ImKAB_XMLKutuphanesi belgesinin bulunduðu klasörün tutulduðu deðiþkendir.
	*		str_XML_dosyasi_ismi		String			Ýçerisinden etiket deðeri okunacak olan ImKAB_XMLKutuphanesi belgesinin isminin tutulduðu deðiþkendir.	
	*		str_veri_okunacak_etiket	String			Hangi etikete ait deðerin okunacaðýnýn tutulduðu deðiþkendir.
	* 
	* DÖNÜÞ:
	* 		ADI							TÝPÝ			AÇIKLAMASI
	* 		str_okunan_veri					String
	*	
	* GEREKLÝLÝK: 	Bir ImKAB_XMLKutuphanesi belgesi içerisinde herhangi bir etiket altýndaki deðerin okunmasý gerektiði
	* durumlar için kullanýlmaktadýr.
	* 
	*********************************************************************************************/
	public String Im_XMLVeriOku( String str_dosya_klasoru, 
   						 		 String str_XML_dosyasi_ismi, 
   						 	     String str_veri_okunacak_etiket
		  					   )
	{
		String str_okunan_veri = "Veri Yok!"; /*Belirtilen yolda herhangi bir veri bulunamazsa dönecek deðerdir.*/
		try
		{
			Document belge = Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Dosya açmak için ayar fonksiyonu çaðrýlmaktadýr.*/
	    
		    /**
		     * belge.getElementsByTagName ile içerisinde deðiþiklik yapýlmak istenen etiketler, NodeList tipinde
		     * etiketlere atandý ve oluþturulan NodeList etiketlerinden istenen etikete ait içerik getTextContent() ile çaðrýldý.
		     * Okunmak istenen deðer str_okunan_veri deðiþkenine atandý.
		     */
		    NodeList etiketler = belge.getElementsByTagName(str_veri_okunacak_etiket);
			for (int i =0; i<etiketler.getLength();i++)
			{
			    Node eleman = etiketler.item(i);
			    
			    if(str_veri_okunacak_etiket.equals(eleman.getNodeName()))
			    {
			        str_okunan_veri=eleman.getTextContent(); 	/*Verinin dönüþ deðerine yüklenme iþlemi*/
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
 	* FONKSÝYON ADI: 				Im_XMLEtiketEkle
 	* FONKSÝYON AÇIKLAMASI: 		Bu Fonksiyon istenilen etiket üstüne yeni bir etiket ve etikete ait deðer
 	* eklenmesini saðlayan fonksiyondur.
 	* 
 	* ERÝÞÝM:	public
 	* 
 	* PARAMETRELER:	
 	* 		ADI								TÝPÝ						AÇIKLAMASI
 	*		str_dosya_klasoru				String		içerisinden etiket eklenecek olan ImKAB_XMLKutuphanesi dosyasýnýn bulunduðu klasörün tutulduðu deðiþkendir.
 	*		str_XML_dosyasi_ismi			String		Ýçerisinden etiket eklenecek olan ImKAB_XMLKutuphanesi dosyasýnýn isminin tutulduðu deðiþkendir.	
 	*		str_belirtec_etiket				String		Hangi etiketin belirteç olarak (o etiketin yukarýsýna eklenmesi) kullanýlacaðýnýn tutulduðu deðiþkendir.
 	* 		str_eklenecek_etiket_ismi		String		Yeni eklenecek olan etiketin ismidir.
 	* 		str_icerisine_yazilacak_deger	String		Yeni eklenecek olan etiketin içerisine yazýlacak olan deðeridir.
 	* 
 	* DÖNÜÞ: YOK
 	* 		ADI							TÝPÝ						AÇIKLAMASI
 	*	
 	* GEREKLÝLÝK: 	Herhangi bir ImKAB_XMLKutuphanesi dosyasý içerisinden istenilen etiket üzerine yeni bir etiket ekleme iþlemi
 	* için gereklidir.
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
			Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyayý kullaným için hazýr hale getirir.*/
			    
		    /* belge.getElementsByTagName ile içerisinde deðiþiklik yapýlmak istenen etiketler çaðrýldý. */
			NodeList etiketler = belge.getElementsByTagName(str_belirtec_etiket);
			
			/**
			 * String tipinde parametre olarak alýnan etiket altýna yazýlacak deðer Text haline dönüþtürülmüþtür.
			 * str_eklenecek_etiket_ismi parametresi ile alýnan etiket ismi ile yeni Element yaratýlmýþtýr.
			 * Bu yeni etikete içerisine yazýlmasý istenilen deðer iliþtirilmiþtir.
			 * Yeni etiket parametre olarak alýnan belirteç etiketinin üzerine eklenmiþtir.
			 */
			Text icerisine_yazilacak_deger = belge.createTextNode(str_icerisine_yazilacak_deger); 
			Element yeni_etiket = belge.createElement(str_eklenecek_etiket_ismi); 
			yeni_etiket.appendChild(icerisine_yazilacak_deger);
			etiketler.item(0).getParentNode().insertBefore(yeni_etiket, etiketler.item(0));
			
			/* belgeden String e dönüþüm yapabilmek için str_string_belgeden nesnesi yaratýlmýþtýr.*/
			String str_dosya_icerigi = Im_BelgedenStringYarat(belge);
			
			/*Dosya kaydet fonksiyonu çaðrýlarak yapýlan iþlemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		 }
 		catch (Exception e) 
 		{	
 			e.printStackTrace();
 		}
	}

	
	/********************************************************************************************
	*
	* FONKSÝYON ADI: 				Im_XMLEtiketIsmiGuncelle
	* FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon belirtilen ImKAB_XMLKutuphanesi dosyasýna ait, belirtilen etiketin
	* isminin deðiþtirilmesini saðlayan fonksiyondur.
	* 
	* ERÝÞÝM: public
	* 
	* PARAMETRELER:	
	* 		ADI									TÝPÝ			AÇIKLAMASI
	*		str_dosya_klasoru					String			Ýçerisinde deðiþiklik yapýlacak olan ImKAB_XMLKutuphanesi dosyasýnýn bulunduðu klasörün tutulduðu deðiþkendir.
	*		str_XML_dosyasi_ismi				String			Ýçerisinde deðiþiklik yapýlacak olan ImKAB_XMLKutuphanesi isminin tutulduðu deðiþkendir.	
	*		str_ismi_degistirilecek_olan_etiket	String			Hangi etiketin isminin deðiþtirileceðinin tutulduðu deðiþkenidir.
	* 		str_yeni_isim						String			Yeni ismin tutulduðu deðiþkendir.
	* 
	* DÖNÜÞ: YOK
	* 		ADI									TÝPÝ			AÇIKLAMASI
	*	
	* GEREKLÝLÝK: 	Herhangi bir ImKAB_XMLKutuphanesi dosyasý içerisinden istenilen etiketin isminin deðiþtirilmesi
	* gerektiði durumlarda kullanýlýr.
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
			Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyayý kullaným için hazýr hale getirir.*/	
			
			/*Ýsmi deðiþtirilecek olan etiket seçilir.*/
			NodeList etiket = belge.getElementsByTagName(str_ismi_degistirilecek_olan_etiket);
		 		    
		 	/*Seçilen etiket aratýlarak isminin deðiþtirilmesi ve verilerini kaybetmemesi saðlanýr.*/
 		    for (int i = 0; i < etiket.getLength(); i++) {
 		    	belge.renameNode(etiket.item(i), null, str_yeni_isim);
 		    }

 		    /*Belgeden stringe geçiþ yapabilmek için belgeden_string_yarat fonksiyonu çaðrýlmýþtýr.*/
		 	String str_dosya_icerigi=Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu çaðrýlarak yapýlan iþlemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		}
 		catch (Exception e) 
 		{	
 			e.printStackTrace();
 		}
	}
		 	
	
	/********************************************************************************************
	*
	* FONKSÝYON ADI: 				Im_XMLEtiketSil
	* FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon belirtilen ImKAB_XMLKutuphanesi etiketinin tamamen silinmesini saðlayan
	* fonksiyondur.
	* 
	* ERÝÞÝM:	public
	* 
	* PARAMETRELER:	
	* 		ADI						TÝPÝ			AÇIKLAMASI
	*		str_dosya_klasoru		String			içerisinden etiket silinecek olan ImKAB_XMLKutuphanesi dosyasýnýn bulunduðu klasörün tutulduðu deðiþkendir.
	*		str_XML_dosyasi_ismi	String			Ýçerisinden etiket silinecek olan ImKAB_XMLKutuphanesi dosyasýnýn isminin tutulduðu deðiþkendir.	
	*		str_silinecek_etiket	String			Hangi etiketin silineceðinin tutulduðu string deðiþkendir.
	* 
	* DÖNÜÞ: YOK
	* 		ADI						TÝPÝ			AÇIKLAMASI
	*	
	* GEREKLÝLÝK: 	Herhangi bir ImKAB_XMLKutuphanesi dosyasý içerisinden istenilen etiketin tamamen silinmesi gerektiði
	* durumlarda kullanýlýr.
	* 
	*********************************************************************************************/		 	
	public void Im_XMLEtiketSil( String str_dosya_klasoru, 
						   	  	 String str_XML_dosyasi_ismi, 
						   	  	 String str_silinecek_etiket
						       )
	{
		try
		{
			Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyayý kullaným için hazýr hale getirir.*/
			
 		    /**
 		     * belge.getElementsByTagName(str_silinecek_etiket).item(0) ile silinmek istenen etiket çaðrýldý
 		     * silinecek_olan_eleman.getParentNode().removeChild(silinecek_olan_eleman) ile etiket ImKAB_XMLKutuphanesi belgesi içersinden çýkarýldý.
 		     * belge.normalize() ile belgede olabilecek bir uyumsuzluk (etiketler arasý deðer varmýþ gibi gösterme) giderildi.
 		     */
 		    Element silinecek_olan_eleman = (Element) belge.getElementsByTagName(str_silinecek_etiket).item(0);
 		    silinecek_olan_eleman.getParentNode().removeChild(silinecek_olan_eleman);
 		    belge.normalize(); 
		 	
 		    /*Belgeden string geçiþ yapabilmek için belgeden_string_yarat fonksiyonu çaðrýlmýþtýr.*/
		 	String str_dosya_icerigi=Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu çaðrýlarak yapýlan iþlemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		 }
 		catch (Exception e) 
 		{	
 			e.printStackTrace();
 		}
	}
		 
		  
	/********************************************************************************************
	 *
	 * FONKSÝYON ADI: 				Im_XMLVeriYaz
	 * FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon daha önce hazýrlanmýþ olan ImKAB_XMLKutuphanesi belgesinde; belir
	 * tilen etiket içerisine, belirtilen veriyi yazma iþlemini yapar. Daha sonrasýnda belirtilen
	 * isim ile ImKAB_XMLKutuphanesi belgesini, belirtilen dosya klasörü içerisine kaydeder. 
	 * 
	 * ERÝÞÝM: public
	 * 
	 * PARAMETRELER:	
	 * 		ADI										TÝPÝ		AÇIKLAMASI
	 *		str_dosya_klasoru						String		Kullanýlacak olan ImKAB_XMLKutuphanesi dosyasýnýn bulunduðu klasörünün tutulduðu deðiþkenidir.
	 *		str_acilacak_XML_dosyasi_ismi			String		Kullanýlacak olan ImKAB_XMLKutuphanesi dosyasýnýn isminin tutulduðu deðiþkendir
	 *		str_icinde_degisiklik_yapilacak_etiket	String		Yapýlacak deðiþikliðin hangi etiket altýnda olacaðýnýn belirtildiði deðiþkendir.
	 *		str_veri_girilecek_etiket_elemani		String		Etiket içerisinde hangi elemana veri girileceðinin belirtildiði deðiþkendir.
	 *		str_girilecek_veri						String		Yazýlacak olan verinin tutulduðu deðiþkendir.
	 *		str_yeni_dosya_ismi						String		Dosyanýn son hali ile kaydedileceði ismin tutulduðu deðiþkendir.
	 *		str_yeni_XMLin_kaydedilecegi_dosya		String		Yeni oluþturulan dosyanýn hangi klasör içerisine kaydedileceðinin tutulduðu deðiþkendir.
	 * 
	 * DÖNÜÞ: YOK
	 * 		ADI										TÝPÝ		AÇIKLAMASI
	 *	
	 * GEREKLÝLÝK: 	Bu fonksiyon taslak olarak hazýrlanmýþ ImKAB_XMLKutuphanesi belgeri içerisine veri yazabilmek
	 * için gereklidir.
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
			 Document belge= Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_acilacak_XML_dosyasi_ismi); /*Varolan dosyayý kullaným için hazýr hale getirir.*/			 
		     /**
		      * belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0) ile içerisinde deðiþiklik yapýlmak istenen etiket çaðrýldý ve
		      * oluþturulan NodeList liste deðiþkeni içerisine alt elemanlarý "elemani.getChildNodes()"
		      * fonksiyonu ile atýldý.
		      */
		    Node elemani = belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0);
		    NodeList liste = elemani.getChildNodes();

		    /**
		     * Listede tutulan elemanlar, içerisinde deðiþiklik yapýlmak istenen etiket elemaný ile
		     * karþýlaþtýrýlarak, doðru olan yer içerisine "eleman.setTextContent(str_girilecek_veri)"
		     * yardýmý ile istenilen veri yazýlýr.
		     */
			for (int i = 0; i < liste.getLength(); i++)
			{
			    Node eleman = liste.item(i);
			    
			    if(str_veri_girilecek_etiket_elemani.equals(eleman.getNodeName()))
			    {
			        eleman.setTextContent(str_girilecek_veri);		/*Verinin Tag içerisinde yazdýrýlma iþlemi*/
			    }
			}
			
 		    /*Belgeden string geçiþ yapabilmek için belgeden_string_yarat fonksiyonu çaðrýlmýþtýr.*/
		 	String str_dosya_icerigi=Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu çaðrýlarak yapýlan iþlemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_yeni_XMLin_kaydedilecegi_dosya, str_yeni_dosya_ismi, str_dosya_icerigi);
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
	}
	

	/********************************************************************************************
	 *
	 * FONKSÝYON ADI: 				Im_XMLVeriGuncelle
	 * FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon daha önce oluþturulmuþ olan ImKAB_XMLKutuphanesi dosyasýnýn içeri
	 * sinde belirtilen etiket altýnda bulunan öðelerden, seçilen öðenin güncellemesini yapmaktadýr.
	 * 
	 * ERÝÞÝM:	public
	 * 
	 * PARAMETRELER:	
	 * 		ADI											TÝPÝ		AÇIKLAMASI
	 *		str_dosya_klasoru							String		Kullanýlacak olan ImKAB_XMLKutuphanesi dosyasýnýn bulunduðu klasör deðiþkenidir.
	 *		str_gulcellencek_XML_dosyasi_ismi			String		Güncellenecek olan ImKAB_XMLKutuphanesi dosyasýnýn isminin tutulduðu deðiþkendir.	
	 *		str_içerisinde_guncelleme_yapilacak_etiket	String		Yapýlacak deðiþikliðin hangi TAG altýnda yapýldýðýný belirten deðiþkendir.
	 *		str_guncelleme_yapýlacak_etiket_elemani		String		Tag içerisinde hangi elemanýn verisinin güncelleneceðinin belirtildiði deðiþkendir.
	 *		str_yeni_veri								String		Yeni veriye ait deðiþkendir.
	 * 
	 * DÖNÜÞ: YOK
	 * 		ADI											TÝPÝ		AÇIKLAMASI
	 *	
	 * GEREKLÝLÝK: 	Bu foksiyon var olan ImKAB_XMLKutuphanesi dosyalarýndan herhangi biri içerisinde deðiþiklik 
	 * yapmak için gereklidir.
	 * 
	***********************************************************************************************/
	public void Im_XMLVeriGuncelle( String str_dosya_klasoru, 
								 	String str_gulcellencek_XML_dosyasi_ismi, 
								 	String str_icerisinde_guncelleme_yapilacak_etiket, 
								 	String str_guncelleme_yapýlacak_etiket_elemani, 
								 	String str_yeni_veri 
								  )
	{
		/**
		 * Daha önce oluþturulan Im_XMLVeriYaz fonksiyonu, dosyayý ayný yere ayný isim
		 * ile kaydedecek þekilde düzenlenerek güncelleme iþlemi için de kullanýlmýþtýr. 
		 */
		Im_XMLVeriYaz(str_dosya_klasoru, str_gulcellencek_XML_dosyasi_ismi, 
				str_icerisinde_guncelleme_yapilacak_etiket, str_guncelleme_yapýlacak_etiket_elemani, 
				str_yeni_veri, str_gulcellencek_XML_dosyasi_ismi, str_dosya_klasoru);
	}

	
	/*******************************************************************************************
	*
	* FONKSÝYON ADI: 				Im_XMLVeriSil
	* FONKSÝYON AÇIKLAMASI: 		Bu fonksiyon belirtilen etikete ait etiket elemanýnýn içeriðinin
	* temizlenmesi iþlemini yapan fonksiyondur.
	* 
	* ERÝÞÝM:	public
	* 
	* PARAMETRELER:	
	* 		ADI										TÝPÝ		AÇIKLAMASI
	*		str_dosya_klasoru						String		içerisinden veri silinecek olan ImKAB_XMLKutuphanesi dosyasýnýn klasörün tutulduðu deðiþkenidir.
	*		str_XML_dosyasi_ismi					String		Ýçerisinden veri silinecek olan ImKAB_XMLKutuphanesi dosyasýnýn isminin tutulduðu deðiþkenidir.	
	*		str_icinde_degisiklik_yapilacak_etiket	String		Silinecek verinin hangi etiket altýnda bulunduðunun tutulduðu deðiþkendir.
	* 		str_verisi_silinecek_etiket_elemaný		String		Silinecek verinin hangi elemana ait olduðununun tutulduðu deðiþkendir.
	* 
	* DÖNÜÞ: YOK
	* 		ADI										TÝPÝ		AÇIKLAMASI
	*	
	* GEREKLÝLÝK: 	Herhangi bir ImKAB_XMLKutuphanesi dosyasý içerisinden istenilen etiket elemanýnýn verisini silmek için
	* gereklidir.
	***********************************************************************************************/  
	
	public void Im_XMLVeriSil(  String str_dosya_klasoru, 
							 	String str_XML_dosyasi_ismi, 
							 	String str_icinde_degisiklik_yapilacak_etiket,
							 	String str_verisi_silinecek_etiket_elemaný
						  	 )
	{
		 try
		 {
			 Document belge = Im_VarolanDosyayiAcmaAyari(str_dosya_klasoru, str_XML_dosyasi_ismi); /*Varolan dosyayý kullaným için hazýr hale getirir.*/	
			 
		     /**
		      * belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0) ile içerisinde deðiþiklik yapýlmak istenen etiket çaðrýldý
		      * ve oluþturulan NodeList liste deðiþkeni içerisine alt elemanlarý "elemani.getChildNodes()"
		      * fonksiyonu ile atýldý.
		      */
			 Node elemani = belge.getElementsByTagName(str_icinde_degisiklik_yapilacak_etiket).item(0);
			 NodeList liste = elemani.getChildNodes();
	
		    /**
		     * Listede tutulan elemanlar, içerisi boþaltýlmak istenen etiket elemaný ile
		     * karþýlaþtýrýlýr. Doðru olan etiket elemaný-> "eleman.setTextContent("")"
		     * yardýmý ile boþaltýlýr.
		     */
			for (int i = 0; i < liste.getLength(); i++)
			{
			    Node eleman = liste.item(i);
			    
			    if(str_verisi_silinecek_etiket_elemaný.equals(eleman.getNodeName()))
			    {
			        eleman.setTextContent("");		/*Verinin Temizlenme Ýþlemi*/
			    }
			}
			
			/*Belgeden string geçiþ yapabilmek için belgeden_string_yarat fonksiyonu çaðrýlmýþtýr.*/
		 	String str_dosya_icerigi = Im_BelgedenStringYarat(belge);
		 	
		 	/*Dosya kaydet fonksiyonu çaðrýlarak yapýlan iþlemler belirtilen konuma, belirtilen isim ile kaydedildi.*/
	   		Im_DosyaKaydet(str_dosya_klasoru, str_XML_dosyasi_ismi, str_dosya_icerigi);
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
	}
	
}
