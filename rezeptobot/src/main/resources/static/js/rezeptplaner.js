$(document).ready(function () {
    var eventRequestUrl = window.location.origin + '/getJsonEvents';

    registriereAuswahlboxAlternativesGericht();

    $("#calendar").fullCalendar({
        locale: "de",
        events: function (start, end, timezone, callback) {
            $.ajax({
                url: eventRequestUrl,
                //data: {
                // data if you are passing
                //},
                success: function (data) {
                    var events = [];

                    data.forEach(function (event) {
                        events.push({
                            id: event.id,
                            title: event.title,
                            start: event.start,
                            allDay: true,
                            backgroundColor: event.hintergrundfarbe
                        });
                    });

                    callback(events);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus + " - " + errorThrown);
                },
            });
        },

        header: {
            left: "prev,next today",
            center: "custom1",
            right: "title",
        },
        firstDay: 1,
        height: 700,
        eventClick: function (info) {
            //onEventGeklickt(info);
        },
        customButtons: {
            custom1: {
                text: "Alternatives Gericht hinzufügen",
                click: function () {
                    $("#exampleModal").modal();
                },
            },
        },
    });

    function registriereAuswahlboxAlternativesGericht() {
        $("#exampleModal").on("shown.bs.modal", function () {
            zeigeEingabefeldAlternativesGericht();
        });
    }

    function zeigeEingabefeldAlternativesGericht() {
        var elem = document.getElementById("selectArt");
        elem.addEventListener("change", function () {
            if (document.getElementById("selectArt").value == "son") {
                document.getElementById('test1').hidden = false;
            } else {
                document.getElementById('test1').hidden = true;
            }
        });
    }
});
