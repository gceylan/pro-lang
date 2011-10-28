<?php
$kart_no = $_POST["kart"];
if (strlen($kart_no) != 16){
	echo "16 basamaklı kredi kartı numaranızı doğru girdiğinize emin olunuz.";
}
else{
	$tek_top = 0;
	$cift_top = 0;
	foreach (range(0, 15) as $i){
		if ($i % 2 == 0){
			$n = $kart_no[$i] * 2;
			$dizi = str_split($n);
			foreach ($dizi as $j){
				$cift_top += $j;
			}
		}
		else{
			$tek_top += $kart_no[$i];
		}
	}
	if (($cift_top + $tek_top) % 10 == 0){
		echo "Kredi kartı no doğrulandı.";
	}
	else{
		echo "Kredi kartı no doğrulanmadı.";
	}
}

?>
