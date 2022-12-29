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
).round()
#df_grouped['time_in_milliseconds','mean'] = df_grouped['mean'].apply(lambda x: round(x, 0))
#df_grouped['std'] = df_grouped['std'].apply(lambda x: round(x, 2))
print(df_grouped)

with open('horse_latex.tex', 'w') as tf:
     tf.write(df_grouped.to_latex())

#Make individual tables for each algorithm
df_ele = df[df.algorithm=='Elementary']
df_ele = df_ele.drop('s',axis=1)
df_ele = df_ele.groupby(['algorithm','n']).agg(
        {'time_in_milliseconds':['min','mean','median','std','max']}
).round()
with open('horse_latex_ele.tex', 'w') as tf:
     tf.write(df_ele.to_latex())

df_trans = df[df.algorithm=='Transposed']
df_trans = df_trans.groupby(['algorithm','n','s']).agg(
        {'time_in_milliseconds':['min','mean','median','std','max']}
).round()
with open('horse_latex_trans.tex', 'w') as tf:
     tf.write(df_trans.to_latex())

df_tiled = df[df.algorithm=='Tiled']
df_tiled = df_tiled.groupby(['algorithm','n','s']).agg(
        {'time_in_milliseconds':['min','mean','median','std','max']}
).round()
with open('horse_latex_tiled.tex', 'w') as tf:
     tf.write(df_tiled.to_latex())

df_rec = df[df.algorithm=='Recursive']
df_rec = df_rec.groupby(['algorithm','n','s']).agg(
        {'time_in_milliseconds':['min','mean','median','std','max']}
).round()
with open('horse_latex_rec.tex', 'w') as tf:
     tf.write(df_rec.to_latex())

df_strassen = df[df.algorithm=='Strassen']
df_strassen = df_strassen.groupby(['algorithm','n','s']).agg(
        {'time_in_milliseconds':['min','mean','median','std','max']}
).round()
with open('horse_latex_strassen.tex', 'w') as tf:
     tf.write(df_strassen.to_latex())

#Making table with optimal values of s for each algorithm at each n.
df = df.drop(df[(df.algorithm=='Transposed') & (df.n==1024) & (df.s!=8)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Transposed') & (df.n==2048) & (df.s!=64)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Transposed') & (df.n==4096) & (df.s!=4)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Tiled') & (df.n==1024) & (df.s!=8)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Tiled') & (df.n==2048) & (df.s!=8)].index)
df.reset_index(drop=True, inplace=True)
# Tiled only finished n=4096 at s=8
df = df.drop(df[(df.algorithm=='Recursive') & (df.n==1024) & (df.s!=8)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Recursive') & (df.n==2048) & (df.s!=8)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Recursive') & (df.n==4096) & (df.s!=8)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Strassen') & (df.n==1024) & (df.s!=64)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Strassen') & (df.n==2048) & (df.s!=64)].index)
df.reset_index(drop=True, inplace=True)
df = df.drop(df[(df.algorithm=='Strassen') & (df.n==4096) & (df.s!=64)].index)
df.reset_index(drop=True, inplace=True)
print(df.to_string())
df_grouped = df.groupby(['algorithm','n','s']).agg(
        {'time_in_milliseconds':['min','mean','median','std','max']}
).round()
#df_grouped['time_in_milliseconds','mean'] = df_grouped['mean'].apply(lambda x: round(x, 0))
#df_grouped['std'] = df_grouped['std'].apply(lambda x: round(x, 2))
print(df_grouped)

with open('horse_latex_optimal_s.tex', 'w') as tf:
     tf.write(df_grouped.to_latex())