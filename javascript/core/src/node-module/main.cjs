// This is a CommonJS module that exports some utility functions and a constant
// It can be imported in other files using require

/*
    The .cjs file extension stands for CommonJS module and is used in Node.js
    to explicitly declare that the file should be interpreted using the CommonJS module system,
    even if "type": "module" is set in package.json

    The .mjs file extension is used for ECMAScript modules (ESM) in Node.js.
    This allows developers to use both CommonJS and ESM in the same project without conflicts.
*/

// Import the module using require
const mathUtils = require("./math-utils.cjs");

console.log(mathUtils.add(2, 3)); // 5
console.log(mathUtils.multiply(4, 5)); // 20
console.log(mathUtils.PI); // 3.14159
