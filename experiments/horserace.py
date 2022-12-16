import os.path
import os
import time
import re
import subprocess
import csv
from time import sleep
from numpy import delete, source
### This experiment is meant to determine the optimal s in regards to recursively transposing an algorithm.
n_values = [1024,2048,4096] #Values of n to experiment on.
s_values = [2,4,8,16,32,64,128,256,512,1024,2048,4096,8192]
trials = 10 #Amount of runs pr. n
algs = ['elementary_multiplication', 'transposed_multiplication','tiled_multiplication','recursive_multiplication','strassen_multiplication']


JAR: str = '../app/build/libs/app.jar'
CSV_COLUMNS = ['n','s','time_in_milliseconds']
TIMEOUT = 210

def run_java(n: str,s: str, alg: str) -> str:
    p = subprocess.Popen(['java', '-jar','-Xmx8g', JAR,alg,n,s],
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE)
    try:
        (output, _) = p.communicate(timeout=TIMEOUT)
        # (output, _) = p.communicate()
    except:
        return 'timeout'
    return str(output)


if __name__ == '__main__':
    print('Experiment started.')
    for alg in algs:
        print (alg)
        with open('../experiment_results/horserace_'+alg+'.csv','w') as resFile:
            writer = csv.DictWriter(resFile, fieldnames=CSV_COLUMNS)
            writer.writeheader()
            for n in n_values:
                for s in s_values:
                    timeout = False 
                    if s < n:
                        for i in range(trials):
                            if timeout == False:
                                print('Running: n=' +str(n)+" s=" +str(s)+" "+str(i+1)+"/"+str(trials))
                                output = run_java(n=str(n),s=str(s),alg=alg)
                                if output == 'timeout':
                                    timeout = True
                                    result = output
                                else:
                                    result = re.findall('[0-9]+', output)[0]
                                print(result)
                                writer.writerow({CSV_COLUMNS[0]:str(n), CSV_COLUMNS[1]:str(s), CSV_COLUMNS[2]:result})
    print("All done.")