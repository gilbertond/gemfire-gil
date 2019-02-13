package com.gil.expiry;

import org.apache.geode.cache.CustomExpiry;
import org.apache.geode.cache.ExpirationAction;
import org.apache.geode.cache.ExpirationAttributes;
import org.apache.geode.cache.Region;

import java.util.Properties;

public class GilCustomExpiry implements CustomExpiry {

    @Override
    public ExpirationAttributes getExpiry(Region.Entry entry) {

        //Expire object by key example
        if (entry.getKey().equals(21)){
            return new ExpirationAttributes(10, ExpirationAction.INVALIDATE);

        }else if(entry.getKey().equals(24)){
            return new ExpirationAttributes(10, ExpirationAction.DESTROY);

        } else return null;   //Means no expiration
    }

    @Override
    public void close() {

    }

    @Override
    public void init(Properties props) {

    }
}
