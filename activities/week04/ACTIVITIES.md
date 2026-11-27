# Week 4 — Event listeners and interaction

## Activities 1–2: ActionListener styles
Buttons and menu items use `ActionListener`; it may be expressed as a named class (reusable), anonymous class (local), or lambda (concise). The listener receives an `ActionEvent`; `getSource()` identifies the component, while action commands can provide a stable semantic identifier.

## Activity 3: Item and document listeners
Checkboxes/radio buttons are naturally handled with `ItemListener`/`ActionListener`. Text-field document changes use `DocumentListener` for immediate feedback; do not mutate the same document inside its notification callback. A live character count is simply the document length.

## Activity 4: Counter app
`Counter.java` handles increment/decrement/reset, enforces a lower bound, and keeps display state in one place. Boundary checks belong in the model/handler rather than relying on disabled button appearance alone.

## Activity 5: Interactive form
A registration form should validate required fields and email, display actionable errors, clear values on reset, and ask before destructive exit. Validation is repeated at submit, even if live feedback already exists.

## Activity 6: Mouse and key interaction
Mouse position and drag are reported by `MouseMotionListener`; key events require focus and should be used only where key bindings are not more suitable. Swing `InputMap`/`ActionMap` are generally preferable for application shortcuts.
