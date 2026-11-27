# Week 8 — Properties and bindings

1. **Observable model:** use `StringProperty`, `IntegerProperty`, etc. so views can observe a field; expose property getters for controls/table columns and ordinary getters for domain logic.
2. **Listeners:** `ChangeListener` receives old/new values; `InvalidationListener` reports that a value became invalid and can be more lazy. Remove listeners when their owner is disposed if they retain references.
3. **Unidirectional binding:** `view.textProperty().bind(model.nameProperty())` makes the view follow the model; the bound target is read-only from the target side.
4. **Bidirectional binding:** both values synchronize; use matching types or a converter for numeric text. Prevent inconsistent duplicate sources of truth.
5. **Reactive registration capstone:** the submit button in the University app binds `disableProperty` to emptiness of all required fields; email format is checked in the event handler before persistence.

The `Student` model uses JavaFX properties; TableView columns observe them directly. The model properties remain the canonical displayed state.
