#!/usr/bin/perl
#encoding: utf-8

# girilen cümledeki kelime sayısını bulan program
sub main()
{
	print("Bir cümle giriniz: ");
	$cumle = <STDIN>;
	chop($cumle);
	
	& kelime_say($cumle);
}



# Diger dillerde metod, fonsiyon ya da prosedür olarak tanidigimiz
# kod birimleri Perl dilinde subrutin olarak isimlendirilir.

sub kelime_say()
{
	# @_ degiskeni Perl derleyicisi tarafindan rezerve edilmis ve
	# gönderilen parametreleri ihtiva eden liste tipinde bir degiskendir.
	local($cumle) = @_;
	
	@kelimeler = split(" ", $cumle);
	
	foreach $kelime (@kelimeler)
	{
		$HASH{$kelime}++;
	}
	
	foreach $anahtar (sort keys %HASH)
	{
		print $anahtar, " -> $HASH{$anahtar}", "\n";
	}
}

# & kelime_say("merhaba ben gökhan");
& main();