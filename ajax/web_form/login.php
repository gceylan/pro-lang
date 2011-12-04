<?php

$kull_adi = $_GET['username'];
$sifre = $_GET['password'];
if (($kull_adi == "gceylan") && ($sifre == "gceylan")) {
	echo "Hoşgeldiniz...";
} else {
	echo "kullanıcı adı veya şifre hatalı!";
}

?>
