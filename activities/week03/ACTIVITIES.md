# Week 3 — Swing GUI construction

## Activity 1: First window
A `JFrame` is the top-level window. Create/show it on the EDT with `SwingUtilities.invokeLater`, select a close operation, set size or pack, and show it only after components are installed.

## Activity 2: Component showcase
The Student Portal example below demonstrates labels, text fields, buttons, combo box, table and status bar. Other commonly used controls include `JCheckBox`, `JRadioButton`, `JList`, `JTree`, `JTabbedPane`, `JMenuBar`, and `JScrollPane`.

## Activity 3: Layout managers
`BorderLayout` divides a window into regions; `FlowLayout` lays out controls in sequence; `GridLayout` makes uniform cells; `GridBagLayout` supports flexible forms. Prefer nested panels/layouts over absolute coordinates so resizing and accessibility remain useful.

## Activity 4: EDT rule
Swing components are not generally thread-safe. Initialize/change them on the EDT. Never put `Thread.sleep`, JDBC, network calls, or heavy computation in an action handler. Use `SwingWorker` for longer work and update the UI in `done()` / `process()`.

## Activity 5: Static student portal mockup
See `StudentPortal.java`. It combines a header, search controls, student table, and status/footer; table is intentionally a mockup. Validate user input before any persistence layer is added.

## Self-check
`invokeLater` queues GUI initialization on AWT-EventQueue. `pack()` sizes around preferred component sizes. A layout manager adapts when the window is resized. A scroll pane provides scrolling for a table/list. UI freeze means the EDT is occupied.
