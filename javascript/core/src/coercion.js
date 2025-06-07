// coercion in JavaScript
// Coercion is the process of converting a value from one type to another in JavaScript.
// JavaScript is a dynamically typed language, meaning that types are determined at runtime.
// Coercion can happen implicitly (automatic) or explicitly (manual).
// Implicit coercion occurs when JavaScript automatically converts types during operations.
// Explicit coercion occurs when you use functions or methods to convert types manually.

// Implicit coercion examples
let num = 5;
let str = "10";
let result = num + str; // Implicit coercion: number to string
console.log(result); // "510" (string concatenation)

let bool = true;
let coercedNum = num + bool; // Implicit coercion: boolean to number
console.log(coercedNum); // 6 (true is coerced to 1)

let arr = [1, 2, 3];
let coercedStr = arr + ""; // Implicit coercion: array to string
console.log(coercedStr); // "1,2,3" (array to string)

// Explicit coercion examples
let explicitNum = Number(str); // Explicit coercion: string to number
console.log(explicitNum); // 10 (string to number)

let explicitStr = String(num); // Explicit coercion: number to string
console.log(explicitStr); // "5" (number to string)

let explicitBool = Boolean(num); // Explicit coercion: number to boolean
console.log(explicitBool); // true (non-zero number is coerced to true)

// Explicit coercion with parseInt and parseFloat
let parsedInt = parseInt(str, 10); // Explicit coercion: string to integer
console.log(parsedInt); // 10 (string to integer)

let parsedFloat = parseFloat("3.14"); // Explicit coercion: string to float
console.log(parsedFloat); // 3.14 (string to float)
