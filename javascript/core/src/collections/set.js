// Set is a collection of unique values, similar to arrays but without duplicates.
// It is useful for storing unique items and performing set operations like union, intersection, and difference.

const mySet = new Set();

const numbers = new Set([1, 2, 3, 3, 2]);
console.log(numbers); // Set(3) {1, 2, 3} - duplicates automatically removed

const mixedSet = new Set([1, '1', 1]);
console.log(mixedSet); // Set(2) {1, "1"} - number 1 and string "1" are different

/*  Common Array Methods */
// Adding elements
mySet.add(1); // Adds 1 to the set

// removing elements
mySet.delete(1); // Removes 1 from the set

// Checking existence
mySet.has(1); // Returns true if 1 is in the set

mySet.clear(); // Removes all elements from the set

mySet.size; // Returns the number of elements in the set

mySet.forEach(value => {
  console.log(value); // Logs each value in the set
})

for (const letter of numbers) {
  console.log(letter);
}

// Using spread operator to convert Set to Array
const lettersArray = [...numbers];
console.log(lettersArray);  // [1, 2, 3]
