function getCar(car) {
    console.log(car);
    $("#modalTitle").text(car.brand + " " + car.model);
    $("#brand").val(car.brand);
    $("#model").val(car.model);
    $("#color").val(car.color);
    $("#price").val(car.formattedPrice);
    if (car.gearType == "M") {
        $("#gearType").val("Manuel");
    } else if (car.gearType == "O") {
        $("#gearType").val("Otomatic");
    }
    if (car.fuelType == "H") {
        $("#fuelType").val("Hybrid");
    } else if (car.fuelType == "D") {
        $("#fuelType").val("Diesel");
    } else if (car.fuelType == "F") {
        $("#fuelType").val("Fuel");
    } else if (car.fuelType == "E") {
        $("#fuelType").val("Electric");
    }
    $("#releaseDate").val(car.formattedReleaseDate);
    if (car.isRefurbished == false) {
        $("#isRefurbished").val("No");
    } else if (car.isRefurbished == true) {
        $("#isRefurbished").val("Yes");
    }
    //$("#brand").val(car.find(x => x.carID == 65).brand);

    $('#MdlCar').modal();
}
;
$('#filter-form').on('submit', function (event) {


    console.log(form.serialize());
    var self = this;
    var form = $(this);
    var errorMsg = $('#errorMsg');


    if (form.data('requestRunning')) {
        return;
    }

    form.data('requestRunning', true);
    event.preventDefault();

    $.ajax({
        url: form.attr("action"),
        type: form.attr("method"),
        data: form.serialize(),
        success: function (result) {

            console.log("ajax working");

        },
        complete: function (e) {
            form.data('requestRunning', false);
        }

    });
    clear();
});

$(document).ready(function () {

    // $.ajaxSetup({ cache: false });
    $.ajax({
        url: "/CarsData",
        method: "GET",
        contentType: 'application/json',
        dataType: 'json'
    }).done(function (data) {
        console.log("ajax working");
        console.log(data);
        $('#carTable').dataTable({
            searching: false,
            pageLength: 25,
            "data": data,
            "columns": [
                { data: "carID" },
                { data: "brand" },
                { data: "model" },
                { data: "color" },
                { data: "price" },
                { data: "releaseDate" },
                { data: "carID" },
            ],

            columnDefs: [

                {
                    targets: 0,
                    render: function (data, type, full, meta) {
                        const test = JSON.stringify(full);
                        
                        var buttons = `
                        <a type="button" onclick='GetCarDetail(${test})' class="view-button"><i
                        class="fa-solid fa-lg fa-circle-chevron-right"></i>
                        `
                        return buttons;
                    }
                },
                {
                    targets: -1,

                    render: function (data,type,meta,full) {
                        
                       
                        var buttons = `<a type="button" th:href="@{/Cars/update/{id}(id=${data.carID})}" class="btn action-button"
                        style=" text-align:center; margin-right: 8px;" onclick="UpdateCar();">
                        <i class="fa-solid fa-gear fa-sm" style=" text-align:center;"></i></a>
 
    
                        <a type="button" th:href="@{/Cars/{id}(id=${data.carID})}"
                        class="btn action-button delete-button" style="text-align:center;" onclick='deleteCarByID(${full.carID})'
                        th:data-confirm-delete="|Are you sure you want to delete ${data.brand} ${data.model}?|"
                        onclick="if (!confirm(this.getAttribute('data-confirm-delete'))) return false">
                        <i class="fa-solid fa-trash-can fa-sm" style=" text-align:center;"></i></a>
    `;
                        return buttons;
                    }
                },
                {
                    targets: [5],
                    render: function (data, type, full, meta) {
                        if (data != null) {
                            var date = new Date(data);
                            return date.toLocaleDateString();
                        }
                        return "";
                    }
                },

            ]

        })
    })


});

function UpdateCar() {
    $('#MdlUpdate').modal();
}

function GetCarDetail(car) {
    $("#modalTitle").text(car.brand + " " + car.model);
    $("#brand").val(car.brand);
    $("#model").val(car.model);
    $("#color").val(car.color);
    $("#price").val(car.formattedPrice);
    if (car.gearType == "M") {
        $("#gearType").val("Manuel");
    } else if (car.gearType == "O") {
        $("#gearType").val("Otomatic");
    }
    if (car.fuelType == "H") {
        $("#fuelType").val("Hybrid");
    } else if (car.fuelType == "D") {
        $("#fuelType").val("Diesel");
    } else if (car.fuelType == "F") {
        $("#fuelType").val("Fuel");
    } else if (car.fuelType == "E") {
        $("#fuelType").val("Electric");
    }
    $("#releaseDate").val(car.formattedReleaseDate);
    if (car.isRefurbished == false) {
        $("#isRefurbished").val("No");
    } else if (car.isRefurbished == true) {
        $("#isRefurbished").val("Yes");
    }
    //$("#brand").val(car.find(x => x.carID == 65).brand);

    $('#MdlCar').modal();
}

function deleteCarByID(data) {
console.log(data)
    $.ajax({
        url: "/CarsDelete",
        method: "POST",
        data: data
    }).done(function (data) {
        console.log("ajax working");
        console.log(data);

    });


}

