let player = document.getElementById('audio');
let image = document.getElementById('audio');
if(player){
player.addEventListener('click',function(){
image.classList.toggle('video-active')
let video = document.getElementById('video'); 
video.classList.toggle('video-active');
video.play();
})

}