package com.gil.functions;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.partition.PartitionRegionHelper;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MultiGetFunction implements Function {

  public void execute(FunctionContext fc) {
    if(! (fc instanceof RegionFunctionContext)){
      throw new FunctionException("This is a data aware function, and has to be called using FunctionService.onRegion.");
    }
    RegionFunctionContext context = (RegionFunctionContext)fc;
    Set keys = context.getFilter();
    Set keysTillSecondLast = new HashSet();
    int setSize = keys.size();
    Iterator keysIterator = keys.iterator();
    for(int i = 0; i < (setSize -1); i++)
    {
      keysTillSecondLast.add(keysIterator.next());
    }
    for (Object k : keysTillSecondLast) {
      context.getResultSender().sendResult(
          (Serializable)PartitionRegionHelper.getLocalDataForContext(context)
              .get(k));
    }
    Object lastResult = keysIterator.next();
    context.getResultSender().lastResult(
            PartitionRegionHelper.getLocalDataForContext(context)
                .get(lastResult));
  }

  public String getId() {
    return getClass().getName();
  }
}