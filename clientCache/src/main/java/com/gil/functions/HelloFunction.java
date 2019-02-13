package com.gil.functions;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.security.ResourcePermission;

import java.util.Collection;

/**
 * Created by markito on 4/29/14.
 */
public class HelloFunction implements Function {
  @Override
  public boolean hasResult() {
    return false;
  }

  @Override
  public void execute(org.apache.geode.cache.execute.FunctionContext context) {
    System.out.println("Hello, I'm running here");
  }

  @Override
  public String getId() {
    return HelloFunction.class.getCanonicalName();
  }

  @Override
  public boolean optimizeForWrite() {
    return false;
  }

  @Override
  public boolean isHA() {
    return false;
  }

  @Override
  public Collection<ResourcePermission> getRequiredPermissions(String regionName) {
    return null;
  }

//  @Override
//  public void execute(FunctionContext functionContext) {
//
//    System.out.println("Hello, I'm running here");
//  }

//  @Override
//  public String getId() {
//    return HelloFunction.class.getCanonicalName();
//  }
//
//  @Override
//  public boolean hasResult() {
//    return false;
//  }
//
//  @Override
//  public boolean isHA() {
//    return false;
//  }
}
