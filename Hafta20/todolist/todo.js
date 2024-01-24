var input = document.getElementById("task");
var btn = document.getElementById("liveToastBtn");
var list = document.getElementById("list");

btn.addEventListener("click", addTask);
list.addEventListener("click", doneTask);

document.addEventListener("DOMContentLoaded", function () {
  var savedList = localStorage.getItem("list");
  if (savedList) {
    list.innerHTML = savedList;
  }
});

function addTask() {
  let task = input.value;

  if (task === "") {
    $("#liveToast .toast-body").text("Listeye boş ekleme yapamazsınız!");
    $("#liveToast").addClass("error").toast("show");
  } else {
    $("#liveToast .toast-body").text("Başarıyla Eklendi!");
    $("#liveToast").addClass("success").toast("show");
    let li = document.createElement("li");
    li.innerText = task;
    list.appendChild(li);
    input.value = "";
    li.innerHTML += '<span class="close" id="close">x</span>';
  }

  localStorage.setItem("list", list.innerHTML);
}

list.addEventListener("click", function (event) {
  if (event.target.classList == "close") {
    removeTask.call(event.target);
  }
});

function removeTask() {
  let li = this.parentNode;
  let ul = li.parentNode;
  ul.removeChild(li);
  $("#liveToast .toast-body").text("Başarıyla Silindi!");
  $("#liveToast").addClass("success").toast("show");
  localStorage.setItem("list", list.innerHTML);
}

list.addEventListener("click", function (e) {
  if (e.target.tagName == "li") {
    doneTask(e.target);
  }
});

function doneTask(e) {
  if (e.target.classList.contains("bg-primary")) {
    e.target.classList.remove("bg-primary");
    e.target.classList.remove("text-white");
    e.target.classList.remove("text-decoration-line-through");
    e.target.style.textDecoration = "none";
  } else {
    e.target.classList.add("bg-primary");
    e.target.classList.add("text-white");
    e.target.style.textDecoration = "line-through";
  }
  localStorage.setItem("list", list.innerHTML);
}
