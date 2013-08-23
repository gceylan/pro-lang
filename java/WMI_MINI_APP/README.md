##### Java ile basit bir WMI uygulaması

Bu uygulama ile örneğin 10 sn de bir çalışan bir prosesin toplam bellek kullanımını hesaplayıp herhangi bir veritabanına yazdırabilirsiniz.

Java ile WMI bağlanabilmek için farklı kütüphaneler mevcuttur. Bu uygulama JaCOB kütüphanesi ile yapılmıştır. 

##### JaCOB(Java COM Bridge) kurulumu

Öncelikle [JaCOB](http://sourceforge.net/projects/jacob-project/) kütüphanesini indirin.

.rar dosyasında `jacob.jar` ve `jacob.dll` olacak.

	- İşletim sisteminizin mimarisine uygun jocob.dll' i Windows/system32 altına yapıştırın.
	- jacob.jar' ı da projenize dahil edin.