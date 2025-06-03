# SQL Project (language-lab)

This project contains SQL examples including schema definitions, seed data, queries, and test scripts.

## Structure

- `schema/`: DDL files for creating tables and other DB objects
- `data/`: DML scripts to seed initial data
- `queries/`: Useful SQL queries
- `migrations/`: Versioned migration scripts
- `tests/`: SQL scripts to verify schema and constraints
- `config/`: Optional DB configuration and environment files

## Running Locally

You can use Docker or SQLite for local testing. Example for SQLite:

```bash
sqlite3 test.db < schema/init.sql
sqlite3 test.db < data/seed.sql
sqlite3 test.db < queries/report_queries.sql
```

or

```sh
make init        # Initialize database schema
make seed        # Populate test data
make migrate     # Apply migrations
make test        # Run constraint checks
make clean       # Remove the SQLite database
```

## Migrations

You can use a tool like Flyway or Liquibase for managing migrations.

## Testing

Include test cases in tests/, and you can run them manually or automate using Makefile.
