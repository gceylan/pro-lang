<?php

function my_replace($i, $j, $metin){
	$text = "";
	for ($x=0; $x < strlen($metin); $x++){
		$harf = $metin[$x];
		if ($harf == $i){
			$text = $text.$j;
		}
		else{
			$text = $text.$harf;
		}

	}
	echo $text;
}


my_replace("a", "e", "korcan");

?>
