`start locator --name=locator --mcast-port=0 --enable-cluster-configuration=true`

`start server --name=server1 --server-port=40404 --max-heap=1G --properties-file=../config/gemfire.properties --locators=locator[10334] --J=-DPORT=40404 --cache-xml-file=../config/cache.xml`
`start server --name=server2 --server-port=40405 --max-heap=1G --properties-file=../config/gemfire.properties --locators=locator[10334] --J=-DPORT=40405 --cache-xml-file=../config/cache.xml`
`start server --name=server3 --server-port=40406 --max-heap=1G --properties-file=../config/gemfire.properties --locators=locator[10334] --J=-DPORT=40404 --cache-xml-file=../config/cache.xml`


start locator --name=locator --mcast-port=0 --enable-cluster-configuration=true --include-system-classpath --classpath=/Users/gilberto/workspace/gemfire/pluralSight/clientCache/build/libs/customPartition-1.0-SNAPSHOT.jar
start server --name=server1 --server-port=40404 --max-heap=1G --properties-file=../config/gemfire.properties --locators=locator[10334] --J=-DPORT=40404 --cache-xml-file=../config/cache.xml --classpath=/Users/gilberto/workspace/gemfire/pluralSight/clientCache/build/libs/customPartition-1.0-SNAPSHOT.jar --include-system-classpath
start server --name=server2 --server-port=40405 --max-heap=1G --properties-file=../config/gemfire.properties --locators=locator[10334] --J=-DPORT=40405 --cache-xml-file=../config/cache.xml  --classpath=/Users/gilberto/workspace/gemfire/pluralSight/clientCache/build/libs/customPartition-1.0-SNAPSHOT.jar --include-system-classpath
