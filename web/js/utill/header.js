function showUpdateBlock(blockId) {
    if (blockId.style.display == "none")
    {
        blockId.style.display = "block";
    }
    else
    {
        blockId.style.display = "none";
    }
}

function showMessage(blockId) {
    showUpdateBlock(blockId);
}

function changeLocal(localValue) {
    var currentUrl = window.location;
    var changeLocalUrl = "command?command=change_local&local=" + localValue
        +"&currentUrl=" + currentUrl;

    window.location = changeLocalUrl;
}

function enLocal() {
    var localValue = "en";
    changeLocal(localValue);
}

function ruLocal() {
    var localValue = "ru";
    changeLocal(localValue);
}