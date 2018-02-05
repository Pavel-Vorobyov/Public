function handleSubmit(){
    var courseModerationPageURL = "command?command=training_portal_page";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;
    var courseStatus = courseFilter.courseStatus.value;

    var resultURL = courseModerationPageURL + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseStatus=" + courseStatus;
    location.href = resultURL;
}

function changeCourseStatus(courseStatus) {
    var courseModerationPageURL = "command?command=training_portal_page";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;

    var resultURL = courseModerationPageURL + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseStatus=" + courseStatus;
    location.href = resultURL;
}

function applyForCourse(courseId) {
    var currentUrl = window.location;
    var applyForCourseUrl = "command?command=student_apply_for_course&courseId=" + courseId
        + "&currentUrl=" + currentUrl;

    window.location = applyForCourseUrl;
}