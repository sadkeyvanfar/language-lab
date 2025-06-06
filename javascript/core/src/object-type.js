"use strict";

// Objects in JavaScript can be of various types, including arrays and functions

var book = {
    title: "JS",
    isbn: "978-0596805524",
    tags: [ "JavaScript", "Programming", "Web Development" ],
    read: function() {
        return "Reading the book: " + this.title;
    }
}

console.log("Book title:", book.title); // Accessing properties of an object
console.log("Book first tag:", book.tags[0]); // Accessing elements in an array property of an object

var arr = [1, 2, 3];
console.log("Array length:", arr.length); // Arrays are also objects, and have a length property
console.log("Array first element:", arr[0]); // Accessing elements in an array

// Functions are first-class objects in JavaScript

// function declaration
function decFunc() {
    return "This is a declaration function";
}

// function expression
var expFunc = function() {
    return "This is a expression function";
};

// Arrow function expression
var arrowFunc = () => "This is an arrow expression function"; // Arrow functions are a concise syntax for writing functions

console.log("Object:", book, "type", typeof book);
console.log("Array:", arr, "type", typeof arr);
console.log("decFunc:", decFunc(), "type", typeof decFunc);
console.log("expFunc:", expFunc(), "type", typeof expFunc);
console.log("arrowFunc:", arrowFunc(), "type", typeof arrowFunc);
