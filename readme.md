# Q-SFL maven plugin example

This sample project provides usage examples of
[aperez/q-sfl](https://github.com/aperez/q-sfl), namely:
- Declaring the `qsfl-maven-plugin` dependency and running the instrumentation;
- Using Q-SFL's annotation API;
- Creating custom qualitative partitioners to be used by the Q-SFL framework.

## Running the Q-SFL instrumentation

To run the project's test cases and perform the Q-SFL instrumentation, execute
the command:
```
mvn qsfl:test
```

## Sample Output

After executing test cases, Q-SFL's output files are stored in the `target/qsfl`
folder:

### `nodes.txt`

This file reports a basic syntax tree of the target project, along with
qualitative paritionings:
```
{"id":1,"line":-1,"name":"qsfl","parentId":0,"type":"PACKAGE"}
{"id":2,"line":-1,"name":"example","parentId":1,"type":"PACKAGE"}
{"id":3,"line":-1,"name":"Calculator","parentId":2,"type":"CLASS"}
{"id":4,"line":10,"name":"Calculator()","parentId":3,"type":"METHOD"}
{"id":5,"line":13,"name":"mul(double,double)","parentId":3,"type":"METHOD"}
{"id":6,"line":20,"name":"div(double,double)","parentId":3,"type":"METHOD"}
{"id":7,"line":26,"name":"add(double,double)","parentId":3,"type":"METHOD"}
{"id":8,"line":31,"name":"sub(double,double)","parentId":3,"type":"METHOD"}
{"id":9,"line":13,"name":"x","parentId":5,"type":"PARAMETER"}
{"id":10,"line":13,"name":"lt 0","parentId":9,"type":"LANDMARK"}
{"id":11,"line":13,"name":"eq 0","parentId":9,"type":"LANDMARK"}
{"id":12,"line":13,"name":"gt 0","parentId":9,"type":"LANDMARK"}
{"id":13,"line":13,"name":"y","parentId":5,"type":"PARAMETER"}
{"id":14,"line":13,"name":"lt 0","parentId":13,"type":"LANDMARK"}
{"id":15,"line":13,"name":"eq 0","parentId":13,"type":"LANDMARK"}
{"id":16,"line":13,"name":"gt 0","parentId":13,"type":"LANDMARK"}
{"id":17,"line":13,"name":"lt 0","parentId":5,"type":"LANDMARK"}
{"id":18,"line":13,"name":"eq 0","parentId":5,"type":"LANDMARK"}
{"id":19,"line":13,"name":"gt 0","parentId":5,"type":"LANDMARK"}
{"id":20,"line":20,"name":"x","parentId":6,"type":"PARAMETER"}
{"id":21,"line":20,"name":"lt 0","parentId":20,"type":"LANDMARK"}
{"id":22,"line":20,"name":"eq 0","parentId":20,"type":"LANDMARK"}
{"id":23,"line":20,"name":"gt 0","parentId":20,"type":"LANDMARK"}
{"id":24,"line":20,"name":"y","parentId":6,"type":"PARAMETER"}
{"id":25,"line":20,"name":"lt 0","parentId":24,"type":"LANDMARK"}
{"id":26,"line":20,"name":"eq 0","parentId":24,"type":"LANDMARK"}
{"id":27,"line":20,"name":"gt 0","parentId":24,"type":"LANDMARK"}
{"id":28,"line":20,"name":"MyCustomHandler: lt pivot","parentId":6,"type":"LANDMARK"}
{"id":29,"line":20,"name":"MyCustomHandler: ge pivot","parentId":6,"type":"LANDMARK"}
{"id":30,"line":26,"name":"x","parentId":7,"type":"PARAMETER"}
{"id":31,"line":26,"name":"lt 0","parentId":30,"type":"LANDMARK"}
{"id":32,"line":26,"name":"eq 0","parentId":30,"type":"LANDMARK"}
{"id":33,"line":26,"name":"gt 0","parentId":30,"type":"LANDMARK"}
{"id":34,"line":26,"name":"y","parentId":7,"type":"PARAMETER"}
{"id":35,"line":26,"name":"lt 0","parentId":34,"type":"LANDMARK"}
{"id":36,"line":26,"name":"eq 0","parentId":34,"type":"LANDMARK"}
{"id":37,"line":26,"name":"gt 0","parentId":34,"type":"LANDMARK"}
{"id":38,"line":31,"name":"x","parentId":8,"type":"PARAMETER"}
{"id":39,"line":31,"name":"lt 0","parentId":38,"type":"LANDMARK"}
{"id":40,"line":31,"name":"eq 0","parentId":38,"type":"LANDMARK"}
{"id":41,"line":31,"name":"gt 0","parentId":38,"type":"LANDMARK"}
{"id":42,"line":31,"name":"y","parentId":8,"type":"PARAMETER"}
{"id":43,"line":31,"name":"lt 0","parentId":8,"type":"LANDMARK"}
{"id":44,"line":31,"name":"eq 0","parentId":8,"type":"LANDMARK"}
{"id":45,"line":31,"name":"gt 0","parentId":8,"type":"LANDMARK"}
```

### `probes.txt`

This file provides a mapping between each node and probes injected in the code
for coverage activity gathering:
```
{"id":0,"nodeId":4}
{"id":1,"nodeId":5}
{"id":2,"nodeId":6}
{"id":3,"nodeId":7}
{"id":4,"nodeId":8}
{"id":5,"nodeId":10}
{"id":6,"nodeId":11}
{"id":7,"nodeId":12}
{"id":8,"nodeId":14}
{"id":9,"nodeId":15}
{"id":10,"nodeId":16}
{"id":11,"nodeId":17}
{"id":12,"nodeId":18}
{"id":13,"nodeId":19}
{"id":14,"nodeId":21}
{"id":15,"nodeId":22}
{"id":16,"nodeId":23}
{"id":17,"nodeId":25}
{"id":18,"nodeId":26}
{"id":19,"nodeId":27}
{"id":20,"nodeId":28}
{"id":21,"nodeId":29}
{"id":22,"nodeId":31}
{"id":23,"nodeId":32}
{"id":24,"nodeId":33}
{"id":25,"nodeId":35}
{"id":26,"nodeId":36}
{"id":27,"nodeId":37}
{"id":28,"nodeId":39}
{"id":29,"nodeId":40}
{"id":30,"nodeId":41}
{"id":31,"nodeId":43}
{"id":32,"nodeId":44}
{"id":33,"nodeId":45}
```

### `transactions.txt`

This file provides a record of every test execution, their outcome, and probe
activity:
```
{"activity":[1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0],"isError":0,"transactionName":"qsfl.example.CalculatorTest#testAdd1"}
{"activity":[1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0],"isError":0,"transactionName":"qsfl.example.CalculatorTest#testAdd2"}
{"activity":[1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0],"isError":0,"transactionName":"qsfl.example.CalculatorTest#testSub1"}
{"activity":[1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0],"isError":0,"transactionName":"qsfl.example.CalculatorTest#testSub2"}
```

### `valueprobes.txt`

In case the `valueProbes` configuration parameter of Q-SFL is enabled, parameter
values for function invocations will be recorded:
```
{"node":14,"t":"d","value":2.0}
{"node":13,"t":"d","value":2.0}
{"activity":null,"isError":0,"transactionName":"qsfl.example.CalculatorTest#testAdd1"}
{"node":14,"t":"d","value":4.0}
{"node":13,"t":"d","value":1.0}
{"activity":null,"isError":0,"transactionName":"qsfl.example.CalculatorTest#testAdd2"}
{"node":16,"t":"d","value":0.0}
{"node":15,"t":"d","value":0.0}
{"activity":null,"isError":0,"transactionName":"qsfl.example.CalculatorTest#testSub1"}
{"node":16,"t":"d","value":5.0}
{"node":15,"t":"d","value":4.0}
{"activity":null,"isError":0,"transactionName":"qsfl.example.CalculatorTest#testSub2"}
```
