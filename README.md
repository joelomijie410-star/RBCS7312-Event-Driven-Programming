# RBCS7312 — Event-Driven Programming Portfolio

**Author: Joel Omijie**

This repository is a worked portfolio for the supplied RBCS7312 Sep–Dec 2026 course pack. It turns the course’s concepts into a progression of activities and finishes with a JavaFX University Management System. It is intended as a learning aid: read the explanations, run each activity, and be ready to explain/modify the work yourself.

## Understand the course

Event-driven programming reverses the control flow of a simple script. The program registers listeners; the runtime waits for events (clicks, key presses, data changes, timers), dispatches each event to a handler, and the handler updates state or asks another component to do work. A sound design separates the event source, event object, listener/handler, and work being performed. GUI work must happen on the UI thread (Swing EDT / JavaFX Application Thread); slow I/O belongs on background workers.

The course sequence is: Week 1 event concepts and event loops; Week 2 Observer/custom notification; Week 3 Swing windows, components, layouts and EDT; Week 4 Swing listeners/forms/input; Week 5 lists, tables, trees, renderers, menus/dialogs; Week 6 JavaFX stages/layouts/FXML; Week 7 event propagation, mouse/key, drag-and-drop and custom events; Week 8 observable properties/listeners/bindings; Week 9 Task/Service and progress; Week 10 architecture, database work and scheduled tasks.

## Activities and where to find the work

| Course section | Completed evidence |
|---|---|
| Week 1 — identify event sources/handlers, event-loop reasoning, procedural vs event-driven, repair exercise, design and self-assessment | [`activities/week01/ACTIVITIES.md`](activities/week01/ACTIVITIES.md) and [`activities/week01/EventDrivenCalculator.java`](activities/week01/EventDrivenCalculator.java) |
| Week 2 — custom Observer, legacy Observer discussion, refactor, compare mechanisms | [`activities/week02/ACTIVITIES.md`](activities/week02/ACTIVITIES.md), [`WeatherStation.java`](activities/week02/WeatherStation.java) |
| Week 3 — Swing frame, controls, layouts, EDT, student portal mockup | [`activities/week03/ACTIVITIES.md`](activities/week03/ACTIVITIES.md), [`StudentPortal.java`](activities/week03/StudentPortal.java) |
| Week 4 — listeners, form validation, counter, mouse/key interactions | [`activities/week04/ACTIVITIES.md`](activities/week04/ACTIVITIES.md), [`Counter.java`](activities/week04/Counter.java) |
| Week 5 — renderers, JTable, tree/tabs, menus/toolbars/dialogs/file manager | [`activities/week05/ACTIVITIES.md`](activities/week05/ACTIVITIES.md), [`FileManagerMockup.java`](activities/week05/FileManagerMockup.java) |
| Week 6 — JavaFX window/layouts/FXML/dashboard | [`activities/week06/ACTIVITIES.md`](activities/week06/ACTIVITIES.md) |
| Week 7 — filters/handlers, mouse/key, drag-drop, custom events | [`activities/week07/ACTIVITIES.md`](activities/week07/ACTIVITIES.md) |
| Week 8 — observable model, listeners, bindings, reactive form | [`activities/week08/ACTIVITIES.md`](activities/week08/ACTIVITIES.md) |
| Week 9 — blocking vs background, Task/progress/Service | [`activities/week09/ACTIVITIES.md`](activities/week09/ACTIVITIES.md) |
| Week 10 — University Management System capstone | [`activities/week10/ACTIVITIES.md`](activities/week10/ACTIVITIES.md) and runnable application in `src/main/java/com/university/` |

The Week 6 pack contains both NetBeans and VS Code editions of substantially the same exercise; this portfolio consolidates them rather than duplicating deliverables. The Week 1 and Week 2 paper/design activities are answered as written evidence rather than falsely represented as code. Week 3–9 written prompts/check questions are summarized with answers in each weekly activity file.

## Run the capstone

Requirements: JDK 17+, Maven, MySQL 8+, and a graphical desktop session. Create tables with `db/schema.sql`, then configure credentials as environment variables (do not commit passwords):

```bash
export RBCS_DB_URL='jdbc:mysql://localhost:3306/university_db?serverTimezone=UTC'
export RBCS_DB_USER='root'
export RBCS_DB_PASSWORD='your-local-password'
mvn clean javafx:run
```

The UI starts even if MySQL is not available; database errors are shown in the status area. Saving/loading are JavaFX `Task`s on background threads, and the scheduler updates the status every five seconds on the JavaFX thread. The form binds button availability to all required fields and validates email before inserting. `Database` uses prepared statements and reads secrets only from the process environment.

## Validate and learn

```bash
mvn -q -DskipTests package
```

A database integration check requires a local MySQL instance and credentials, which are intentionally not included. See each activity note for its concept, answer, and limitations. Avoid pasting passwords or personal student records into commits.
