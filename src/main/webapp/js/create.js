function checkAllValues() {
const currentUrlPaths = window.location.pathname.split("/").filter(path=>path);
const currentPath = currentUrlPaths[1];

const fields = currentPath === "books" ? ["name","author","price"] : ["name","department","designation"];
const name = document.querySelector(`#${fields[0]}`);
  const department = document.querySelector(`#${fields[1]}`);
  const designation = document.querySelector(`#${fields[2]}`);
  let isNotError = true;

  isNotError = checkLengthError(name, fields[0]) 
  isNotError = checkLengthError(department, fields[1]) 
  isNotError = checkLengthError(designation, fields[2]);
  if(fields[2] === "price"){
    console.log(fields[2]);
    isNotError = checkNumber(designation,fields[2]);
  }
  return isNotError;
}
function checkLengthError(element, field) {
  let isNotError = true;
  const errorElement = document.querySelector(`#${field}-error`);
  errorElement.classList.remove("show");
  
  
  if (element.value.length === 0) {
    errorMessage = field + " is required";
    
    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = false;
  }
  return isNotError;
}
function checkNumber(element,field){
  const value = Number(element.value);
  
  const errorElement = document.querySelector(`#${field}-error`);
let isNotError = true;
  errorElement.classList.remove("show");
  if(isNaN(value) ){
        errorMessage = field + " Should be Number";

        errorElement.textContent = errorMessage;
        errorElement.classList.add("show");
        isNotError = false;
  }
return isNotError;
}




async function getUsers(e){
const selectedValue = e.value;
const response = await fetch(`users/all/${selectedValue}`);
const result = response.json();
console.log(result);
}
