
// each module is singleton by default
// if need multiple instances, use a class or factory function
// counter.js module
let count = 0;
export let description = 'Counter module for incrementing a count value';

export function increment() {
  count++;
  return count;
}
