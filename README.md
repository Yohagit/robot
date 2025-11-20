# Robot Package Sorter (Java)

Implements `sort(width, height, length, mass)` returning one of:
- `STANDARD`
- `SPECIAL`
- `REJECTED`

## Rules
- **Bulky** if:
  - volume `width * height * length >= 1,000,000 cm³`, **or**
  - any dimension `>= 150 cm`
- **Heavy** if `mass >= 20 kg`
- **Stacks**
  - `REJECTED` if **bulky AND heavy**
  - `SPECIAL` if **bulky OR heavy** (but not both)
  - `STANDARD` otherwise
