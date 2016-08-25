/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
$(document).ready(function () {


    var supplierOrdersTable;

    initSupplierOrdersTable();
    initSupplierOrdersSeatch();
    initDeleteOrderModalSelector();

    function initSupplierOrdersSeatch() {
        $('#supplierOrderSearch').on('keyup', function (e) {
            e.preventDefault();
            e.stopPropagation();
            var searchValue = $(this).val();
            supplierOrdersTable.search(searchValue).draw();
        });
    }

    function initSupplierOrdersTable() {
        supplierOrdersTable = $("#supplierOrdersTable").DataTable({
            responsive: true,
            "searching": true,
            "stateSave": false,
            "pageLength": 4,
            "bLengthChange": false,
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

    function initDeleteOrderModalSelector() {
        $('#supplierOrdersTable').on('click', ".deleteSupplierOrderSelector", function (e) {
            e.preventDefault();
            e.stopPropagation();
            var ordersId = $(this).data("ordersid");
            $('#deleteOrderModal')
                .modal({
                    closable: false,
                    onDeny: function () {
                        $('#deleteOrderModal').modal("hide");
                        return false;
                    },
                    onApprove: function () {
                        $('#deleteOrderModal').modal("hide");
                        var callBack = $.ajax({
                            url: ctx + '/api/secured/SupplierOrderRestController/deleteSupplierOrder/' + ordersId,
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