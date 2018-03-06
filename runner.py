import os
import subprocess
import csv

with open('results-cim.csv', 'w') as f:
    csv_writer = csv.writer(f, delimiter=';',
                            quotechar='|', quoting=csv.QUOTE_MINIMAL)
    header = ['Matrix {n}x{n}'.format(n=i) for i in range(1, 20)]
    header.insert(0, 'file')
    csv_writer.writerow(header)
    for x in range(0, 20):
        # print('File {}'.format(x))
        numbers = [x]
        for y in range(1, 20):
            # print('Matrix {}x{}'.format(y, y))
            command = 'java -jar cell-index-method-1.0-SNAPSHOT-jar-with-dependencies.jar -sf ../generator/2-static-{filen}.ari -df ../generator/2-dynamic-{filen}.ari -rc 1 -m {matrix}'.format(
                    filen=x,
                    matrix=y
                )
            p = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
            number = None;
            for line in p.stdout.readlines():
                number = line.split(' ')
                number = number[-1]
                number = number.replace('\n', '')
                break;
            retval = p.wait()
            numbers.append(number)
        csv_writer.writerow(numbers)
