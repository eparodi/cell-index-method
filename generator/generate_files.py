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

def generate_files(index, number, length, radius_mean=0.5, radius_disp=0.1):
    generate_static_file(number, length,'static-' + str(index) + '.ari')
    generate_dynamic_file(number, length,'dynamic-' + str(index) + '.ari')

numbers = [10,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900,1000]

i = 0
for x in numbers:
    i += 1
    generate_files(i, numbers[i-1], 20)
