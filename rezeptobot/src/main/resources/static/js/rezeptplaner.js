$( document ).ready(function() {
    $('#calendar').fullCalendar({
        events: null,
        header: {
            left: 'prev,next today',
            center: 'custom1',
            right: 'title'
        },
        firstDay: 1,
        height: 700,
        eventClick: function(info) {
            //onEventGeklickt(info);
        },
        customButtons: {
            custom1: {
                text: 'Alternatives Gericht hinzufügen',
                click: function () {
                    $("#exampleModal").modal()
                }
            }
        },
    });
});
