
function initUpdateBlock(blockId){
    blockId.style.display = "none";
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

function deleteCourse(courseId) {
    var link = "command?command=delete-course";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;
    var courseAvailability = courseFilter.courseAvailability.value;

    var resultURL = link + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseAvailability=" + courseAvailability + "&courseId=" + courseId;
    window.location.href = resultURL;
}

function handleSubmit(){
    var courseModerationPageURL = "command?command=admin-course-moderation-page";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;
    var courseAvailability = courseFilter.courseAvailability.value;

    var resultURL = courseModerationPageURL + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseAvailability=" + courseAvailability;
    location.href = resultURL;
}