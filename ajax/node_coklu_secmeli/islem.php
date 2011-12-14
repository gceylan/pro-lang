<?php
$answers = Array( check1 => "check1 seçildi.",
				  check2 => "check2 seçildi.",
				  check3 => "How did you know? ı' ve had a headache at the side of my head over the last few days.",
				  check4 => "check4 seçildi.",
				  check5 => "check5 seçildi.",
				  check6 => "What in the world is that? It sounds awful.",
				  check7 => "check7 seçildi."
				  );
				  
$checkbox_name = $_GET['check_name'];

echo $answers[$checkbox_name];
?>
