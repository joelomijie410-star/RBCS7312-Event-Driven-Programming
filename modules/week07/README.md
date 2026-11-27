# Week 07 — JavaFX event handling

1. **Filters vs handlers:** capturing filters run from the root toward the target and can consume/prevent an event; bubbling handlers run from the target toward ancestors. Use a filter for cross-cutting interception and a handler for normal control behavior.
2. **Mouse and key:** mouse events expose coordinates/button state; key events are delivered to the focused node. Prefer key combinations through scene accelerators for global commands.
3. **Drag and drop:** start a drag from `setOnDragDetected`, write a typed/string payload to the `Dragboard`, accept supported transfer modes in `setOnDragOver`, then validate/extract and mark completion in `setOnDragDropped`. Always report whether the drop actually succeeded.
4. **Custom events:** define an `EventType`, custom event payload, and fire it on a node; subscribers listen by event type. This reduces direct dependency between components.

The Week 10 app applies the event-handling principles to form actions and view refresh; custom drag/drop is a separate GUI exercise and is not misrepresented as part of the database capstone.

## Code implementation

Primary implementation: [`src/main/java/com/university/modules/week07/EventHandlingDemo.java`](../../src/main/java/com/university/modules/week07/EventHandlingDemo.java).

## Reflection

What does consuming an event in the capture phase prevent? Why must a drop target validate payload before reporting success?

## Considerations

The example handles string drag payloads only. Keyboard events require focus; custom event types should be namespaced and carry immutable data.
