"use strict";

console.log("Comparison Operators");

// === The strict equality operator (===) checks for both value and type equality
console.log(5 === 5); // true
console.log(5 === "5"); // false,
console.log("yes" === "yes"); // true
console.log(null === null); // true
console.log(false === false); // true
console.log(true === 1); // false
console.log(0 === null); // false
console.log(0 === undefined); // false
console.log(null === undefined); // false

// these two comparisons shows unexpected behavior of === operator
console.log(NaN === NaN); // false, // NaN is not equal to anything, even itself
console.log(Object.is(NaN, NaN)); // true, // Use Object.is or isNaN to check for NaN
console.log(0 === -0); // true // 0 and -0 are considered equal in JavaScript
console.log(Object.is(0, -0)); // false // Use Object.is to differentiate between 0 and -0

console.log([1, 2] === [1, 2]); // false, Two different objects are not equal
console.log({ a: 1 } === { a: 1 }); // false,
console.log((x) => x * 2 === x * 2);

// == The loose equality operator (==) checks for value equality, performing type coercion if necessary
// if the types are different, it will try to convert them to a common type before comparing
// if the types are the same, it behaves like ===
console.log(5 == 5); // true
console.log(5 == "5"); // true, // string "5" is coerced to number 5
console.log("yes" == "yes"); // true
console.log(null == null); // true
console.log(true == 1); // true, // true is coerced to 1

// <, >, <=, >= Comparison operators also convert types if necessary
console.log(5 < 10); // true
console.log(5 > 10); // false
console.log(5 <= 5); // true
console.log(5 >= 5); // true
console.log("5" < 10); // true, // string "5" is coerced to number 5
console.log("5" > 10); // false, // string "5" is coerced to number 5
