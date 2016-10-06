/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
$(document).ready(function () {


    var supplierOrdersSynchroTable;

    initSupplierOrdersSynchroTable();
    initSupplierOrdersSynchroSeatch();

    function initSupplierOrdersSynchroSeatch() {
        $('#supplierOrderSynchroSearch').on('keyup', function (e) {
            e.preventDefault();
            e.stopPropagation();
            var searchValue = $(this).val();
            supplierOrdersSynchroTable.search(searchValue).draw();
        });
    }

    function initSupplierOrdersSynchroTable() {
        supplierOrdersSynchroTable = $("#supplierOrdersSynchroTable").DataTable({
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


});