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


let newArtistPopup = document.getElementById('new-artist-popup'); 
let newArtistBtn = document.getElementById('new-artist'); 

if(newArtistBtn){
newArtistBtn.addEventListener('click',function(){
newArtistPopup.classList.add('active');
 })
}

let closeNewArtistBtn = document.getElementById('close-btn1');
if(closeNewArtistBtn){
closeNewArtistBtn.addEventListener('click',function(){ 
newArtistPopup.classList.remove('active');
 })
}

