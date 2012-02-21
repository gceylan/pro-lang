$(document).ready(function(){
	$('a.soru-penceresi').click(function(){
		
		var pencere = $(this).attr('href');
		$(pencere).fadeIn(400);
		var popMargTop = ($(pencere).height() + 24) / 2;
		var popMargLeft = ($(pencere).width() + 24) / 2;
		$(pencere).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		$('body').append('<div id="maske"></div>');
		$('#maske').fadeIn(400);
		
		return false;
	});
	
	$('a.kapat, #maske').live('click', function(){
		$('#maske, .soru-popup').fadeOut(400, function(){
			$('#maske').remove;
		});
		
		return false;
	});
	
	$('#kaydet').click(function(){
		
		alert('bağlantılar yapılacak');
		
		$('#maske, .soru-popup').fadeOut(400, function(){
			$('#maske').remove;
		});
		
	});
	
});
