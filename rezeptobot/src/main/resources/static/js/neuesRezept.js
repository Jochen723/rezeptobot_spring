function addNewIngredient() {
    var nodeAvailable = true,
        zaehler = 1,
        node = document.getElementById("zutatenrow_1"),
        clonedNode = node.cloneNode(true);

    do {
        nodeAvailable =
            document.getElementById("zutatenrow" + "_" + zaehler) != null;
        if (nodeAvailable) {
            zaehler = zaehler + 1;
        }
    } while (nodeAvailable);

    clonedNode.setAttribute("id", "zutatenrow_" + zaehler);
    clonedNode.querySelector("#anzahlSelect1").name =
        "rezeptzutaten[" + (zaehler - 1) + "].anzahl";

    clonedNode.querySelector("#einheitSelect1").name =
        "rezeptzutaten[" + (zaehler - 1) + "].einheit";
    clonedNode.querySelector("#zutatSelect1").name =
        "rezeptzutaten[" + (zaehler - 1) + "].bezeichnung";

    clonedNode.querySelector("#minusbtn1").id = "minusbtn" + zaehler;

    document.getElementById("zutatenreihe").appendChild(clonedNode);
}

function removeNewIngredient(clicked_id) {
    var nodeAvailable = true,
        zaehler = Number(clicked_id.substr(clicked_id.length - 1));

    if (zaehler > 1) {
        document.getElementById("zutatenrow" + "_" + zaehler).remove();

        do {
            nodeAvailable =
                document.getElementById("zutatenrow" + "_" + (zaehler + 1)) !=
                null;
            if (nodeAvailable) {
                document
                    .getElementById("zutatenrow" + "_" + (zaehler + 1))
                    .querySelector("#anzahlSelect1").name =
                    "rezeptzutaten[" + (zaehler - 1) + "].anzahl";
                document
                    .getElementById("zutatenrow" + "_" + (zaehler + 1))
                    .querySelector("#einheitSelect1").name =
                    "rezeptzutaten[" + (zaehler - 1) + "].einheit";
                document
                    .getElementById("zutatenrow" + "_" + (zaehler + 1))
                    .querySelector("#zutatSelect1").name =
                    "rezeptzutaten[" + (zaehler - 1) + "].bezeichnung";

                document
                    .getElementById("zutatenrow" + "_" + (zaehler + 1))
                    .querySelector("#minusbtn" + (zaehler + 1)).id =
                    "minusbtn" + zaehler;

                document.getElementById("zutatenrow" + "_" + (zaehler + 1)).id =
                    "zutatenrow" + "_" + zaehler;

                zaehler = zaehler + 1;
            }
        } while (nodeAvailable);
    }
}
