$(document).ready(function(){

    var dt = $('#myOrderTable').DataTable({
        "ajax": "http://localhost:8087/",
        "serverSide": true,
        "dom": '<"toolbar">frtip',
        "columns": [
            { "data": "id" },
            { "data": "name" },
            { "data": "nuberCar" },
            { "data": "tenant" },
            { "data": "pointofsale" },
            { "data": "amount" },
            { "data": "rentalDateOn" },
            { "data": "rentalDateOff" },
            { "data": "buttons" }
        ]
    });

    //Загрузка авто
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/cars/all',
        success: function(data){
            console.log(data);
            $(".ibc-select-avto").empty();
            data.forEach(function(item, i, data) {
                $(".ibc-select-avto").append( '<option value="'+item.id+'" ibc-mark="'+item.mark+'" ibc-number="'+item.numberCar+'">'+item.name+'</option>' );
            });
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr);
            console.log(thrownError);
        }
    });

    //Загрузка арендаторов
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/tenants/all',
        success: function(data){
            console.log(data);
            $(".ibc-select-tanents").empty();
            data.forEach(function(item, i, data) {
                $(".ibc-select-tanents").append( '<option value="'+item.id+'">'+item.name+'</option>' );
            });
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr);
            console.log(thrownError);
        }
    });

    //Загрузка магазинов
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/pointofsale/all',
        success: function(data){
            console.log(data);
            $(".ibc-select-pointofsale").empty();
            data.forEach(function(item, i, data) {
                $(".ibc-select-pointofsale").append( '<option value="'+item.id+'">'+item.name+'</option>' );
            });
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr);
            console.log(thrownError);
        }
    });

    $('#rental_Date_On').datepicker();

    $('#rental_Date_Off').datepicker();

    $("div.toolbar").html("<a role='button' class='ibcbtn-create btn btn-success' data-target='#newModal'>Добавить новый заказ</a>");

    $("body").on("click", ".ibcbtn-edit", function (e) {
        e.preventDefault();

        $('.ibc-hidden-id').val($(this).attr("rowid"));
        $('#editModal').modal('show');
    });

    $("body").on("click", ".ibcbtn-update-order", function (e) {

        let id_order = $('.ibc-hidden-id').val();

        let id_car = $('.ibc-select-avto').val();
        let mark_car = $(".ibc-select-avto option:selected").attr('ibc-mark');
        let name_car = $(".ibc-select-avto option:selected").html();
        let number_car = $(".ibc-select-avto option:selected").attr('ibc-number');

        let id_pointofsale = $('.ibc-select-pointofsale').val();
        let name_pointofsale = $('.ibc-select-pointofsale option:selected').html();

        let id_tenant = $('.ibc-select-tanents').val();
        let name_tenant = $('.ibc-select-tanents option:selected').html();

        let date_on =$(".ibc_rental_Date_On").val().replace(/\//g, "-")+'T00:00:00.000+0000';
        let date_off =$(".ibc_rental_Date_Off").val().replace(/\//g, "-")+'T00:00:00.000+0000';
        let amount = $("#ibc_amount").val();
        var JSONObject= {
            "id": $('.ibc-hidden-id').val(),
            "car":{"id":Number(id_car),"name":name_car,"mark":mark_car,"numberCar":number_car},
            "pointofsale":{"id":Number(id_pointofsale),"name":name_pointofsale},
            "tenant":{"id":Number(id_tenant),"name":name_tenant},
            "rentalDateOn":date_on,
            "rentalDateOff":date_off,
            "amount":amount};

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8087/editOrder/'+id_order,
            headers: { 'Content-Type': 'application/json' },
            dataType: 'json',
            data:  JSON.stringify(JSONObject),
            success: function(data){

            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr);
                console.log(thrownError);
            }
        });
        $('#editModal').modal('hide');
    });

    $("body").on("click", ".ibcbtn-delete", function (e) {
        e.preventDefault();

        let url =  'http://localhost:8087/deleteOrder/'+$(this).attr("rowid");
        $.ajax({
            type: 'GET',
            url: url,
            success: function(data){
                if(data == 'Удалено'){

                    $('#deleteModal').modal('show');

                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr);
                console.log(thrownError);
            }
        });

    });

    $("body").on("click", ".ibcbtn-create", function (e) {
        e.preventDefault();
        $('#createModal').modal('show');

    });

    $("body").on("click", ".ibcbtn-create-order", function (e) {
        e.preventDefault();

        let id_car = $('.ibc-create-select-avto').val();
        let mark_car = $(".ibc-create-select-avto option:selected").attr('ibc-mark');
        let name_car = $(".ibc-create-select-avto option:selected").html();
        let number_car = $(".ibc-create-select-avto option:selected").attr('ibc-number');

        let id_pointofsale = $('.ibc-create-select-pointofsale').val();
        let name_pointofsale = $('.ibc-create-select-pointofsale option:selected').html();

        let id_tenant = $('.ibc-create-select-tanents').val();
        let name_tenant = $('.ibc-create-select-tanents option:selected').html();

        let date_on =$(".ibc_create_rental_Date_On").val().replace(/\//g, "-")+'T00:00:00.000+0000';
        let date_off =$(".ibc_create_rental_Date_Off").val().replace(/\//g, "-")+'T00:00:00.000+0000';
        let amount = $("#ibc_create_amount").val();
        var JSONObject= {
            "car":{"id":Number(id_car),"name":name_car,"mark":mark_car,"numberCar":number_car},
            "pointofsale":{"id":Number(id_pointofsale),"name":name_pointofsale},
            "tenant":{"id":Number(id_tenant),"name":name_tenant},
            "createdAt": Date_toYMD(),
            "rentalDateOn":date_on,
            "rentalDateOff":date_off,
            "amount":amount};

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8087/createOrder/',
            headers: { 'Content-Type': 'application/json' },
            dataType: 'json',
            data:  JSON.stringify(JSONObject),
            success: function(data){

            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr);
                console.log(thrownError);
            }
        });

        $('#createModal').modal('hide');

    });

});

setInterval( function () {
    console.log('reload');
    $('#myOrderTable').DataTable().ajax.reload(null, false);
}, 5000  );

function Date_toYMD() {
    var year, month, day;
    year = String(this.getFullYear());
    month = String(this.getMonth() + 1);
    if (month.length == 1) {
        month = "0" + month;
    }
    day = String(this.getDate());
    if (day.length == 1) {
        day = "0" + day;
    }
    return month + "-" + day + "-" + year+'T00:00:00.000+0000';
}