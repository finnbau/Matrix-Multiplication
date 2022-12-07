import pandas as pd
import numpy as np

df = pd.read_csv('experiment_results/task4_results.csv')

df_grouped = df.groupby(['n','s']).agg({'time_in_milliseconds':['min','mean','median','max']})

print(df_grouped.to_string())

with open('task4_latex', 'w') as tf:
     tf.write(df_grouped.to_latex())
