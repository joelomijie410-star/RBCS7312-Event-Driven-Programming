# Week 5 — Advanced Swing components

## Activity 1: JList and custom renderer
Use `JList` for one-dimensional selectable data; a custom `ListCellRenderer` maps a model item to a component. Renderers are reused, so set every visual property on each invocation (including selected/focus colors) to prevent stale styling.

## Activity 2: JTable
`JTable` displays a `TableModel`; provide explicit column classes/editability for production. Sort with `TableRowSorter`. Convert view row indices to model indices before editing model records after sorting.

## Activity 3: JTree and tabs
`JTree` represents hierarchy via tree nodes; `JTabbedPane` separates related views. Keep file-system operations separate from tree rendering; avoid representing a whole disk by recursively loading every item at startup.

## Activity 4: Menus, toolbars, dialogs
Menus/toolbars should invoke the same `Action` where possible so enabled state, label and shortcut remain consistent. Use `JFileChooser` for open/save; confirm destructive operations with a dialog. The file manager mockup below illustrates the tree/table composition.

## Activity 5: File manager capstone
`FileManagerMockup.java` has a navigation tree, file table, menu and toolbar. It is an interface demonstration, not an operating-system file manager; file operations are intentionally not executed. This is safer than presenting a mock UI as destructive functional behavior.
