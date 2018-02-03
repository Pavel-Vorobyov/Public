function handleSubmit(){
    var userModerationPageURL = "command?command=admin-user-moderation-page";
    var filterUserStatus = userFilter.filterUserStatus.value;

    var resultURL = userModerationPageURL + "&filterUserStatus=" + filterUserStatus;
    location.href = resultURL;
}