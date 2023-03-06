function checkRegistration() {
	var validationSuccessful = true,
		mail = document.getElementById('mail').value;
		pw1 = document.getElementById('passwort').value;
		pw2 = document.getElementById('passwortWiederholen').value;

	if (!validateEmail(mail)) {
		validationSuccessful = false;
		document.getElementById("emailFailure").innerHTML = "Bitte geben Sie eine valide E-Mail Adresse ein."; 
        document.getElementById("emailFailure").style.display = "inline";   
	} else {
		document.getElementById("emailFailure").style.display = "none";
	}
	
	if (pw1 === '') {
		validationSuccessful = false;
		document.getElementById("pw1Failure").innerHTML = "Bitte geben Sie ein Passwort ein."; 
        document.getElementById("pw1Failure").style.display = "inline";
	} else {
		document.getElementById("pw1Failure").style.display = "none";
	}
	
	if (pw1 !== pw2) {
		validationSuccessful = false;
		document.getElementById("pw2Failure").innerHTML = "Die Passwörter stimmen nicht überein."; 
        document.getElementById("pw2Failure").style.display = "inline"; 
	} else {
		document.getElementById("pw2Failure").style.display = "none";
	}

	if (validationSuccessful) {
		document.getElementById('myform').submit();
	}
}

function validateEmail(email) {
	var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	return re.test(email);
}