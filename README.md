[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/cLW1_9CJ)

## Part 1 — Structural Coverage

### Question 1 — Line Coverage (Multiple Choice)

Consider the following Java method, which plays a simplified game of Blackjack:

```java
public int play(int left, int right) {
    int ln = left;
    int rn = right;
    if (ln > 21)
        ln = 0;
    if (rn > 21)
        rn = 0;
    if (ln > rn)
        return ln;
    else
        return rn;
}
```

A test is executed with the following input values:

* `left = 22`
* `right = 21`

**Question:**
What is the **line coverage percentage** achieved by this test?

**Notes:**

* Disregard the line containing the method signature and the final closing brace.
* Only count executable lines inside the method body.

**Answer choices:**

1. 60%
2. 70%
3. 80%
4. 100%

---

### Question 2 — Testing Techniques (Multiple Choice)

Which of the following statements correctly describes the relationship between **specification-based testing** and **structural testing**?

**Answer choices:**

1. A testing process should prioritize structural testing because it is cheaper and generally more effective than specification-based testing.
2. Specification-based testing can only be effectively performed when formal models of the system exist; a simple user story is insufficient.
3. Boundary value analysis requires access to the source code and should therefore be classified as a structural testing technique.
4. **None of the other answers is true.**

---

## Part 2 — Add Structural Coverage

In Week 3, we began exploring **structural-based testing**. For this exercise, you will use **IntelliJ IDEA** to perform **coverage-guided test generation** on your test cases from **Assignment 1**, specifically `NumberUtils`.
If you achieved, 100\% coverage using **specification-based testing** then you could report so.

### Tasks

1. Use IntelliJ’s coverage tools to **measure code coverage** for your existing test suite.
2. Identify:

   * Uncovered **lines**
   * Uncovered **branches**
3. Add **additional test cases** to achieve **full coverage**.

### Reporting Requirements

In your report, you must clearly distinguish between:

* Test cases derived **exclusively from specification-based testing**
* Test cases added **based on coverage analysis**

Use the JUnit `@Tag` annotation to separate the two groups, for example:

* `@Tag("specification")`
* `@Tag("structural")`

This annotation separation above is required for clarity and grading.

---

## Part 3 — More Specification-Based Testing

In Weeks 1 and 2, we focused on **specification-based testing**. In this part, you will apply those concepts to a **new Java class**.

### Setup

1. You are already provided with code on `LeftPadUtils.java`

### Tasks

Follow the specification-based testing process below:

1. **Understand the requirements**

   * Review the specification (in this case, the Java method behavior)
   * Identify input types and output types

2. **Identify input partitions and boundaries**

   * Individual inputs
   * Combinations of inputs
   * Expected outputs

3. **Create test cases using JUnit**

   * Derive tests from the identified partitions
   * Ensure coverage of boundary conditions

**Tip:**
If you are having trouble, refer to **D2L → Week 2 resources** and review the `StringUtil.java` example.

---

## Part 4 — Structural Coverage for `LeftPadUtils`

For this final part, return to **structural-based testing**.

### Tasks

1. Use IntelliJ to perform **coverage analysis** on `LeftPadUtils.java`.
2. Identify uncovered:

   * Lines
   * Branches
3. Add test cases as needed to achieve **full coverage**.

### Reporting Requirements

As in Part 3, clearly distinguish between:

* Test cases derived from **specification-based testing**
* Test cases added using **coverage-guided analysis**

Use the JUnit `@Tag` annotation to separate the two categories for organization and clarity.

---

## Submission Guide

### Required Files

1. Your repository **must include code from both Assignment 1 and Assignment 2**.
2. You must create a file named:

   ```
   solution-readme.md
   ```

   This file will contain **all written answers** for **Parts 1–4**.

---

### What to Include in `solution-readme.md`

Use clear section headers (e.g., `## Part 1`, `## Part 2`, etc.).

---

#### **Part 1**

* State your **multiple-choice answer**
* Briefly explain **why** you selected that answer

---

#### **Part 2**

* State your **multiple-choice answer**
* Briefly explain **why** you selected that answer

---

#### **Part 3**

* Provide a **link to your Assignment 1 code** in the repository
* Copy the **equivalence partitioning** you performed in Assignment 1 into `solution-readme.md`
* Clearly discuss:

  * Whether **100% coverage was achieved before** applying structural testing techniques
  * Or **only after** adding tests based on coverage analysis

---

#### **Part 4**

* Provide a **link to your Assignment 2 code** in the repository
* Describe the **equivalence partitioning** you performed for the new assignment
* Clearly discuss:

  * Whether **100% coverage was achieved before** applying structural testing techniques
  * Or **only after** adding tests based on coverage analysis

---

### Important Notes

* All links must point to files **within your GitHub Classroom repository**
* Coverage discussion must be based on **actual IntelliJ coverage results**


