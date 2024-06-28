# Introduction

AINDD is a solution to Approximate Inclusion Dependency discovery. Given several instances of relational schema, AINDD efficiently find all AINDs of specific violation threshold.



# **Usage**

The [Metanome](https://hpi.de/naumann/projects/data-profiling-and-analytics/metanome-data-profiling.html) profiling tool is a framework for various profiling algorithms. It handles both algorithms and datasets as external resources. To compare with other IND discovery algorithms on the Metanome platform, we implemented code adapted to the Metanome platform. 


To run our algorithm, you need to :

- clone source code of AINDD
- ensure the following configuration
  - `Java 9 or later`
  - `Maven 3.1.0 or later`
- package AINDD using `mvn package`
- put `AINDD-1.0-SNAPSHOT.jar` under `Metanome/backend/WEB-INF/classes/algorithms`
- run AINDD on Metanome



You can learn more about usage of Metanome in [here](https://hpi.de/naumann/projects/data-profiling-and-analytics/metanome-data-profiling/algorithms.html)



# **Comparative Experiments**

We provide the algorithm code and datasets required for the experiments in [here](https://github.com/A-IND/AINDD-Expt)



# License

AINDD is released under the [Apache 2.0 license](https://github.com/A-IND/AINDD/blob/main/LICENSE). Some basic data structure's source code is imported from [BINDER](https://github.com/HPI-Information-Systems/metanome-algorithms/tree/master/BINDER)

