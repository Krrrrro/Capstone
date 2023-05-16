const imageContainer = document.querySelector('.main-content');
let currentImageIndex = 0;

function changeImage() {

    const images = imageContainer.querySelectorAll(".changeimg");
    console.log(images);
    const currentImage = images[currentImageIndex];
    const nextImageIndex = (currentImageIndex + 1) % images.length;
    const nextImage = images[nextImageIndex];
    currentImage.classList.add('hidden');
    nextImage.classList.remove('hidden');
    currentImageIndex = nextImageIndex;
}

window.onload = () => { setInterval(() => { changeImage() }, 2000) };



const showToggleDetail = () => {
    const toggleDetail = document.getElementsByClassName("toggle-detail");
    if (toggleDetail[0].style.display == "block") {
        toggleDetail[0].style.display = "none";
    } else {
        toggleDetail[0].style.display = "block";
    }

}

const showtoggleMenu = () => {
    const toggleMenu = document.getElementsByClassName("toggle-menu");
    console.log("asdf");
    if (toggleMenu[0].style.display == "block") {
        toggleMenu[0].style.display = "none";
    } else {
        toggleMenu[0].style.display = "block";
    }
}

window.onresize = function () {
    if (matchMedia("screen and (max-width: 767px)").matches == false) {
        const toggleMenu = document.getElementsByClassName("toggle-menu");
        toggleMenu[0].style.display = "none";
    }
};