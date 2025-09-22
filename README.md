# Assignment05 — Medical Insurance Data

**Course:** CPSC.2740.01 (Software Engineering) — Fall 2025  
**Team Red Members:**  
- **Lead:** kjone127  
- **Designer:** smaxey  
- **SWE:** jstephe3  
- **Tester:** akhan5  

---

## 📌 Project Overview
This project analyzes a medical insurance dataset (from Kaggle) using **Java only**.  
We cannot use Python libraries such as NumPy, Pandas, or Matplotlib — only **Java Collections** and the standard library.  

The program provides:
- Reading & storing the first **N** records of the dataset into a custom `InsuranceRecord` object.
- Summary statistics (count, mean, std dev, min, percentiles, max) for numerical attributes.
- Horizontal & vertical text-based histograms.
- Hypothesis checks (fairness by region, smokers vs non-smokers, age vs charges, etc.).
- Simple linear regression & Pearson correlation coefficient for charges vs BMI, children, and region.
- Unit tests (AAA pattern) and Continuous Integration via GitHub Actions.

---
