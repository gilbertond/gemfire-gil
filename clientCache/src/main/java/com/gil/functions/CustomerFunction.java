package com.gil.functions;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;

public class CustomerFunction implements Function {
    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public void execute(FunctionContext functionContext) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

    @Override
    public boolean isHA() {
        return false;
    }
}
