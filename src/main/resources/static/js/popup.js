let loginPopup = document.getElementById('login-popup'); 
let loginOpenBtn = document.getElementById('login-open-popup'); 

if(loginOpenBtn){
loginOpenBtn.addEventListener('click',function(){
loginPopup.classList.add('active');
 })
}

let closeBtn = document.getElementById('close-btn');
if(closeBtn){
closeBtn.addEventListener('click',function(){
let loginPopup = document.getElementById('login-popup'); 
loginPopup.classList.remove('active');
 })
}


let songPopup = document.getElementById('song-popup'); 
let songOpenBtn = document.getElementById('song-open-popup'); 

if(songOpenBtn){
songOpenBtn.addEventListener('click',function(){
songPopup.classList.add('active');
 })
}

let songCloseBtn = document.getElementById('close-btn1');
if(songCloseBtn){
songCloseBtn.addEventListener('click',function(){
let artistPopup = document.getElementById('song-popup'); 
songPopup.classList.remove('active');
 })
}