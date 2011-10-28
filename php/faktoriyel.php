<html>
<body>
<head>
</head>
<style>
html {background-color:#525252;}
body {margin:auto; width:800; margin-top:30px; background-color:#dfdfdf; padding:20px}
</style>
<?php
$sayi2 = $_POST['sayi'];
$sonuc = 1;
for ($sayi2; $sayi2 > 0; $sayi2--){
	$sonuc *= $sayi2;
}
echo "sonuç : $sonuc";
?>
</body>
</html>
