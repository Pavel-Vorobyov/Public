function handleSubmit(){
    var userModerationPageURL = "command?command=admin_user_moderation_page";
    var filterUserStatus = userFilter.filterUserStatus.value;

    var resultURL = userModerationPageURL + "&filterUserStatus=" + filterUserStatus;
    location.href = resultURL;
}