/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
$(document).ready(function () {

    $('.ui.modal')
        .modal()
    ;

    $("#changeState").on("click", function (e) {
        e.preventDefault();
        e.stopPropagation();
        var orderDetailId = $(this).data("orderdetailid");
        console.log(orderDetailId);
        $("#orderDetailIdModal").val(orderDetailId);
        $('#changeStateModal')
            .modal('show')
        ;
    });

    var supplierOrderDetailTable;

    initSupplierOrderDetailTable();
    initSupplierOrderDetailSearch();

    function initSupplierOrderDetailSearch() {
        $('#supplierOrderDetailSearch').on('keyup', function (e) {
            e.preventDefault();
            e.stopPropagation();
            var searchValue = $(this).val();
            supplierOrderDetailTable.search(searchValue).draw();
        });
    }

    function initSupplierOrderDetailTable() {
        supplierOrderDetailTable = $("#supplierOrderDetailTable").DataTable({
            "responsive": true,
            "bPaginate": true,
            "bLengthChange": false,
            "bFilter": true,
            "bInfo": false,
            "bAutoWidth": true,
            "language": {
                "decimal": ",",
                "thousands": ".",
                "sSearch": "Recherche : ",
                "lengthMenu": "Display _MENU_ records per page",
                "zeroRecords": "Rien à afficher pour l'instant - désolé",
                "info": "Affichage de la page _PAGE_ de _PAGES_",
                "infoEmpty": "Aucun enregistrement disponible",
                "infoFiltered": "(filtered from _MAX_ total records)",
                "oPaginate": {
                    "sNext": "Suivant",
                    "sPrevious": "Précédent"
                }
            }
        });
    }

});
