from numpy import random

def generate_static_file(number, length, name, radius=0.25):
    f = open(name, 'w')
    one_value = '{}\n'
    f.write(one_value.format(number))
    f.write(one_value.format(length))
    prop = 1
    for x in range(0,number):
        f.write('{} {}\n'.format(radius, prop))

def generate_dynamic_file(number, length, name):
    f = open(name, 'w')
    f.write('0\n')
    for x in range(0, number):
        f.write('{} {}\n'.format(random.uniform(0, length), random.uniform(0,length)))

def generate_files(file_type, index, number, length, radius_mean=0.5, radius_disp=0.1):
    generate_static_file(number, length, file_type +'-static-' + str(index) + '.ari')
    generate_dynamic_file(number, length, file_type + '-dynamic-' + str(index) + '.ari')

NUMBER_OF_SIMULATIONS = 20

numbers = [i * 20 for i in range(1, NUMBER_OF_SIMULATIONS + 1)]
numbers.sort()

for x in range(0, NUMBER_OF_SIMULATIONS):
    generate_files('2', x, numbers[x], 20)
