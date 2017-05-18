$(document).ready(function (){
    loadData();
});

function insertNasabah(){
    var txtNamaNasabah = $("#nama").val();
    var txtAlamatNasabah = $("#alamat").val();
    var txtTeleponNasabah = $("#notelp").val();
    
    
    $.ajax({
        type: "POST",
        url: "/api/simpan",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        data:JSON.stringify({nama:txtNamaNasabah, alamat:txtAlamatNasabah, notelp:txtTeleponNasabah}),
        success : function(){
            alert("data berhasil disimpan !");
            window.location.href='/nasabah/list';
        }
    });
}

function updateNasabah(){
    var txtNamaNasabah = $("#nama").val();
    var txtAlamatNasabah = $("#alamat").val();
    var txtTeleponNasabah = $("#notelp").val();
    var txtKodeNasabah = $("#idnasabah").val();
    
    $.ajax({
        type: "POST",
        url: "/api/update",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        data:JSON.stringify({nama:txtNamaNasabah, alamat:txtAlamatNasabah, notelp:txtTeleponNasabah, idnasabah:txtKodeNasabah}),
        success : function (){
            window.location.href='/nasabah/list';
        }
    });
}

function hapusNasabah(idnasabah){
    $.ajax({
        
        url: "/api/delete/"+idnasabah,
        type: 'DELETE',
        success: function () {
            alert("data berhasil di hapus !");
            window.location.href='/nasabah/list';
        }
    });
}


function ambilNasabah(idnasabah){
    $.ajax({
        url: "/nasabah/ambil/"+idnasabah, 
        type: 'GET',
        success: function () {
            window.location.href='/nasabah/ambil/'+idnasabah;
        }
    });
}

function loadData(){
    $.ajax({
        type: "GET",
        url: "/api/nasabah",
        success:function(result){
            var resultRow = $.parseJSON(result);
            var list = "";
            var dataHandler = $("#load-nasabah");
            
            for(var  i=0; i<resultRow.length; i++){
                list += "<tr><td>"+resultRow[i].idnasabah+"</td><td>"+resultRow[i].nama+"</td>\n\
                <td>"+resultRow[i].alamat+"</td><td>"+resultRow[i].notelp+"</td>\n\
                <td><button type='button' onclick=hapusNasabah('"+resultRow[i].idnasabah+"') class='btn btn-danger open_delete'>Hapus</button> \n\
                <button type='button' class='btn btn-primary' onclick=ambilNasabah('"+resultRow[i].idnasabah+"')>Update</button></td></tr>";
            }
            dataHandler.append(list);
        }
    });
}