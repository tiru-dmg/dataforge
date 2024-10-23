import pandas as pd
from mlxtend.frequent_patterns import apriori, association_rules
from mlxtend.preprocessing import TransactionEncoder

dataset = [['Milk', 'Bread', 'Butter'],
           ['Bread', 'Diaper', 'Beer', 'Eggs'],
           ['Milk', 'Bread', 'Diaper', 'Beer'],
           ['Milk', 'Bread'],
           ['Bread', 'Butter', 'Diaper']]

encoder = TransactionEncoder()
onehot = encoder.fit(dataset).transform(dataset)
df = pd.DataFrame(onehot, columns=encoder.columns_)

frequent_itemsets = apriori(df, min_support=0.4, use_colnames=True)
print("Frequent Itemsets:")
print(frequent_itemsets)

rules = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.6)
print("\nAssociation Rules:")
print(rules)
