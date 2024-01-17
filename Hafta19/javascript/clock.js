let name = prompt("Adınızı giriniz:");

let docName = document.querySelector("#myName");
docName.innerHTML = `${name}`;

let clock = document.querySelector("#myClock");

function updateClock() {
  let nowTime = new Date().toString()
  let hours = nowTime.slice(16, 18)
  let minutes = nowTime.slice(19, 21)
  let seconds = nowTime.slice(22, 24)
  let day = nowTime.slice(0, 3)

  switch (day) {
    case "Mon":
      day = "Pazartesi"
      break;
    case "Tue":
      day = "Salı"
      break;
    case "Wed":
      day = "Çarşamba"
      break;
    case "Thu":
      day = "Perşembe"
      break;
    case "Fri":
      day = "Cuma"
      break;
    case "Sat":
      day = "Cumartesi"
      break;
    case "Sun":
      day = "Pazar"
      break;
    default:
      break;
  }

  clock.innerHTML = `${hours}:${minutes}:${seconds} ${day}`;
}

setInterval(updateClock, 1000);