## Instructions to run the tests:

--------------------------------------------------------
#### NOTES)

#### I use JDK21

--------------------------------------------------------
## PROBLEM 1 - QUICK FIND)

#### 1) Naive Union Find (union is always O(n))

--------------------------------------------------------
## PROBLEM 2 - QUICK UNION)

#### 1) Quick Union Find
#### 2) Weighted Quick Union Find (adds set to largest set, instead of randomly)
#### 2.2) added method: collapsingFindRoot() -> performs path compression

--------------------------------------------------------
## PROBLEM 3 - TIMER)

#### 1) Function used to time other functions.

--------------------------------------------------------
## PROBLEM 4 - TEST QUICK FIND AND QUICK UNION)

#### 1) Run the programs "FindRunTimesQuickFind" and "FindRunTimesQuickUnion".

#### 2) These programs will generate .csv files that are used for the calculations.

#### 3) Uncomment the last 2 lines of code of each class to write new .csv files (not necessary since I base my calculation on the already existing .csv file)

#### 4) Run the programs "CalcQuickFind" and "CalcQuickUnion".

#### 5) These programs find the slopes, the intercepts and calculate the times based on the previously generated .csv files.
#### In addition, they will create .csv files that end on "_predicted". These are the predicted run times based on the calculated model.

#### 6) On line 30 in "CalcQuickUnion" there is a commented line that sets the average slope to 0.
#### In the report, I wrote that for the calculations I used the normal slope and the rounded version, which is 0.
#### Uncomment that line if you want to see the results with slope 0.

#### 7) The programs rely on the helper classes in the package HelperClasses, such as CSVReaderWriter, Formulas and InfoList.

--------------------------------------------------------
## PROBLEM 5 - NAIVE 3SUM)

#### 1) Run main to see the algorithm perform tasks.

#### 2) The program relies on the helper class Tuple3 (form HelperClasses package) which a class created to hold 3 integer values.

--------------------------------------------------------
## PROBLEM 6 - LR-POINTER 3SUM)

#### 1) Run main to see the algorithm perform tasks.

#### 2) The program relies on the helper class Tuple3 (form HelperClasses package) which a class created to hold 3 integer values.

--------------------------------------------------------
## PROBLEM 7)

#### 1) Run the programs "FindRunTimesNaive3Sum" and "FindRunTimesLR3Sum".

#### 2) These programs will generate .csv files that are used for the calculations.

#### 3) Uncomment the last 2 lines of code of each class to write new .csv files (not necessary since I base my calculation on the already existing .csv file)

#### 4) Run the programs "CalcNaive3Sum" and "CalcLR3Sum".

#### 5) These programs find a, b and c based on the previously generated .csv files.
#### The numbers passed to the function fs.calcB() and fs.calcC() shouldn't be modified, as they are chosen based on the calculations in the report.
#### In addition, the programs they will generate .csv files that end on "_predicted". These are the predicted run times based on the calculated model.

#### 6) The programs rely on the helper classes in the package HelperClasses, such as CSVReaderWriter, Formulas and InfoList.

--------------------------------------------------------
## HelperClasses class)

#### 1) The class Tuple3 (only used in 3sum) is just a class that holds 3 integers. For the sake of simplicity, the attributes (int a, int b, int c) are public.

#### 2) The class InfoList is just a class that holds 3 Arraylists.

#### 3) The ReaderWriter class is a class that I created to simplify reading and writing to files.
#### Among other functions, it reads from .csv files and generates InfoLists (see pt.5) that contain ArrayLists of ID's, sizes, and measured times.

#### 4) The Formulas class only contains mathematica formulas used by other classes to find values.