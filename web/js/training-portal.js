function handleSubmit(){
    var courseModerationPageURL = "command?command=training-portal-page";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;
    var courseStatus = courseFilter.courseStatus.value;

    var resultURL = courseModerationPageURL + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseStatus=" + courseStatus;
    location.href = resultURL;
}

function changeCourseStatus(courseStatus) {
    var courseModerationPageURL = "command?command=training-portal-page";
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;

    var resultURL = courseModerationPageURL + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseStatus=" + courseStatus;
    location.href = resultURL;
}