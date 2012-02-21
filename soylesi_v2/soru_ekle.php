<?php
$soru = trim($_POST["soru2"]);
$cevap = trim($_POST["cevap2"]);

if (!$soru || !$cevap) {
	echo "Bilgiler eksik.";
	exit;
}

$connection = mysql_connect("localhost", "root", "emineker");
if (!$connection) {
	die("<b>veritabanına bağlanılamadı: </b>". mysql_error());
}

$db_select = mysql_select_db("soylesi", $connection);
if (!$db_select) {
	die("<b>veritabanı seçilemedi: </b>".mysql_error());
}

$sql = mysql_query("insert into sorular values(null, '$soru', '$cevap')");
if ($sql) {
	echo "Eklenene: ".$soru;
} else {
	echo "Eklenemedi...";
}

mysql_close($connection);
?>
