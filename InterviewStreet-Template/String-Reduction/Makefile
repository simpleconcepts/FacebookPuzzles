JFlags = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Solution.java

default: classes

classes: $(CLASSES:.java=.class)

run:
	java Solution input00.txt
clean:
	$(RM) *.class