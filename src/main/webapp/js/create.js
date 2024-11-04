function checkAllValues() {
  const currentUrlPaths = window.location.pathname
    .split("/")
    .filter((path) => path);
  const currentPath = currentUrlPaths[1];

  const fields =
    currentPath === "books"
      ? ["name", "author", "price"]
      : ["name", "department", "designation"];
  const field1 = document.querySelector(`#${fields[0]}`);
  const field2 = document.querySelector(`#${fields[1]}`);
  const field3 = document.querySelector(`#${fields[2]}`);
  let isNotError = true;

  isNotError = checkLengthError(field1, fields[0]);
  isNotError = checkLengthError(field2, fields[1]);
  isNotError = checkLengthError(field3, fields[2]);

  if (fields[2] === "price") {
    isNotError = checkNumber(field3, fields[2]);
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
  } else if (element.value.length > 100) {
    const errorMessage =
      String(field).charAt(0).toUpperCase() +
      String(field).slice(1) +
      " should be less than 100 characters";

    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = !isNotError;
  } else if (hasLeadingOrTrailingSpaces(element.value)) {
    const errorMessage = "trailing and leading spaces are not allowed";

    errorElement.textContent = errorMessage;
    errorElement.classList.add("show");
    isNotError = !isNotError;
  }
  return isNotError;
}

function hasLeadingOrTrailingSpaces(str) {
  const leadingSpace = /^\s/; // Checks for leading space
  const trailingSpace = /\s$/; // Checks for trailing space

  return leadingSpace.test(str) || trailingSpace.test(str);
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
    const errorMessage =
      String(field).charAt(0).toUpperCase() +
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
