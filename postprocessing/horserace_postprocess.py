import pandas as pd
import numpy as np

df_ele = pd.read_csv('experiment_results/horserace_elementary_multiplication.csv')
df_trans = pd.read_csv('experiment_results/horserace_transposed_multiplication.csv')
df_tiled = pd.read_csv('experiment_results/horserace_tiled_multiplication.csv')
df_rec = pd.read_csv('experiment_results/horserace_recursive_multiplication.csv')
df_strassen = pd.read_csv('experiment_results/horserace_strassen_multiplication.csv')

df_ele['algorithm'] = 'Elementary'
df_ele['s'] = 'na'
df_trans['algorithm'] = 'Transposed'
df_tiled['algorithm'] = 'Tiled'
df_rec['algorithm'] = 'Recursive'
df_strassen['algorithm'] = 'Strassen'

df = pd.concat([df_ele,df_trans,df_tiled,df_rec,df_strassen],axis=0)

#Find number of timeouts
df_timeouts = df[df.time_in_milliseconds=='timeout']
df_timeouts_grouped = df_timeouts.groupby(['algorithm','n','s']).count()
print(df_timeouts_grouped)

df = df[df.time_in_milliseconds!='timeout'] #Remove timeouts for aggregation
df['time_in_milliseconds'] = pd.to_numeric(df['time_in_milliseconds']) #Some means were =inf because of type. This fixed it.
df_grouped = df.groupby(['algorithm','n','s']).agg(
        {'time_in_milliseconds':['min','mean','median','std','max']}
)
print(df_grouped)

with open('horse_latex', 'w') as tf:
     tf.write(df_grouped.to_latex())