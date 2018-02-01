function handleSubmit(){
    var userModerationPageURL = "command?command=admin-user-moderation-page";
    var filterUserStatus = userFilter.filterUserStatus.value;

    var resultURL = userModerationPageURL + "&filterUserStatus=" + filterUserStatus;
    location.href = resultURL;
}

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