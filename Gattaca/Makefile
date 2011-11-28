JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	Interval1D.java \
	StdOut.java \
	GattacaTest.java\
	AdjMatrixGraph.java
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class