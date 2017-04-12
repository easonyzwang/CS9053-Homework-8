## Job.java

1. lien 12 & 13 & 14: Make them `final`
2. line 17: Ideally you should check that `start` < `end`
3. Must include equals/hashCode proper implementations

## LambdaScheduler.java

1. line 11 ~ 14: Should use `List` rather than concrete class `ArrayList` for variable declaration
2. line 11 ~ 14: Make them `final`
3. line 26: Should use `List` rather than concrete class `ArrayList` for variable declaration
4. line 26: `scheduler` is not a good name in this context, try `jobs`
5. line 32: Should ensure null or empty cases are handled

```
if ((jobs == null) || jobs.isEmpty() || containsNulls(jobs)) {
	throw new IllegalArgumentException();
}

```

```
protected boolean containsNulls(Collection<J> jobs) {
        for (J job : jobs) {
            if (job == null) {
                return true;
            }
        }
        return false;
}

```

1. Break down `jobSelect()` into several helper methods

## LambdaWeightedScheduler.java

1. line 12 & 15: Should use `List` rather than concrete class `ArrayList` for variable declaration
2. Break down `weightedJobSelection()` into several helper methods