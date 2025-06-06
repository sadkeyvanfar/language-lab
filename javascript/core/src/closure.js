// Closure example in JavaScript
// A closure is a function that retains access to its lexical scope, even when the function is executed outside that scope.
// Closures are often used to create private variables or functions, allowing for encapsulation and data hiding.
// like #private variables in other languages, but in JavaScript, we can achieve this using closures.
// #filed is now alternatively used to create private variables in JavaScript.
function createCounter() {
  let count = 0; // This variable is enclosed

  return function () {
    count++;
    return count;
  };
}

const counter = createCounter(); // 'count' is now preserved in closure
console.log(counter()); // 1
console.log(counter()); // 2

console.log(counter().count); // undefined, private
