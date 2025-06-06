// This code defines an iterable object `range` that generates numbers from `from` to `to`.
// The `Symbol.iterator` method returns an iterator that produces the numbers in the specified range.
// The `for...of` loop is used to iterate over the values produced by the iterator, logging each number to the console.
// define an iterable object with a custom iterator
const range = {
  from: 1,
  to: 3,
  [Symbol.iterator]() {
    let current = this.from;
    let end = this.to;

    return {
      next() {
        if (current <= end) {
          return { value: current++, done: false };
        } else {
          return { done: true };
        }
      }
    };
  }
};

// using the iterable object in a for...of loop
for (const num of range) {
  console.log(num); // 1, 2, 3
}

// converting the iterable object to an array
const numbers = [...range];
console.log(numbers); // [1, 2, 3]

// converting the iterable object to an array using Array.from
const list = Array.from(range);
console.log(list); // [1, 2, 3]
