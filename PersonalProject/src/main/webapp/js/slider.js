var container = document.getElementsByClassName("image-slider-container")[0];
var clone = document.getElementsByClassName("image-slider-item")[0];

var num = 0;
var canMove = true;

const moveImage = (dir) => {
  console.log(canMove);
  if (canMove) {
    canMove = false;
    if (dir == "right") {
      container.style.transform = `translate(-${++num * 1900}px)`;
    } else {
      container.style.transform = `translate(-${(num - 1) * 1900}px)`;
      num -= 1;
    }
    setTimeout(() => {
      canMove = true;
    }, 1000);
  }
};

window.onload = () => {
  setInterval(() => {
    if (canMove) {
      canMove = false;
      container.style.transform = `translate(-${++num * 1900}px)`;
      setTimeout(() => {
        if (num > 4) {
          container.style.transition = "none";
          container.style.transform = "translate(0px)";
          num = 1;
          setTimeout(() => {
            container.style.transition = "transform 1s";
            canMove = true;
          }, 100);
        }
        canMove = true;
      }, 1000);
    }
  }, 3000);
};
