# Week 09 — JavaFX asynchronous work

1. **Freeze demonstration:** running `Thread.sleep` or slow I/O inside an action handler blocks the JavaFX Application Thread, preventing input, layout, and repaint. That intentional anti-pattern is explained here rather than included as a program that encourages freezing.
2. **Task:** subclass `Task<V>` and put blocking computation in `call()`. Start it on a worker thread; attach success/failure handlers on the FX thread. UI controls must never be changed from `call()`.
3. **Progress:** call `updateProgress(done,total)` and `updateMessage(...)` from `call()`, then bind a progress bar and label to task properties.
4. **Service:** use `Service<V>` when a reusable/restartable Task factory is needed. A Task instance runs once; a Service creates fresh tasks for repeated jobs.

In the capstone, both loading and inserting students run in `Task`s. SQL is executed inside `call()`; results are applied in success handlers. The five-second heartbeat is scheduled on a daemon executor and marshalled to the UI with `Platform.runLater`. The executor shuts down when the stage closes.

## Code implementation

Primary implementation: [`src/main/java/com/university/modules/week09/AsyncTaskDemo.java`](../../src/main/java/com/university/modules/week09/AsyncTaskDemo.java).

## Reflection

What symptoms would a blocking call produce on the FX thread? Which Task properties can safely drive UI feedback?

## Considerations

Task is single-use; use Service to create repeatable tasks. Cancel work on shutdown where appropriate and never manipulate scene graph nodes directly from call().
