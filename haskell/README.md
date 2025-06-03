# Haskell Module – Language Lab

This is a simple, structured Haskell project designed for experimentation and learning as part of the **language-lab** repository.

## Setup

## Prerequisites

- [Haskell Stack](https://docs.haskellstack.org/en/stable/README/)
- Optionally, [GHCup](https://www.haskell.org/ghcup/) to manage Haskell tools.

Install via Homebrew:

```bash
brew install haskell-stack
```

## Build & Run
Initialize project if not yet done
```bash
stack init
```

Build the project
```bash
stack build
```

Run the main application
```bash
stack run
```

## Running Tests
```bash
stack test
```

## Configuration
config/settings.yaml

## Dependencies
Dependencies are managed in package.yaml and compiled to haskell.cabal via hpack.
