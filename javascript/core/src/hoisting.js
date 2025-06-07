// Hoisting is a JavaScript mechanism where variables and function declarations are moved to the top of their containing scope during the compile phase.
// This means that you can use variables and functions before they are declared in the code.
// However, only the declarations are hoisted, not the initializations.
// This can lead to some unexpected behavior, especially with `var`, `let`, and `const`.

// Variable Hoisting: var
console.log(x); // undefined
var x = 5;
/* like this:
var x;         // declaration is hoisted
console.log(x); // undefined
x = 5;         // assignment stays in place
*/

// let and const are hoisted too — but in a different way!
// console.log(a); // ReferenceError!
let a = 10;

// Function declarations are fully hoisted
sayHello(); // Works

function sayHello() {
  console.log("Hi!");
}

// Function expressions are not hoisted
// sayHi(); // TypeError: sayHi is not a function

var sayHi = function () {
  console.log("Hi!");
};
