function handleSubmit(){
    var groupModerationPageURL = "command?command=admin-group-moderation-page";
    var groupRegion = groupFilter.groupRegion.value;
    var groupType = groupFilter.groupType.value;
    var groupStatus = groupFilter.groupStatus.value;

    var resultURL = groupModerationPageURL + "&groupRegion=" + groupRegion + "&groupType=" + groupType
        + "&groupStatus=" + groupStatus;
    location.href = resultURL;
}

function deleteGroup(groupId) {
    var groupModerationPageURL = "command?command=delete-group";
    var groupRegion = groupFilter.groupRegion.value;
    var groupType = groupFilter.groupType.value;
    var groupStatus = groupFilter.groupStatus.value;

    var resultURL = groupModerationPageURL + "&groupRegion=" + groupRegion + "&groupType=" + groupType
        + "&groupStatus=" + groupStatus + "&groupId=" + groupId;
    location.href = resultURL;
}