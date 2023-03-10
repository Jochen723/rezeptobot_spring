$( document ).ready(function() {
    $('#calendar').fullCalendar({
        locale: 'de',
        events: function(start, end, timezone, callback) {
            $.ajax({
                url: 'http://localhost:8080/getJsonEvents',
                //data: {
                    // data if you are passing
                //},
                success: function(data) {
                    var events = [];
                    
                    data.forEach(function(event) {
                        events.push({
                            id: event.id,
                            title: event.title,
                            start: event.start,
                            allDay: true,
                            backgroundColor: '#00cc99',
                            //url: 'http://www.google.de'
                        });
                    });

                    callback(events);
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log( textStatus +" - "+ errorThrown );
                }
            });
        },
        
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
