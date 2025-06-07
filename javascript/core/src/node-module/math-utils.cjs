// Define functions and export them using CommonJS
function add(a, b) {
  return a + b;
}

function multiply(a, b) {
  return a * b;
}

const PI = 3.14159;

// Export the functions and constant
module.exports = {
  add,
  multiply,
  PI,
};
