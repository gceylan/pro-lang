<html>
	<head>
		<meta http-equiv="content" content="text/html; charset=utf-8">
		<meta http-equiv="content-style-type" content="text/css">
		<title>text to bin</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<div id="merkez">
		<form id="form" action="" method="post">
			<h4>--Text--</h4>
			<textarea name="text" id="textarea" cols="20" rows="7">
				<?php if (isset($_POST["to_text"])) {echo bin2text($_POST["bin"]);} ?>
			</textarea><br>
			<input type="submit" name="to_bin" id="to_bin_input" value="binary">
			<br><br><br>
			
			<h4>--Bin--</h4>
			<textarea name="bin" id="textarea" cols="20" rows="7">
				<?php if (isset($_POST["to_bin"])){echo text2bin($_POST["text"]);} ?>
			</textarea><br>
			<input type="submit" name="to_text" id="to_text_input" value="text"><br>
		</form>
	</div>
	</body>
</html>

<?
//tekerleği yeniden icat etmeden(decbin, bindec) yapılan program.


function bin2text($bin)  //to_text
{ 
    $text = "";
    $bin = trim($bin);
    $sayi_dizisi = explode("\n", chunk_split(str_replace("\n", "", $bin), 8));  //  \n karakterinden kurtulduk ve 8'li parçalara böldük.
    $x = count($sayi_dizisi) - 1; 
    for($i = 0; $i < $x; $i++)
    {
		$text .= chr(bindec($sayi_dizisi[$i]));
	}
    return $text;
}

function text2bin($text)  //to_bin
{ 
    $len = strlen(trim($text));  //text'in sağındaki ve solundaki boşuklardan kurtulduk ve uzunluğunu bulduk.
    $bin = ""; 
    for($i = 0; $i < $len; $i++) 
    { 
        $bin .= strlen(decbin(ord($text[$i]))) < 8 ? str_pad(decbin(ord($text[$i])), 8, 0, STR_PAD_LEFT) : decbin(ord($text[$i]));  //str_pad fonkriyonu ile her karakter 8 basamaklı binary sistemine dönüştürülür. STR_PAD_LEFT parametresi ile 0 ları var olan binary sayınının soluna ekledik.
    } 
    return $bin;
}
?>
