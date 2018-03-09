# cell-index-method
Implementation of the Cell Index Method

## Compilation
### Simulation

```
mvn package
```

## Execution
### Generation of Random Values
```
python generator/generate_values.py
```
### Simulation

```
java -jar cell-index-method-1.0-SNAPSHOT-jar-with-dependencies.jar
```
Parameters:

* -bf,--brute_force: Enables brute force mode.
* -df,--dynamic_file <arg>: Path to the file with the dynamic values.
* -h,--help: Shows the help.
* -m,--matrix <arg>: Size of the squared matrix.
* -pc,--periodic_contour: Enables periodic contour conditions.
* -rc,--radius <arg>: Radius of interaction between particles.
* -sf,--static_file <arg>: Path to the file with the static values.

or if you ran the program that generates random values you can run:

```
python runner.py
``` 

This program returns a csv in the folder with the results of the simulations.

### Animation

The animation can be run by executing the octave file `animation.m` that
accepts the following parameters `animation(static_file, dynamic_file, output_file, m, particle)`.

* **static_file**: Path to the file with the static values.
* **dynamic_file**: Path to the file with the dynamic values.
* **output**: Path to the file that contains the output of the simulation.
* **m**: Size of the squared matrix.
* **particle**: id of the selected particle to print it's neighbours.

Example:
```
animation('../examples/Static100.txt','../examples/Dynamic100.txt','../out.data', 4, 24);
```
