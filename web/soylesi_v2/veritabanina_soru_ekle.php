<?php
$soru = trim($_POST['soru']);

$connection = mysql_connect("localhost", "root", "emineker");
if (!$connection) {
	die("<b>veritabanına bağlanılamadı: </b>". mysql_error());
}

$db_select = mysql_select_db("soylesi", $connection);
if (!$db_select) {
	die("<b>veritabanı seçilemedi: </b>".mysql_error());
}

$sql = mysql_query("insert into sorular (soru) values ('$soru')");
if ($sql) {
	echo "eklenen: ".$soru;
}

mysql_close($connection);
?>
