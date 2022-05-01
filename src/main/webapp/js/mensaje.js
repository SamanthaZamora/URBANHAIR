/**
 * 
 */
const alertlogin=()=>{
	let alert=document.querySelector('.alert-login');
	let close=alert.querySelector('.alert-login-close');
	close.addEventListener('click',()=>{
		alert.style.display='none';
	});
};