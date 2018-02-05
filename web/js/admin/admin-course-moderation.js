function deleteCourse(courseId) {
    var link = "command?command=delete_course";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;
    var courseAvailability = courseFilter.courseAvailability.value;

    var resultURL = link + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseAvailability=" + courseAvailability + "&courseId=" + courseId;
    window.location.href = resultURL;
}

function handleSubmit(){
    var courseModerationPageURL = "command?command=admin_course_moderation_page";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;
    var courseAvailability = courseFilter.courseAvailability.value;

    var resultURL = courseModerationPageURL + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseAvailability=" + courseAvailability;
    location.href = resultURL;
}