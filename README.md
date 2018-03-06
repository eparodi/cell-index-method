# cell-index-method
Implementation of the Cell Index Method

## Compilation
### Simulation

```
mvn package
```

## Execution
### Simulation

```
java -jar cell-index-method-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Animation

The animation can be run by executing the octave file `animation.m` that 
accepts the following parameters `animation(static_file, dynamic_file, output_file, particle)`.

Example:
```
animation('../examples/Static100.txt','../examples/Dynamic100.txt','../out.data', 24);
```
