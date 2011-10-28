<?php

$tc = $_POST["tc"];
$L = strlen($tc);
if ($L != 11){
	echo "T.C kimlik numaraları 11 basamaklıdır. Doğru girdiğinizden emin olun.";
}
else {
	$tc_dizi = str_split($tc);
	$tek_bsmk_top = 0;
	$cift_bsmk_top = 0;
	foreach (range(1, ($L - 2)) as $index){
		if ($index % 2 == 0){
			$cift_bsmk_top += $tc_dizi[$index - 1];
		}

		else{
			$tek_bsmk_top += $tc_dizi[$index - 1];
		}
	}
	$onuncu_bsmk = (($tek_bsmk_top * 7) - $cift_bsmk_top) % 10;
	$on_birinci_bsmk = ($tek_bsmk_top + $cift_bsmk_top + $onuncu_bsmk) % 10;
	if ($onuncu_bsmk == $tc[9] and $on_birinci_bsmk == $tc[10]){
		echo "T.C kimlik numarası geçerlidir.";
	}
	else{
		echo "T.C kimlik numarası geçerli değildir.";
	}
}
?>
