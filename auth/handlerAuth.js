var modal_login = document.getElementById('modal_login_id');
var modal_register = document.getElementById('modal_register_id');
var btn_login = document.getElementById('login_id');
var btn_register = document.getElementById('register_id');
var close_modal = document.getElementById('close-modal');
var close_modal_register = document.getElementById('close-modal-register');
var select_login = document.getElementById('register');
var select_register = document.getElementById('login');

select_login.addEventListener("click", () =>{
    modal_login.style.display = "none";
    modal_register.style.display= "flex";
})

select_register.addEventListener("click", () =>{
    modal_register.style.display = "none";
    modal_login.style.display= "flex";
})

btn_login.addEventListener("click", () =>{
    modal_login.style.display= "flex";
})

btn_register.addEventListener("click", () =>{
    modal_register.style.display= "flex";
})

close_modal.addEventListener("click", () =>{
    modal_login.style.display = "none";
})

close_modal_register.addEventListener("click", () =>{
    modal_register.style.display = "none";
})

window.onclick = function(event) {
    if (event.target == modal_login) {
        modal_login.style.display = "none";
    } else if (event.target == modal_register){
        modal_register.style.display = "none";
    }
}