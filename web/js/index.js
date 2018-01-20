function init(bgVideo){
    bgVideo.playbackRate = 0.4;
}

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
