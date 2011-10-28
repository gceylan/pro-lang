<?php

function my_reverse($text){
	$new_text = "";
	$L = strlen($text);
	for ($i=$L; $i>0; $i--){
		$new_text = $new_text.$text[$i - 1];
	}
	echo $new_text;
}

my_reverse("deneme");
?>
