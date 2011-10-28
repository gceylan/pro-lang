<?php

function my_upper ($metin){
	$cikti = "";
	$x = ord($metin[0]);
	if ((97 <= $x) and ($x <= 122)){
		$x = $x - 32;
		for ($i=1; $i < strlen($metin); $i++){
			$cikti = $cikti.$metin[$i];
		}
	}
	echo chr($x).$cikti;
}

my_upper("gökhan");

?>
