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

                    render: function (data, type, full, meta) {

                        const test = JSON.stringify(full);
                        var buttons = `<a type="button"  
                        class="btn action-button"
                        style=" text-align:center; margin-right: 8px;" onclick='UpdateCar(${test})'>
                        <i class="fa-solid fa-gear fa-sm" style=" text-align:center;"></i></a>
 
    
                        <a type="button" 
                        class="btn action-button delete-button" style="text-align:center;" onclick='deleteCarByID(${test})'>
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
                {
                    targets: [4],
                    render: 
                    $.fn.dataTable.render.number( '.', ',', 2,""," TL" )
                    


                }

            ]

        })
    })


});

function UpdateCar(car) {
    $("#modalTitle").text(car.brand + " " + car.model);
    $("#Brand").val(car.brandID);
    $("#Model").val(car.model);
    $("#Color").val(car.colorID);
    $("#Price").val(car.price);
    $("#GearType").val(car.gearType);
    $("#FuelType").val(car.fuelType);
    $("#ReleaseDate").val(car.releaseDate);
    if (car.isRefurbished == false) {
        document.getElementById("IsRefurbishedNo").checked = true;
    } else if (car.isRefurbished == true) {
        document.getElementById("IsRefurbishedYes").checked = true;
    }
    document.getElementById("Brand").disabled = false;
    document.getElementById("Model").disabled = false;
    document.getElementById("Color").disabled = false;
    document.getElementById("Price").disabled = false;
    document.getElementById("GearType").disabled = false;
    document.getElementById("FuelType").disabled = false;
    document.getElementById("ReleaseDate").disabled = false;
    document.getElementById("IsRefurbishedNo").disabled = false;
    document.getElementById("IsRefurbishedYes").disabled = false;
    document.getElementById("save-button").style.visibility = 'visible';
    //document.getElementById("save-button").addEventListener('click', save, false);
    $('#MdlCar').modal();

    $('#update-form').on('submit', function (event) {
        var result = confirm("Want to Save?");
        var self = this;
        var form = $(this);
        var errorMsg = $('#errorMsg');

        var formData = form.serializeArray();
        formData.push({ name: 'id', value: car.carID });
        console.log(formData);

        if (form.data('requestRunning')) {
            return;
        }

        form.data('requestRunning', true);
        event.preventDefault();

        if (result) {
            $.ajax({
                url: form.attr("action"),
                type: form.attr("method"),
                data: formData,

                success: function (result) {

                    console.log("ajax working");
                    window.location.reload();

                },
                complete: function (e) {
                    form.data('requestRunning', false);
                }

            });
        } else {
            return;
        }

    });
}

// function save() {
//     $('#update-form').on('submit', function (event) {

//         console.log(form.serialize());
//         var self = this;
//         var form = $(this);
//         var errorMsg = $('#errorMsg');

//         if (form.data('requestRunning')) {
//             return;
//         }

//         form.data('requestRunning', true);
//         event.preventDefault();

//         $.ajax({
//             url: form.attr("action"),
//             type: form.attr("method"),
//             data: form.serialize(),
//             success: function (result) {

//                 console.log("ajax working");

//             },
//             complete: function (e) {
//                 form.data('requestRunning', false);
//             }

//         });
//         clear();
//     });

//     $('#MdlCar').modal();
// }
function GetCarDetail(car) {
    $("#modalTitle").text(car.brand + " " + car.model);
    $("#Brand").val(car.brandID);
    $("#Model").val(car.model);
    $("#Color").val(car.colorID);
    $("#Price").val(car.formattedPrice);
    $("#GearType").val(car.gearType);
    $("#FuelType").val(car.fuelType);
    $("#ReleaseDate").val(car.releaseDate);
    document.getElementById("Brand").disabled = true;
    document.getElementById("Model").disabled = true;
    document.getElementById("Color").disabled = true;
    document.getElementById("Price").disabled = true;
    document.getElementById("GearType").disabled = true;
    document.getElementById("FuelType").disabled = true;
    document.getElementById("ReleaseDate").disabled = true;
    document.getElementById("IsRefurbishedNo").disabled = true;
    document.getElementById("IsRefurbishedYes").disabled = true;
    document.getElementById("save-button").style.visibility = 'hidden';
    //$("#IsRefurbished").val(car.isRefurbished);
    // if (car.gearType == "M") {
    //     $("#GearType").val("Manuel");
    // } else if (car.gearType == "O") {
    //     $("#GearType").val("Otomatic");
    // }
    // if (car.fuelType == "H") {
    //     $("#FuelType").val("Hybrid");
    // } else if (car.fuelType == "D") {
    //     $("#FuelType").val("Diesel");
    // } else if (car.fuelType == "F") {
    //     $("#FuelType").val("Fuel");
    // } else if (car.fuelType == "E") {
    //     $("#FuelType").val("Electric");
    // }
    //$("#ReleaseDate").val(car.formattedReleaseDate);
    if (car.isRefurbished == false) {
        document.getElementById("IsRefurbishedNo").checked = true;
        //$("#IsRefurbishedNo").checked = true;
    } else if (car.isRefurbished == true) {
        document.getElementById("IsRefurbishedYes").checked = true;
        //$("#IsRefurbishedYes").checked = true;
    }
    //$("#brand").val(car.find(x => x.carID == 65).brand);

    $('#MdlCar').modal();
}

function deleteCarByID(data) {

    var result = confirm("Want to Delete "+ data.brand+" " + data.model +" ?");
    if (result) {

        console.log(data)
        $.ajax({
            url: "/CarsDelete",
            method: "POST",
            data: data
        }).done(function (data) {
            console.log("ajax working");
            console.log(data);
            window.location.reload();
        });
    } else {
        return;
    }


}

window.onscroll = function () {scrollFunction();};

function scrollFunction() {
if (document.body.scrollTop > 10 || document.documentElement.scrollTop > 10) {

document.getElementById("navbar").style.background = "#501e27";
} else {

document.getElementById("navbar").style.background = "none";
}
}