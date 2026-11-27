# Week 6 — JavaFX foundations

The two provided guides cover equivalent exercises; the VS Code/Maven path is the portable reference.

1. **Programmatic window:** create an `Application`, override `start(Stage)`, add nodes to a layout, place it in a `Scene`, then show the stage. JavaFX calls `start` on the JavaFX Application Thread.
2. **Layouts:** use `VBox`/`HBox` for linear arrangements, `GridPane` for forms, and `BorderPane` for top/left/center/bottom page structure. Let layout managers compute geometry rather than absolute positioning.
3–4. **FXML/controller:** FXML describes nodes; `fx:controller` names the controller and `fx:id`/`@FXML` connect fields. Load via `FXMLLoader`; handlers should be short and UI work remain on the FX thread. Keep view markup separate from behavior.
5. **Dashboard capstone:** a dashboard combines header/navigation, summary cards and a content area. In this portfolio the larger University Management System supersedes a separate static dashboard, while preserving layout/card design principles.

Self-check: Stage is the top-level window; Scene owns the scene graph; a Node is a UI element; FXML is declarative markup; controllers connect view events to behavior.
