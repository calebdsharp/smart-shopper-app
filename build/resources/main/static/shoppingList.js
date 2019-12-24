const myNodelist = document.getElementsByTagName("LI");

for (i = 0; i < myNodelist.length; i++) {
    const span = document.createElement("SPAN");
    const txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
const close = document.getElementsByClassName("close");
for (i = 0; i < close.length; i++) {
    close[i].onclick = function () {
        const div = this.parentElement;
        div.style.display = "none";
    }
}

// Add a "checked" symbol when clicking on a list item
const list = document.querySelector('ul');
list.addEventListener('click', function (ev) {
    if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
    } else if (ev.target.tagName === 'H5') {
        ev.target.parentElement.parentElement.classList.toggle('checked');
        console.log('clicked');
    }
}, false);

// Create a new list item when clicking on the "Add" button
function newElement() {
    const newLi = document.createElement("li");
    const newDiv = document.createElement("div");
    newLi.appendChild(newDiv);
    const newH5 = document.createElement("h5");
    newDiv.appendChild(newH5);
    const newDiv2 = document.createElement("div");
    newLi.appendChild(newDiv2);
    const newP = document.createElement("p");
    newDiv2.appendChild(newP);
    const inputValue = document.getElementById("miscinput").value;
    const inputQty = document.getElementById("miscInputQty").value;
    const t = document.createTextNode(inputValue);
    const n = document.createTextNode(inputQty);
    newH5.appendChild(t);
    newP.appendChild(n);
    if (inputValue === '') {
        alert("You must write something!");
    } else {
        document.getElementById("shoppinglist").appendChild(newLi);
    }
    document.getElementById("miscinput").value = "";
    document.getElementById("miscInputQty").value = "";

    const span = document.createElement("SPAN");
    const txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    newLi.appendChild(span);

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            const div = this.parentElement;
            div.style.display = "none";
        }
    }
}