$(function() {
    console.log( "ready!" );
    $("#cResult").hide();

    let postJSON = function(url, data, callback) {
        return jQuery.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'url': url,
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success': callback
        });
    };

    $("#cSubmit").on("click", function() {
        let fName = $("#cFirstName").val();
        let lName =  $("#cLastName").val();

        if(fName === ""|| lName === "") {
            alert("Empty Parameters");
            return;
        }

        postJSON(
            "/create",
            {"firstName": fName, "lastName": lName},
            function (data, status) {
                $("#cResult").show();
                $("#cIdRes").val(data.id);
                $("#cFirstNameRes").val(data.firstName);
                $("#cLastNameRes").val(data.lastName);
                alert("Status: " + status);
                console.info(data);
            });
    });
});
