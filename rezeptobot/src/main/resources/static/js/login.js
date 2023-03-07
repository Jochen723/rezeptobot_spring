function checkLogin() {
  var validationSuccessful = true,
        mail = document.getElementById("mail").value;

  if (!validateEmail(mail)) {
    validationSuccessful = false;
    document.getElementById("emailFailure").innerHTML =
      "Bitte geben Sie eine valide E-Mail Adresse ein.";
    document.getElementById("emailFailure").style.display = "inline";
  } else {
    document.getElementById("emailFailure").style.display = "none";
  }
}

function validateEmail(email) {
  var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  return re.test(email);
}
});
