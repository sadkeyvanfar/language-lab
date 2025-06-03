DB = sqlite3
DB_FILE = test.db

.PHONY: init seed test clean

init:
	$(DB) $(DB_FILE) < schema/init.sql

seed:
	$(DB) $(DB_FILE) < data/seed.sql

migrate:
	for f in migrations/*.sql; do $(DB) $(DB_FILE) < $$f; done

test: init seed migrate
	$(DB) $(DB_FILE) < tests/test_constraints.sql

clean:
	rm -f $(DB_FILE)
