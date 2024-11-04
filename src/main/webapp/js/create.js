function checkAllValues() {
  const currentUrlPaths = window.location.pathname
    .split("/")
    .filter((path) => path);
  const currentPath = currentUrlPaths[1];

  const fields =
    currentPath === "books"
      ? ["name", "author", "price"]
      : ["name", "department", "designation"];
  const name = document.querySelector(`#${fields[0]}`);
  const department = document.querySelector(`#${fields[1]}`);
  const designation = document.querySelector(`#${fields[2]}`);
  let isNotError = true;

  isNotError = checkLengthError(name, fields[0]);
  isNotError = checkLengthError(department, fields[1]);
  isNotError = checkLengthError(designation, fields[2]);

  if (fields[2] === "price") {
    isNotError = checkNumber(designation, fields[2]);
  }
  return isNotError;
}
function checkLengthError(element, field) {
  let isNotError = true;
  const errorElement = document.querySelector(`#${field}-error`);
  errorElement.classList.remove("show");

  if (element.value.length === 0) {
    const errorMessage =
      String(field).charAt(0).toUpperCase() +
      String(field).slice(1) +
      " is required";

    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = !isNotError;
  }else if (element.value.length > 100) {
    const errorMessage =
      String(field).charAt(0).toUpperCase() +
      String(field).slice(1) +
      " should be less than 100 characters";

    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = !isNotError;
  }

  return isNotError;
}

function checkEmptySelected() {
  const bookSelect = document.querySelector("#bookselect");
  const bookSelectError = document.querySelector("#select-error");

  let isNotError = true;
  bookSelectError.classList.remove("show");
  if (bookSelect.value === "") {
    bookSelectError.textContent = "Book name is required";
    bookSelectError.classList.add("show");
    isNotError = !isNotError;
  }
  return isNotError;
}
function checkNumber(element, field) {
  const value = parseFloat(element.value);

  const errorElement = document.querySelector(`#${field}-error`);
  let isNotError = true;
  errorElement.classList.remove("show");
  if (isNaN(value)) {
    const errorMessage =
      String(field).charAt(0).toUpperCase() +
      String(field).slice(1) +
      " Should be a Number";

    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = !isNotError;
  } else if (value < 0) {
    const errorMessage =
      String(field).charAt(0).toUpperCase() +
      String(field).slice(1) +
      " Should be a positive Number";

    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = !isNotError;
  } else if (element.value.length > 7) {
   const errorMessage = String(field).charAt(0).toUpperCase() +
      String(field).slice(1) +
      " should be less than 7 digits";

    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = !isNotError;
  }
  return isNotError;
}

async function getUsers(e) {
  const selectedValue = e.value;

  const response = await fetch(`users/all/${selectedValue}`);
  const results = await response.json();
  const checkBoxes = document.querySelectorAll(".checkbox");
  checkBoxes.forEach((checkBox) => {
    const checkBoxValue = Number(checkBox.value);

    const matchedResult = results.find((result) => result.id === checkBoxValue);

    if (matchedResult) {
      checkBox.checked = true;
    } else {
      checkBox.checked = false;
    }
  });
}
