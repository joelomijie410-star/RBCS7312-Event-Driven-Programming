# RBCS7312 — Event-Driven Programming Portfolio

**Author: Joel Omijie**  
**Course:** RBCS7312 · September–December 2026

This repository is Joel Omijie’s weekly portfolio for the event-driven programming course. It is arranged as learning modules that pair the weekly assignment concepts with implementation/code, reflection prompts, and practical considerations. The goal is to show the progression from event sources and listeners to reactive JavaFX interfaces and asynchronous application architecture.

## Portfolio guide

Event-driven programs register reactions to events instead of imposing one fixed execution sequence. A source (button, key, timer, sensor) produces an event; a handler/listener reacts; the model changes; and the view reflects that change. Swing work must run on the Event Dispatch Thread (EDT), JavaFX UI changes on the JavaFX Application Thread, and slow I/O on background workers. The Observer pattern supports loosely coupled notifications, while properties/bindings support observable state in JavaFX.

Each `modules/weekNN/README.md` includes the week’s outcomes, activity evidence, implementation links, a reflection, and considerations/limitations. Runnable examples live beside the module notes where practical; the larger JavaFX modules live under `src/main/java/com/university/modules/` so they share the Maven dependency setup.

| Module | Focus | Implementation |
|---|---|---|
| [Week 1](modules/week01/README.md) | Event sources, event loop, procedural vs event-driven design | [EventDrivenCalculator.java](modules/week01/EventDrivenCalculator.java) |
| [Week 2](modules/week02/README.md) | Observer pattern and notification mechanisms | [WeatherStation.java](modules/week02/WeatherStation.java) |
| [Week 3](modules/week03/README.md) | Swing windows, components, layouts, EDT | [StudentPortal.java](modules/week03/StudentPortal.java) |
| [Week 4](modules/week04/README.md) | Action/item/document listeners, input and validation | [Counter.java](modules/week04/Counter.java) |
| [Week 5](modules/week05/README.md) | Lists, tables, trees, menus, dialogs, renderers | [FileManagerMockup.java](modules/week05/FileManagerMockup.java) |
| [Week 6](modules/week06/README.md) | JavaFX Stage/Scene, layouts, FXML and controller | [LayoutsDemo.java](src/main/java/com/university/modules/week06/LayoutsDemo.java), [FXMLLoginDemo.java](src/main/java/com/university/modules/week06/FxmlLoginDemo.java) |
| [Week 7](modules/week07/README.md) | Filters/handlers, mouse/key, drag and drop, custom event | [EventHandlingDemo.java](src/main/java/com/university/modules/week07/EventHandlingDemo.java) |
| [Week 8](modules/week08/README.md) | Observable properties, listeners, bindings, reactive form | [ReactiveFormDemo.java](src/main/java/com/university/modules/week08/ReactiveFormDemo.java) |
| [Week 9](modules/week09/README.md) | Task, progress, background work and UI-thread safety | [AsyncTaskDemo.java](src/main/java/com/university/modules/week09/AsyncTaskDemo.java) |
| [Week 10](modules/week10/README.md) | Event-driven architecture and university-system capstone | [App.java](src/main/java/com/university/App.java) |

The course pack included two Week 6 IDE variants; they are consolidated into one JavaFX/Maven implementation. The Week 1–2 paper/design activities are represented by written responses in their module notes. Each weekly README distinguishes runnable implementation from conceptual discussion and calls out anything not backed by a live integration test.

## Build and run

Requirements: JDK 17 or newer and Maven. Compile the complete JavaFX project:

```bash
mvn clean package
```

Run the capstone (requires MySQL for real student records):

```bash
export RBCS_DB_URL='jdbc:mysql://localhost:3306/university_db?serverTimezone=UTC'
export RBCS_DB_USER='root'
export RBCS_DB_PASSWORD='your-local-password'
mvn javafx:run
```

Initialize the schema with [`db/schema.sql`](db/schema.sql). Do not commit database credentials or real student information. Database integration was not exercised without a configured MySQL instance.

Run a JavaFX weekly module by overriding the configured main class, for example:

```bash
mvn javafx:run -Dapp.mainClass=com.university.modules.week07.EventHandlingDemo
```

Other main classes include `com.university.modules.week06.LayoutsDemo`, `com.university.modules.week06.FxmlLoginDemo`, `com.university.modules.week08.ReactiveFormDemo`, and `com.university.modules.week09.AsyncTaskDemo`. Swing activity examples can be compiled from their respective `modules/weekNN` folders with `javac FileName.java`; use a desktop environment to open the windows.

## Portfolio integrity

A successful compile verifies that source code builds; it does not prove every GUI path or database integration was exercised. The notes explicitly mark mockups and environment-dependent behaviors. Reflections are prompts to help Joel explain design decisions and further develop the work rather than claims of external assessment or instructor approval.
