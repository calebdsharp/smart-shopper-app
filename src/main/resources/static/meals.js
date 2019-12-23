const increaseButton = document.querySelector('.increaseButton');
incrementMealCount(increaseButton);

function incrementMealCount() {
  const mealIds = document.querySelectorAll('.incrementMealId');
  for (let i = 0; i < mealIds.length; i++) {
    mealIds[i].parentElement.addEventListener('click', () => {
      fetch(
        'http://localhost:8080/api/mealPlan/increaseCount/' + mealIds[i].value,
        {
          method: 'GET',
        }
      );
      location.reload();
    });
  }
}
const decreaseButton = document.querySelector('.decreaseButton');
decrementMealCount(decreaseButton);

function decrementMealCount() {
  const mealIds = document.querySelectorAll('.decrementMealId');
  for (let i = 0; i < mealIds.length; i++) {
    mealIds[i].parentElement.addEventListener('click', () => {
      fetch(
        'http://localhost:8080/api/mealPlan/decreaseCount/' + mealIds[i].value,
        {
          method: 'GET',
        }
      );
      location.reload();
    });
  }
}

const currentMealCount = document.querySelector('.currentMealCount');
updateCurrentMealCount(currentMealCount);

async function updateCurrentMealCount() {
  const mealCounts = document.querySelectorAll('.currentMealCount');
  for (let i = 0; i < mealCounts.length; i++) {
    let url =
      'http://localhost:8080/api/mealPlan/mealCount/' +
      mealCounts[i].querySelector('.countMealId').value;
    let mealPlanCount = await fetch(url).then(response => response.json());
    console.log(mealPlanCount);
    mealCounts[i].innerText = mealPlanCount.count;
    if (mealPlanCount.count == 0) {
      mealCounts[i].classList.add('hidden');
      mealCounts[i].parentNode.querySelector('.decrementMealId').parentNode.classList.add('hidden');
    }
  }
}
// fetch("https://swapi.co/api/people/22")
//   .then(response => response.json())
//   .then(jsonData => console.log(jsonData))
//   .catch(err => console.log(err))
