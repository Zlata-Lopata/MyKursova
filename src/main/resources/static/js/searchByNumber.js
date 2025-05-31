document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("searchForm");
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        const trainNumber = document.getElementById("trainNumberInput").value;

        fetch(`/trains/number/result?trainNumber=${encodeURIComponent(trainNumber)}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Server error: " + response.status);
                }
                return response.text();
            })
            .then(html => {
                document.getElementById("result").innerHTML = html;
            })
            .catch(error => {
                document.getElementById("result").textContent = "Помилка: " + error.message;
            });
    });
});
