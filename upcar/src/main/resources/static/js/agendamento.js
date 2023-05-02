
/**
 *  Busca todos os vendedores cadastrados com radio
 */
$(document).ready(function() {
        $.get( "/vendedores/listar/", function( result ) {

            var ultimo = result.length - 1;

            $.each(result, function (k, v) {

                if ( k == ultimo ) {
                    $("#vendedores").append(
                        '<div class="custom-control custom-radio">'
                        +  '<input class="custom-control-input" type="radio" id="customRadio'+ k +'" name="vendedor.id" value="'+ v.id +'" required>'
                        +  '<label class="custom-control-label" for="customRadio'+ k +'">'+ v.nome +'</label>'
                        +  '<div class="invalid-feedback">Vendedor é obrigatório</div>'
                        +'</div>'
                    );
                } else {
                    $("#vendedores").append(
                        '<div class="custom-control custom-radio">'
                        +  '<input class="custom-control-input" type="radio" id="customRadio'+ k +'" name="vendedor.id" value="'+ v.id +'" required>'
                        +  '<label class="custom-control-label" for="customRadio'+ k +'">'+ v.nome +'</label>'
                        +'</div>'
                    );
                }
            });
        });
});

/**
 * busca os horários livres para consulta conforme a data e o vendedor.
 * os horários são adicionados a página como um select:option.
 */
$('#data').on('blur', function () {
    $("#horarios").empty();
    var data = $(this).val();
    var vendedor = $('input[name="vendedor.id"]:checked').val();
    if (Date.parse(data)) {
        $.get('/agendamentos/horario/vendedor/'+ vendedor + '/data/' + data , function( result ) {
            console.log(result)
            if ($.isEmptyObject(result)) {
                alert('Nenhum horário disponível nesta data!') ;
            } else {
                $.each(result, function (k, v) {
                    $("#horarios").append(
                        '<option class="op" value="'+ v.id +'">'+ v.horaMinuto + '</option>'
                    );
                });
            }
        });
    }
});

/**
 * Datatable histórico de agendamentos
 */
$(document).ready(function() {
    moment.locale('pt-BR');
    var table = $('#table-vendedores-historico').DataTable({
        searching : false,
        lengthMenu : [ 5, 10 ],
        processing : true,
        serverSide : true,
        responsive : true,
        order: [2, 'desc'],
        ajax : {
            url : '/agendamentos/datatables/server/historico',
            data : 'data'
        },
        columns : [
            {data : 'id'},
            {data : 'cliente.nome'},
            {data: 'dataReuniao', render:
                    function( dataConsulta ) {
                        return moment(dataConsulta).format('LLL');
                    }
            },
            {data : 'vendedor.nome'},
            {orderable : false,	data : 'id', "render" : function(id) {
                    return '<a class="btn btn-success btn-sm btn-block" href="/agendamentos/editar/agendamento/'
                        + id + '" role="button"><i class="fas fa-edit"></i></a>';
                }
            },
            {orderable : false,	data : 'id', "render" : function(id) {
                    return '<a class="btn btn-danger btn-sm btn-block" href="/agendamentos/excluir/agendamento/'
                        + id +'" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
                }
            }
        ]
    });
});


















