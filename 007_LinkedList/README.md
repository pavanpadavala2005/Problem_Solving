# 🔗 007 — Linked List

<div align="center">
  <h3>Custom Node Models • Reusable Utilities • Daily DSA Practice</h3>
  <p>
    <code>Node</code> &nbsp;•&nbsp;
    <code>DNode</code> &nbsp;•&nbsp;
    <code>NlNode</code> &nbsp;•&nbsp;
    <code>MyNode</code>
  </p>
  <p><b>Java implementations from fundamentals to advanced Linked List problems</b></p>
</div>

> [!IMPORTANT] > **The Node Architecture is the heart of this folder.** Before exploring the daily problems, start with the four node models below. Each one has a different pointer design and a specific responsibility.

<div align="center">
  <a href="#node-architecture"><b>🧱 Node Architecture</b></a>
  &nbsp; • &nbsp;
  <a href="#core-infrastructure"><b>🧰 Core Infrastructure</b></a>
  &nbsp; • &nbsp;
  <a href="#practice-timeline"><b>📅 Practice Timeline</b></a>
  &nbsp; • &nbsp;
  <a href="#problem-index"><b>📊 Problem Index</b></a>
  &nbsp; • &nbsp;
  <a href="#progress"><b>📈 Progress</b></a>
</div>

---

<a id="node-architecture"></a>

# 🧱 Node Architecture — The Heart of This Folder

This folder intentionally uses multiple node classes. A singly linked list needs one directional link, a doubly linked list needs two directional links, and a multi-level list needs both horizontal and vertical connections.

## ✨ Architecture at a Glance

<div align="center">
<table>
  <tr>
    <td align="center" width="25%">
      <h3>🔵 <code>Node</code></h3>
      <b>Singly Linked List</b><br><br>
      <code>data │ next</code><br><br>
      One forward pointer
    </td>
    <td align="center" width="25%">
      <h3>🟣 <code>DNode</code></h3>
      <b>Doubly Linked List</b><br><br>
      <code>prev │ data │ next</code><br><br>
      Two directional pointers
    </td>
    <td align="center" width="25%">
      <h3>🟠 <code>NlNode</code></h3>
      <b>Multi-Level Linked List</b><br><br>
      <code>data │ next │ bottom</code><br><br>
      Horizontal and vertical pointers
    </td>
    <td align="center" width="25%">
      <h3>🟢 <code>MyNode</code></h3>
      <b>Learning Implementation</b><br><br>
      <code>data │ next</code><br><br>
      Independent practice model
    </td>
  </tr>
</table>
</div>

### 🎯 Choosing the Correct Node

| When the problem requires...             | Use      | Pointer Design    | Defined In                                               |
| ---------------------------------------- | -------- | ----------------- | -------------------------------------------------------- |
| Normal one-direction traversal           | `Node`   | `next`            | [`SinglyLinkedList.java`](./SinglyLinkedList.java)       |
| Forward and backward movement            | `DNode`  | `prev` + `next`   | [`DoublyLinkedList.java`](./DoublyLinkedList.java)       |
| Horizontal and child-level traversal     | `NlNode` | `next` + `bottom` | [`NonLinearLinkedList.java`](./NonLinearLinkedList.java) |
| A self-contained learning implementation | `MyNode` | `next`            | [`July16.java`](./July16.java)                           |

---

## 🔵 1. Singly Linked List Node — `Node`

> **Primary model:** Used by most problem-solving files in this folder.

`Node` stores one value and one reference to the next node. Traversal always moves forward from `HEAD` until `next` becomes `null`.

<div align="center">
<table>
  <tr>
    <td align="center"><b>HEAD</b></td>
    <td align="center">→</td>
    <td align="center"><b>Node 1</b><br><code>data │ next</code></td>
    <td align="center">→</td>
    <td align="center"><b>Node 2</b><br><code>data │ next</code></td>
    <td align="center">→</td>
    <td align="center"><b>Node 3</b><br><code>data │ next</code></td>
    <td align="center">→</td>
    <td align="center"><b>NULL</b></td>
  </tr>
</table>
</div>

### Java Node Structure

```java
class Node {
    int data;
    Node next;

    public Node() {
        this.data = Integer.MIN_VALUE;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
```

| Component           | Responsibility                                               |
| ------------------- | ------------------------------------------------------------ |
| `int data`          | Stores the value of the current node                         |
| `Node next`         | Stores the reference to the next node                        |
| `head`              | Holds the first node of the list                             |
| `next == null`      | Marks the end of the list                                    |
| Main implementation | [`SinglyLinkedList.java`](./SinglyLinkedList.java)           |
| Utility support     | [`SinglyLinkedListUtils.java`](./SinglyLinkedListUtils.java) |

**Used for:** reversal, middle node, cycle detection, palindrome checking, sorting, merging, arithmetic, intersection, and node-removal problems.

---

## 🟣 2. Doubly Linked List Node — `DNode`

> **Bidirectional model:** Every node knows both its previous and next node.

`DNode` supports forward and backward movement. The first node has no previous node, and the last node has no next node.

<div align="center">
<table>
  <tr>
    <td align="center"><b>NULL</b></td>
    <td align="center">←</td>
    <td align="center"><b>Node 1</b><br><code>prev │ data │ next</code></td>
    <td align="center">⇄</td>
    <td align="center"><b>Node 2</b><br><code>prev │ data │ next</code></td>
    <td align="center">⇄</td>
    <td align="center"><b>Node 3</b><br><code>prev │ data │ next</code></td>
    <td align="center">→</td>
    <td align="center"><b>NULL</b></td>
  </tr>
</table>
</div>

### Java Node Structure

```java
class DNode {
    DNode prev;
    int data;
    DNode next;

    public DNode() {
        this.prev = null;
        this.data = -1;
        this.next = null;
    }

    public DNode(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    public DNode(int data, DNode prev, DNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
```

| Component           | Responsibility                                               |
| ------------------- | ------------------------------------------------------------ |
| `DNode prev`        | Points to the previous node                                  |
| `int data`          | Stores the value of the current node                         |
| `DNode next`        | Points to the next node                                      |
| `head.prev == null` | Marks the beginning of the list                              |
| `tail.next == null` | Marks the end of the list                                    |
| Main implementation | [`DoublyLinkedList.java`](./DoublyLinkedList.java)           |
| Utility support     | [`DoublyLinkedListUtils.java`](./DoublyLinkedListUtils.java) |

**Used for:** bidirectional traversal, head/tail operations, position-based insertion and deletion, reversal, and target-sum pairs.

---

## 🟠 3. Non-Linear / Multi-Level Node — `NlNode`

> **Two-dimensional model:** `next` moves horizontally, while `bottom` moves vertically.

`NlNode` represents a multi-level Linked List. It is especially useful for flattening problems where several sorted child lists must become one sorted bottom-linked list.

<div align="center">
<table>
  <tr>
    <td align="center"><b>HEAD</b></td>
    <td align="center">→</td>
    <td align="center"><b>Top Node 1</b><br><code>data │ next │ bottom</code></td>
    <td align="center">→</td>
    <td align="center"><b>Top Node 2</b><br><code>data │ next │ bottom</code></td>
    <td align="center">→</td>
    <td align="center"><b>Top Node 3</b><br><code>data │ next │ bottom</code></td>
  </tr>
  <tr>
    <td></td><td></td>
    <td align="center">↓ <code>bottom</code></td>
    <td></td>
    <td align="center">↓ <code>bottom</code></td>
    <td></td>
    <td align="center">↓ <code>bottom</code></td>
  </tr>
  <tr>
    <td></td><td></td>
    <td align="center"><code>child node</code></td>
    <td></td>
    <td align="center"><code>child node</code></td>
    <td></td>
    <td align="center"><code>child node</code></td>
  </tr>
  <tr>
    <td></td><td></td>
    <td align="center">↓</td>
    <td></td>
    <td align="center">↓</td>
    <td></td>
    <td align="center">↓</td>
  </tr>
  <tr>
    <td></td><td></td>
    <td align="center"><b>NULL</b></td>
    <td></td>
    <td align="center"><b>NULL</b></td>
    <td></td>
    <td align="center"><b>NULL</b></td>
  </tr>
</table>
</div>

### Java Node Structure

```java
class NlNode {
    int data;
    NlNode next;
    NlNode bottom;

    NlNode(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}
```

| Component           | Responsibility                                                     |
| ------------------- | ------------------------------------------------------------------ |
| `int data`          | Stores the value of the current node                               |
| `NlNode next`       | Points to the next top-level node horizontally                     |
| `NlNode bottom`     | Points to the next child node vertically                           |
| Main use            | Building and flattening multi-level sorted Linked Lists            |
| Main implementation | [`NonLinearLinkedList.java`](./NonLinearLinkedList.java)           |
| Utility support     | [`NonLinearLinkedListUtils.java`](./NonLinearLinkedListUtils.java) |

**Used for:** creating bottom chains, visualizing multi-level structures, merging child lists, and flattening the complete structure.

---

## 🟢 4. Learning-Specific Singly Node — `MyNode`

> **Foundation model:** The original self-contained implementation created while learning Linked List fundamentals.

`MyNode` intentionally remains separate from the reusable `Node` model. This preserves the original learning journey while allowing later files to share the main `Node` implementation.

<div align="center">
<table>
  <tr>
    <td align="center"><b>MyLinkedList.head</b></td>
    <td align="center">→</td>
    <td align="center"><b>MyNode</b><br><code>data │ next</code></td>
    <td align="center">→</td>
    <td align="center"><b>MyNode</b><br><code>data │ next</code></td>
    <td align="center">→</td>
    <td align="center"><b>NULL</b></td>
  </tr>
</table>
</div>

### Java Node Structure

```java
class MyNode {
    int data;
    MyNode next;

    public MyNode(int data) {
        this.data = data;
        this.next = null;
    }
}
```

| Component     | Responsibility                                 |
| ------------- | ---------------------------------------------- |
| `int data`    | Stores the value of the current node           |
| `MyNode next` | Points to the next `MyNode`                    |
| Owning class  | `MyLinkedList`                                 |
| Purpose       | Independent practice of fundamental operations |
| Practice file | [`July16.java`](./July16.java)                 |

**Used for:** the first implementation of insertion, deletion, traversal, and list-management fundamentals.

---

## 🧭 How the Folder Works

<div align="center">
<table>
  <tr>
    <td align="center"><b>1. Node Model</b><br><code>Node / DNode / NlNode</code></td>
    <td align="center">→</td>
    <td align="center"><b>2. Core Structure</b><br><code>LinkedList classes</code></td>
    <td align="center">→</td>
    <td align="center"><b>3. Utilities</b><br><code>builder + helper methods</code></td>
    <td align="center">→</td>
    <td align="center"><b>4. Daily Solutions</b><br><code>date-based files</code></td>
    <td align="center">→</td>
    <td align="center"><b>5. Runner</b><br><code>Demo.java</code></td>
  </tr>
</table>
</div>

| Structure             | Owns                       | Utility Support                 | Main Responsibility                     |
| --------------------- | -------------------------- | ------------------------------- | --------------------------------------- |
| `SinglyLinkedList`    | `Node head`                | `SinglyLinkedListUtils`         | Most singly linked list problems        |
| `DoublyLinkedList`    | `DNode head`, `DNode tail` | `DoublyLinkedListUtils`         | Bidirectional operations and pair sum   |
| `NonLinearLinkedList` | `NlNode head`              | `NonLinearLinkedListUtils`      | Multi-level construction and flattening |
| `MyLinkedList`        | `MyNode head`              | Self-contained in `July16.java` | Initial implementation practice         |
| `Demo`                | Test data and method calls | Uses all applicable structures  | Common runner for daily testing         |

> [!NOTE]
> The node classes are package-private on purpose, allowing all Java files in this folder to reuse them without introducing additional public-class files.

---

<a id="core-infrastructure"></a>

# 🧰 Core Infrastructure

| File                                                               | Responsibility                                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------------------------- |
| [`SinglyLinkedList.java`](./SinglyLinkedList.java)                 | Defines `Node` and implements fundamental singly linked list operations               |
| [`SinglyLinkedListUtils.java`](./SinglyLinkedListUtils.java)       | Creates lists, finds nodes, reverses lists, creates cycles, and creates intersections |
| [`DoublyLinkedList.java`](./DoublyLinkedList.java)                 | Defines `DNode` and implements doubly linked list insertion, deletion, and traversal  |
| [`DoublyLinkedListUtils.java`](./DoublyLinkedListUtils.java)       | Builds DLLs, finds `DNode` objects, and converts a DLL to a list                      |
| [`NonLinearLinkedList.java`](./NonLinearLinkedList.java)           | Defines `NlNode` and builds the horizontal part of a multi-level list                 |
| [`NonLinearLinkedListUtils.java`](./NonLinearLinkedListUtils.java) | Builds bottom lists and converts non-linear structures into readable collections      |
| [`Demo.java`](./Demo.java)                                         | Common runner used to test the implementations and date-based solutions               |

> These seven files support the folder architecture and are not counted as solved problem entries.

---

## 🧭 Repository Overview

| Metric                    |                Value |
| ------------------------- | -------------------: |
| Java Files                |               **17** |
| Core Infrastructure Files |                **7** |
| Date-Based Practice Files |               **10** |
| Practice Entries          |               **25** |
| Period Covered            | **July–August 2026** |
| Language                  |             **Java** |

> Multiple approaches to the same problem inside one Java file are counted as one practice entry. Core node implementations, utility classes, and `Demo.java` are documented separately and are not counted as solved problems.

## 🏷️ Source Legend

| Label     | Platform                                                          |
| --------- | ----------------------------------------------------------------- |
| `LC`      | LeetCode                                                          |
| `GFG`     | GeeksforGeeks                                                     |
| `General` | Custom implementation, general practice, or no confirmed platform |

## 🧩 Topic Coverage

| Area                    | Problems Practiced                                                                   |
| ----------------------- | ------------------------------------------------------------------------------------ |
| Core Linked List Design | Custom nodes, insertion, deletion, traversal, and reusable utilities                 |
| Fast & Slow Pointers    | Middle node, cycle detection, loop length, and palindrome checking                   |
| Reversal                | Full reversal, recursive reversal, partial reversal, and doubly linked list reversal |
| Sorting & Merging       | Sort List, Merge Two Sorted Lists, and flattening a multi-level linked list          |
| Linked List Arithmetic  | Add Two Numbers, Add Two Numbers II, and Add 1 to a linked list number               |
| Node Relationships      | Intersection point, cycle starting node, and removal by node/position                |
| Doubly Linked Lists     | Core DLL operations and target-sum pairs                                             |
| Non-Linear Linked Lists | Horizontal `next` links, vertical `bottom` links, and flattening                     |

---

<a id="practice-timeline"></a>

# 📅 August 2026

## 🗓️ August 01 — `Aug01.java`

|   # | Problem                                         | Source | Solution                      |
| --: | ----------------------------------------------- | ------ | ----------------------------- |
|   1 | Remove Duplicates from Sorted List              | LC 83  | [View Solution](./Aug01.java) |
|   2 | Flattening a Linked List                        | GFG    | [View Solution](./Aug01.java) |
|   3 | Find Pairs with Given Sum in Doubly Linked List | GFG    | [View Solution](./Aug01.java) |

---

## 🗓️ August 03 — `Aug03.java`

|   # | Problem            | Source | Solution                      |
| --: | ------------------ | ------ | ----------------------------- |
|   4 | Add Two Numbers II | LC 445 | [View Solution](./Aug03.java) |

---

## 🗓️ August 05 — `Aug05.java`

|   # | Problem                                           | Source  | Solution                      |
| --: | ------------------------------------------------- | ------- | ----------------------------- |
|   5 | Convert Binary Number in a Linked List to Integer | LC 1290 | [View Solution](./Aug05.java) |
|   6 | Remove Linked List Elements                       | LC 203  | [View Solution](./Aug05.java) |

---

# 📅 July 2026

## 🗓️ July 16 — `July16.java`

|   # | Problem                               | Source  | Solution                       |
| --: | ------------------------------------- | ------- | ------------------------------ |
|   7 | Implement a Custom Singly Linked List | General | [View Solution](./July16.java) |

---

## 🗓️ July 21 — `July21.java`

|   # | Problem                      | Source | Solution                       |
| --: | ---------------------------- | ------ | ------------------------------ |
|   8 | Delete Node in a Linked List | LC 237 | [View Solution](./July21.java) |
|   9 | Middle of the Linked List    | LC 876 | [View Solution](./July21.java) |
|  10 | Reverse Linked List          | LC 206 | [View Solution](./July21.java) |

---

## 🗓️ July 22 — `July22.java`

|   # | Problem              | Source | Solution                       |
| --: | -------------------- | ------ | ------------------------------ |
|  11 | Linked List Cycle    | LC 141 | [View Solution](./July22.java) |
|  12 | Linked List Cycle II | LC 142 | [View Solution](./July22.java) |

---

## 🗓️ July 24 — `July24.java`

|   # | Problem                                   | Source  | Solution                       |
| --: | ----------------------------------------- | ------- | ------------------------------ |
|  13 | Odd Even Linked List                      | LC 328  | [View Solution](./July24.java) |
|  14 | Rearrange Array by Odd and Even Positions | General | [View Solution](./July24.java) |
|  15 | Find Length of Loop                       | GFG     | [View Solution](./July24.java) |
|  16 | Palindrome Linked List                    | LC 234  | [View Solution](./July24.java) |

---

## 🗓️ July 25 — `July25.java`

|   # | Problem                                 | Source  | Solution                       |
| --: | --------------------------------------- | ------- | ------------------------------ |
|  17 | Sort List                               | LC 148  | [View Solution](./July25.java) |
|  18 | Merge Two Sorted Lists                  | LC 21   | [View Solution](./July25.java) |
|  19 | Add Two Numbers                         | LC 2    | [View Solution](./July25.java) |
|  20 | Add 1 to a Linked List Number           | GFG     | [View Solution](./July25.java) |
|  21 | Intersection of Two Linked Lists        | LC 160  | [View Solution](./July25.java) |
|  22 | Delete the Middle Node of a Linked List | LC 2095 | [View Solution](./July25.java) |
|  23 | Remove Nth Node From End of List        | LC 19   | [View Solution](./July25.java) |

---

## 🗓️ July 29 — `July29.java`

|   # | Problem                      | Source | Solution                       |
| --: | ---------------------------- | ------ | ------------------------------ |
|  24 | Reverse a Doubly Linked List | GFG    | [View Solution](./July29.java) |

> The approaches in this file are currently preserved as commented practice code.

---

## 🗓️ July 30 — `July30.java`

|   # | Problem                | Source | Solution                       |
| --: | ---------------------- | ------ | ------------------------------ |
|  25 | Reverse Linked List II | LC 92  | [View Solution](./July30.java) |

---

<a id="problem-index"></a>

# 📊 Problem Index

|   # | Problem                                           | Source  | File                         |
| --: | ------------------------------------------------- | ------- | ---------------------------- |
|   1 | Remove Duplicates from Sorted List                | LC 83   | [Aug01.java](./Aug01.java)   |
|   2 | Flattening a Linked List                          | GFG     | [Aug01.java](./Aug01.java)   |
|   3 | Find Pairs with Given Sum in Doubly Linked List   | GFG     | [Aug01.java](./Aug01.java)   |
|   4 | Add Two Numbers II                                | LC 445  | [Aug03.java](./Aug03.java)   |
|   5 | Convert Binary Number in a Linked List to Integer | LC 1290 | [Aug05.java](./Aug05.java)   |
|   6 | Remove Linked List Elements                       | LC 203  | [Aug05.java](./Aug05.java)   |
|   7 | Implement a Custom Singly Linked List             | General | [July16.java](./July16.java) |
|   8 | Delete Node in a Linked List                      | LC 237  | [July21.java](./July21.java) |
|   9 | Middle of the Linked List                         | LC 876  | [July21.java](./July21.java) |
|  10 | Reverse Linked List                               | LC 206  | [July21.java](./July21.java) |
|  11 | Linked List Cycle                                 | LC 141  | [July22.java](./July22.java) |
|  12 | Linked List Cycle II                              | LC 142  | [July22.java](./July22.java) |
|  13 | Odd Even Linked List                              | LC 328  | [July24.java](./July24.java) |
|  14 | Rearrange Array by Odd and Even Positions         | General | [July24.java](./July24.java) |
|  15 | Find Length of Loop                               | GFG     | [July24.java](./July24.java) |
|  16 | Palindrome Linked List                            | LC 234  | [July24.java](./July24.java) |
|  17 | Sort List                                         | LC 148  | [July25.java](./July25.java) |
|  18 | Merge Two Sorted Lists                            | LC 21   | [July25.java](./July25.java) |
|  19 | Add Two Numbers                                   | LC 2    | [July25.java](./July25.java) |
|  20 | Add 1 to a Linked List Number                     | GFG     | [July25.java](./July25.java) |
|  21 | Intersection of Two Linked Lists                  | LC 160  | [July25.java](./July25.java) |
|  22 | Delete the Middle Node of a Linked List           | LC 2095 | [July25.java](./July25.java) |
|  23 | Remove Nth Node From End of List                  | LC 19   | [July25.java](./July25.java) |
|  24 | Reverse a Doubly Linked List                      | GFG     | [July29.java](./July29.java) |
|  25 | Reverse Linked List II                            | LC 92   | [July30.java](./July30.java) |

---

# 📁 Daily Practice Files

| File                           | Purpose                                                               |
| ------------------------------ | --------------------------------------------------------------------- |
| [`July16.java`](./July16.java) | First custom node and singly linked list implementation               |
| [`July21.java`](./July21.java) | Delete node, middle node, and full Linked List reversal               |
| [`July22.java`](./July22.java) | Cycle detection and cycle starting node                               |
| [`July24.java`](./July24.java) | Odd-even arrangement, loop length, and palindrome checking            |
| [`July25.java`](./July25.java) | Sorting, merging, arithmetic, intersection, and node-removal problems |
| [`July29.java`](./July29.java) | Doubly linked list reversal practice                                  |
| [`July30.java`](./July30.java) | Reversing a selected portion of a Linked List                         |
| [`Aug01.java`](./Aug01.java)   | Duplicate removal, multi-level flattening, and DLL pair sum           |
| [`Aug03.java`](./Aug03.java)   | Forward-order Linked List addition                                    |
| [`Aug05.java`](./Aug05.java)   | Binary conversion and value-based node removal                        |

---

<a id="progress"></a>

# 📈 Progress

| Category    | Practice Entries |
| ----------- | ---------------: |
| Total       |           **25** |
| August 2026 |            **6** |
| July 2026   |           **19** |

## 🌐 Platform Distribution

| Source           | Practice Entries |
| ---------------- | ---------------: |
| LeetCode         |           **18** |
| GeeksforGeeks    |            **5** |
| General Practice |            **2** |

---

# 🔄 Daily Update

Whenever I solve a new problem:

1. Use the correct node type: `Node`, `DNode`, or `NlNode`.
2. Add the solution to the appropriate date-based Java file.
3. Add a structured problem heading above the solution method.
4. Include the correct platform abbreviation and problem number when known.
5. Add time and space complexity without changing the original approach.
6. Add the problem under the corresponding **month and date** section.
7. Continue the global problem number.
8. Add the problem to the **Problem Index**.
9. Update the **Daily Practice Files** section when a new Java file is created.
10. Update the monthly, total, and platform progress counts.

### Example

If the next problem is added to `Aug18.java`:

```md
| 26 | New Linked List Problem | LC / GFG / General | [View Solution](./Aug18.java) |
```
