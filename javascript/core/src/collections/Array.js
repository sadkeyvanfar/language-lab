// Arrays are special objects with indexed keys (0, 1, 2, …)
// Literal syntax (most common)
const fruits = ["apple", "banana", "cherry"];

// Using Array constructor
const numbers = new Array(1, 2, 3);

// Empty array of fixed size (rarely used)
const empty = new Array(5);

console.log(fruits[0]); // 'apple'
console.log(fruits.length); // 3

/* creating arrays with different factory functions */

// Using Array.of() for creating an array from a set of elements.
const moreFruits = Array.of("orange", "grape", "kiwi");

// Using Array.from() to create an array from an iterable or array-like object
const str = "hello";
const chars = Array.from(str); // ['h', 'e', 'l', 'l', 'o']
// Using Array.from() with a mapping function
const numbersArray = Array.from({ length: 5 }, (_, i) => i + 1); // [1, 2, 3, 4, 5]
// Using Array.from() with a Set
const uniqueNumbers = new Set([1, 2, 3, 4, 5]);
const setArray = Array.from(uniqueNumbers); // [1, 2, 3, 4, 5]

/*  Common Array Methods */
// Adding elements
fruits.push("date"); // Adds 'date' to the end
fruits.unshift("apricot"); // Adds 'apricot' to the beginning

// Removing elements
fruits.pop(); // Removes 'date' from the end
fruits.shift(); // Removes 'apricot' from the beginning

// Finding elements
const index = fruits.indexOf("banana"); // Returns index of 'banana'
const found = fruits.includes("cherry"); // Returns true if 'cherry' is in the array

// Iterating over elements
fruits.forEach((fruit) => console.log(fruit)); // Logs each fruit

// Transforming elements
const upperFruits = fruits.map((fruit) => fruit.toUpperCase()); // ['APPLE', 'BANANA', 'CHERRY']

// Filtering elements
const longFruits = fruits.filter((fruit) => fruit.length > 5); // ['banana', 'cherry']

// Reducing elements
const totalLength = fruits.reduce((acc, fruit) => acc + fruit.length, 0); // Total length of all fruit names

// Sorting elements
const sortedFruits = fruits.slice().sort(); // Returns a new sorted array

/* Iteration */
for (const fruit of fruits) {
  console.log(fruit);
}

// Using spread operator
const muchMoreFruits = [...fruits, "elderberry"];

// Using destructuring
const [first, second, ...rest] = fruits; // first = 'apple', second = 'banana', rest = ['cherry']

// Multidimensional Arrays (arrays of arrays)
const matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

console.log(matrix[1][2]); // 6
