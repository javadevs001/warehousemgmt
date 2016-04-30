/* Common function */
function initSemanticObject() {

    $('.button')
        .popup()
    ;

    $('a')
        .popup()
    ;

    $('i')
        .popup()
    ;
}

/* Common application init */
$(document).ready(function () {

    /* Init function */
    initSemanticObject();

    $('.ui.dropdown').dropdown();


    $('.ui.checkbox')
        .checkbox()
    ;

});

