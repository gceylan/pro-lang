<?php
$sayi = $_POST["sayi"];
if (isset($_POST["to_bin"])){
        $bin_sayi = array();
        $sayi = str_split(strrev($sayi));  //sayıyı ters çevirdik ve rakam rakam ayırdık.
        foreach ($sayi as $i){
                if ($i >= 8){
                        echo "8' lik sayı sisteminde sayı giriniz.";
                        break;
                }
                else {
                        foreach (range(0, 2) as $j){
                                $x = $i % 2;
                                $bin_sayi[] = $x;
                                $i = $i / 2;
                        }
                }
        }
        echo strrev(implode($bin_sayi));  // bu işlem diziyi metine çevirir.
}



?>

