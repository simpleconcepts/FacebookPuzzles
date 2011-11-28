JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	Interval1D.java \
	StdOut.java \
	Gattaca.java\
	InputParser.java
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class