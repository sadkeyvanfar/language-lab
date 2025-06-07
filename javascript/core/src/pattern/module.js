// Define a module using an IIFE (Immediately Invoked Function Expression)
// Module pattern in JavaScript
// The module pattern is a design pattern that allows you to encapsulate private variables and functions,
// exposing only a public API. This helps in organizing code and preventing global namespace pollution.
// ES6 introduced modules, but the module pattern is still widely used for encapsulation and privacy.
const MathModule = (function () {
  // Private variables and functions
  const PI = 3.14159;

  function add(a, b) {
    return a + b;
  }

  function multiply(a, b) {
    return a * b;
  }

  // Expose public API
  return {
    add: add,
    multiply: multiply,
  };
})();

// Using the module
console.log(MathModule.add(2, 3)); // 5
console.log(MathModule.multiply(4, 5)); // 20
// console.log(MathModule.PI);              // undefined
