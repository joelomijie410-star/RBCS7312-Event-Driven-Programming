# Week 1 — Event-driven programming

## Activity 1: Spot the components

| Example | Event source | Event | Handler / response |
|---|---|---|---|
| ATM | keypad/card reader | PIN submitted | validate PIN, show menu or error |
| Microwave | keypad/door sensor | time entered / door opened | update timer / pause heating |
| Traffic signal | timer/vehicle sensor | timeout / vehicle detected | transition signal state |
| Web form | Submit button | click | validate fields, send request |
| Phone | touch screen | tap/swipe | dispatch gesture to active view |
| Thermostat | temperature sensor | threshold crossing | turn heating on/off |
| Smoke alarm | smoke sensor | smoke threshold crossed | sound alarm and notify |
| Music player | play/pause control | click/key | start/stop playback |

The source detects the action; the event carries context; the listener/handler decides the response. Keep input detection separate from application logic.

## Activity 2: Build the event loop

A GUI loop repeatedly waits for queued events, removes the next event, dispatches it to registered listeners, and returns to waiting. If a handler blocks, later events remain queued: controls stop repainting and the UI appears frozen. Handlers should finish quickly and delegate long work to a worker thread.

## Activity 3: Procedural vs event-driven

A procedural calculator prompts for all operands and operations in a fixed order. An event-driven calculator remains open; number/operator buttons change state, and `=` evaluates when the user chooses. The latter lets users determine the interaction order and requires explicit state (current input, pending operator, previous value).

Run `javac EventDrivenCalculator.java && java EventDrivenCalculator` in a graphical desktop to see the button-based version.

## Activity 4: Debug the event handler

Repair checklist: register the listener on the actual source; do not call the handler while registering it; update Swing components only on the EDT; do not sleep or perform network/database work in a listener; handle invalid input and division by zero; avoid stale mutable state by clearing/resetting after completion.

## Activity 5: Design a system — library checkout

Sources: barcode scanner, search field, checkout/return buttons, due-date timer. Events: book scanned, query submitted, checkout requested, return requested, overdue timer. Handlers validate member status and availability, then update the catalogue and show a result. The catalogue is the model; the screen is a view. Database writes run off the UI thread. Observer subscribers can update inventory count, activity log, and overdue notifications independently.

## Activity 6: Self-assessment

1. EDP reacts to events rather than imposing one fixed sequence. 2. Event sources emit events; listeners handle them. 3. A blocking handler prevents the UI loop from processing further work. 4. Use a background worker for slow I/O and marshal results back to the UI thread. 5. State machines make valid transitions explicit.