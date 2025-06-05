import { describe, it, expect } from 'vitest';
import { greet } from './index';

describe('greet', () => {
  it('greets a person', () => {
    expect(greet('Ada')).toBe('Hello, Ada!');
  });
});
