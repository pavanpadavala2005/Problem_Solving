# 🔗 007 — Linked List

> 📌 **This README is the central tracker for all Linked List implementations and problem-solving practice.**
>
> This folder is organized differently from the other topic folders because it contains custom node models, reusable Linked List implementations, utility classes, a common runner, and date-based problem solutions.
>
> **Tracked details:** node architecture, supporting classes, problem name, source/platform, practice date, and Java solution file.

---

## 🧭 Repository Overview

| Metric | Value |
| ------ | ----: |
| Java Files | **17** |
| Core Infrastructure Files | **7** |
| Date-Based Practice Files | **10** |
| Practice Entries | **25** |
| Period Covered | **July–August 2026** |
| Language | **Java** |

> Multiple approaches to the same problem inside one Java file are counted as one practice entry. Core node implementations, utility classes, and `Demo.java` are documented separately and are not counted as solved problems.

## 🏷️ Source Legend

| Label | Platform |
| ----- | -------- |
| `LC` | LeetCode |
| `GFG` | GeeksforGeeks |
| `General` | Custom implementation, general practice, or no confirmed platform |

## 🧩 Topic Coverage

| Area | Problems Practiced |
| ---- | ------------------ |
| Core Linked List Design | Custom nodes, insertion, deletion, traversal, and reusable utilities |
| Fast & Slow Pointers | Middle node, cycle detection, loop length, and palindrome checking |
| Reversal | Full reversal, recursive reversal, partial reversal, and doubly linked list reversal |
| Sorting & Merging | Sort List, Merge Two Sorted Lists, and flattening a multi-level linked list |
| Linked List Arithmetic | Add Two Numbers, Add Two Numbers II, and Add 1 to a linked list number |
| Node Relationships | Intersection point, cycle starting node, and removal by node/position |
| Doubly Linked Lists | Core DLL operations and target-sum pairs |
| Non-Linear Linked Lists | Horizontal `next` links, vertical `bottom` links, and flattening |

---

# 🧱 Node Architecture

This folder intentionally uses different node classes because each Linked List structure requires a different set of links.

<div align="center">
<table>
  <thead>
    <tr>
      <th>Node</th>
      <th>Structure</th>
      <th>Links</th>
      <th>Primary File</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>Node</b></td>
      <td>Singly Linked List</td>
      <td><code>next</code></td>
      <td><a href="./SinglyLinkedList.java">SinglyLinkedList.java</a></td>
    </tr>
    <tr>
      <td><b>DNode</b></td>
      <td>Doubly Linked List</td>
      <td><code>prev</code> + <code>next</code></td>
      <td><a href="./DoublyLinkedList.java">DoublyLinkedList.java</a></td>
    </tr>
    <tr>
      <td><b>NlNode</b></td>
      <td>Non-Linear / Multi-Level Linked List</td>
      <td><code>next</code> + <code>bottom</code></td>
      <td><a href="./NonLinearLinkedList.java">NonLinearLinkedList.java</a></td>
    </tr>
    <tr>
      <td><b>MyNode</b></td>
      <td>Learning-Specific Singly Linked List</td>
      <td><code>next</code></td>
      <td><a href="./July16.java">July16.java</a></td>
    </tr>
  </tbody>
</table>
</div>

## 1️⃣ Singly Linked List Node — `Node`

`Node` is the primary node used by the singly linked list utilities and most date-based problem solutions.

<div align="center">
<table>
  <tr>
    <td><b>HEAD</b></td>
    <td>→</td>
    <td><code>data</code></td>
    <td><code>next</code></td>
    <td>→</td>
    <td><code>data</code></td>
    <td><code>next</code></td>
    <td>→</td>
    <td><b>NULL</b></td>
  </tr>
</table>
</div>

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

| Property | Details |
| -------- | ------- |
| Data field | `int data` stores the value |
| Link field | `Node next` points to the next node |
| End condition | The last node's `next` is `null` |
| Main implementation | [`SinglyLinkedList.java`](./SinglyLinkedList.java) |
| Utilities | [`SinglyLinkedListUtils.java`](./SinglyLinkedListUtils.java) |

---

## 2️⃣ Doubly Linked List Node — `DNode`

`DNode` supports movement in both directions by maintaining links to the previous and next nodes.

<div align="center">
<table>
  <tr>
    <td><b>NULL</b></td>
    <td>←</td>
    <td><code>prev</code></td>
    <td><code>data</code></td>
    <td><code>next</code></td>
    <td>⇄</td>
    <td><code>prev</code></td>
    <td><code>data</code></td>
    <td><code>next</code></td>
    <td>→</td>
    <td><b>NULL</b></td>
  </tr>
</table>
</div>

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

| Property | Details |
| -------- | ------- |
| Data field | `int data` stores the value |
| Backward link | `DNode prev` points to the previous node |
| Forward link | `DNode next` points to the next node |
| Boundary conditions | `head.prev == null` and `tail.next == null` |
| Main implementation | [`DoublyLinkedList.java`](./DoublyLinkedList.java) |
| Utilities | [`DoublyLinkedListUtils.java`](./DoublyLinkedListUtils.java) |

---

## 3️⃣ Non-Linear Linked List Node — `NlNode`

`NlNode` represents a multi-level Linked List. The `next` pointer connects top-level nodes, while the `bottom` pointer connects a vertical child list.

<div align="center">
<table>
  <tr>
    <td><b>HEAD</b></td>
    <td>→</td>
    <td><code>data | next | bottom</code></td>
    <td>→</td>
    <td><code>data | next | bottom</code></td>
    <td>→</td>
    <td><b>NULL</b></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td align="center">↓ <code>bottom</code></td>
    <td></td>
    <td align="center">↓ <code>bottom</code></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td><code>data | bottom</code></td>
    <td></td>
    <td><code>data | bottom</code></td>
    <td></td>
    <td></td>
  </tr>
</table>
</div>

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

| Property | Details |
| -------- | ------- |
| Data field | `int data` stores the value |
| Horizontal link | `NlNode next` points to the next top-level node |
| Vertical link | `NlNode bottom` points to the next child node |
| Main use | Building and flattening multi-level sorted Linked Lists |
| Main implementation | [`NonLinearLinkedList.java`](./NonLinearLinkedList.java) |
| Utilities | [`NonLinearLinkedListUtils.java`](./NonLinearLinkedListUtils.java) |

---



| Property | Details |
| -------- | ------- |
| Purpose | Independent practice implementation |
| Link field | `MyNode next` points to the next `MyNode` |
| Owning class | `MyLinkedList` |
| Practice file | [`July16.java`](./July16.java) |

---

## 🔄 Structure Relationships

| Structure | Owns | Utility Support | Used For |
| --------- | ---- | --------------- | -------- |
| `SinglyLinkedList` | `Node head` | `SinglyLinkedListUtils` | Most singly linked list problems |
| `DoublyLinkedList` | `DNode head`, `DNode tail` | `DoublyLinkedListUtils` | Bidirectional operations and pair sum |
| `NonLinearLinkedList` | `NlNode head` | `NonLinearLinkedListUtils` | Multi-level lists and flattening |

| `Demo` | Test data and method calls | Uses all applicable structures | Common runner for daily testing |

---

# 🧰 Core Infrastructure

| File | Responsibility |
| ---- | -------------- |
| [`SinglyLinkedList.java`](./SinglyLinkedList.java) | Defines `Node` and implements fundamental singly linked list operations |
| [`SinglyLinkedListUtils.java`](./SinglyLinkedListUtils.java) | Creates lists, finds nodes, reverses lists, creates cycles, and creates intersections |
| [`DoublyLinkedList.java`](./DoublyLinkedList.java) | Defines `DNode` and implements doubly linked list insertion, deletion, and traversal |
| [`DoublyLinkedListUtils.java`](./DoublyLinkedListUtils.java) | Builds DLLs, finds `DNode` objects, and converts a DLL to a list |
| [`NonLinearLinkedList.java`](./NonLinearLinkedList.java) | Defines `NlNode` and builds the horizontal part of a multi-level list |
| [`NonLinearLinkedListUtils.java`](./NonLinearLinkedListUtils.java) | Builds bottom lists and converts non-linear structures into readable collections |
| [`Demo.java`](./Demo.java) | Common runner used to test the implementations and date-based solutions |

> These seven files support the folder architecture and are not counted as solved problem entries.

---

# 📅 August 2026

## 🗓️ August 01 — `Aug01.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|   1 | Remove Duplicates from Sorted List | LC 83 | [View Solution](./Aug01.java) |
|   2 | Flattening a Linked List | GFG | [View Solution](./Aug01.java) |
|   3 | Find Pairs with Given Sum in Doubly Linked List | GFG | [View Solution](./Aug01.java) |

---

## 🗓️ August 03 — `Aug03.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|   4 | Add Two Numbers II | LC 445 | [View Solution](./Aug03.java) |

---

## 🗓️ August 05 — `Aug05.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|   5 | Convert Binary Number in a Linked List to Integer | LC 1290 | [View Solution](./Aug05.java) |
|   6 | Remove Linked List Elements | LC 203 | [View Solution](./Aug05.java) |

---

# 📅 July 2026

## 🗓️ July 16 — `July16.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|   7 | Implement a Custom Singly Linked List | General | [View Solution](./July16.java) |

---

## 🗓️ July 21 — `July21.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|   8 | Delete Node in a Linked List | LC 237 | [View Solution](./July21.java) |
|   9 | Middle of the Linked List | LC 876 | [View Solution](./July21.java) |
|  10 | Reverse Linked List | LC 206 | [View Solution](./July21.java) |

---

## 🗓️ July 22 — `July22.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|  11 | Linked List Cycle | LC 141 | [View Solution](./July22.java) |
|  12 | Linked List Cycle II | LC 142 | [View Solution](./July22.java) |

---

## 🗓️ July 24 — `July24.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|  13 | Odd Even Linked List | LC 328 | [View Solution](./July24.java) |
|  14 | Rearrange Array by Odd and Even Positions | General | [View Solution](./July24.java) |
|  15 | Find Length of Loop | GFG | [View Solution](./July24.java) |
|  16 | Palindrome Linked List | LC 234 | [View Solution](./July24.java) |

---

## 🗓️ July 25 — `July25.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|  17 | Sort List | LC 148 | [View Solution](./July25.java) |
|  18 | Merge Two Sorted Lists | LC 21 | [View Solution](./July25.java) |
|  19 | Add Two Numbers | LC 2 | [View Solution](./July25.java) |
|  20 | Add 1 to a Linked List Number | GFG | [View Solution](./July25.java) |
|  21 | Intersection of Two Linked Lists | LC 160 | [View Solution](./July25.java) |
|  22 | Delete the Middle Node of a Linked List | LC 2095 | [View Solution](./July25.java) |
|  23 | Remove Nth Node From End of List | LC 19 | [View Solution](./July25.java) |

---

## 🗓️ July 29 — `July29.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|  24 | Reverse a Doubly Linked List | GFG | [View Solution](./July29.java) |

> The approaches in this file are currently preserved as commented practice code.

---

## 🗓️ July 30 — `July30.java`

|   # | Problem | Source | Solution |
| --: | ------- | ------ | -------- |
|  25 | Reverse Linked List II | LC 92 | [View Solution](./July30.java) |

---

# 📊 Problem Index

|   # | Problem | Source | File |
| --: | ------- | ------ | ---- |
|   1 | Remove Duplicates from Sorted List | LC 83 | [Aug01.java](./Aug01.java) |
|   2 | Flattening a Linked List | GFG | [Aug01.java](./Aug01.java) |
|   3 | Find Pairs with Given Sum in Doubly Linked List | GFG | [Aug01.java](./Aug01.java) |
|   4 | Add Two Numbers II | LC 445 | [Aug03.java](./Aug03.java) |
|   5 | Convert Binary Number in a Linked List to Integer | LC 1290 | [Aug05.java](./Aug05.java) |
|   6 | Remove Linked List Elements | LC 203 | [Aug05.java](./Aug05.java) |
|   7 | Implement a Custom Singly Linked List | General | [July16.java](./July16.java) |
|   8 | Delete Node in a Linked List | LC 237 | [July21.java](./July21.java) |
|   9 | Middle of the Linked List | LC 876 | [July21.java](./July21.java) |
|  10 | Reverse Linked List | LC 206 | [July21.java](./July21.java) |
|  11 | Linked List Cycle | LC 141 | [July22.java](./July22.java) |
|  12 | Linked List Cycle II | LC 142 | [July22.java](./July22.java) |
|  13 | Odd Even Linked List | LC 328 | [July24.java](./July24.java) |
|  14 | Rearrange Array by Odd and Even Positions | General | [July24.java](./July24.java) |
|  15 | Find Length of Loop | GFG | [July24.java](./July24.java) |
|  16 | Palindrome Linked List | LC 234 | [July24.java](./July24.java) |
|  17 | Sort List | LC 148 | [July25.java](./July25.java) |
|  18 | Merge Two Sorted Lists | LC 21 | [July25.java](./July25.java) |
|  19 | Add Two Numbers | LC 2 | [July25.java](./July25.java) |
|  20 | Add 1 to a Linked List Number | GFG | [July25.java](./July25.java) |
|  21 | Intersection of Two Linked Lists | LC 160 | [July25.java](./July25.java) |
|  22 | Delete the Middle Node of a Linked List | LC 2095 | [July25.java](./July25.java) |
|  23 | Remove Nth Node From End of List | LC 19 | [July25.java](./July25.java) |
|  24 | Reverse a Doubly Linked List | GFG | [July29.java](./July29.java) |
|  25 | Reverse Linked List II | LC 92 | [July30.java](./July30.java) |

---

# 📁 Daily Practice Files

| File | Purpose |
| ---- | ------- |
| [`July16.java`](./July16.java) | First custom node and singly linked list implementation |
| [`July21.java`](./July21.java) | Delete node, middle node, and full Linked List reversal |
| [`July22.java`](./July22.java) | Cycle detection and cycle starting node |
| [`July24.java`](./July24.java) | Odd-even arrangement, loop length, and palindrome checking |
| [`July25.java`](./July25.java) | Sorting, merging, arithmetic, intersection, and node-removal problems |
| [`July29.java`](./July29.java) | Doubly linked list reversal practice |
| [`July30.java`](./July30.java) | Reversing a selected portion of a Linked List |
| [`Aug01.java`](./Aug01.java) | Duplicate removal, multi-level flattening, and DLL pair sum |
| [`Aug03.java`](./Aug03.java) | Forward-order Linked List addition |
| [`Aug05.java`](./Aug05.java) | Binary conversion and value-based node removal |

---

# 📈 Progress

| Category | Practice Entries |
| -------- | ---------------: |
| Total | **25** |
| August 2026 | **6** |
| July 2026 | **19** |

## 🌐 Platform Distribution

| Source | Practice Entries |
| ------ | ---------------: |
| LeetCode | **18** |
| GeeksforGeeks | **5** |
| General Practice | **2** |

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
