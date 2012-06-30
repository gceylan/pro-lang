var nesne;
if (navigator.appName.search("Microsof") > -1) {
	nesne = new ActiveXObject("MSXML2.XMLHTTP");
} else {
	nesne = new XMLHttpRequest();
}

function yolla() {
	nesne.open('get', 'login.php?username=' +
			document.form.username.value +
			'&password=' +
			document.form.password.value, true);
	nesne.onreadystatechange = handleResponse;
	nesne.send(null);
}

function handleResponse() {
	if (nesne.readyState == 4) {
		document.getElementById('sonuc').innerHTML = nesne.responseText;
	}
}
