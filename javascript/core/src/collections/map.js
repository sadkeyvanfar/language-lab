const myMap = new Map();

// Add entries
myMap.set('name', 'Alice');
myMap.set(42, 'Answer to everything');
myMap.set({ x: 1 }, 'Object key');

// Getting values, If the key doesn't exist, get returns undefined.
console.log(myMap.get('name')); // Alice
console.log(myMap.get(42));     // Answer to everything

// Iterating over entries
const roles = new Map([
  ['admin', 'Alice'],
  ['user', 'Bob'],
]);

/* Useful Methods */
// Add a new entry
roles.set('guest', 'Charlie'); // Adds a new entry with key 'guest' and value 'Charlie'
// Get an entry
console.log(roles.get('admin')); // Alice
// Check if a key exists
console.log(roles.has('admin')); // true
// Remove an entry
roles.delete('user'); // Removes the 'user' entry
// Clear all entries
roles.clear(); // Removes all entries
// Returns iterator of keys
const keys = roles.keys();
// Returns iterator of values
const values = roles.values();
// Returns iterator of entries (key-value pairs)
const entries = roles.entries();

// Iterating over keys
for (const [key, value] of roles) {
  console.log(`${key}: ${value}`);
}

// or
roles.forEach((value, key) => {
  console.log(`${key} => ${value}`);
});
