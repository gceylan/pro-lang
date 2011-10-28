<html>
<head>
</head>
<style>
html { background-color: #656565;}
body {margin:auto; width:400; height:400; margin-top:30px; background-color:grey; padding:20px}
</style>
  <title>Asal Sayı mı?</title>
  <?php
  echo "Sizce 727271 sayısı asal sayı mıdır? Merak mı ettiniz?<br>";
  echo "Aşağıdaki kutucuğa sayıyı yazıp asal olup olmadığını öğrenebilirsin:<br>";
  ?>
  <form action="" method="post">
    <p>sayı:<input type="text" name="sayi"</p>
    <p><input type="submit" name="dugme" value="Test et"</p><br>
  </form>


<?php
  $sayi = $_POST["sayi"];
  if ($sayi > 1){
    if (strlen($sayi) > 6){
      echo "En fazla 6 basamaklı sayı giriniz...";
    }
    elseif ($sayi == 2){
      echo $sayi." <b>Asal sayıdır.</b>";
    }
    elseif ($sayi % 2 == 0){
      echo $sayi." <b>Asal sayı değildir.<br></b>Açıklama: Çift sayı olup asal sayı olan tek sayı 2' dir.";
    }
    else{
      while (True){
        $sonuc = array();
        $bolenler = array();
        foreach (range(3, $sayi - 1, 2) as $i){
          if ($sayi % $i == 0){
            $sonuc[] = 0;               // Asal sayı değildir = 0
            $bolenler[] = $i;
          }
          else {
            $sonuc[] = 1;               // Asal sayıdır = 1
          }
        }
        if (in_array(0, $sonuc)){
          echo $sayi." <b>Asal sayı değildir.</b><br>En küçük böleni : $bolenler[0]";
        }
        else{
          echo $sayi." <b>Asal sayıdır.</b>";
        }
        break;
      }
    }

  }
  else{
    echo $sayi." <b>Asal sayı değildir.<br></b>Açıklama: Asal sayılar 2' den başlarlar. Negatif olamazlar.";
  }

?>

</html>
