<?php

$sayi = $_POST["hex_sayi"];
if (isset($_POST["dugme"])){
	$bin_sayi = array();
	$hex_sayi = array("A"=>10, "B"=>11, "C"=>12, "D"=>13, "E"=>14, "F"=>15);
	$sayi = str_split(strrev($sayi));
	foreach ($sayi as $i){
		if (array_key_exists($i, $hex_sayi)){
			$i = $hex_sayi[$i];
			foreach (range(0, 3) as $j){
				$k = $i % 2;
				$bin_sayi[] = $k;
				$i = $i / 2;
			}
		}
		else{
			foreach(range(0,3) as $j){
				$k = $i % 2;
				$bin_sayi[] = $k;
				$i = $i / 2;
			}
		}
	}
	echo strrev(implode($bin_sayi)); //diziyi ters çevirerek metine dönüştürür.
}





?>
