var prefix="//localhost:8090/";
var report_html = "report.html?"

var login_token = "LOGIN_TOKEN";
var login_email = "LOGIN_EMAIL";

var METHOD_GET  = "GET";
var METHOD_POST = "POST"

function isValidObject(obj){
    return (obj != null && typeof(exp) != undefined);
}

function logout(){
    requestRest("", data, method, successCallback, errorCallback, completeCallback)
}

function syncRequestRest(url, data, method, sync, successCallback, errorCallback, completeCallback){
    $.ajax({
        type: method,
        headers: {
            'Content-Type':'application/json;charset=utf-8',
            "token":window.sessionStorage.getItem(login_token)
        },
        url: prefix + url,
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(data),
        async: !sync,
        dataType:"json",
        cache: false,
        success: function(data){
            if (isValidObject(successCallback)){
                successCallback(data);
            }
        },
        error: function(jqXHR, textStatus, exception) {
            console.log(jqXHR.responseText);
            if (isValidObject(errorCallback)){
                errorCallback(jqXHR, textStatus, exception);
            }
        },
        complete: function() {
            if (isValidObject(completeCallback)){
                completeCallback();
            }
        }
    });
}

function requestRest(url, data, method, successCallback, errorCallback, completeCallback){
    syncRequestRest(url, data, method, false, successCallback, errorCallback, completeCallback);
}
