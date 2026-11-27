# Week 10 — University Management System capstone

## Architecture and learning outcome mapping

- **EDA:** controls produce events; the view handles them; the database layer is isolated in `Database`; JavaFX observable properties drive table display.
- **Producer/consumer:** save/load requests use JavaFX `Task`s and run JDBC work away from the UI thread. Completion/failure callbacks update status and refresh the observable list.
- **Scheduled work:** a `ScheduledExecutorService` emits a heartbeat every five seconds. UI changes are posted with `Platform.runLater`; `stop()` shuts the scheduler down.
- **Event communication:** button listeners, property binding and table observation avoid coupling view widgets directly to SQL implementation.

## Implementation

- Schema and sample degree programs: `db/schema.sql`.
- Observable model: `src/main/java/com/university/Student.java`.
- JDBC repository: `Database.java`; prepared statements and environment-based credentials.
- JavaFX UI/application: `App.java`; student form, validation, table, asynchronous save/load, refresh, heartbeat.
- Build: `pom.xml` with JavaFX and MySQL Connector/J.

## Verification and known constraints

Maven package compilation is checked in this environment. Runtime CRUD needs MySQL 8+, schema setup, local credentials and a graphical session; none of those were supplied, so live database integration is not claimed. `program_id` is nullable because the guided capstone form does not collect a program; an extension should add a program selector and persist its selected foreign key. Passwords are not committed.
