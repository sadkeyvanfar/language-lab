// This code demonstrates a simple for loop in JavaScript
for (let i = 0; i < 10; i++) {
  console.log("Iteration number: " + i);
}

let i = 0
while (i < 5) {
  console.log("This will run until i is less than 5: " + i);
  i++;
}

do {
  console.log("This will run at least once, even if the condition is false.");
} while (false); // This will not run again because the condition is false

// This code demonstrates the use of for...of loop to iterate over an array in JavaScript.
// The for...of loop is used to iterate over iterable objects like arrays, strings, and more.
const numbers = [1, 2, 3, 4, 5];
for (const number of numbers) {
  console.log("Current number: " + number);
}
