
  
  //banner js
  let currentSlide = 0;
const slides = document.querySelectorAll('.slide');
const slider = document.querySelector('.slider');

function showSlide(index) {
    const offset = index * -100;
    slider.style.transform = `translateX(${offset}%)`;
    slides.forEach((slide, i) => {
      slide.classList.toggle('active', i === index);
    });
    currentSlide = index;
  }

function nextSlide() {
  const next = (currentSlide + 1) % slides.length;
  showSlide(next);
}

// Change slide every 20 seconds
setInterval(nextSlide, 10000);

//logout

// Simulate login state
let isLoggedIn = true;

function logout() {
  isLoggedIn = false; // Set the logged-out state

  // Hide profile and logout button, show the logo again
  document.body.classList.add('logged-out');

  // Clear any user session or authentication logic here
  alert('Logged out successfully!');
}

// Set the initial state based on whether the user is logged in
if (!isLoggedIn) {
  document.body.classList.add('logged-out');
} else {
  document.body.classList.add('logged-in');
}
