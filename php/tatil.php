<html>
  <body>
    <form action="" method="post">
      <p>Adınız:<input type="text" name="ad"></p>
      <p>Soyadınız:<input type="text" name="soyad"></p>
      <p><input type="submit" name="dugme" value="Gönder bakiyim..."><br>
    </form>



    <?php
    if (isset($_POST['dugme'])){
      $kullanici_adi = $_POST['ad'];
      $kullanici_soyadi = $_POST['soyad'];
      echo "Merhaba $kullanici_adi $kullanici_soyadi";
    }
    ?>


  </body>
</html>

