



function checkAllValues(){
        
  const name = document.querySelector("#name").value;
  console.log(name);
  const department = document.querySelector("#department").value;
  const designation = document.querySelector("#designation").value;
  let errorMessage;
  let isNotError = true;
  if (name.length === 0) {
    errorMessage = "Name is required";
    const nameErrorElement = document.querySelector("#name-error");
    nameErrorElement.textContent = errorMessage;
    nameErrorElement.classList.add("show");
    isNotError = false;
  }

//   if (department.length === 0) {
//     errorMessage = "Rating is required";
//     const ageErrorElement = document.querySelector("#department-error");
//     ageErrorElement.textContent = errorMessage;
//     nameErrorElement.classList.add("show");    
//     isNotError = false;
//   }
//   if (designation.length === 0) {
//     errorMessage = "designation is required";
//     const ageErrorElement = document.querySelector("#designation-error");
//     ageErrorElement.textContent = errorMessage;
//     ageErrorElement.classList.add("show");
//     isNotError = false;
//   }
  return isNotError;


}

