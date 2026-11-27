# Week 2 — Observer pattern and notifications

## Activity 1: Weather station
`WeatherStation.java` has a subject that stores observers, a weather reading, and three independent displays. Register/unregister controls subscription; update sends a snapshot of temperature/humidity/pressure. This avoids the subject depending on specific display classes.

## Activity 2: Legacy `Observable` / `Observer`
The JDK legacy API is deprecated because `Observable` is a concrete class (single inheritance), notification is not strongly typed, and callers can expose mutable implementation details. Prefer a small typed interface, JavaBeans `PropertyChangeSupport`, or JavaFX properties depending on the application.

## Activity 3: Refactor tight coupling
Replace direct calls such as `dashboard.refresh(); logger.write(); alert.send()` in the data provider with `Subject.addObserver(...)` and a `WeatherObserver.update(Reading)` interface. Add/removing a consumer no longer edits the data source. Each observer should remain small and handle its own failure.

## Activity 4: Compare mechanisms

| Mechanism | Best fit | Limitation |
|---|---|---|
| Custom Observer | Plain Java domain events | Must define lifecycle/thread policy |
| `java.util.Observable` | Legacy maintenance only | Deprecated, weakly typed, inheritance constraint |
| `PropertyChangeListener` | JavaBeans old/new property values | General property names are strings |
| JavaFX properties/bindings | JavaFX UI/model reactive updates | UI framework-specific |

## Activity 5: Self-check
The subject owns subscription state; observers own their reactions. A publisher should notify from a stable snapshot if callbacks may change subscriptions. Avoid invoking arbitrary observers while holding a lock. Use JavaFX bindings for values displayed in JavaFX; use domain events for business events such as `StudentRegistered`.
