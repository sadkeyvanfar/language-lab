// This code demonstrates the use of different primitive types in JavaScript
"use strict"; // all this code will run in strict mode

// strings can be defined using single quotes, double quotes, or backticks (template literals)
var str = "Hello, World!";
var str = "Hello, World!";

// Template literals allow for string interpolation and multi-line strings
var nam = "Saeid keyvanfar";
var str = `Hello, ${nam}!`;

// JavaScript has a single number type, which can represent both integers and floating-point numbers
var num = 42; // Numbers in JavaScript are always floating-point, even if they look like integers
var num2 = 3.14; // This is also a number, just a floating-point one

var bool = true; // Boolean values can be true or false

// undefined is a special value that indicates a variable has not been assigned a value, should not be preferred over null
var undef = undefined;
var nul = null; // null is a special value that represents "no value"
var sym = Symbol("unique"); // Symbol is a new primitive type introduced in ES6
var bigInt = BigInt(1234567890123456789012345678901234567890); // BigInt is a new primitive type for large integers

console.log("String:", str, "type:", typeof str); // "string"
console.log("Number:", num, "type:", typeof num); // "number"
console.log("Boolean:", bool, "type:", typeof bool); // "boolean"
console.log("Undefined:", undef, "type:", typeof undef); // "undefined"
console.log("Null:", nul, "type:", typeof nul); // "object" -- this is a known bug in JavaScript
console.log("Symbol:", sym, "type:", typeof sym); // "symbol"
console.log("BigInt:", bigInt, "type:", typeof bigInt); // "bigint"
