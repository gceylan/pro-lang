<head>
<title>checkbox</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script language="JavaScript">

     function updateTextArea() {
         var items_array = [];
         $('#cbox :checked').each(function() {
			 if ($(this).attr('checked', true)) {
				 $(this).attr('disabled', true);
			 }
			 var item = $(this).attr('value');
			 var item2 = $(this).attr('name');
			 items_array.push(item2);	//push id or name
             items_array.push(item);	//push value
         });
         $('#t').val(items_array)
      }
     $(function() {
       $('#cbox input').click(updateTextArea);
       updateTextArea();
     });

</script>

</head>
<body>
  <div id="cbox">
   <input type="checkbox" name="p.h.p" value="php">  PHP <br>
   <input type="checkbox" name="h.t.m.l" value="html"> HTML<br>
   <input type="checkbox" name="c.s.s" value="css" >  CSS <br>
   <input type="checkbox" name="j.s" value="js" >  JS <br>
   <input type="checkbox" name="m.y.s.q.l" value="mysql" >  MYSQL <br>
   <input type="checkbox" name="a.j.a.x" value="ajax" >  AJAX <br>
   <input type="checkbox" name="c.s" value="cs" >  COFFE SCRIPT <br>
  </div>
  <textarea id="t"></textarea><br>
  <div id="result"></div>
</body>
</html>
