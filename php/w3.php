<html>
<body>

<?php
$i = "j";
$j = "merhaba";
$pos = strpos($j, $i);
if ($pos == false){
	echo "merhaba kelimesinde $i harfi bulunamadı.<br>";
}
else {
	$pos += 1;
	echo "merhaba kelimesinde $i harfi baştan $pos. sırada bulunmaktadır.";
}
?>

<?php
$d = date("D");
if ($d == "Mon"){
	echo "have a nice day";
}
else{
	echo "today haven' t friday. sory...";
}
?>

<?php


?>





</body>
</html>
