// ES modules allow you to export and import code between files, making it easier to manage dependencies and organize code.
// each file is modular and can export functions, objects, or primitives.
// ES module is alternative to CommonJS, which is used in Node.js.

// main.js module
import { increment, description } from './counter.js';

console.log(increment()); // 1
console.log(description); // Counter module for incrementing a count value
