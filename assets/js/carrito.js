function updateQty(btn, change) {
  const qtyInput = btn.parentElement.querySelector("input");
  let qty = parseInt(qtyInput.value);
  qty = Math.max(1, qty + change);
  qtyInput.value = qty;

  updateTotal();
}

function updateTotal() {
  const items = document.querySelectorAll(".item");
  let total = 0;
  items.forEach((item) => {
    const price = parseInt(item.dataset.price);
    const qty = parseInt(item.querySelector("input").value);
    total += price * qty;
  });
  document.getElementById(
    "productTotal"
  ).textContent = `$${total.toLocaleString("es-CL")}`;
  document.getElementById("finalTotal").textContent = `$${total.toLocaleString(
    "es-CL"
  )}`;
}

document.addEventListener("DOMContentLoaded", updateTotal);
