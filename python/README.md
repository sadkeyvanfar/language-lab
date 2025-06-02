# Python Language Samples

This directory contains sample programs written in the Python programming language.

## Prerequisites

- Python 3.8+
- `pip` package manager

## Setup

Install development dependencies (from project root):

```bash
pip install -e ".[dev]"
```
Install pre-commit git hooks:

```bash
pre-commit install
```

## Build

Build source and wheel distributions:

```bash
python -m build
```

Artifacts will be created under dist/.

## Clean

Remove build artifacts:

```bash
rm -rf build dist *.egg-info
```

## Test

Run tests with coverage:

```bash
pytest
```

## Formatting & Linting

Format code with Black:

```bash
black .
```

Sort imports with isort:

```bash
isort .
```

Check code style with flake8:

```bash
flake8 .
```

Static type checking with mypy:

```bash
mypy core
```

Git Hooks

The project uses pre-commit to run checks automatically on commit.

To manually run all pre-commit hooks against all files:

```bash
pre-commit run --all-files
```
