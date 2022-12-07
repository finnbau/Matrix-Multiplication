import os.path
import os
import time
import re
import subprocess
import csv
from time import sleep
from numpy import delete, source
### This experiment is meant to determine the optimal s in regards to recursively transposing an algorithm.
n_values = [2048, 4096, 8192] #Values of n to experiment on.
s_values = [2,4,8,16,32,64,128]
trials = 100 #Amount of runs pr. n

JAR: str = 'app/build/libs/app.jar'
CSV_COLUMNS = ['n','s','time_in_milliseconds']
TIMEOUT = 120000

def run_java(n: str,s: str) -> str:
    p = subprocess.Popen(['java', '-jar', JAR,'rec_trans',n,s],
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE)
    (output, _) = p.communicate(timeout=TIMEOUT)
    return str(output)

if __name__ == '__main__':
    print('Experiment started.')
    with open('experiment_results/task4_results.csv','w') as resFile:
        writer = csv.DictWriter(resFile, fieldnames=CSV_COLUMNS)
        writer.writeheader()
        for n in n_values:
            for s in s_values:
                for i in range(trials):
                    print('Running: n=' +str(n)+" s=" +str(s)+" "+str(i)+"/"+str(trials))
                    output = run_java(n=str(n),s=str(s))
                    result = re.findall('[0-9]+', output)[0]
                    writer.writerow({CSV_COLUMNS[0]:str(n), CSV_COLUMNS[1]:str(s), CSV_COLUMNS[2]:result})
    print("All done.")

