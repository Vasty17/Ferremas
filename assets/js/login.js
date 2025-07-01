$(".message a").click(function () {
  $("form").animate({ height: "toggle", opacity: "toggle" }, "slow");
});

document.getElementById("btnLogin").addEventListener("click", function (event) {
  event.preventDefault();

  const usuario = document.getElementById("username").value;
  const clave = document.getElementById("password").value;
  const mensaje = document.getElementById("mensaje");

  if (usuario === "admin" && clave === "1234") {
    mensaje.style.color = "green";
    mensaje.textContent = "Bienvenido!!";

    setTimeout(() => {
      window.location.href = "index.html";
    }, 3000);
  } else {
    mensaje.style.color = "red";
    mensaje.textContent = "Usuario o contraseña incorrectos";
  }
});
