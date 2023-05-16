
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