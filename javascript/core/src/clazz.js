// This code demonstrates the use of classes in JavaScript, including inheritance and polymorphism.
// ES6 introduced classes as syntactical sugar over JavaScript's existing prototype-based inheritance.
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  greet() {
    return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
  }
}

// inheritance
class Student extends Person {
  constructor(name, age, grade) {
    super(name, age);
    this.grade = grade;
  }

  study() {
    return `${this.name} is studying for grade ${this.grade}.`;
  }
}

class Teacher extends Person {
  constructor(name, age, subject) {
    super(name, age);
    this.subject = subject;
  }

  teach() {
    return `${this.name} is teaching ${this.subject}.`;
  }
}

const person = new Person("Alice", 30);
const student = new Student("Bob", 20, "10th");
const teacher = new Teacher("Charlie", 40, "Mathematics");

// polymorphism
console.log(person.greet());
console.log(student.greet());
console.log(teacher.greet());

// javascript do not support overloading, but we can achieve similar behavior using default parameters
function greet(person, greeting = "Hello") {
  return `${greeting}, my name is ${person.name}.`;
}
