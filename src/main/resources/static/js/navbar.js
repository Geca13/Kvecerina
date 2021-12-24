let menu = document.getElementById('menu');
if(menu){
menu.addEventListener('click',function(){
let menuItems = document.getElementById('menu-list'); 
menuItems.classList.toggle('active');
})

}