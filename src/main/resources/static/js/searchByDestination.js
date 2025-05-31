document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("searchForm");
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        const destination = document.getElementById("destinationInput").value;

        fetch(`/trains/destination/result?destination=${encodeURIComponent(destination)}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Server error: " + response.status);
                }
                return response.text(); // ✅ Отримуємо HTML, а не JSON
            })
            .then(html => {
                document.getElementById("result").innerHTML = html; // ✅ Вставляємо HTML-фрагмент з таблицею
            })
            .catch(error => {
                document.getElementById("result").textContent = "Помилка: " + error.message;
            });
    });
});
