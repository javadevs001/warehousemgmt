/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
$(document).ready(function () {

    var supplierOrderDetailTable;

    initSupplierOrderDetailTable();
    initSupplierOrderDetailSearch();
    initDeleteOrderDetailModalSelector();

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
            "pageLength": 4,
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

    function initDeleteOrderDetailModalSelector() {
        $('#supplierOrderDetailTable').on('click', '.deleteOrderDetailModalSelector', function (e) {
            e.preventDefault();
            e.stopPropagation();
            var orderdetailid = $(this).data("orderdetailid");
            $('#deleteOrderDetailModal')
                .modal({
                    closable: false,
                    onDeny: function () {
                        $('#deleteOrderDetailModal').modal("hide");
                        return false;
                    },
                    onApprove: function () {
                        $('#deleteOrderDetailModal').modal("hide");
                        var callBack = $.ajax({
                            url: ctx + '/api/secured/SupplierOrderRestController/deleteOrderDetail/' + orderdetailid,
                            async: true,
                            method: 'POST'
                        });

                        callBack.done(function (response) {
                            location.reload();
                        });

                        callBack.fail(function (error) {
                            handleAjaxError(error);
                        });
                    }
                })
                .modal('show')
            ;
        });
    }

});
