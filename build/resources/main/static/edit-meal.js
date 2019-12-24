const editIngredientList = document.querySelector(".edit-ingredients");
addNewIngredient(editIngredientList);

function addNewIngredient(element) {
  element.appendChild(createNewIngredientInput());
}

function createNewIngredientInput() {
  const ingredientInput = document.createElement("div");
  ingredientInput.classList.add("ingredientInput");
  ingredientInput.appendChild(createNameBox());
  ingredientInput.appendChild(createNumberBox());
  const button = createAddItemButton();
  const removeButton = createRemoveItemButton();
  ingredientInput.appendChild(button);
  ingredientInput.appendChild(removeButton);
  button.addEventListener('click', (event) => {
    event.preventDefault();
    console.log(event.target);
    addNewIngredient(event.target.parentNode.parentNode);
    event.target.remove();
  })
  removeButton.addEventListener('click', (event) => {
    console.log(event.target);
    event.target.parentNode.remove();
  })
  return ingredientInput;
}

function wireDeleteButton() {
  let deleteButtons = document.querySelectorAll(".remove-ingredient-button");
  for (let i = 0; i < deleteButtons.length; i++) {
    deleteButtons[i].addEventListener('click', event => {
      console.log(event.target);
      event.target.parentNode.remove();
    })
  }
}
wireDeleteButton();

function createNameBox() {
  const nameBox = document.createElement("input");
  nameBox.setAttribute("type", "text");
  nameBox.setAttribute("placeholder", "Ingredient Name");
  nameBox.classList.add("ingredientName");
  return nameBox;
}

function createNumberBox() {
  const numberBox = document.createElement("input");
  numberBox.classList.add("ingredientQty");
  numberBox.setAttribute("placeholder", "Qty");
  numberBox.setAttribute("type", "number");
  return numberBox;
}

function createAddItemButton() {
  const button = document.createElement('button');
  button.innerText = '+';
  button.classList.add('add-ingredient-button');
  return button;
}

function createRemoveItemButton() {
  const removeButton = document.createElement('button');
  removeButton.innerText = 'x';
  removeButton.classList.add('remove-ingredient-button');
  return removeButton;
}

function readIngredientInput() {
  const mealIngredients = []

  const mealIngInputs = document.querySelectorAll(".ingredientInput");
  for (let i = 0; i < mealIngInputs.length; i++) {
    let mealIngredient = {
      "ingredient": {
        "name": "SampleIngredient"
      },
      "quantity": 23
    }
    if (mealIngInputs[i].querySelector(".ingredientName").value) {
      mealIngredient.ingredient.name = mealIngInputs[i].querySelector(".ingredientName").value;
      mealIngredient.quantity = mealIngInputs[i].querySelector(".ingredientQty").value;
      mealIngredients.push(mealIngredient);
    }
  }
  return mealIngredients;
}


const mealToEdit = {
  "id": -1,
  "name": "AwesomeName",
  "servingCount": 1,
  "mealIngredients": [{
    "ingredient": {
      "name": "TestIngredient"
    },
    "quantity": 1
  }]
}

const form = document.getElementById('editMealName');

document.querySelector(".submit").addEventListener("click", async function(event) {
  event.preventDefault();

  if (form.reportValidity()) {
    mealToEdit.name = document.querySelector('.meal-name-input').value;
    mealToEdit.id = document.querySelector('.meal-id-input').value;
    mealToEdit.mealIngredients = readIngredientInput();

    let response = await fetch('http://localhost:8080/api/meals/edit-meal/' + mealToEdit.id, {
      method: 'PUT',
      body: JSON.stringify(mealToEdit),
      headers: {
        'Content-Type': 'application/json'
      }
    });
    console.log(response);

    if (response.ok) {
      window.location.replace("http://localhost:8080");
    }
  }
});
