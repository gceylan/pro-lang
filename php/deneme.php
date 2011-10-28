<html>
<head>
	<title>PHP ısınma turları</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<?php

//php' de $a=0 ve $x="" ifadelerinin bool değeri false dir.

function acilir_liste(){
	echo "<select name='yillar'>";
	for ($i=2011;$i>=1991;$i--)
		echo "<option value='$i'>$i</option>";
	echo "</select>";
}

function carpim_tablosu($sayi){
	for ($i=0; $i<=10; $i++){
		echo "$sayi x $i = ".$sayi*$i."<br>";
	}
}

function faktoriyel($sayi){
	echo "$sayi! = ";
	$t = 1;
	while ($sayi>=1){
		$t *= $sayi;
		$sayi -= 1;
		}
	echo "$t";
}

function faktoriyel_2($sayi){  //faktoriyel kavramı
	echo "$sayi! = ";
	$t = 1;
	for ($i=1; $i <= $sayi; $i++){
		$t *= $i;
		}
	echo "$t";
}

function pbs($sayi){  //bir sayını pozitif bölenleri
	$t = 0;
	for ($i=1; $i<=$sayi; $i++){
		if ($sayi%$i == 0){
			$pbs_dizi[] = $i;
			$t += $i;    //pozitif bölenler toplamı
			}
		}
	echo "$sayi sayısının pozitif bölenleri;<br>{ ";
	foreach ($pbs_dizi as $x){
		echo $x.", ";
		}
	echo "}<br>";
	echo "$sayi sayısının pozitif bölenlerinin sayısı, ".count($pbs_dizi)."<br>";
	echo "$sayi sayısının pozitif bölenlerinin toplamı, ".$t."<br>";
	echo "$sayi sayısının tam bölenlerinin sayısı ".count($pbs_dizi)*2 .", toplamı 0";
}

function metni_yaz($metin){  //ekrana büyükten küçüğe istenilen metni yazar
	for ($i=1; $i < 7; $i++){
		echo "<h$i>$metin</h$i>";
		}
}

function tablo_yap($satir, $sutun){
	echo "<table border='1' width='50%'>";
	for ($i=1; $i<=$satir; $i++){
		echo "<tr>";
		for ($j=1; $j<=$sutun; $j++){
			echo "<td>$j. sütun</td>";
			}
		echo "</tr>";
		}
	echo "</table>";
}
//tablo_yap(5, 3);

function asal_mi($sayi) {
	$sayac=0;
	for($i=2; $i<=($sayi-1); $i++){
		if ($sayi%$i==0)
		$sayac++;
		}
	if ($sayac==0) {echo "sayı asaldır= ".$sayi;}
	else {echo "sayı asal değildir= ".$sayi;}
}
//asal_mi(125976717);

function sayinin_karesi($sayi, $ust){
	echo "<table border='1' width='30%'>";
	echo "<tr><td>Sayı</td><td>$ust. kuvveti</td></tr>";
	for ($i=1; $i<=$sayi; $i++){
		echo "<tr><td>$i</td><td>".pow($i, $ust)."</td></tr>";
		}
	echo "</table>";
}
//sayinin_karesi(20, 2);

function il_plaka_listesi(){
	echo "İl Seçiniz: <select name='iller'>";
	for ($i=1; $i<=81; $i++){
		echo "<option value='$i'>",($i < 10)?"0".$i:$i,"</option>";
		}
	echo "</select>";
}
//il_plaka_listesi();

function dokuza_bolunenler_dizisi(){
	for ($i=0; $i<=100; $i++){
		if ($i%9==0){
			$dizi[]=$i;
			}
		}
	print_r($dizi);
}
//dokuza_bolunenler_dizisi();

function dokuza_bolunenler_dizisi_2(){
	for ($i=1;$i<=100;$i++)
		if($i%9==0)
		$sayilar[]=$i;
		
	for ($i=0;@$sayilar[$i];$i++)  //Bir komutun verdiği uyarıyı ekranda görmek istemiyorsanız o komutun başına @ işareti koymalısınız.
		echo $sayilar[$i]," ";
}
//dokuza_bolunenler_dizisi_2();

function diziden_acilir_liste_yap($dizi, $adi){
	echo "<select name=$adi><br>";
	foreach($dizi as $i){
		echo "<option value=$i>$i</option><br>";
		}
	echo "</select>";
}
//$aylar=array("Ocak","Şubat","Mart","Nisan","Mayıs","Haziran","Temmuz","Ağustos","Eylül","Ekim","Kasım","Aralık");
//diziden_acilir_liste_yap($aylar, "aylar");

//üst alma fonksiyonu my_pow();
function my_pow($sayi, $ust){
	$s = 1;
	for ($i=1; $i<=$ust; $i++){
		$s *= $sayi;
		}
	return $s;
}
//echo my_pow(10, 3);

//Tanımlı olan notlar dizisindeki zayıf ve iyi notların sayısını ekranda gösterelim.
function notlar($dizi){
	foreach ($dizi as $not){
		if ($not < 45){
			$zayif += 1;
			}
		else {
			$iyi += 1;
			}
		}
	echo "Zayıf : $zayif<br>İyi :$iyi";
}
//$notlar=array(64,52,32,96,15,77,81,25,78,55,65,40);
//notlar($notlar);

//başka bir yoldan
function notlar_2($dizi){
	foreach ($dizi as $not){
		($not<45)?$zayif+=1:$iyi+=1;
		}
	echo "Zayıf :$zayif<br>İyi: $iyi";
}
//$notlar=array(64,52,32,96,15,77,81,25,78,55,65,40);
//notlar_2($notlar);

//Tanımlı olan notlar dizisindeki en büyük notu bulalım.
function en_buyuk($dizi){
	$max = 0;
	foreach ($dizi as $i){
		$max = ($i>=$max)?$i:$max;
		}
	echo $max;
}
//$notlar=array(64,52,32,96,15,77,81,25,78,55,65,40);
//en_buyuk($notlar);

function en_kucuk($dizi){
	foreach ($dizi as $i){
		foreach ($dizi as $j){
			$min = ($i<$j)?$i:$j;
			}
		}
	echo $min;
}
//$notlar=array(64,52,32,96,15,77,81,25,78,55,65,40);
//en_kucuk($notlar);

//Tanımlı olan notlar dizisindeki notları grafik olarak ekranda gösterelim.
function notlari_grafik_olarak_goster($dizi){
	for($i=0; $i<count($dizi); $i++){
		echo "<img src='cubuk.png' width='14' height='",2*$dizi[$i],"'> ";
		//echo "<img src='cubuk.png' width='20' height='",2*$dizi[$i],"'> ";
		}
	echo "<br>";
	foreach ($dizi as $i){
		echo " $i";
		}
}
//$notlar=array(64,52,32,96,15,77,81,25,78,55,65,40);
//notlari_grafik_olarak_goster($notlar);

//Şimdi aynı grafiği tablo içinde gösterelim. Bu kez notları da altına yazalım.
function notlari_tablo_ile_goster($dizi){
	echo "<table border='0'>";
	echo "<tr>";
	for ($i=0; $i<count($dizi); $i++){
		echo "<td valign='bottom'><img src='cubuk.png' width='20' height='",2*$dizi[$i],"'></td>";
		}
	echo "</tr>";
	echo "<tr>";
	for ($i=0; $i<count($dizi); $i++){
		echo "<td>", $dizi[$i], "</td>";
		}
	echo "</tr>";
	echo "</table>";
}
//$notlar=array(64,52,32,96,15,77,81,25,78,55,65,40);
//notlari_tablo_ile_goster($notlar);

//Bir dizideki notları küçükten büyüğe doğru sıralayalım.
function k_b_sirala($dizi){
	echo print_r($dizi)."<br>";
	while (count($dizi) != 0){
		$n = min($dizi);  //en küçük eleman bulundu.
		$index = array_search($n, $dizi);
		$sirali_dizi[] = $dizi[$index];
		unset($dizi[$index]);  //en küçük eleman silindi.
	}
	print_r($sirali_dizi);
}
//$notlar=array(64,52,32,96,15,77,81,25,78,55,65,40);
//k_b_sirala($notlar);

function a(){
	$sayi = 1;
	$i = 0;
	while ($sayi != 45){
		$sayi = rand(1, 100);
		$i += 1;
		}
	echo "$sayi sayısı $i. tahminde bulundu.";
}

function dizi_elemanlarını_yaz($dizi){
	foreach ($dizi as $i){
		echo "$i ";
		}
}

function oylesine(){
	$s = rand(1, 100);
	$t = 0;
	$sayac = 0;
	while ($t <= 500){
		$sayi = rand(1, 100);
		$t += $sayi;
		$dizi[] = $sayi;
		$sayac += 1;
	}
	echo "Toplam=$t Toplanan sayı adeti, $sayac<br>";
	echo "seçilen sayılar, ";
	dizi_elemanlarını_yaz($dizi);
}

//1 ile 100 arasında rastgele üretilen 10 tek sayıyı bir diziye atayıp ekrana yazdıralım.
function farklı_on_tek_sayi(){
	$sayac = 0;
	while (count($dizi) != 10){
		$sayi = rand(1, 100);
		if ($sayi%2 == 1 and !in_array($sayi, $dizi)){
			$dizi[]=$sayi;
			}
		}
	dizi_elemanlarını_yaz($dizi);
}
//farklı_on_tek_sayi();

//Aldığı metni aldığı sayı kadar ekrana yazan fonksiyon.
function yaz($metin, $x){
	for ($i=0; $i<=$x; $i++){
		echo $metin;
		}
}
//yaz("merhaba gökhan", 10)

//Aldığı diziyi ekranda sırasız liste şeklinde gösteren fonksiyonu yazıp çağıralım.
function liste($dizi){
	echo "<ul>";
	foreach ($dizi as $i){
		echo "<li>$i</li>";
		}
	echo "</ul>";
}
//$ic_donanim=array("İşlemci","Anakart","RAM","Ekran Kartı","Sabitdisk");
//liste($ic_donanim);

//Aldığı sayının birler, onlar ve yüzler... basamağındaki rakamları bir dizi olarak gönderen fonksiyonu yazıp çağıralım.
function bsmk($sayi){
	echo "Sayı = $sayi<br>";
	$L = strlen($sayi);
	$dizi = array("birler bsmk.", "onlar bsmk.", "yüzler bsmk.",
	"binler bsmk", "onbinler bsmk.", "yüzbinler");
	$i = 0;
	while ($i < $L){
		$k = $sayi % 10;
		$bsmklar[$dizi[$i]] = $k;
		$sayi /= 10;
		$i += 1;
		continue;
		}
	print_r($bsmklar);
}
//bsmk(126579);

//Çağrıldığında içerisinde 1 ile 100 arasında "x" tane sayı bulunan bir dizi gönderen fonksiyon
function secilenler($x){
	for ($i=0; $i<=$x; $i++){
		$s = rand(1, 100);
		(!in_array($dizi))?$dizi[]=$s:$dizi[]='';
		}
	return $dizi;
}
//print_r(secilenler(10));

//Aldığı dizideki sayıların en büyüğünü, en küçüğünü ve ortalamasını gönderen fonksiyonu yazıp çağıralım.
function isle($sayilar){
	$t = 0;
	foreach ($sayilar as $i){
		$t += $i;
	}
	echo "dizideki en büyük sayı: ", en_buyuk($sayilar)."<br>";
	echo "dizideki en küçük sayı: ", en_kucuk($sayilar)."<br>";
	echo "dizideki sayıların ortalaması: ", $t/count($dizi);
}
//$sayilar = array(43,6,15,41,97,65,84,68,45,64,94,72,56);
//isle($sayilar);
?>


</body>
</html>
