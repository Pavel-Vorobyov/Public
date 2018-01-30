
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
    location.href = resultURL;
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

function createCourse() {
    var title = courseCreation.title.value;
    var courseComment = courseCreation.courseComment.value;
    var availability = courseCreation.availability.value;
    var type = courseCreation.type.value;
    var region = courseCreation.region.value;
    var teacherId = courseCreation.leadId.value;

    if (title != null && courseComment != null) {

    }
}