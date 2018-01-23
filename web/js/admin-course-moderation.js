var link = "command?command=admin-home-page";
function handleSubmit(){
    var courseRegion = courseFilter.courseRegion.value;
    var courseType = courseFilter.courseType.value;
    var courseAvailability = courseFilter.courseAvailability.value;

    var resultURL = link + "&courseRegion=" + courseRegion + "&courseType=" + courseType
        + "&courseAvailability=" + courseAvailability;
    location.href=resultURL;
}