(function () {
  function isValidEmail(v) {
    return /^\S+@\S+\.\S+$/.test(v);
  }

  const loginForm = document.getElementById("loginForm");
  loginForm.addEventListener("submit", (e) => {
    const email = document.getElementById("loginEmail");
    const pass = document.getElementById("loginPassword");
    const emailErr = document.getElementById("loginEmailErr");
    const passErr = document.getElementById("loginPassErr");

    email.classList.remove("error");
    pass.classList.remove("error");
    emailErr.style.display = "none";
    passErr.style.display = "none";

    let ok = true;
    if (!isValidEmail(email.value.trim())) {
      ok = false;
      email.classList.add("error");
      emailErr.style.display = "block";
    }
    if (pass.value.length < 6) {
      ok = false;
      pass.classList.add("error");
      passErr.style.display = "block";
    }

    if (!ok) {
      e.preventDefault();
    }

  });
})();
