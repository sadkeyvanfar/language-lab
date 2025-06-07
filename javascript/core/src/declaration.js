"use strict";

var name = "Saeid"; // Using 'var' for a variable that can be redeclared and updated
const city = "Tehran"; // Using 'const' for a constant value

if (true) {
  var name = "Saeid";
  let age = 30; // Using 'let' for a block-scoped variable
}

console.log(name); // Saeid
// console.log(age);  // Uncommenting this line will throw an error because 'age' is not defined outside the block
// city = "Mashhad"; // This will throw an error because 'city' is a constant

const cities = ["Tehran", "Mashhad", "Isfahan"];
cities[2] = "Tom Cruise"; // OK :(
// cities = []; // Error! Assignment to a constant variable
