use rust_project::greet;

#[test]
fn test_greet() {
    assert_eq!(greet("Rust"), "Hello, Rust!");
}
