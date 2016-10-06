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


function handleAjaxError(error) {
    if (error.status == 403) {
        window.location = ctx + "/LoginController/getLoginView?sessionExpired=true";
    }
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

