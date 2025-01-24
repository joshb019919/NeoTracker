<%@ include file="templates/base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="templates/head.jsp" %>
</head>
<body style="background-color:#fafafa;">
<div class="container">
    <%@ include file="templates/navbar.jsp" %>
    <%@ include file="templates/form.jsp" %>
    <%@ include file="templates/table.jsp" %>
    <%@ include file="templates/footer.jsp" %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    const obj = {};
    let button, start, end, table, tr, td;
    window.addEventListener("DOMContentLoaded", () => {

        button = document.querySelector("#submit");
        start = document.getElementById("start-date");
        end = document.querySelector("#end-date");
        table = document.querySelector("table");

        button.addEventListener("click", (e) => {
            e.preventDefault();
            obj.start = start.value;
            obj.end = end.value;

            fetch("${pageContext.request.contextPath}/nearEarthObject", {
                method: "POST",
                body: JSON.stringify(obj),
                headers: {"Content-Type": "application/json"}
            }).then(function (httpservletresponse) {
                if (httpservletresponse.ok) {
                    return httpservletresponse.json();
                } else {
                    console.log("From Fetch: " + httpservletresponse.status);
                }
            }).then(function (objects) {
                console.log(objects);
                let row;
                let cell0;
                let cell1;
                let cell2;
                let cell3;
                let cell4;
                let cell5;
                let cell6;
                let cell7;
                let cell8;
                let cell9;
                let cell10;
                let cell11;
                for (const i in objects) {
                    console.log(objects[i]);
                    console.log(typeof(objects[i]["closeApproachDate"]));
                    row = table.insertRow();
                    cell0 = row.insertCell(0);
                    cell1 = row.insertCell(1);
                    cell2 = row.insertCell(2);
                    cell3 = row.insertCell(3);
                    cell4 = row.insertCell(4);
                    cell5 = row.insertCell(5);
                    cell6 = row.insertCell(6);
                    cell7 = row.insertCell(7);
                    cell8 = row.insertCell(8);
                    cell9 = row.insertCell(9);
                    cell10 = row.insertCell(10);

                    cell0.textContent = objects[i]["id"];
                    cell1.textContent = objects[i]["name"];
                    cell2.textContent = Math.round(objects[i]["kiloDiamMax"] * 1000) / 1000;
                    cell3.textContent = Math.round(objects[i]["feetDiamMax"] * 1000) / 1000;
                    cell4.textContent = objects[i]["isHazard"];
                    cell5.textContent = objects[i]["closeApproachDate"].substring(0,10);
                    cell6.textContent = Math.round(objects[i]["kilometersPerSecond"] * 1000) / 1000;
                    cell7.textContent = Math.round(objects[i]["milesPerHour"]).toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
                    cell8.textContent = Math.round(objects[i]["milesMissDist"]).toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
                    cell9.textContent = objects[i]["orbiting"];
                    cell10.textContent = objects[i]["isSentry"];
                }
            }).catch((e) => {
                console.log("Fetch Error: " + e);
            });
        });
    });
</script>
</body>
</html>