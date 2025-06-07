// Memoization is an optimization technique that stores the results of expensive function calls
// and returns the cached result when the same inputs occur again.
// This can significantly speed up programs that perform repeated calculations with the same inputs.
// JavaScript’s features make it easy to implement:
// First-class functions (functions as values)
// Closures (to preserve the cache)
// Objects or Maps (for fast key-based lookup)

// with not memoization
function slowSquare(n) {
  console.log('Calculating...');
  return n * n;
}

console.log(slowSquare(5)); // Calculating... -> 25
console.log(slowSquare(5)); // Calculating... -> 25 (again, not cached)

// with memoization

function memoize(fn) {
  const cache = {};

  return function(...args) {
    const key = JSON.stringify(args);
    if (cache[key]) {
      return cache[key];
    } else {
      const result = fn(...args);
      cache[key] = result;
      return result;
    }
  };
}

const fastSquare = memoize(slowSquare);

console.log(fastSquare(5)); // Calculating... -> 25
console.log(fastSquare(5)); // (from cache) -> 25
